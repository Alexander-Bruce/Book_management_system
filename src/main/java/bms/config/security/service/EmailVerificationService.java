package bms.config.security.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Service
public class EmailVerificationService {
    @Autowired
    private JWTService jwtService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    ApplicationContext context;

    @Value("${spring.mail.username}")
    private String from;

    @Value("${spring.mail.password}")
    private String password;

    @Value("classpath:static/smtp_html.html")
    private Resource smtpHtmlResource;

    private String generateVerificationToken(String username) {
        return jwtService.generateToken(username);
    }

    private void sendHtmlMessage(String to, String subject, String token) throws MessagingException, IOException {
        // Load HTML content
        String htmlContent = new String(Files.readAllBytes(smtpHtmlResource.getFile().toPath()), StandardCharsets.UTF_8);
        token = URLEncoder.encode(token, StandardCharsets.UTF_8.toString());

        // Replace placeholder
        htmlContent = htmlContent.replace("your-verification-token", token);

        // Send email
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlContent, true);  // true indicates HTML content
        helper.setFrom(from);

        javaMailSender.send(message);
    }


    public void sendVerificationEmail(String username, String to) throws MessagingException, IOException {
        String token = generateVerificationToken(username);

        String subject = "Email Verification";

        sendHtmlMessage(to, subject, token);
    }

    public boolean verifyToken(String token) {
        String username;
        try {
            username = jwtService.extractUserName(token);
            if(username != null && context.getBean(UserDetailsServiceImpl.class).loadUserByUsername(username) != null)
                return true;
        }catch (Exception e) {
            return false;
        }
        return true;
    }
}

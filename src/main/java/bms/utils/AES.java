package bms.utils;

import lombok.Value;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class AES {
    private static String pwd = System.getenv("AES_SECRET_KEY");
//     * 将传入的明文转换为密文
//     * @param str
//     * @param pwd
//     * @return
//     */
    public static String encode(String str) {
        byte[] result = null;
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(pwd.getBytes());
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");

            // 创建密码器
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] byteContent = str.getBytes();
            result = cipher.doFinal(byteContent);

        } catch (Exception e) {
            return null;
        }

        return parseByte2HexStr(result);
    }

//    /**
//     * 将传入的密文转换为明文
//     * @param str
//     * @param
//     * @return
//     */
    public static String decode(String str) {
        byte[] result = null;
        byte[] content = parseHexStr2Byte(str);
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(pwd.getBytes());
            kgen.init(128, random);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");

            // 创建密码器
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            result = cipher.doFinal(content);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return new String(result);
    }

//    /**
//     * 将二进制转换成十六进制
//     *
//     * @param buf
//     * @return
//     */
    private static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

//    /**
//     * 将十六进制转换为二进制
//     *
//     * @param hexStr
//     * @return
//     */
    private static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

//    public static void main(String[] args) {
//        AES aes = new AES();
//        String content = "Heqinglin2021@";
//
//        // 加密
//        System.out.println("加密前：" + content);
//        String encodeResultStr = aes.encode(content);
//        System.out.println("加密后：" + encodeResultStr);
//
//        // 解密
//        String decodeResultStr = aes.decode(encodeResultStr);
//        System.out.println("解密后：" + decodeResultStr);
//    }

}


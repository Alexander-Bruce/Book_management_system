package bms.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.Map;

public class JWTUtils {
    //签名私钥
    private final static String key = "heqinglin";
    //签名有效时间
    private static long ttl = 1000 * 60 * 60 * 3;

    public static String createJwtToken(Map<String,Object> claims){
        //设置失效时间
        //获取当前时间
        long now = System.currentTimeMillis();

        //当前时间+有效时间=过期时间
        long exp = now + ttl;

        return JWT.create()
                .withClaim("claims", claims)
                .withExpiresAt(new Date(exp))
                .sign(Algorithm.HMAC256(key));
    }

    public static Map<String, Object> parseToken(String token){
        return JWT.require(Algorithm.HMAC256(key))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();

    }
}

package POM;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.nio.charset.StandardCharsets;
import java.io.UnsupportedEncodingException;

public class sampla {


        public static String generateJwt(String userEmail) {

            // Secret key provided by Zoho (Addon creation)
            String secretKey = "LhkFZ6Q9FSPu8VbS2ABpaN8PHzdKC4FbTPEZinZg";

            long notBeforeMillis = System.currentTimeMillis();
            long notAfterMillis = notBeforeMillis + 300000; // 5 minutes

            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

            byte[] apiKeySecretBytes = secretKey.getBytes(StandardCharsets.UTF_8);
            Key signingKey = new SecretKeySpec(
                    apiKeySecretBytes,
                    signatureAlgorithm.getJcaName()
            );

            JwtBuilder builder = Jwts.builder()
                    .claim("email_verified", true)
                    .claim("not_before", notBeforeMillis)
                    .claim("not_after", notAfterMillis)
                    .claim("email", userEmail)
                    .signWith(signingKey, signatureAlgorithm);

            return builder.compact();
        }

        public static void main(String[] args) {
            String jwt = generateJwt("deeban.s@foodhub.com");
            System.out.println(jwt);
        }
    }



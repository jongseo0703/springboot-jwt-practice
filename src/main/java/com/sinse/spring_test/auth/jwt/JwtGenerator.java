package com.sinse.spring_test.auth.jwt;

import static com.sinse.spring_test.auth.constant.JwtConstant.*;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtGenerator {
  private final Key key;

  public JwtGenerator(@Value("${jwt.secret}") String secretKey) {
    byte[] keyBytes = Decoders.BASE64.decode(secretKey);
    this.key = Keys.hmacShaKeyFor(keyBytes);
  }

  public JWToken generateToken(Long userId) {
    long now = (new Date()).getTime();

    // Access Token 생성
    Date accessTokenExpiresIn = new Date(now + ACCESS_TOKEN_EXPIRE_TIME);

    String accessToken =
        Jwts.builder()
            .setSubject(String.valueOf(userId))
            .setExpiration(accessTokenExpiresIn)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();

    // Refresh Token 생성
    String refreshToken =
        Jwts.builder()
            .setExpiration(new Date(now + REFRESH_TOKEN_EXPIRE_TIME))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();

    return JWToken.builder()
        .grantType(GRANT_TYPE)
        .accessToken(accessToken)
        .refreshToken(refreshToken)
        .build();
  }
}

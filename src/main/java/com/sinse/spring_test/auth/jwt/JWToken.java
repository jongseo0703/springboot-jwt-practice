package com.sinse.spring_test.auth.jwt;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JWToken {
  private String grantType;
  private String accessToken;
  private String refreshToken;
}

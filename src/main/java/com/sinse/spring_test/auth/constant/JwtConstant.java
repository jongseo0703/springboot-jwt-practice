package com.sinse.spring_test.auth.constant;

public class JwtConstant {
  public static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 60 * 30;
  public static final long REFRESH_TOKEN_EXPIRE_TIME = 1000 * 60 * 60 * 24 * 7;
  public static final String GRANT_TYPE = "Bearer";
}

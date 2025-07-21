package com.sinse.spring_test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinse.spring_test.auth.jwt.JWToken;
import com.sinse.spring_test.auth.jwt.JwtGenerator;
import com.sinse.spring_test.auth.jwt.JwtProvider;
import com.sinse.spring_test.model.LoginRequestDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class AuthController {

  private final JwtGenerator jwtGenerator; // JWT를 만들어주는 클래스
  private final JwtProvider jwtProvider; // 로그인시 JWT를 검증해주는 클래스
  private final PasswordEncoder passwordEncoder;

  /* 로그인 로직 localhost:{본인포트번호}/auth/login + POST*/
  @PostMapping("/auth/login")
  public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequestDTO) {
    String testEmail = "test1234@gmail.com";
    String testPassword = "1234";
    String testEncodingPassword = passwordEncoder.encode(testPassword);

    if (!loginRequestDTO.getEmail().equals(testEmail)) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("존재 하지 않는 사용자입니다.");
    }

    if (!loginRequestDTO.getPassword().equals(testPassword)) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("비밀번호가 일치하지 않습니다.");
    }

    JWToken token = jwtGenerator.generateToken(1L);

    return ResponseEntity.ok(token);
  }
}

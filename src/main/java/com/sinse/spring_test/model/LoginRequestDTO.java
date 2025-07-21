package com.sinse.spring_test.model;

/* 로그인하면 대신 처리해주는 DTO(Data Time Object) */
public record LoginRequestDTO (String email, String password){}

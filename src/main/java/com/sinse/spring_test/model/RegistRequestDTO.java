package com.sinse.spring_test.model;

/* 가입 입력을 받으면 처리해주는 DTO(Data Time Object) */
public record RegistRequestDTO (long id, String email, String password, String nickname, String role){}

package com.sinse.spring_test.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "test용 hello controller야", description = "test용")
public class HelloController {

  @GetMapping("hello")
  public String hello(Model model) {
    model.addAttribute("data", "hello!!");
    return "hello";
  }

  @Operation(summary = "얘는 테스트야", description = "이거 사용하려면 그냥하면됨")
  @PostMapping("hello")
  public String hello1(Model model) {
    model.addAttribute("data", "hello!!");
    return "hello";
  }

  @PutMapping("hello")
  public String hello3(Model model) {
    model.addAttribute("data", "hello!!");
    return "hello";
  }

  @DeleteMapping("hello")
  public String hello5(Model model) {
    model.addAttribute("data", "hello!!");
    return "hello";
  }
}

package com.sinse.spring_test.domain;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import java.util.Collection;
import java.util.Collections;

import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
@Table(name = "users")
public class User implements UserDetails {
  @Id
  @GeneratedValue
  @Column(name = "user_id")
  private long id;

  @Column(length = 25)
  private String email;

  @Column(length = 100, nullable = false)
  private String password;

  @Column(length = 25, nullable = false)
  private String nickname;

  @Column(length = 25, nullable = false)
  private String role;

  @Builder
  public User(Long id, String email, String password, String nickname, String role) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.nickname = nickname;
    this.role = role;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singletonList(new SimpleGrantedAuthority(this.role));
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.nickname;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}

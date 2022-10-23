package com.bd.dipti.TestSpringSecurity.Security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@AllArgsConstructor
public class PasswordEncoder {
    @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder(){
      return new  BCryptPasswordEncoder();
  }
}

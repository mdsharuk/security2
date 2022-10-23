package com.bd.dipti.TestSpringSecurity.controller;
import com.bd.dipti.TestSpringSecurity.appuser.AppUser;
import com.bd.dipti.TestSpringSecurity.appuser.AppUserRole;
import com.bd.dipti.TestSpringSecurity.service.AppUserService;
import com.bd.dipti.TestSpringSecurity.service.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class RegistrationService {

    private  EmailValidator emailValidator;
    private  AppUserService appUserService;

    public String register(RegistrationRequest request) {
      boolean isValidEmail= emailValidator.
              test(request.getEmail());
      if(!isValidEmail){
          throw new IllegalStateException("Email not valid");
      }
        return appUserService.signUpUser(
               new AppUser(request.getName(),
                           request.getUsername(),
                   request.getEmail(),
                   request.getPassword(),
                 AppUserRole.USER)

        );

    }
}

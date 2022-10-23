package com.bd.dipti.TestSpringSecurity.service;


import com.bd.dipti.TestSpringSecurity.Repo.AppUserRepository;

import com.bd.dipti.TestSpringSecurity.appuser.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AppUserService implements UserDetailsService {

    private  static String USER_NOT_FOUND="user with email %s not found";

    private AppUserRepository appUserRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException
                        (String.format(USER_NOT_FOUND,email)));
    }
    public String signUpUser(AppUser appUser){
        boolean existingUser=appUserRepository
                .findByEmail(appUser.getEmail()).isPresent();


        if (existingUser){
            throw new IllegalStateException("Email already taken");
        }

       String encodePassword=bCryptPasswordEncoder
               .encode(appUser.getPassword());
        appUser.setPassword(encodePassword);

        appUserRepository.save(appUser);
        return "it works";
    }
    
    
    
}

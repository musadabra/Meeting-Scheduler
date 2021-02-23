package com.loizenai.jwtauthentication.service;

import com.loizenai.jwtauthentication.model.PasswordResetToken;
import com.loizenai.jwtauthentication.model.User;
import com.loizenai.jwtauthentication.repository.PasswordResetRepository;
import com.loizenai.jwtauthentication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    PasswordResetRepository passwordTokenRepository;

    @Autowired
    UserRepository userRepository;

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordTokenRepository.save(myToken);
    }
}

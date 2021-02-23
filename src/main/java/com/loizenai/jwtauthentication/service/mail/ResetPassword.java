package com.loizenai.jwtauthentication.service.mail;

import com.loizenai.jwtauthentication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;

import java.util.Locale;

public class ResetPassword {

    @Autowired
    private Environment env;

    public SimpleMailMessage constructResetTokenEmail(String contextPath, Locale locale, String token, User user) {

        String url = contextPath + "/user/changePassword?token=" + token;
//        String message = messages.getMessage("message.resetPassword", null, locale);

//        String message = messages.getMessage("message.resetPassword", null, locale);

//        return constructEmail("Reset Password", message + " \r\n" + url, user);

        return constructEmail("Reset Password", " \r\n" + url, user);

    }

    private SimpleMailMessage constructEmail(String subject, String body, User user) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(user.getEmail());
//        email.setFrom(env.getProperty("support.email"));
        email.setFrom("musadabra@gmail.com");
        return email;
    }
}

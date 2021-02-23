package com.loizenai.jwtauthentication.message.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class PasswordResetForm {

    @NotBlank
    @Email
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

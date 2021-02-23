package com.loizenai.jwtauthentication.repository;

import com.loizenai.jwtauthentication.model.PasswordResetToken;
import org.springframework.data.repository.CrudRepository;

public interface PasswordResetRepository extends CrudRepository<PasswordResetToken, Long> {
}

package com.loizenai.jwtauthentication.repository;

import com.loizenai.jwtauthentication.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimesloteRepository extends JpaRepository<TimeSlot, String> {

    Optional<TimeSlot> findByid(long id);
    Optional<TimeSlot> findByDate(String id);

    boolean existsById(String id);
    boolean existsByUserId(String id);

}

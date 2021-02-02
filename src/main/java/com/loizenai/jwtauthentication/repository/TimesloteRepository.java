package com.loizenai.jwtauthentication.repository;

import com.loizenai.jwtauthentication.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimesloteRepository extends JpaRepository<TimeSlot, String> {

    Optional<TimeSlot> findById(long id);
    Optional<TimeSlot> findByDate(String date);

    boolean existsById(long id);
    boolean existsByUserId(String id);

    void deleteById(long id);
}

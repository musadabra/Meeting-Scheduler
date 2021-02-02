package com.loizenai.jwtauthentication.scheduler;

import com.loizenai.jwtauthentication.model.TimeSlot;
import com.loizenai.jwtauthentication.repository.TimesloteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimeslotService {
    @Autowired
    TimesloteRepository timesloteRepository;

    public ResponseEntity<?> timeSlots(TimeSlot slot){

        List<TimeSlot> slots = new ArrayList<TimeSlot>();

        try{
            timesloteRepository.findAll().forEach(slots::add);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(slots, HttpStatus.OK);
    }

    public Optional<TimeSlot> timeSlot(long id) {
        return timesloteRepository.findByid(id);
    }

    //CREATE
    public void createTimeSlot(TimeSlot timeslot){
        TimeSlot slot = new TimeSlot(
                timeslot.getUserId(),
                timeslot.getDate(),
                timeslot.getStartTime(),
                timeslot.getEndTime()
        );
        timesloteRepository.save(slot);
    }


}

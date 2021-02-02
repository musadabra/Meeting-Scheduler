package com.loizenai.jwtauthentication.scheduler;

import com.loizenai.jwtauthentication.model.TimeSlot;
import com.loizenai.jwtauthentication.repository.TimesloteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimeslotService {
    @Autowired
    TimesloteRepository timesloteRepository;

    public List<TimeSlot> timeSlots(){
        return new ArrayList<TimeSlot>(
                timesloteRepository.findAll()
        );
    }

    public Optional<TimeSlot> timeSlot(String id) {
        return timesloteRepository.findByid(id);
    }

    //CREATE
    public void createTimeSlot(TimeSlot timeslot){
        timesloteRepository.save(timeslot);
    }
    //UPDATE
    //DELETE
}

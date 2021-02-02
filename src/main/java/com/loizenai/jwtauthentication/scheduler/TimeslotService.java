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

    public ResponseEntity<?> timeSlots(){

        List<TimeSlot> slots = new ArrayList<TimeSlot>();

        try{
            timesloteRepository.findAll().forEach(slots::add);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(slots, HttpStatus.OK);
    }

    //GET TIME SLOT{ID}
    public ResponseEntity<?> timeSlot(long id) {
            return new ResponseEntity<>(timesloteRepository.findById(id), HttpStatus.OK);
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

    //UPDATE TIME SLOT
    public ResponseEntity<?> updateSlot(TimeSlot slot, long id){
       Optional<TimeSlot> timeslot = timesloteRepository.findById(id);

       if(timeslot.isPresent()){
           TimeSlot aslot = timeslot.get();
           aslot.setUserId(slot.getUserId());
           aslot.setDate(slot.getDate());
           aslot.setStartTime(slot.getStartTime());
           aslot.setEndTime(slot.getEndTime());

           return new ResponseEntity<>(timesloteRepository.save(aslot), HttpStatus.OK);
       }else{
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }

    }

    //DELETE
    public void deleteTimeSlot(long id){
        timesloteRepository.deleteById(id);
    }


}

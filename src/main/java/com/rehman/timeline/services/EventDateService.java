package com.rehman.timeline.services;

import com.rehman.timeline.model.EventDate;
import com.rehman.timeline.repository.EventDateRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class EventDateService {

    @Autowired
    EventDateRepository eventDateRepository;


    public Optional<EventDate> findEventByDayMonthAndYear(Long day, Long month, Long year) {

        return eventDateRepository.findByDayMonthAndYear(day,month,year);
    }
}

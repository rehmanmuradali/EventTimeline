package com.rehman.timeline.services;

import com.rehman.timeline.model.Event;
import com.rehman.timeline.repositories.EventRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public void addAllEvent(Event[] events) {
        //eventRepository.saveAll(events)
    }

}

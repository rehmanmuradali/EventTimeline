package com.rehman.timeline.services;

import com.rehman.timeline.model.Event;
import com.rehman.timeline.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public void addAllEvent(Event[] events) {

    }

    public void saveAll(Event[] events) {
        eventRepository.saveAll(Arrays.asList(events));
    }

    public List<Event> getAllEvents() {
        List<Event> eventList = new ArrayList<>();
        eventRepository.findAll().forEach(eventList::add);
        return eventList;
    }
}

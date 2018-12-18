package com.rehman.timeline.controller;

import com.rehman.timeline.model.Event;
import com.rehman.timeline.services.EventService;
import com.rehman.timeline.util.StringUtil;
import com.rehman.timeline.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        try {
            List<Event> eventList = eventService.getAllEvents();


            if (eventList.size() > 0)
                return eventList;


            readAllEventsAndSave();
            return eventService.getAllEvents();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }


    @GetMapping("/{id}")
    public Event getEventById(@PathVariable(name = "id") Long id) {

        return eventService.findById(id);
    }


    @GetMapping("/year/{year}")
    public List<Event> getEventByYear(@PathVariable(name = "year") Long year) {
        return eventService.findEventByYear(year);
    }

    private void readAllEventsAndSave() {
        String fileContent = StringUtil.getHardCodedEventsJson();
        Event[] events = Utility.convertJsonToObject(fileContent, Event[].class);
        eventService.saveAll(events);
    }
}

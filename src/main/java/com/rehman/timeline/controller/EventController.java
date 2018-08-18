package com.rehman.timeline.controller;

import com.rehman.timeline.model.Event;
import com.rehman.timeline.services.EventService;
import com.rehman.timeline.util.StringUtil;
import com.rehman.timeline.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping("/events")
    public List<Event> getAllEvents() {
        List<Event> eventList = eventService.getAllEvents();

        if (eventList.size() > 0)
            return eventList;


        readAllEventsAndSave();
        return eventService.getAllEvents();
    }

    private void readAllEventsAndSave() {
        String fileContent = StringUtil.getHardCodedEventsJson();
        Event[] events = Utility.convertJsonToObject(fileContent, Event[].class);
        eventService.saveAll(events);
    }
}

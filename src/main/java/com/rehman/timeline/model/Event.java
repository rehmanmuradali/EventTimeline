package com.rehman.timeline.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Event {
    @Id
    private String Id;
    @OneToOne
    private EventDate start_date;
    @OneToOne
    private EventDetail text;
    private String display_date;

    public String getId() {
        return Id;
    }

    public EventDate getStart_date() {
        return start_date;
    }

    public EventDetail getText() {
        return text;
    }

    public String getDisplay_date() {
        return display_date;
    }
}


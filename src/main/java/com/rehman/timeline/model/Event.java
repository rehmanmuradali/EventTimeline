package com.rehman.timeline.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private EventDate start_date;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private EventDetail text;
    private String display_date;

    public Long getId() {
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


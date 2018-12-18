package com.rehman.timeline.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @OneToOne
    @JoinColumn(name = "start_date_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private EventDate startDate;



    @OneToOne
    @JoinColumn(name= "text_id")

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private EventDetail text;

    private String displayDate;


    public Event() {

    }


    public Event(EventDate startDate, EventDetail text, String displayDate) {
        this.startDate = startDate;
        this.text = text;
        this.displayDate = displayDate;
    }


    public Long getId() {
        return Id;
    }

    public EventDate getStartDate() {
        return startDate;
    }

    public EventDetail getText() {
        return text;
    }

    public String getDisplayDate() {
        return displayDate;
    }
}


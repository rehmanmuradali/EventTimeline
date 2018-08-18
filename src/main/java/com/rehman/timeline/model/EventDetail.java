package com.rehman.timeline.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EventDetail {
    @Id
    private String id;
    private String text;
    private String headline;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }
}

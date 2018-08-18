package com.rehman.timeline.model;


import javax.persistence.*;

@Entity
public class EventDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 10000)
    private String text;
    @Column(length = 2064)
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

    public Long getId() {
        return id;
    }
}

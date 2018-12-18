package com.rehman.timeline.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EventDate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;
    private String displayDate;


    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public String getDisplayDate() {
        return displayDate;
    }

    public void setDisplayDate(String displayDate) {
        this.displayDate = displayDate;
    }

    public Long getId() {
        return id;
    }
}

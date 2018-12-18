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
    private Long month;
    private Long day;
    private int hour;
    private int minute;
    private int second;
    private String displayDate;


    public EventDate() {

    }

    public EventDate(Long id,Long year, Long month, Long day) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
        displayDate = "\"<span class=\\\"date-display-single\\\" property=\\\"dc:date\\\" datatype=\\\"xsd:dateTime\\\" content=\\\"2018-03-21T00:00:00-04:00\\\">" + day + " " + month + " " + year + "</span>";
    }


    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long month) {
        this.month = month;
    }

    public Long getDay() {
        return day;
    }

    public void setDay(Long day) {
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

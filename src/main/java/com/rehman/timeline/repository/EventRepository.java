package com.rehman.timeline.repository;

import com.rehman.timeline.model.Event;
import com.rehman.timeline.model.EventDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

    @Query("SELECT new com.rehman.timeline.model.Event(e.startDate, e.text, e.displayDate )  FROM Event e, EventDate ed WHERE e.startDate.id = ed.id AND ed.year = :year")
    List<Event> findEventsByYear(@Param("year") Long year);


    List<Event> findEventsByStartDate(EventDate startDate);



}



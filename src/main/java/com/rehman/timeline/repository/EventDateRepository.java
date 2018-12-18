package com.rehman.timeline.repository;

import com.rehman.timeline.model.EventDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EventDateRepository extends JpaRepository<EventDate, Long> {

    @Query("SELECT new EventDate(ed.id, ed.day, ed.month, ed.year) FROM EventDate ed WHERE ed.day=:day AND ed.month=:month AND ed.year=:year")
    Optional<EventDate> findByDayMonthAndYear(@Param("day") Long day, @Param("month") Long month, @Param("year") Long year);

}

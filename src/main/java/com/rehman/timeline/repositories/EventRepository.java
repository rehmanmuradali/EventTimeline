package com.rehman.timeline.repositories;

import com.rehman.timeline.model.Event;
import org.springframework.data.repository.CrudRepository;

public abstract class EventRepository implements CrudRepository<Event,String> {
}

package com.rehman.timeline;

import com.rehman.timeline.model.Event;
import com.rehman.timeline.services.EventService;
import com.rehman.timeline.util.StringUtil;
import com.rehman.timeline.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimelineApplication {


	public static void main(String[] args) {
		SpringApplication.run(TimelineApplication.class, args);
	}


}

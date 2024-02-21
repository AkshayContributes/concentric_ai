package com.example.demo;

import com.example.demo.model.Event;
import com.example.demo.service.NewsfeedImpl;
import com.example.demo.service.NewsfeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	private static final NewsfeedService newsfeedService = new NewsfeedImpl();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		for(int i = 1; i<=20; i++){
			Event event = Event.builder().
					userId("user1").postId(String.format("post%s", i)).build();
			newsfeedService.addEvent(event);
		}
	}
}

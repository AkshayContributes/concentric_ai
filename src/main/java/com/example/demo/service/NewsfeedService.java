package com.example.demo.service;

import com.example.demo.model.Event;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface NewsfeedService {
    public List<Event> getNewsfeed(String userId);
    public Event addEvent(Event event);
}

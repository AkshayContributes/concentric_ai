package com.example.demo.service;

import com.example.demo.model.Event;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.springframework.stereotype.Service;

@Service
public class NewsfeedImpl implements NewsfeedService {
    private static final Map<String, PriorityQueue<Event>> newsfeeds = new HashMap<>();
    private static final List<Event> database = new ArrayList<>();

    @Override
    public List<Event> getNewsfeed(String userId) {
        return new ArrayList<>(newsfeeds.getOrDefault(userId, new PriorityQueue<>()));
    }

    @Override
    public Event addEvent(Event event) {
       addToNewsFeeds(event);
       addToDatabase(event);
       return event;
    }

    private void addToDatabase(Event event) {
        database.add(event);
    }

    private void addToNewsFeeds(Event event) {
        PriorityQueue<Event> newsFeedForUser = newsfeeds.getOrDefault(event.getUserId(),
                new PriorityQueue<Event>(10, Comparator.comparing(Event::getTimestamp)));
        event.setTimestamp( LocalDateTime.now());
        while(newsFeedForUser.size() >= 10){
            System.out.println(newsFeedForUser.poll());
        }
        newsFeedForUser.add(event);
        newsfeeds.put(event.getUserId(), newsFeedForUser);
    }


}

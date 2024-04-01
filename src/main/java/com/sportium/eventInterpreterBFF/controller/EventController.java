package com.sportium.eventInterpreterBFF.controller;

import com.sportium.eventInterpreterBFF.api.EventApi;
import com.sportium.eventInterpreterBFF.model.AmericanFootballEvent;
import com.sportium.eventInterpreterBFF.model.FootballEvent;
import com.sportium.eventInterpreterBFF.model.TennisEvent;
import com.sportium.eventInterpreterBFF.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class EventController implements EventApi {

    @Autowired
    private EventService eventService;

    @Override
    public ResponseEntity<FootballEvent> getFootballEvent(String event) {
        return ResponseEntity.ok().body(eventService.getFootballEvent(event));
    }

    @Override
    public ResponseEntity<TennisEvent> getTennisEvent(String event) {
        return ResponseEntity.ok().body(eventService.getTennisEvent(event));
    }

    @Override
    public ResponseEntity<AmericanFootballEvent> getAmericanFootballEvent(String event) {
        return ResponseEntity.ok().body(eventService.getAmericanFootballEvent(event));
    }
}
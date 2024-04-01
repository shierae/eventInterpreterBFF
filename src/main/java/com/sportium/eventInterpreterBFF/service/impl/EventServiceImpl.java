package com.sportium.eventInterpreterBFF.service.impl;

import com.sportium.eventInterpreterBFF.model.AmericanFootballEvent;
import com.sportium.eventInterpreterBFF.model.FootballEvent;
import com.sportium.eventInterpreterBFF.model.TennisEvent;
import com.sportium.eventInterpreterBFF.service.EventService;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    public FootballEvent getFootballEvent(String event) {
        return new FootballEvent();
    }

    public TennisEvent getTennisEvent(String event) {
        return new TennisEvent();
    }

    public AmericanFootballEvent getAmericanFootballEvent(String event) {
        return new AmericanFootballEvent();
    }

}
package com.sportium.eventInterpreterBFF.service.impl;

import com.sportium.eventInterpreterBFF.model.AmericanFootballEvent;
import com.sportium.eventInterpreterBFF.model.FootballEvent;
import com.sportium.eventInterpreterBFF.model.TennisEvent;
import com.sportium.eventInterpreterBFF.service.EventService;
import com.sportium.eventInterpreterBFF.service.InterpretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    InterpretService interpretService;

    public FootballEvent getFootballEvent(String event) {
        return interpretService.intrerpretFootballEvent(event);
    }

    public TennisEvent getTennisEvent(String event) {
        return interpretService.intrerpretTennisEvent(event);
    }

    public AmericanFootballEvent getAmericanFootballEvent(String event) {
        return interpretService.intrerpretAmericanFootballEvent(event);
    }

}
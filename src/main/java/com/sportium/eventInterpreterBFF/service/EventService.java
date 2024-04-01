package com.sportium.eventInterpreterBFF.service;

import com.sportium.eventInterpreterBFF.model.AmericanFootballEvent;
import com.sportium.eventInterpreterBFF.model.FootballEvent;
import com.sportium.eventInterpreterBFF.model.TennisEvent;

public interface EventService {

    public FootballEvent getFootballEvent(String event);

    public TennisEvent getTennisEvent(String event);

    public AmericanFootballEvent getAmericanFootballEvent(String event);
}
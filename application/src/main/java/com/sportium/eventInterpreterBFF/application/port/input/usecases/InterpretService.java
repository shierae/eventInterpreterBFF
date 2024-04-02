package com.sportium.eventInterpreterBFF.service;

import com.sportium.eventInterpreterBFF.model.AmericanFootballEvent;
import com.sportium.eventInterpreterBFF.model.FootballEvent;
import com.sportium.eventInterpreterBFF.model.TennisEvent;

public interface InterpretService {
    public FootballEvent intrerpretFootballEvent(String event);

    public TennisEvent intrerpretTennisEvent(String event);

    public AmericanFootballEvent intrerpretAmericanFootballEvent(String event);
}

package com.sportium.eventInterpreterBFF.service.impl;

import com.sportium.eventInterpreterBFF.model.AmericanFootballEvent;
import com.sportium.eventInterpreterBFF.model.FootballEvent;
import com.sportium.eventInterpreterBFF.model.TennisEvent;
import com.sportium.eventInterpreterBFF.service.InterpretService;
import com.sportium.eventInterpreterBFF.service.UtilsService;
import org.springframework.stereotype.Service;

@Service
public class InterpretServiceImpl implements InterpretService {

    @Override
    public FootballEvent intrerpretFootballEvent(String event) {
        String[] scores = UtilsService.extractScoreResults(event);
        String[] names = UtilsService.extractFootballTeamNames(event, scores[0]);

        FootballEvent footballEvent = new FootballEvent();
        UtilsService.mapFootballEvent(footballEvent, names, scores);

        return footballEvent;
    }

    @Override
    public TennisEvent intrerpretTennisEvent(String event) {
        String[] scores = UtilsService.extractScoreResults(event);
        String[] footballTeamNames = UtilsService.extractFootballTeamNames(event, scores[0]);
        String[] tennisTeamNames = UtilsService.extractTennisTeamNames(footballTeamNames);
        int[] sets = UtilsService.extractSets(footballTeamNames[0], footballTeamNames[1]);
        int[] games = UtilsService.extractGames(footballTeamNames[0], footballTeamNames[1]);
        boolean isServing = UtilsService.extractServing(footballTeamNames[1]);

        TennisEvent tennisEvent = new TennisEvent();
        UtilsService.mapTennisEvent(tennisEvent, tennisTeamNames, scores, sets, games, isServing);

        return tennisEvent;
    }

    @Override
    public AmericanFootballEvent intrerpretAmericanFootballEvent(String event) {
        String[] scores = UtilsService.extractScoreResults(event);
        String[] footballTeamNames = UtilsService.extractFootballTeamNames(event, scores[0]);
        String[] americanFootballTeamNames = UtilsService.extractAmericanFootballTeamNames(footballTeamNames);
        String period = UtilsService.extractPeriod(footballTeamNames[1]);

        AmericanFootballEvent americanFootballEvent = new AmericanFootballEvent();
        UtilsService.mapAmericanFootballEvent(americanFootballEvent, americanFootballTeamNames, scores, period);

        return americanFootballEvent;
    }
}

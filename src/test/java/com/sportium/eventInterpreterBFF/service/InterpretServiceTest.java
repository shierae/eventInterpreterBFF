package com.sportium.eventInterpreterBFF.service;

import com.sportium.eventInterpreterBFF.model.AmericanFootballEvent;
import com.sportium.eventInterpreterBFF.model.FootballEvent;
import com.sportium.eventInterpreterBFF.model.TennisEvent;
import com.sportium.eventInterpreterBFF.service.impl.InterpretServiceImpl;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class InterpretServiceTest {

    private InterpretServiceImpl interpretService = new InterpretServiceImpl();

    @Test
    public void testIntrerpretFootballEvent() {
        String event = "F.C. Barcelona 3-2 Real Madrid";

        FootballEvent result = interpretService.intrerpretFootballEvent(event);

        assertEquals("F.C. Barcelona", result.getTeamAName());
        assertEquals("Real Madrid", result.getTeamBName());
        assertEquals("3", result.getTeamAScore());
        assertEquals("2", result.getTeamBScore());
    }

    @Test
    public void testIntrerpretTennisEvent() {
        String event = "Anna Karolina Schmiedlova (1) 1 40-Adv 1 (0) *Varvara Lepchenko";

        TennisEvent result = interpretService.intrerpretTennisEvent(event);

        assertEquals("Anna Karolina Schmiedlova", result.getTeamAName());
        assertEquals("Varvara Lepchenko", result.getTeamBName());
        assertEquals("40", result.getTeamAScore());
        assertEquals("Adv", result.getTeamBScore());
        assertEquals(true, result.getIsServing());
        assertEquals("1", result.getTeamASets().toString());
        assertEquals("1", result.getTeamBSets().toString());
        assertEquals("1", result.getTeamAGames().toString());
        assertEquals("0", result.getTeamBGames().toString());
    }

    @Test
    public void testIntrerpretAmericanFootballEvent() {
        String event = "Pittsburgh Steelers 3-7 Minnesota Vikings 3rd Quarter";

        AmericanFootballEvent result = interpretService.intrerpretAmericanFootballEvent(event);

        assertEquals("Pittsburgh Steelers", result.getTeamAName());
        assertEquals("Minnesota Vikings", result.getTeamBName());
        assertEquals("3", result.getTeamAScore());
        assertEquals("7", result.getTeamBScore());
        assertEquals("3rd Quarter", result.getPeriod());
    }
}

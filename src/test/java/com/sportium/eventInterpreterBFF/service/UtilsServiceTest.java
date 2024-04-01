package com.sportium.eventInterpreterBFF.service;

import com.sportium.eventInterpreterBFF.model.AmericanFootballEvent;
import com.sportium.eventInterpreterBFF.model.FootballEvent;
import com.sportium.eventInterpreterBFF.model.TennisEvent;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UtilsServiceTest {

    @Test
    public void testExtractScoreResults() {
        String text = "F.C. Barcelona 3-2 Real Madrid";

        String[] expected = {"3-2", "3", "2"};

        String[] result = UtilsService.extractScoreResults(text);

        assertArrayEquals(expected, result);
    }

    @Test
    public void testExtractFootballTeamNames() {
        String text = "F.C. Barcelona 3-2 Real Madrid";
        String scores = "3-2";

        String[] expected = {"F.C. Barcelona", "Real Madrid"};
        assertArrayEquals(expected, UtilsService.extractFootballTeamNames(text, scores));
    }

    @Test
    public void testExtractAmericanFootballTeamNames() {
        String[] footballTeamNames = {"Pittsburgh Steelers", "Minnesota Vikings 3rd Quarter"};

        String[] expected = {"Pittsburgh Steelers", "Minnesota Vikings"};
        assertArrayEquals(expected, UtilsService.extractAmericanFootballTeamNames(footballTeamNames));
    }

    @Test
    public void testExtractSets() {
        String teamANameValid = "Anna Karolina Schmiedlova (1) 1";
        String teamBNameValid = "1 (0) *Varvara Lepchenko";
        int[] expectedValid = {1, 1};
        assertArrayEquals(expectedValid, UtilsService.extractSets(teamANameValid, teamBNameValid));
    }

    @Test
    public void testExtractGames() {
        String teamANameValid = "Anna Karolina Schmiedlova (1) 1";
        String teamBNameValid = "1 (0) *Varvara Lepchenko";
        int[] expectedValid = {1, 0};
        assertArrayEquals(expectedValid, UtilsService.extractGames(teamANameValid, teamBNameValid));
    }

    @Test
    public void testExtractServing() {
        String teamBNameServing = "1 (0) *Varvara Lepchenko";
        assertTrue(UtilsService.extractServing(teamBNameServing));
    }

    @Test
    public void testExtractPeriod() {
        String period = "Minnesota Vikings 3rd Quarter";
        assertEquals("3rd Quarter", UtilsService.extractPeriod(period));
    }

    @Test
    public void testMapFootballEvent() {
        FootballEvent footballEvent = new FootballEvent();
        String[] names = {"Team A", "Team B"};
        String[] scores = {"", "2", "3"};

        UtilsService.mapFootballEvent(footballEvent, names, scores);

        assertEquals("Team A", footballEvent.getTeamAName());
        assertEquals("Team B", footballEvent.getTeamBName());
        assertEquals("2", footballEvent.getTeamAScore());
        assertEquals("3", footballEvent.getTeamBScore());
    }

    @Test
    public void testMapTennisEvent() {
        TennisEvent tennisEvent = new TennisEvent();
        String[] names = {"Player 1", "Player 2"};
        String[] scores = {"", "6", "4"};
        int[] sets = {1, 0};
        int[] games = {6, 4};
        boolean isServing = true;

        UtilsService.mapTennisEvent(tennisEvent, names, scores, sets, games, isServing);

        assertEquals("Player 1", tennisEvent.getTeamAName());
        assertEquals("Player 2", tennisEvent.getTeamBName());
        assertEquals("4", tennisEvent.getTeamBScore());
        assertEquals("6", tennisEvent.getTeamAScore());
        assertEquals(1, tennisEvent.getTeamASets());
        assertEquals(0, tennisEvent.getTeamBSets());
        assertEquals(6, tennisEvent.getTeamAGames());
        assertEquals(4, tennisEvent.getTeamBGames());
    }

    @Test
    public void testMapAmericanFootballEvent() {
        AmericanFootballEvent americanFootballEvent = new AmericanFootballEvent();
        String[] names = {"Team A", "Team B"};
        String[] scores = {"", "7", "14"};
        String period = "2nd quarter";

        UtilsService.mapAmericanFootballEvent(americanFootballEvent, names, scores, period);

        assertEquals("Team A", americanFootballEvent.getTeamAName());
        assertEquals("Team B", americanFootballEvent.getTeamBName());
        assertEquals("7", americanFootballEvent.getTeamAScore());
        assertEquals("14", americanFootballEvent.getTeamBScore());
        assertEquals("2nd quarter", americanFootballEvent.getPeriod());
    }

}

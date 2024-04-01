package com.sportium.eventInterpreterBFF.service;

import com.sportium.eventInterpreterBFF.model.AmericanFootballEvent;
import com.sportium.eventInterpreterBFF.model.FootballEvent;
import com.sportium.eventInterpreterBFF.model.TennisEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilsService {

    public static String[] extractScoreResults(String text) {
        String[] result = new String[3];
        Pattern patron = Pattern.compile("(\\w+-\\w+)");
        Matcher matcher = patron.matcher(text);

        if (matcher.find()) {
            result[0] = matcher.group(1);
            String[] split = result[0].split("-");
            result[1] = split[0];
            result[2] = split[1];
        }
        return result;
    }

    public static String[] extractFootballTeamNames(String text, String scores) {
        String[] result = new String[2];
        String[] split = text.split(scores);

        result[0] = split[0].trim();
        result[1] = split[1].trim();

        return result;
    }

    public static String[] extractTennisTeamNames(String[] footballTeamNames) {
        String[] result = new String[2];
        String[] split = footballTeamNames[0].split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length - 2; i++) {
            stringBuilder.append(split[i]).append(" ");
        }
        result[0] = "";
        result[0] = stringBuilder.toString().trim();

        stringBuilder = new StringBuilder();
        split = footballTeamNames[1].split(" ");
        for (int i = 2; i < split.length; i++) {
            stringBuilder.append(split[i]).append(" ");
        }
        result[1] = "";
        result[1] = stringBuilder.toString().trim();
        result[1] = result[1].replace(String.valueOf('*'), "");

        return result;
    }

    public static String[] extractAmericanFootballTeamNames(String[] footballTeamNames) {
        String[] result = new String[2];

        result[0] = footballTeamNames[0].trim();

        String[] split = footballTeamNames[1].split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length - 2; i++) {
            stringBuilder.append(split[i]).append(" ");
        }
        result[1] = stringBuilder.toString().trim();

        return result;
    }

    public static int[] extractSets(String teamAName, String teamBName) {
        int[] result = new int[2];
        String[] split = teamAName.split(" ");

        result[0] = Integer.valueOf(split[split.length - 1]);
        split = teamBName.split(" ");
        result[1] = Integer.valueOf(split[0]);

        return result;
    }

    public static int[] extractGames(String teamAName, String teamBName) {
        int[] result = new int[2];
        String[] split = teamAName.split(" ");

        result[0] = Integer.valueOf(Character.toString(split[split.length - 2].toCharArray()[1]));
        split = teamBName.split(" ");
        result[1] = Integer.valueOf(Character.toString(split[1].toCharArray()[1]));

        return result;
    }

    public static boolean extractServing(String teamBName) {
        String[] split = teamBName.split(" ");
        return split[2].toCharArray()[0] == 42;
    }

    public static String extractPeriod(String teamBName) {
        String[] split = teamBName.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = split.length - 2; i < split.length; i++) {
            result.append(split[i]).append(" ");
        }

        return result.toString().trim();
    }

    public static void mapFootballEvent(FootballEvent footballEvent, String[] names, String[] scores) {
        footballEvent.setTeamAName(names[0]);
        footballEvent.setTeamBName(names[1]);

        footballEvent.setTeamAScore(scores[1]);
        footballEvent.setTeamBScore(scores[2]);
    }

    public static void mapTennisEvent(TennisEvent tennisEvent, String[] names, String[] scores, int[] sets, int[] games, boolean isServing) {
        tennisEvent.setTeamAName(names[0]);
        tennisEvent.setTeamBName(names[1]);

        tennisEvent.setTeamBScore(scores[2]);
        tennisEvent.setTeamAScore(scores[1]);

        tennisEvent.setTeamASets(sets[0]);
        tennisEvent.setTeamBSets(sets[1]);

        tennisEvent.setTeamAGames(games[0]);
        tennisEvent.setTeamBGames(games[1]);

        tennisEvent.setIsServing(isServing);
    }

    public static void mapAmericanFootballEvent(AmericanFootballEvent americanFootballEvent, String[] names, String[] scores, String period) {
        americanFootballEvent.setTeamAName(names[0]);
        americanFootballEvent.setTeamBName(names[1]);

        americanFootballEvent.setTeamAScore(scores[1]);
        americanFootballEvent.setTeamBScore(scores[2]);

        americanFootballEvent.setPeriod(period);
    }
}

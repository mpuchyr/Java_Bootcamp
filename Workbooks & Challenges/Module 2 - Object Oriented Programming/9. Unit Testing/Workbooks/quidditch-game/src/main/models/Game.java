package src.main.models;

import java.util.Arrays;
import java.util.HashMap;

public class Game {

    
    private HashMap<Team, Integer> scoreboard;
    private static int gameCount;
    private static final int QUAFFLE_POINTS = 10;
    private static final int SNITCH_POINTS = 150;


    public Game(Team home, Team away) {
        this.scoreboard = new HashMap<Team, Integer>();
        this.scoreboard.put(new Team(home), 0);
        this.scoreboard.put(new Team(away), 0);
        gameCount++;
    }

    public int getScore(Team team) {
        return this.scoreboard.get(team);
    }

    public Team getTeam(String name) {
        return this.scoreboard.keySet().stream()
            .filter((key) -> key.getHouse().equals(name))
            .findFirst()
            .orElse(null);
    }

    public Team[] getTeams() {
        Object[] objs = scoreboard.keySet().toArray();
        Team[] teams = new Team[objs.length];
        for (int i = 0; i < teams.length; i++) {
            teams[i] = new Team((Team)objs[i]);
        }

        return teams;
    }

    public void setScore(Team team, Integer score) {
        if (team == null) {
            throw new IllegalArgumentException("team cannot be null");
        }

        this.scoreboard.put(team, score);
    }

    public static int getGameCount() {
        return gameCount;
    }

    public String getPlaceholder(String play) {
        return play.substring(play.indexOf("<") + 1, play.indexOf(">"));
    }

    public String replacePlaceholder(String play, String placeholder, String value) {
        return play.replace("<" + placeholder + ">", value);
    }

    public void quaffleScore(Team team) {
        setScore(team, scoreboard.get(team) + QUAFFLE_POINTS);
    }

    public void catchSnith(Team team) {
        setScore(team, scoreboard.get(team) + SNITCH_POINTS);
    }

    public String simulate(String play) {
        String placeholder = getPlaceholder(play);
        Team team = getRandomTeam();
        if (placeholder.equals(Team.getPositionChaser())) {
            quaffleScore(team);
            String chaser = team.getChasers()[random(team.getChasers().length)];
            return replacePlaceholder(play, placeholder, chaser);
        } else if (placeholder.equals(Team.getPositionSeeker())) {
            catchSnith(team);
            return replacePlaceholder(play, placeholder, team.getSeeker());
        } else {
            return replacePlaceholder(play, placeholder, team.getKeeper());
        }
    }

    public Team getRandomTeam() {
        Object[] teams = scoreboard.keySet().toArray();
        return (Team)teams[random(teams.length)];        
    }

    public int random(int range) {
        return (int)(Math.random() * range);
    }

}

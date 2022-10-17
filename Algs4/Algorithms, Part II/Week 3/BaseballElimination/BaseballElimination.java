import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.HashMap;

public class BaseballElimination {
    private final int numOfTeams;
    private final HashMap<String, Team> teamsMap;
    private final String[] teams;

    // create a baseball division from given filename in format specified below
    public BaseballElimination(String filename) {
        In input = new In(filename);
        numOfTeams = input.readInt();
        teamsMap = new HashMap<>();
        teams = new String[numOfTeams];

        for (int i = 0; i < numOfTeams; i++) {
            String teamName = input.readString();
            int wins = input.readInt();
            int losses = input.readInt();
            int remaning = input.readInt();
            int[] against = new int[numOfTeams];

            for (int j = 0; j < numOfTeams; j++) {
                against[j] = input.readInt();
            }
            Team team = new Team(i, teamName, wins, losses, remaning, against);
            teamsMap.put(teamName, team);
            teams[i] = teamName;
        }
    }

    // number of teams
    public int numberOfTeams() {
        return numOfTeams;
    }

    // all teams
    public Iterable<String> teams() {
        return teamsMap.keySet();
    }

    // number of wins for given team
    public int wins(String team) {
        if (!teamsMap.containsKey(team)) {
            throw new IllegalArgumentException();
        }
        return teamsMap.get(team).getWins();
    }

    // number of losses for given team
    public int losses(String team) {
        if (!teamsMap.containsKey(team)) {
            throw new IllegalArgumentException();
        }
        return teamsMap.get(team).getLosses();
    }

    // number of remaining games for given team
    public int remaining(String team) {
        if (!teamsMap.containsKey(team)) {
            throw new IllegalArgumentException();
        }
        return teamsMap.get(team).getRemaning();
    }

    // number of remaining games between team1 and team2
    public int against(String team1, String team2) {
        if (!teamsMap.containsKey(team1) || !teamsMap.containsKey(team2)) {
            throw new IllegalArgumentException();
        }
        int id2 = teamsMap.get(team2).getId();

        return teamsMap.get(team1).getAgainst()[id2];
    }

    // is given team eliminated?
    public boolean isEliminated(String team) {
        if (!teamsMap.containsKey(team)) {
            throw new IllegalArgumentException();
        }
        return teamsMap.get(team).isEliminated();
    }

    // subset R of teams that eliminates given team; null if not eliminated
    public Iterable<String> certificateOfElimination(String team) {
        if (!teamsMap.containsKey(team)) {
            throw new IllegalArgumentException();
        }
        if (!isEliminated(team)) {
            return null;
        }
        return teamsMap.get(team).getCertificateOfElimination();
    }


    public static void main(String[] args) {
        BaseballElimination baseball = new BaseballElimination(args[0]);


        System.out.println(baseball.numberOfTeams());
        String[] baseballTeams = baseball.teams;
        System.out.println(Arrays.toString(baseballTeams));
        System.out.println(baseball.wins(baseballTeams[0]));
        System.out.println(baseball.losses(baseballTeams[0]));
        System.out.println(baseball.remaining(baseballTeams[0]));
        System.out.println(baseball.against(baseballTeams[0], baseballTeams[1]));
        System.out.println(baseball.isEliminated(baseballTeams[0]));
    }
}

import edu.princeton.cs.algs4.In;

import java.util.HashMap;

public class BaseballElimination {
    private int numOfTeams;
    private HashMap<String, Team> teamsMap;
    private String[] teams;

    // create a baseball division from given filename in format specified below
    public BaseballElimination(String filename) {
        In input = new In(filename);
        numOfTeams = Integer.parseInt(input.readLine());
        teamsMap = new HashMap<>();
        teams = new String[numOfTeams];
        int id = 0;
        while (!input.isEmpty()) {
            String[] line = input.readLine().split(" ");
            String teamName = line[0];
            teams[id] = teamName;
            int space = 1;
            for (int i = 1; i < line.length; i++) {
                if (!line[i].equals("")) {
                    break;
                }
                space++;
            }
            int wins = Integer.parseInt(line[space++]);
            int losses = Integer.parseInt(line[space++]);
            int remaning = Integer.parseInt(line[space++]);

            int[] against = new int[numOfTeams];
            int againstId = 0;
            for (int i = space + 2; i < line.length; i++) {
                against[againstId] = Integer.parseInt(line[i]);
                againstId++;
            }

            Team team = new Team(id, teamName, wins, losses, remaning, against);
            teamsMap.put(teamName, team);

            id++;
        }
    }

    public static void main(String[] args) {
        BaseballElimination baseballElimination = new BaseballElimination(args[0]);
    }
}

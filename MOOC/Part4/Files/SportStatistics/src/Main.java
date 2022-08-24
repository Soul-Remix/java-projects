import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner line = new Scanner(System.in);
        ArrayList<Game> games = new ArrayList<>();

        System.out.print("Name of the file: ");
        String fileName = line.nextLine();

        System.out.print("Team: ");
        String team = line.nextLine();

        try {
            Scanner scanner = new Scanner(Paths.get(fileName));

            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String[] rowArr = row.split(",");
                games.add(new Game(rowArr[0],
                        rowArr[1],
                        Integer.parseInt(rowArr[2]),
                        Integer.parseInt(rowArr[3])
                ));
            }
        } catch (Exception ex) {
            System.out.println("Reading the file " + fileName + " failed.");
            return;
        }

        var filteredGames = games.stream().filter(g -> {
            return g.getAwayTeam().equals(team) || g.getHomeTeam().equals(team);
        }).toList();

        int wins = 0;
        int losses = 0;

        for (Game game : filteredGames) {
            if (game.getHomeTeam().equals(team) && game.getHomeScore() > game.getAwayScore()) {
                wins++;
            } else if (game.getAwayTeam().equals(team) && game.getAwayScore() > game.getHomeScore()) {
                wins++;
            } else {
                losses++;
            }
        }
        System.out.println("Games: " + filteredGames.size());
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
    }
}
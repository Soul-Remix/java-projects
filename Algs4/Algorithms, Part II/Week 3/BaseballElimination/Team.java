import java.util.ArrayList;
import java.util.Arrays;

public class Team {

    private final int id;
    private final String teamName;
    private final int wins;
    private final int losses;
    private final int remaning;
    private final int[] against;
    private boolean isEliminated = false;
    private ArrayList<String> certificateOfElimination = new ArrayList<>();


    public Team(int id, String teamName, int wins, int losses, int remaning, int[] against) {
        this.id = id;
        this.teamName = teamName;
        this.wins = wins;
        this.losses = losses;
        this.remaning = remaning;
        this.against = against;
    }

    public int getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getRemaning() {
        return remaning;
    }

    public int[] getAgainst() {
        return against;
    }

    public boolean isEliminated() {
        return isEliminated;
    }

    public void setIsEliminated(boolean eliminated) {
        isEliminated = eliminated;
    }

    public ArrayList<String> getCertificateOfElimination() {
        return certificateOfElimination;
    }

    public void setCertificateOfElimination(ArrayList<String> certificateOfElimination) {
        this.certificateOfElimination = certificateOfElimination;
    }

    public String toString() {
        return "Team{" +
                "id=" + id +
                ", teamName='" + teamName + '\'' +
                ", wins=" + wins +
                ", losses=" + losses +
                ", remaning=" + remaning +
                ", against=" + Arrays.toString(against) +
                '}';
    }
}

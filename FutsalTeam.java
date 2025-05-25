import java.util.ArrayList;
import java.util.Comparator;

public class FutsalTeam {
    private String name;
    private ArrayList<Player> players;

    public FutsalTeam(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    
    public void addPlayer(Player p) {
        players.add(p);
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

    public ArrayList<Player> getSortedByHeight(boolean ascending) {
        ArrayList<Player> sortedList = new ArrayList<>(players);
        if (ascending) {
            sortedList.sort(Comparator.comparingInt(Player::getHeight));
        } else {
            sortedList.sort(Comparator.comparingInt(Player::getHeight).reversed());
        }
        return sortedList;
    }

    public ArrayList<Player> getSortedByWeight(boolean ascending) {
        ArrayList<Player> sortedList = new ArrayList<>(players);
        if (ascending) {
            sortedList.sort(Comparator.comparingInt(Player::getWeight));
        } else {
            sortedList.sort(Comparator.comparingInt(Player::getWeight).reversed());
        }
        return sortedList;
    }

    public int getMinHeight() {
        return players.stream().mapToInt(Player::getHeight).min().orElse(0);
    }

    public int getMaxHeight() {
        return players.stream().mapToInt(Player::getHeight).max().orElse(0);
    }

    public int getMinWeight() {
        return players.stream().mapToInt(Player::getWeight).min().orElse(0);
    }

    public int getMaxWeight() {
        return players.stream().mapToInt(Player::getWeight).max().orElse(0);
    }
}

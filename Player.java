public class Player {
    private String team;
    private int height;
    private int weight;

    public Player(String team, int height, int weight) {
        this.team = team;
        this.height = height;
        this.weight = weight;
    }

    public String getTeam() {
        return team;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Team " + team + " | Height: " + height + " cm, Weight: " + weight + " kg";
    }
}

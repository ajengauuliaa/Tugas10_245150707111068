import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FutsalTeamAnalysis {
    public static void main(String[] args) {
        // Membuat Tim A dan Tim B beserta data sample masing-masing
        FutsalTeam teamA = new FutsalTeam("A");
        teamA.addPlayer(new Player("A", 172, 56));
        teamA.addPlayer(new Player("A", 168, 53));
        teamA.addPlayer(new Player("A", 165, 55));
        teamA.addPlayer(new Player("A", 170, 59));
        
        FutsalTeam teamB = new FutsalTeam("B");
        teamB.addPlayer(new Player("B", 168, 60));
        teamB.addPlayer(new Player("B", 160, 55));
        teamB.addPlayer(new Player("B", 170, 58));
        teamB.addPlayer(new Player("B", 160, 57));
        
        // Menggabungkan pemain dari kedua tim untuk operasi global
        ArrayList<Player> allPlayers = new ArrayList<>();
        allPlayers.addAll(teamA.getPlayers());
        allPlayers.addAll(teamB.getPlayers());
        
        // Contoh sorting: berdasarkan tinggi (ascending) dan berat (descending)
        ArrayList<Player> sortedByHeightAsc = new ArrayList<>(allPlayers);
        Collections.sort(sortedByHeightAsc, Comparator.comparingInt(Player::getHeight));
        System.out.println("Sorting by Height Ascending:");
        for (Player p : sortedByHeightAsc) {
            System.out.println(p);
        }
        System.out.println();
        
        ArrayList<Player> sortedByWeightDesc = new ArrayList<>(allPlayers);
        Collections.sort(sortedByWeightDesc, Comparator.comparingInt(Player::getWeight).reversed());
        System.out.println("Sorting by Weight Descending:");
        for (Player p : sortedByWeightDesc) {
            System.out.println(p);
        }
        System.out.println();
        
        // Menampilkan nilai minimum dan maksimum masing-masing tim
        System.out.println("Tim A => Min Height: " + teamA.getMinHeight() + " cm, Max Height: " + teamA.getMaxHeight() +
                           " cm, Min Weight: " + teamA.getMinWeight() + " kg, Max Weight: " + teamA.getMaxWeight() + " kg");
        System.out.println("Tim B => Min Height: " + teamB.getMinHeight() + " cm, Max Height: " + teamB.getMaxHeight() +
                           " cm, Min Weight: " + teamB.getMinWeight() + " kg, Max Weight: " + teamB.getMaxWeight() + " kg");
        System.out.println();
        
        // Copy data Tim B ke Tim C
        FutsalTeam teamC = new FutsalTeam("C");
        for (Player p : teamB.getPlayers()) {
            teamC.addPlayer(p); // Perlu diingat, ini merupakan shallow copy. Untuk deep copy, buat objek Player baru.
        }
        System.out.println("Data Tim C (hasil copy dari Tim B):");
        for (Player p : teamC.getPlayers()) {
            System.out.println(p);
        }
        System.out.println();

        // Implementasi Binary Search:
        // Pada Tim B: Cari jumlah pemain dengan tinggi 168 cm dan 160 cm.
        ArrayList<Player> teamBSortedByHeight = teamB.getSortedByHeight(true);
        int count168 = BinarySearchUtil.binarySearchCountByHeight(teamBSortedByHeight, 168);
        int count160 = BinarySearchUtil.binarySearchCountByHeight(teamBSortedByHeight, 160);
        System.out.println("Jumlah pemain Tim B dengan tinggi 168 cm: " + count168);
        System.out.println("Jumlah pemain Tim B dengan tinggi 160 cm: " + count160);
        System.out.println();
        
        // Pada Tim A: Cari jumlah pemain dengan berat 56 kg dan 53 kg.
        ArrayList<Player> teamASortedByWeight = teamA.getSortedByWeight(true);
        int countWeight56 = BinarySearchUtil.binarySearchCountByWeight(teamASortedByWeight, 56);
        int countWeight53 = BinarySearchUtil.binarySearchCountByWeight(teamASortedByWeight, 53);
        System.out.println("Jumlah pemain Tim A dengan berat 56 kg: " + countWeight56);
        System.out.println("Jumlah pemain Tim A dengan berat 53 kg: " + countWeight53);
        System.out.println();
        
        // Cek apakah terdapat pemain di Tim A yang mempunyai tinggi atau berat sama dengan pemain di Tim B.
        ArrayList<Player> teamBSortedByWeight = teamB.getSortedByWeight(true);
        boolean commonFound = false;
        for (Player p : teamA.getPlayers()) {
            int idxHeight = Collections.binarySearch(teamBSortedByHeight, new Player("", p.getHeight(), 0),
                    Comparator.comparingInt(Player::getHeight));
            int idxWeight = Collections.binarySearch(teamBSortedByWeight, new Player("", 0, p.getWeight()),
                    Comparator.comparingInt(Player::getWeight));
            if (idxHeight >= 0 || idxWeight >= 0) {
                commonFound = true;
                break;
            }
        }
        if (commonFound) {
            System.out.println("Ada pemain di Tim A yang mempunyai tinggi atau berat yang sama dengan pemain di Tim B.");
        } else {
            System.out.println("Tidak ada pemain di Tim A yang mempunyai tinggi atau berat yang sama dengan pemain di Tim B.");
        }
    }
}

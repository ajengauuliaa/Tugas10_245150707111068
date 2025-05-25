import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BinarySearchUtil {

    // Method untuk menghitung jumlah pemain dengan tinggi tertentu pada list yang sudah diurutkan berdasarkan tinggi.
    public static int binarySearchCountByHeight(ArrayList<Player> list, int targetHeight) {
        Comparator<Player> heightComparator = Comparator.comparingInt(Player::getHeight);
        int index = Collections.binarySearch(list, new Player("", targetHeight, 0), heightComparator);
        if (index < 0) return 0;
        int count = 1;
        int i = index - 1;
        while (i >= 0 && list.get(i).getHeight() == targetHeight) {
            count++; 
            i--;
        }
        int j = index + 1;
        while (j < list.size() && list.get(j).getHeight() == targetHeight) {
            count++; 
            j++;
        }
        return count;
    }

    // Method untuk menghitung jumlah pemain dengan berat tertentu pada list yang sudah diurutkan berdasarkan berat.
    public static int binarySearchCountByWeight(ArrayList<Player> list, int targetWeight) {
        Comparator<Player> weightComparator = Comparator.comparingInt(Player::getWeight);
        int index = Collections.binarySearch(list, new Player("", 0, targetWeight), weightComparator);
        if (index < 0) return 0;
        int count = 1;
        int i = index - 1;
        while (i >= 0 && list.get(i).getWeight() == targetWeight) {
            count++; 
            i--;
        }
        int j = index + 1;
        while (j < list.size() && list.get(j).getWeight() == targetWeight) {
            count++; 
            j++;
        }
        return count;
    }
}

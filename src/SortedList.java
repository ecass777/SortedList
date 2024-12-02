// SortedList.java
import java.util.ArrayList;

public class SortedList {

    private ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    public void add(String s) {
        int index = findInsertionPoint(s);
        list.add(index, s);
    }

    private int findInsertionPoint(String s) {
        int low = 0;
        int high = list.size();

        while (low < high) {
            int mid = (low + high) / 2;
            String midVal = list.get(mid);
            if (midVal.compareTo(s) < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int binarySearch(String s) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midVal = list.get(mid);
            int cmp = midVal.compareTo(s);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid -1;
            } else {
                return mid; // Key found
            }
        }
        return -(low + 1); // Key not found
    }

    public ArrayList<String> getList() {
        return list;
    }
}

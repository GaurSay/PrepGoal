package BinarySearch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Nmeetingrooms {

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end   = {2, 4, 6, 7, 9, 9};

        maxMeetings(start, end);
    }

    private static List<Integer> maxMeetings(int[] start, int[] end) {
        // Store meetings as (end_time, start_time, index)
        List<int[]> meetings = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            // i+1 for 1-based index
            meetings.add(new int[]{end[i], start[i], i + 1});

        }

        // Sort by end time
        meetings.sort(Comparator.comparingInt(a -> a[0]));

        List<Integer> result = new ArrayList<>();
        int lastEnd = -1;

        for (int[] m : meetings) {
            // If meeting can be scheduled
            if (m[1] > lastEnd) {
                // Store original index
                result.add(m[2]);
                // Update last meeting end time
                lastEnd = m[0];
            }
        }
        return result;
    }
}

package SlidingWindow;

import java.util.*;

class Event {
    int timestamp;
    String user;

    Event(int timestamp, String user) {
        this.timestamp = timestamp;
        this.user = user;
    }
}

public class RateLimiter {

    public static Set<String> findUsers(List<Event> events, int k, int window) {

        Map<String, Deque<Integer>> map = new HashMap<>();
        Set<String> flagged = new HashSet<>();

        for (Event e : events) {

            map.putIfAbsent(e.user, new ArrayDeque<>());
            Deque<Integer> q = map.get(e.user);

            // Remove expired timestamps
            while (!q.isEmpty() && q.peekFirst() <= e.timestamp - window) {
                q.pollFirst();
            }

            // Add current request
            q.offerLast(e.timestamp);

            // Check limit
            if (q.size() > k) {
                flagged.add(e.user);
            }
        }

        return flagged;
    }

    public static void main(String[] args) {

        List<Event> events = List.of(
                new Event(1, "A"),
                new Event(2, "A"),
                new Event(3, "B"),
                new Event(4, "A"),
                new Event(5, "A"),
                new Event(6, "B"),
                new Event(7, "A")
        );

        System.out.println(findUsers(events, 3, 5));
    }
}

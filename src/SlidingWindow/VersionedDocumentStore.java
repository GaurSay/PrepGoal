package SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


class VersionedDocumentStore {

        private Map<Integer, TreeMap<Integer, String>> store;

        public VersionedDocumentStore() {
            store = new HashMap<>();
        }

        public void put(int docId, String content, int timestamp) {

            store.putIfAbsent(docId, new TreeMap<>());
            store.get(docId).put(timestamp, content);
        }

        public String get(int docId, int timestamp) {

            if (!store.containsKey(docId))
                return "";

            TreeMap<Integer, String> versions = store.get(docId);

            Map.Entry<Integer, String> entry = versions.floorEntry(timestamp);

            if (entry == null)
                return "";

            return entry.getValue();
        }

        public static void main(String[] args) {

            VersionedDocumentStore db = new VersionedDocumentStore();

            db.put(1, "abc", 10);
            db.put(2, "bcd", 11);
            db.put(1, "cde", 8);
            db.put(2, "def", 9);

            System.out.println(db.get(1, 5));   // ""
            System.out.println(db.get(1, 9));   // cde
            System.out.println(db.get(2, 15));  // bcd
        }
    }

package Day02_stack_queue;

// Custom Hash Map Implementation in Java
import java.util.LinkedList;

// Class to represent a key-value pair
class Entry<K, V> {
    K key;
    V value;

    Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class CustomHashMap<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;

    // Constructor to initialize the hash map
    public CustomHashMap() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Method to compute the bucket index for a given key
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    // Method to insert or update a key-value pair
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value; // Update existing value
                return;
            }
        }

        bucket.add(new Entry<>(key, value)); // Insert new entry
    }

    // Method to retrieve a value by its key
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null; // Key not found
    }

    // Method to remove a key-value pair
    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];

        bucket.removeIf(entry -> entry.key.equals(key));
    }

    // Main method for testing the CustomHashMap
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        // Insert key-value pairs
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        // Retrieve values
        System.out.println("Value for 'One': " + map.get("One"));
        System.out.println("Value for 'Two': " + map.get("Two"));

        // Remove a key-value pair
        map.remove("Two");
        System.out.println("Value for 'Two' after removal: " + map.get("Two"));
    }
}

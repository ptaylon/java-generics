package examples;

public class PairExample<K,V> {

    K key;
    V value;

    public PairExample(final K key, final V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public static void main(String[] args) {

        PairExample<Integer, String> studentData = new PairExample<>(1, "Louis");
        System.out.println(
            "Key: " + studentData.getKey() +
            ", Value: " + studentData.getValue()
        );

    }

}
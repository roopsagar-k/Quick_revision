import java.util.ArrayList;
import java.util.LinkedList;
public class HashMapImplementation {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;
            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // n - nodes
        private int N; // N - buckets.length
        private LinkedList<Node> buckets[]; // Linkedlist array

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.n = 0;
            this.buckets = new LinkedList[4];
            for(int i=0; i<4; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int bi = key.hashCode(); //-12334 +1234
            bi = Math.abs(bi) % N;
            return bi;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for(int i=0; i<ll.size(); i++) {
                if(ll.get(i).key == key) {
                    return i;
                }
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[N*2];
            N = N*2;
            for(int i=0; i<N*2; i++) {
                buckets[i] = new LinkedList<>();
            }
            for(int i=0; i<oldBuckets.length; i++) {
                for(int j=0; j<oldBuckets[i].size(); j++) {
                    put(oldBuckets[i].get(j).key, oldBuckets[i].get(j).value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di == -1) {
                buckets[bi].add(new Node(key, value));
                n++;
            } else {
                buckets[bi].get(di).value = value;
            }

            double lamda = n/N;
            if(lamda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di == -1) {
                return false;
            }

            return true;
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di != -1) {
                V value = buckets[bi].get(di).value;
                buckets[bi].remove(di);
                n--;
                return value;
            }
            return null;
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if(di != -1) {
                V value = buckets[bi].get(di).value;
                return value;
            }
            return null;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<buckets.length; i++) {
                for(int j=0; j<buckets[i].size(); j++) {
                   keys.add(buckets[i].get(j).key);
                }
            }
            return keys.size() > 0 ? keys : null;
        }

        public boolean isEmpty() {
           return n == 0;
        }

    }
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("China", 120);
        map.put("India", 145);
        map.put("Nepal", 3);

        ArrayList<String> keys = map.keySet();
         
        int i = 0;
        while(!map.isEmpty()) {
            System.out.println(keys.get(i) + " -> " + map.get(keys.get(i)));
            map.remove(keys.get(i));
            i++;
        }
    }
}
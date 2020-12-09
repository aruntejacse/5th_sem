package ada9;

public class HashTable {
    String[][] table;
    int tableSize;

    HashTable(int size) {
        table = new String[size][];
        tableSize = size;
    }

    public void add(String key, String value) {

        if (key == null || value == null) {
            System.out.println("Cannot input null values");
        }

        int iter = 0;
        int code = Math.abs(key.hashCode()) % tableSize;

        if (table[code] == null) {
            table[code] = new String[]{key, value};
        } else {

            while (table[code] != null) {
                if (table[code][0].equals(key)) {
                    System.out.println("Already submitted the word " + key);
                    return;
                }

                if (iter == tableSize) {
                    System.out.println("Table is full. Cannot add word \"" + key + "\"");
                    return;
                }

                code++;
                code %= tableSize;
                iter++;
            }

            table[code] = new String[]{key, value};

        }
    }
    public void remove(String key) {

        if (key == null) {
            System.out.println("Cannot input null value");
        }

        int iter = 0;
        int code = Math.abs(key.hashCode()) % tableSize;

        if (table[code][0].equals(key)) {
            table[code] = null;
        } else {
            while (!table[code][0].equals(key)) {
                if (iter == tableSize) {
                    System.out.println("Could not find word \"" + key + "\"");
                    return;
                }
                code++;
                code %= tableSize;
                iter++;
            }

            table[code] = null;

        }
    }

    public String get(String key) {

        if (key == null) {
            return "Cannot input null value.";
        }

        int iter = 0;
        int code = Math.abs(key.hashCode()) % tableSize;

        if (table[code][0].equals(key)) {
            return table[code][1];
        } else {
            while (!table[code][0].equals(key)) {
                if (iter == tableSize) {
                    return "Could not find word \"" + key + "\"";
                }
                code++;
                code %= tableSize;
                iter++;
            }

            return table[code][1];

        }
    }
    
    public static void main(String args[]) {
    	HashTable hash = new HashTable(5);
    	
    	hash.add("One", "1");
    	hash.add("Two", "2");
    	hash.add("Three", "3");
    	
    	String str = hash.get("Three");
    	System.out.println(str);
    	hash.remove("Two");
    }

}
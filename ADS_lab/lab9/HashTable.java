package ada9;

import java.util.Scanner;

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
    	Scanner se = new Scanner(System.in);
    	System.out.print("Enter 1: Add into Dictionary\n2: Remove from Dictionary\n3: Get element from a given key\n-1:Exit");
    	int choice = 0;
    	while(choice != -1) {
    		choice = se.nextInt();
    		switch(choice) {
    			case 1: System.out.println("Enter key:");
    					String key = se.next();
    					System.out.println("Enter value:");
    					String val = se.next();
    					hash.add(key, val);
    					break;
    			case 2:	System.out.println("Enter key to remove:");
						String key2 = se.next();
						hash.remove(key2);
						break;
    			case 3: System.out.println("Enter key to Get:");
						String key3 = se.next();
						System.out.println("Key:"+key3+" Value: "+hash.get(key3));
						break;
				default: System.out.print("Enter right number");
						break;
    		}
    	}
    }

}
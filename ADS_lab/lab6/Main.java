package ada5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Operations<Integer> tree = new Operations<>();
        Scanner scanner = new Scanner(System.in);

        /* Menu */
        while (true) {
            System.out.println("\n2-3-Tree Operations:");
            System.out.println("1) Insert new element");
            System.out.println("2) Remove element");
            System.out.println("3) Display tree");
            System.out.println("0) Exit...\n");

            try {
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.print("Enter integer element to insert: ");
                        tree.add(scanner.nextInt());
                        break;
                    }
                    case 2: {
                        if (tree.isEmpty()) {
                            System.out.println("The tree is empty...");
                        } else {
                            System.out.print("Enter integer element to remove: ");
                            System.out.println("Remove result: " + tree.remove(scanner.nextInt()));
                        }
                        break;
                    }
                    case 3: {
                        System.out.print("\nIn-order: ");
                        tree.inOrder();
                        break;
                    }
                    case 0: {
                        return;
                    }
                    default: {
                        System.out.println("\nWrong Entry!");
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("The value entered is invalid. Try again.");
                break;
            }
        }
    }
}

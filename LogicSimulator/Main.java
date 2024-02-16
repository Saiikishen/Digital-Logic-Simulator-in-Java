package LogicSimulator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter your preffered Gate : ");
        String choice = scanner.nextLine(); 
        Gate gate = null;
        switch (choice) {
            case "AND":
                gate = new AND();
                break;
            case "OR":
                gate = new OR();
                break;
            case "XOR":
                gate = new XOR();
                break;
            case "NAND":
                gate = new NAND();
                break;
            case "NOR":
                gate = new NOR();
                break;
            case "NOT":
                gate = new NOT();
                int[] inputPins = new int[1];
                System.out.print("Enter input pin (0 or 1): ");
                inputPins[0] = scanner.nextInt();
                int output = gate.Logic(inputPins);
                System.out.println("Gate output: " + output);
                System.exit(0);

            case "MUX":
                gate = new Mux();
                break;
                

            default:
                System.out.println("Invalid choice.");
                System.exit(1);
        }

        int[] inputPins;
        if (choice.equals("MUX")) {
            inputPins = new int[3];
            try {
                System.out.print("Enter data input 0 (0 or 1): ");
                inputPins[0] = scanner.nextInt();
                System.out.print("Enter data input 1 (0 or 1): ");
                inputPins[1] = scanner.nextInt();
                System.out.print("Enter control line (0 or 1): ");
                inputPins[2] = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Enter 0 or 1.");
                System.exit(1);
            }
        } 
        
        else {
            inputPins = new int[2];
            try {
                System.out.print("Enter input pin (0 or 1): ");
                inputPins[0] = scanner.nextInt();
                System.out.print("Enter input pin (0 or 1): ");
                inputPins[1] = scanner.nextInt();
                scanner.nextLine(); 
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter 0 or 1.");
                System.exit(1);
            }
        }

        int output = gate.Logic(inputPins);
        System.out.println("Gate output: " + output);

        scanner.close();
    }
}
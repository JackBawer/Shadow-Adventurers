package Game;

import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Personnage selectedCharacter = null;

        boolean continuePlaying = true;

        // Main game loop
        while (continuePlaying) {
            // Display main menu
            UI.printMainMenu();
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Character selection
                System.out.println("Choose your character:");
                System.out.println("1. Guerrier");
                System.out.println("2. Mage");
                System.out.println("3. Voleur");
                int characterChoice = scanner.nextInt();

                System.out.print("Enter your character's name: ");
                scanner.nextLine();  // Consume newline
                String characterName = scanner.nextLine();

                // Create selected character
                switch (characterChoice) {
                    case 1:
                        selectedCharacter = new Guerrier(characterName);
                        break;
                    case 2:
                        selectedCharacter = new Mage(characterName);
                        break;
                    case 3:
                        selectedCharacter = new Voleur(characterName);
                        break;
                    default:
                        System.out.println("Invalid choice, defaulting to Guerrier.");
                        selectedCharacter = new Guerrier(characterName);
                        break;
                }

                boolean continueDueling = true;

                while (continueDueling) {
                    // Start the arena duel
                    Arena arena = new Arena(selectedCharacter);
                    arena.commencerDuel();

                    // Ask player if they want to play another duel
                    System.out.println("Do you want to play another duel? (yes/no)");
                    String response = scanner.nextLine().trim().toLowerCase();
                    if (!response.equals("yes")) {
                        continueDueling = false;
                    }
                }
            } else if (choice == 2) {
                continuePlaying = false;
                System.out.println("Exiting the game.");
            } else {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
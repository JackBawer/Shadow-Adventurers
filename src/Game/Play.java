package Game;

import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Personnage selectedCharacter = null;

        // Display main menu
        System.out.println("Welcome to Shadow Adventurers!");
        System.out.println("Choose your action:");
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
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

            // Start the arena duel
            Arena arena = new Arena(selectedCharacter);
            arena.commencerDuel();
        } else {
            System.out.println("Exiting the game.");
        }

        scanner.close();
    }
}

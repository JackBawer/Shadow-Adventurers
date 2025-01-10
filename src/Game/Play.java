package Game;

import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Character selectedCharacter = null;
        Story story = null;

        boolean continuePlaying = true;

        // Display the game introduction
        Story.displayIntroduction();

        // Main game loop
        while (continuePlaying) {
            // Display main menu
            UI.printMainMenu();
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Character selection
                System.out.println("Choose your character:");
                System.out.println("1. Warrior");
                System.out.println("2. Wizard");
                System.out.println("3. Thief");
                int characterChoice = scanner.nextInt();

                System.out.print("Enter your character's name: ");
                scanner.nextLine();  // Consume newline
                String characterName = scanner.nextLine();
                String characterClass = "";

                // Create selected character
                switch (characterChoice) {
                    case 1:
                        selectedCharacter = new Warrior(characterName);
                        characterClass = "Warrior";
                        story = new Story(characterClass, characterName);
                        break;
                    case 2:
                        selectedCharacter = new Wizard(characterName);
                        characterClass = "Wizard";
                        story = new Story(characterClass, characterName);
                        break;
                    case 3:
                        selectedCharacter = new Thief(characterName);
                        characterClass = "Thief";
                        story = new Story(characterClass, characterName);
                        break;
                    default:
                        System.out.println("Invalid choice, defaulting to Warrior.");
                        selectedCharacter = new Warrior(characterName);
                        characterClass = "Warrior";
                        story = new Story(characterClass, characterName);
                        break;
                }

                // Start the journey
                story.startJourney();

                boolean continueDueling = true;

                while (continueDueling) {
                    // Start the arena duel
                    Arena arena = new Arena(selectedCharacter);
                    arena.startDuel();

                    // Display reflection after the duel
                    story.displayEndgameReflection(selectedCharacter.estVivant());

                    // Ask player if they want to play another duel
                    System.out.println("Do you want to play another duel? (yes/no)");
                    String response = scanner.nextLine().trim().toLowerCase();
                    if (!response.equals("yes")) {
                        continueDueling = false;
                    } else {
                        // Progress the story with a choice
                        System.out.println("Choose your next step in the journey:");
                        System.out.println("1. Venture into the Abyss");
                        System.out.println("2. Seek counsel from the Oracle of the Ego");
                        System.out.println("3. Confront the shadow directly");
                        int storyChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        story.progressStory(storyChoice);

                        // Display a hint based on character class
                        Story.displayHint(characterClass);
                    }
                }

                // Conclude the journey
                story.concludeJourney();

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
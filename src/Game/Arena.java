package Game;

import java.util.Random;
import java.util.Scanner;

public class Arena {
    private Character player;
    private Character opponent;
    private Scanner scanner;
    private static int duelCount = 0; // Track the number of duels

    public Arena(Character player) {
        this.player = player;
        this.scanner = new Scanner(System.in);
        this.opponent = generateOpponent();  // Generate a random AI opponent
    }

    private Character generateOpponent() {
        duelCount++;
        // Randomly select an AI opponent (could be Warrior, Wizard, or Thief)
        Random rand = new Random();
        int choice = rand.nextInt(3);
        String opponentName = "Shadow ";

        switch (choice) {
            case 0:
                opponentName += "Warrior";
                return new Warrior(opponentName, duelCount);
            case 1:
                opponentName += "Wizard";
                return new Wizard(opponentName, duelCount);
            case 2:
                opponentName += "Thief";
                return new Thief(opponentName, duelCount);
            default:
                opponentName += "Warrior";
                return new Warrior(opponentName, duelCount);  // Default case
        }
    }

    public void startDuel() {
        // Reset player's HP to full before each duel
        player.setHp(player.getMaxHp());

        System.out.println("\n--- Duel in the Arena ---");
        System.out.println("Your opponent is: " + opponent.getNom());

        while (player.estVivant() && opponent.estVivant()) {
            // Player's turn
            System.out.println("\nIt's your turn, " + player.getNom() + "!");
            UI.printCombatMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    player.attaquer(opponent);
                    Story.displayBattleDescription("attack", player.getNom(), opponent.getNom(), player.getDegats());
                    break;
                case 2:
                    if (player instanceof Warrior) {
                        ((Warrior) player).activerDefense();
                        Story.displayBattleDescription("defend", player.getNom(), opponent.getNom(), 0);
                    } else if (player instanceof Thief) {
                        ((Thief) player).activerInvisibilite();
                        Story.displayBattleDescription("defend", player.getNom(), opponent.getNom(), 0);
                    } else if (player instanceof Wizard) {
                        ((Wizard) player).regenererMana();
                        Story.displayBattleDescription("defend", player.getNom(), opponent.getNom(), 0);
                    } else {
                        System.out.println("Your character cannot defend.");
                    }
                    break;
                case 3:
                    player.utiliserCompetence(opponent);
                    Story.displayBattleDescription("special", player.getNom(), opponent.getNom(), player.getDegats() * 2);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            if (!opponent.estVivant()) {
                System.out.println(opponent.getNom() + " is defeated!");
                player.gagnerExperience(50);  // Reward for defeating opponent
                break;
            }

            // AI's turn (simple AI that attacks the player)
            System.out.println("\nIt's the opponent's turn, " + opponent.getNom() + "!");
            opponent.attaquer(player);
            Story.displayBattleDescription("attack", opponent.getNom(), player.getNom(), opponent.getDegats());

            if (!player.estVivant()) {
                System.out.println(player.getNom() + " is defeated!");
                break;
            }

            // End of round status
            System.out.println("\n--- Status after the round ---");
            UI.printCharacterStatus(player);
            UI.printCharacterStatus(opponent);
        }

        if (player.estVivant()) {
            UI.printVictoryScreen(player.getNom());
        } else {
            UI.printGameOver();
        }
    }
}
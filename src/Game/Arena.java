package Game;

import java.util.Random;
import java.util.Scanner;

public class Arena {
    private Personnage joueur;
    private Personnage adversaire;
    private Scanner scanner;

    public Arena(Personnage joueur) {
        this.joueur = joueur;
        this.scanner = new Scanner(System.in);
        this.adversaire = generateAdversaire();  // Generate a random AI opponent
    }

    private Personnage generateAdversaire() {
        // Randomly select an AI opponent (could be Guerrier, Mage, or Voleur)
        Random rand = new Random();
        int choice = rand.nextInt(3);
        switch (choice) {
            case 0:
                return new Guerrier("AI Guerrier");
            case 1:
                return new Mage("AI Mage");
            case 2:
                return new Voleur("AI Voleur");
            default:
                return new Guerrier("AI Guerrier");  // Default case
        }
    }

    public void commencerDuel() {
        // Reset player's HP to full before each duel
        joueur.pointsDeVie = joueur.pointsDeVieMax();

        System.out.println("\n--- Duel en arène ---");
        System.out.println("Votre adversaire est : " + adversaire.getNom());

        while (joueur.estVivant() && adversaire.estVivant()) {
            // Player's turn
            System.out.println("\nC'est votre tour, " + joueur.getNom() + "!");
            UI.printCombatMenu();
            int choix = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choix) {
                case 1:
                    joueur.attaquer(adversaire);
                    break;
                case 2:
                    if (joueur instanceof Guerrier) {
                        ((Guerrier) joueur).activerDefense();
                    } else if (joueur instanceof Voleur) {
                        ((Voleur) joueur).activerInvisibilite();
                    } else {
                        System.out.println("Votre personnage ne peut pas se défendre.");
                    }
                    break;
                case 3:
                    joueur.utiliserCompetence(adversaire);
                    break;
                default:
                    System.out.println("Choix invalide.");
            }

            if (!adversaire.estVivant()) {
                System.out.println(adversaire.getNom() + " est vaincu !");
                joueur.gagnerExperience(50);  // Reward for defeating opponent
                break;
            }

            // AI's turn (simple AI that attacks the player)
            System.out.println("\nC'est le tour de l'adversaire, " + adversaire.getNom() + "!");
            adversaire.attaquer(joueur);

            if (!joueur.estVivant()) {
                System.out.println(joueur.getNom() + " est vaincu !");
                break;
            }

            // End of round status
            System.out.println("\n--- État après tour ---");
            UI.printCharacterStatus(joueur);
            UI.printCharacterStatus(adversaire);
        }

        if (joueur.estVivant()) {
            UI.printVictoryScreen(joueur.getNom());
        } else {
            UI.printGameOver();
        }
    }
}
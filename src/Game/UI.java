package Game;

public class UI {
    public static void printMainMenu() {
        System.out.println("Welcome to the Shadow Adventurers!");
        System.out.println("1. Start Game");
        System.out.println("2. Exit");
    }

    public static void printCombatMenu() {
        System.out.println("\nChoose your action:");
        System.out.println("1. Attack");
        System.out.println("2. Defend");
        System.out.println("3. Special Ability");
    }

    public static void printCharacterStatus(Personnage character) {
        System.out.println("\n---- Character Status ----");
        System.out.println("Name: " + character.getNom());
        System.out.println("HP: " + character.pointsDeVie + "/" + character.pointsDeVieMax());
        System.out.println("XP: " + character.experience + "/" + character.xpForNextLevel);
        System.out.println("Level: " + character.niveau);
        System.out.println("Damage: " + character.degats);
        System.out.println("--------------------------");
    }

    public static void printBattleLog(String message) {
        System.out.println("\nBattle Log: " + message);
    }

    public static void printVictoryScreen(String winnerName) {
        System.out.println("\n" + winnerName + " is victorious!");
        System.out.println("They gain XP for their triumph!");
    }

    public static void printGameOver() {
        System.out.println("\nGame Over. Thank you for playing!");
    }
}
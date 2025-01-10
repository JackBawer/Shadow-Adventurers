package Game;

public class Story {

    private String characterClass;
    private String characterName;

    public Story(String characterClass, String characterName) {
        this.characterClass = characterClass;
        this.characterName = characterName;
    }

    public static void displayIntroduction() {
        System.out.println("--- Shadow Adventurers ---");
        System.out.println("*The Arena of the Self*\n");
        System.out.println("Long ago, the world fractured under the weight of the human soul.\n"
                + "The Ego forged its kingdom of light, building walls to hide the restless shadows\n"
                + "clawing at its edges. These shadows, rejected, forgotten, yearned for reunion,\n"
                + "weaving a world where duelists are born to reclaim the truth within.\n");
        System.out.println("\"Do you dare to step into the arena where the Ego meets its Shadow?\n"
                + "Will you command the warrior spirit of dominance, the wizard’s hunger for understanding,\n"
                + "or the thief’s cunning rebellion against the light? Each path reveals not only your power\n"
                + "but the face of the shadow that follows you.\"\n");
        System.out.println("*Know this:* the shadow is not your enemy. It is the mirror of your deepest self,\n"
                + "and in the arena, every strike you land reveals a truth.\n");
        System.out.println("What spirit will you embody, Adventurer? The choice is yours...\n");
    }

    public void startJourney() {
        System.out.println("Welcome, " + characterName + ". You have chosen the path of the " + characterClass + ".");
        System.out.println(getIntroductoryNarrative());
        System.out.println("Your journey begins now. Will you face your shadow, or let it consume you?");
    }

    private String getIntroductoryNarrative() {
        String narrative = "";

        switch (characterClass.toLowerCase()) {
            case "warrior":
                narrative = "As a Warrior, you are the spirit of resilience and unyielding strength.\n"
                        + "But deep within, the shadow whispers of your unquenchable thirst for control.\n"
                        + "Every victory feeds your ego, but will you discover the cost of endless conquest?";
                break;

            case "wizard":
                narrative = "As a Wizard, your intellect and mastery of the arcane set you apart.\n"
                        + "Yet, the shadow lurks in your hubris, tempting you to bend reality to your will.\n"
                        + "Will your quest for knowledge enlighten you, or blind you to the truth?";
                break;

            case "thief":
                narrative = "As a Thief, you embody cunning and agility, thriving in shadows and secrecy.\n"
                        + "But the shadow within you hungers for freedom without bounds, whispering that no code binds you.\n"
                        + "Will you master the shadows, or will they master you?";
                break;

            default:
                narrative = "The path you have chosen is uncharted, and the spirit of your ego remains a mystery.\n"
                        + "Prepare to discover the unknown.";
                break;
        }

        return narrative;
    }

    public static void displayHint(String characterClass) {
        switch (characterClass.toLowerCase()) {
            case "warrior":
                System.out.println("Strength and dominance mask the fear of vulnerability.\n"
                        + "Every blow you deal is a cry for control, every wound a crack in your armor.\n"
                        + "\"Can the fortress of your ego withstand the storm of truth?\"\n");
                break;
            case "wizard":
                System.out.println("Knowledge is your weapon, but beware—insight can burn as brightly as ignorance.\n"
                        + "What mysteries lie buried in your pursuit of the light?\n"
                        + "\"Wisdom is a double-edged sword, cutting the veil and the self in equal measure.\"\n");
                break;
            case "thief":
                System.out.println("Shadows are your domain, but are you their master, or their servant?\n"
                        + "Every stolen victory feeds the shadow, every misstep reveals the one thing you cannot steal: yourself.\n"
                        + "\"The shadow sees everything you wish to hide.\"\n");
                break;
            default:
                System.out.println("The path is unclear, but every choice shapes the shadow you face...\n");
        }
    }

    public static void displayEndgameReflection(boolean victory) {
        if (victory) {
            System.out.println("*Victory belongs to you… but at what cost? The shadows stir, whispering truths\n"
                    + "you’re not yet ready to face.*\n");
            System.out.println("\"Why do you fight? The answer lies not in your foe, but within.\"\n");
        } else {
            System.out.println("*Defeat shadows the arena, but the lesson remains: your shadow grows stronger with each failure.*\n");
            System.out.println("\"What have you learned about yourself today? The arena is not a place of endings,\n"
                    + "but of beginnings.\"\n");
        }
    }

    public static void displayBattleDescription(String action, String actor, String target, int damage) {
        switch (action.toLowerCase()) {
            case "attack":
                System.out.println(actor + " unleashes a powerful strike upon " + target + "!\n"
                        + "The clash echoes with the sound of crumbling walls—a glimpse into the\n"
                        + "weakness beneath strength.\n");
                break;
            case "defend":
                System.out.println(actor + " braces for impact, shielding themselves from harm.\n"
                        + "The defense feels like a desperate plea: \"What are you defending, and from whom?\"\n");
                break;
            case "special":
                System.out.println(actor + " calls forth a surge of untamed energy, targeting " + target + "!\n"
                        + target + " reels under the force, revealing cracks in their psyche.\n");
                break;
            default:
                System.out.println(actor + " acts in an unpredictable way, leaving " + target + " uncertain of what lies ahead.\n");
        }
        System.out.println(target + " receives " + damage + " points of damage.\n");
    }

    public void progressStory(int choice) {
        switch (choice) {
            case 1:
                System.out.println("You venture into the Abyss, where the echoes of your shadow challenge your resolve.");
                break;

            case 2:
                System.out.println("You seek counsel from the Oracle of the Ego, whose riddles unveil fragments of your inner truth.");
                break;

            case 3:
                System.out.println("You confront the shadow directly, risking everything to understand its purpose.");
                break;

            default:
                System.out.println("Your indecision feeds the shadow, growing stronger in the void of your action.");
                break;
        }
    }

    public void concludeJourney() {
        System.out.println("Your journey nears its end. The shadow stands before you, a reflection of your choices.");
        System.out.println("Will you embrace it, conquer it, or be consumed by it? The fate of your spirit is yours to decide.");
    }

    public static void main(String[] args) {
        // Example usage
        Story story = new Story("Wizard", "Alyx");
        story.startJourney();
        story.progressStory(1); // Example of progressing the story
        story.concludeJourney();
    }
}
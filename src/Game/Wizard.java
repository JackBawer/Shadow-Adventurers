package Game;

class Wizard extends Character {
    private int mana;
    private static final int MAX_MANA = 100;

    public Wizard(String nom) {
        super(nom, 80, 15);
        this.mana = MAX_MANA;
    }

    public Wizard(String nom, int niveau) {
        super(nom, 80, 15, niveau);
        this.mana = MAX_MANA;
    }

    private boolean checkMana(int cost) {
        if (mana >= cost) {
            mana -= cost;
            return true;
        } else {
            System.out.println(nom + " n'a pas assez de mana pour utiliser ce sort !");
            return false;
        }
    }

    public void regenererMana() {
        if (mana + 10 <= MAX_MANA) {
            mana += 10;
        } else {
            mana = MAX_MANA;
        }
        System.out.println(nom + " récupère 10 points de mana. Mana actuelle: " + mana);
    }

    @Override
    public void attaquer(Character cible) {
        System.out.println(nom + " lance un sort de base sur " + cible.getNom() + " !");
        cible.recevoirDegats(degats);
    }

    @Override
    public void utiliserCompetence(Character cible) {
        if (checkMana(30)) {
            System.out.println(nom + " invoque une tempête magique !");
            cible.recevoirDegats(degats + 10);
        }
    }

    public void lancerBouleDeFeu(Character cible) {
        if (checkMana(20)) {
            System.out.println(nom + " lance une boule de feu sur " + cible.getNom() + " !");
            cible.recevoirDegats(degats + 15);
        }
    }

    public void soigner() {
        if (checkMana(25)) {
            pointsDeVie += 20;
            if (pointsDeVie > 80) {
                pointsDeVie = 80;
            }
            System.out.println(nom + " se soigne de 20 points de vie. Vie actuelle: " + pointsDeVie);
        }
    }

    @Override
    public void ameliorerStats() {
        niveau++;
        pointsDeVie += 10;  // Increase HP per level
        degats += 5;  // Increase damage per level
        mana = MAX_MANA;  // Max mana on level up

        System.out.println(nom + " a monté de niveau ! Niveau: " + niveau);
        System.out.println("Nouvelles stats - Vie: " + pointsDeVie + ", Dégâts: " + degats + ", Mana: " + mana);
    }

    public void afficherStats() {
        System.out.println(nom + " - Vie: " + pointsDeVie + " | Mana: " + mana + "/" + MAX_MANA);
    }
}
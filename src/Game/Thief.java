package Game;

class Thief extends Character {
    private boolean invisible;

    public Thief(String nom) {
        super(nom, 70, 12); // Initial stats for Thief
        this.invisible = false;
    }

    public Thief(String nom, int niveau) {
        super(nom, 70, 12, niveau); // Initial stats for Thief with level
        this.invisible = false;
    }

    @Override
    public void attaquer(Character cible) {
        System.out.println(nom + " attaque furtivement " + cible.getNom() + " !");
        int actualDamage = degats;

        // Calculate critical hit chance based on level (e.g., +2% crit chance per level)
        double critChance = 0.2 + (niveau * 0.02);
        if (Math.random() < critChance) {
            actualDamage *= 2; // Double the damage for a critical hit
            System.out.println(nom + " inflige un coup critique de " + actualDamage + " dégâts !");
        } else {
            System.out.println(nom + " inflige " + actualDamage + " dégâts.");
        }

        cible.recevoirDegats(actualDamage);
    }

    @Override
    public void utiliserCompetence(Character cible) {
        System.out.println(nom + " utilise sa compétence spéciale : Attaque rapide !");
        int actualDamage = degats * 3;
        if (invisible) {
            actualDamage += 5; // Bonus damage if invisible
            System.out.println(nom + " inflige des dégâts supplémentaires car il est invisible.");
            invisible = false; // Invisibility ends after attack
        }
        cible.recevoirDegats(actualDamage);
    }

    public void activerInvisibilite() {
        System.out.println(nom + " devient invisible et esquivera la prochaine attaque !");
        invisible = true;
    }

    @Override
    public void recevoirDegats(int degats) {
        if (invisible) {
            System.out.println(nom + " esquive l'attaque grâce à son invisibilité !");
            invisible = false; // Invisibility lasts for one attack
        } else {
            super.recevoirDegats(degats);
        }
    }

    @Override
    protected void ameliorerStats() {
        niveau++;
        pointsDeVie += 5;  // Increase HP per level
        degats += 4;  // Increase damage per level
        invisible = false; // Invisibility resets on level up

        System.out.println(nom + " a monté de niveau ! Niveau: " + niveau);
        System.out.println("Nouvelles stats - Vie: " + pointsDeVie + ", Dégâts: " + degats);
    }
}
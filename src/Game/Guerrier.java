package Game;

class Guerrier extends Personnage {
    private boolean enDefense;

    public Guerrier(String nom) {
        super(nom, 100, 10);
        this.enDefense = false;
    }

    @Override
    public void attaquer(Personnage cible) {
        System.out.println(nom + " attaque " + cible.getNom() + " !");
        int actualDamage = degats;
        if (pointsDeVie <= 30) { // Adrenaline Rush
            actualDamage += 5; // Bonus damage
            System.out.println(nom + " est en rage d'adrénaline, infligeant " + actualDamage + " dégâts !");
        }
        cible.recevoirDegats(actualDamage);
    }

    @Override
    public void utiliserCompetence(Personnage cible) {
        System.out.println(nom + " utilise sa compétence spéciale : Coup de rage !");
        int actualDamage = degats * 2;
        if (pointsDeVie <= 30) { // Adrenaline Rush affects the special skill too
            actualDamage += 5;
            System.out.println(nom + " utilise Coup de rage en état d'adrénaline, infligeant " + actualDamage + " dégâts !");
        }
        cible.recevoirDegats(actualDamage);
    }

    public void activerDefense() {
        System.out.println(nom + " se met en mode Défense, réduisant les dégâts reçus au prochain tour !");
        enDefense = true;
    }

    @Override
    public void recevoirDegats(int degats) {
        if (enDefense) {
            degats /= 2; // Reduce incoming damage by half
            System.out.println(nom + " réduit les dégâts reçus de moitié grâce au mode Défense !");
            enDefense = false; // Defense lasts only one turn
        }
        super.recevoirDegats(degats);
    }

    // Implementing ameliorerStats method to improve stats when leveling up
    @Override
    protected void ameliorerStats() {
        // Increase max health and damage on level-up
        pointsDeVie += 20; // Increase health by 20 per level
        degats += 5; // Increase damage by 5 per level
        System.out.println(nom + " améliore ses stats : Points de vie et dégâts augmentés !");
    }
}

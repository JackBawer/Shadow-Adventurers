package Game;

abstract class Personnage implements Attaquable {
	protected String nom;
	protected int pointsDeVie;
	protected int degats; // Dégâts de base
	protected int niveau;
	protected int experience;
	protected int xpForNextLevel;

	public Personnage(String nom, int pointsDeVie, int degats) {
		this.nom = nom;
		this.pointsDeVie = pointsDeVie;
		this.degats = degats;
		this.niveau = 1;
		this.experience = 0;
		this.xpForNextLevel = 100; // Initial XP needed for level 2
	}

	// Method to get max health points
	public int pointsDeVieMax() {
		// Example: Max HP could increase with level
		return 100 + (niveau - 1) * 10; // For example, 100 max HP at level 1, +10 per level
	}

	public void recevoirDegats(int degats) {
		pointsDeVie -= degats;
		System.out.println(nom + " a reçu " + degats + " points de dégâts. Points de vie restants : " + pointsDeVie);
	}

	public boolean estVivant() {
		return pointsDeVie > 0;
	}

	public String getNom() {
		return nom;
	}

	public void gagnerExperience(int xp) {
		experience += xp;
		System.out.println(nom + " gagne " + xp + " XP !");

		// Check if the character has enough experience to level up
		while (experience >= xpForNextLevel) {
			niveauUp();
		}
	}

	private void niveauUp() {
		niveau++;
		experience -= xpForNextLevel; // Carry over excess XP
		xpForNextLevel = niveau * 150; // Increase the XP needed for the next level
		ameliorerStats(); // Improve stats on level up
		System.out.println(nom + " a atteint le niveau " + niveau + " !"
				+ " Points de vie : " + pointsDeVie + ", Dégâts : " + degats);
	}

	// Abstract method for improving stats, to be implemented by subclasses
	protected abstract void ameliorerStats();
}

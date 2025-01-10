package Game;

abstract class Character implements Attaquable {
	protected String nom;
	protected int pointsDeVie;
	protected int degats; // Base damage
	protected int niveau;
	protected int experience;
	protected int xpForNextLevel;

	public Character(String nom, int pointsDeVie, int degats) {
		this(nom, pointsDeVie, degats, 1); // Default level is 1
	}

	public Character(String nom, int pointsDeVie, int degats, int niveau) {
		this.nom = nom;
		this.pointsDeVie = pointsDeVie;
		this.degats = degats;
		this.niveau = niveau;
		this.experience = 0;
		this.xpForNextLevel = 100; // Initial XP needed for level 2

		// Apply level-based stat improvements
		for (int i = 1; i < niveau; i++) {
			ameliorerStats();
		}
	}

	// Method to get max health points
	public int getMaxHp() {
		return 100 + (niveau - 1) * 10; // For example, 100 max HP at level 1, +10 per level
	}

	// Method to set health points
	public void setHp(int pointsDeVie) {
		this.pointsDeVie = pointsDeVie;
	}

	public void recevoirDegats(int degats) {
		pointsDeVie -= degats;
		System.out.println(nom + " has received " + degats + " damage points. Remaining health: " + pointsDeVie);
	}

	public boolean estVivant() {
		return pointsDeVie > 0;
	}

	public String getNom() {
		return nom;
	}

	public int getDegats() {
		return degats;
	}

	public void gagnerExperience(int xp) {
		experience += xp;
		System.out.println(nom + " gains " + xp + " XP!");

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
		System.out.println(nom + " has reached level " + niveau + "!"
				+ " Health: " + pointsDeVie + ", Damage: " + degats);
	}

	// Abstract method for improving stats, to be implemented by subclasses
	protected abstract void ameliorerStats();
}
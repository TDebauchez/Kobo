package modele;

public class IA extends Player {
	
	Difficulty difficulty;

	public IA(String name, Difficulty difficult�){
		super(name);
		this.difficulty = difficult�;
	}
	
	public Card playCard(Card newCard){
		return newCard;
	}
}

package modele;

public class IA extends Player {
	
	Difficulty difficulty;

	public IA(String name, Difficulty difficulté){
		super(name);
		this.difficulty = difficulté;
	}
	
	public Card playCard(Card newCard){
		return newCard;
	}
}

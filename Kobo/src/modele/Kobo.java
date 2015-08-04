package modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Kobo extends Observable{

	private List<Player> players;
	
	private Player currentPlayer;

	private Deck deck;

	private Card currentCard;
	
	private int nbPlayer;

	public Kobo(int nbJoueur) {
		
		this.deck = new Deck();
		
		this.nbPlayer = nbJoueur;
		
		this.players = new ArrayList<>();
		players.add(new Player("La D�bauche"));
		for (int i = 1; i < this.nbPlayer; i++) {
			players.add(new IA("P" + (i + 1), Difficulty.Facile));
		}
		this.currentPlayer = this.players.get(0);
		
		this.dealCard();

		this.currentPlayer.viewCard();

	}

	private void dealCard() {

		for (int i = 1; i <= 4; i++) {
			for (Player player : this.players) {
				player.addCard(this.deck.hitCard());
			}
		}
		this.currentCard = this.pioche();
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}

	public void defausseCard(Card card){
		this.currentCard = card;
		this.currentCard.setVisible(true);
		System.out.println(this.currentCard);
	}
	
	public Card pioche(){
		Card card = this.deck.hitCard();
		card.watchCard();
		return card;
	}
	
	public void swapePlayer(){
		if(this.currentPlayer == this.players.get(this.players.size()-1)){
			this.currentPlayer = this.players.get(0);
		}
		else 
		{
			this.currentPlayer = this.players.get(this.players.indexOf(this.currentPlayer)+1);
		}
		if(currentPlayer instanceof IA){
			this.defausseCard(((IA) this.currentPlayer).playCard(this.pioche()));
			swapePlayer();
		}
	}
	
	public void notifierTous(){
		this.setChanged();
		this.notifyObservers();
	}

	public Card getCurrentCard() {
		return this.currentCard;
	}
}

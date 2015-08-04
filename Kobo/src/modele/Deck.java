package modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
	
	private List<Card> pot;
	
	public Deck(){
		this.fillDeck();
		this.shuffle();
	}
	
	private void fillDeck() {

		pot = new ArrayList<>();
		
		for(int i = 0; i < 4; i++){
			for(int j = 1; j<= 13; j++){
				this.pot.add(new Card(new Valeur(j), Couleur.values()[i]));
			}
		}
	}

	public String toString(){
		for(Card currentCard : this.pot){
			System.out.println(currentCard.toString());
		}
		System.out.println("\n");
		return "Finish";
	}
	
	private void shuffle() {
		Collections.shuffle(pot, new Random());
		Collections.shuffle(pot, new Random());
		Collections.shuffle(pot, new Random());
	}
	
	public Card hitCard(){
		if(!this.pot.isEmpty()){
			Card currentCard = this.pot.get(new Random().nextInt(this.pot.size()));
			this.pot.remove(currentCard);
			return currentCard;
		}
		return new Card(new Valeur(0), Couleur.Joker);
	}

}

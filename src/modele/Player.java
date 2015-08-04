package modele;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private List<Card> main;
	private int scoreTotal;

	public Player(String nom) {
		this.scoreTotal = 0;
		this.name = nom;
		main = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getMain() {
		return main;
	}

	public void addCard(Card card) {
		this.main.add(card);
	}

	private int getScore() {
		int score = 0;
		for (Card card : main) {
			if (card.getValue() != 1 && card.getValue() != 13) {
				score += card.getValue();
			} else if (card.getValue() == 1) {
				score += 13;
			}
		}
		return score;
	}

	public int getScoreTotal() {
		return scoreTotal;
	}

	public void addOwnScore() {
		this.scoreTotal += this.getScore();
	}

	public void viewCard(){
		for(int i = 0; i < 2; i++){
			this.main.get(i).watchCard();
		}
		for(Card card : this.main){
			System.out.println(card.toString());
		}
	}

	public Card throwCardAt(int i, Card newCard) {
		Card oldCard = this.main.get(i);
		this.main.set(i, newCard);
		return oldCard;
	}
}

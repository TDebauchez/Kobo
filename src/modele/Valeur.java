package modele;

public class Valeur {
	
	public static enum valuesText {Joker, As, Deux, Trois, Quatre, Cinq, Six, Sept, Huit, Neuf, Dix, Valet, Dame, Roi};
	
	private int valueNum;
	
	private valuesText valueText;
	
	
	public Valeur(int value){
		this.valueNum = value;
		this.valueText = valuesText.values()[this.valueNum];
	}

	public String toString(){
		return valueText.toString();
	}

	public int getValueNum() {
		return valueNum;
	}
}





package modele;


public class Card {

	private Valeur value;

	private Couleur color;

	private Boolean visible;

	public Card(Valeur valeur, Couleur couleur) {
		this.value = valeur;
		this.color = couleur;
		this.visible = false;
	}

	public void watchCard() {
		if (!isVisible()) {
			this.setVisible(true);
			new java.util.Timer().schedule(new java.util.TimerTask() {
				@Override
				public void run() {
					setVisible(false);
				}
			}, 5000);
		}
	}

	public String toString() {
		if(this.isVisible()){
			return this.value.toString() +" de "+ this.color;
		}
		else 
		{
			return "Caché";
		}
	}

	public Boolean isVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}
	
	public int getValue(){
		return this.value.getValueNum();
	}

}

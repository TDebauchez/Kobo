package modele;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	Kobo game;

	public static void main(String[] args) throws IOException {
		new Main();
	}

	/**
	 * @throws IOException
	 */
	/**
	 * @throws IOException
	 */
	public Main() throws IOException {
		super();
		game = new Kobo(4);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while (line.equalsIgnoreCase("quit") == false) {
    	   System.out.println(this.game.getCurrentCard());
	       line = in.readLine();
	       
	       if(line.equalsIgnoreCase("taper")){
	    	   this.game.finishGame();
	    	   line = in.readLine();
	       }
	       Card currentCard = this.game.getCurrentCard();
	       
	       if(line.equalsIgnoreCase("pioche")){
	    	   currentCard = this.game.pioche();
	       }
	       
    	   System.out.println(currentCard);
    	   
    	   System.out.println("Choose a card to replace (0:None; 1:First;...; 3:Last)");
    	   
	       @SuppressWarnings("resource")
	       int num = new Scanner(System.in).nextInt();
	       if(num == 0){
	    	   this.game.defausseCard(currentCard);
	    	   this.game.swapePlayer();
	       }
	       else if(num >= 1 && num < 5){
	    	  this.game.defausseCard(this.game.getCurrentPlayer().throwCardAt(num-1, currentCard));
	    	  this.game.swapePlayer();
	       }
	       else {
	    	   System.out.println("Prout"+ num);
	       }
	   }
	   in.close();
	}
}


import java.util.ArrayList;




public class Table {
	final int Maxplayer=4;//set the maximum of the players
	Deck ddd; //create a deck for the game
	Player [] ppp; //create a array to put players
	Dealer bobo; // call a dealer named  bobo
	int[] pos_betArray=new int[Maxplayer]; // create a array to save all the players' bet of a round
	ArrayList <Card> dcards;  //create an ArrayList to put dealer's card 
	
	public Table(int nDeck){// table's Constructor
							
		ddd=new Deck(nDeck);// instantiated a Deck (nDeck)
	 	 ppp=new Player[Maxplayer];// instantiated a Player (4player)  
		
		
	}
	public void set_player(int pos, Player p){
		ppp[pos]=p; //put the 4 players in to the array (people)
		
	}
	
	public Player[] get_player(){
		return ppp; //player getter
		
	}
	
	public void set_dealer(Dealer d) {
		 bobo=new Dealer(); //instantiated dealer
		 bobo=d;
		
	}
	
	public Card get_face_up_card_of_dealer(){
		
		return dcards.get(1); // dealer's open card getter
		
	}
	
	private void ask_each_player_about_bets(){
		// using a for loop to call all the players say hello and save the bet
		for(int i=0;i<=3;i++)
		{
		 
		 ppp[i].sayHello();
		 pos_betArray [i]=ppp[i].makeBet(); //put 4 players' bet into the array
		 
		
		}
		
		
		
		
		
	}
	
	private void distribute_cards_to_dealer_and_players(){
		
		
		for(int i=0;i<=3;i++)//for loop for calling 4 players
		{
		 ArrayList <Card> cards=new ArrayList<Card>(); //instantiated a ArrayList card
		 cards.add(ddd.getOneCard(true)); //get the first card
		 cards.add(ddd.getOneCard(true)); //get the second card
		 ppp[i].setOneRoundCard(cards);   //put the two cards into player's oneRoundCard
		}
		
		ArrayList <Card> dcards=new ArrayList<Card>();//instantiated a ArrayList dcards(dealer's card)
		
		dcards.add(ddd.getOneCard(true));//get the first card
		dcards.add(ddd.getOneCard(false));//get the second card(hidden)
		bobo.setOneRoundCard(dcards); //put the two cards into bobo's(dealer) oneRoundCard
		System.out.print("Dealer's face up card is ");
		dcards.get(0).printCard();//print bobo's(dealer) first card
		
	
	}
	private void ask_each_player_about_hits(){
		for(int i=0;i<=3;i++)//for loop for calling 4 players
		{ArrayList<Card> cardst=new ArrayList<Card>(); //instantiated a ArrayList cardst
			boolean hit=false;
			// do while loop do the fist ask(get one more card or not)and ask again after the first ask
			do{
				hit=ppp[i].hit_me(this); 
				if(hit){
					cardst=ppp[i].getOneRoundCard(); //put the player's oneRoundCard into the ArrayList as register
					cardst.add(ddd.getOneCard(true));// get one more card
					ppp[i].setOneRoundCard(cardst);//put all the cards into oneRoundCard again
					System.out.print("Hit! ");
					System.out.println(ppp[i].getName()+"'s Cards now:");
					for(Card c : ppp[i].getOneRoundCard()){
						c.printCard();
					}
					System.out.println(ppp[i].getTotalValue());
				}
				else{
					System.out.println(ppp[i].getName()+", Pass hit!");
					System.out.println(ppp[i].getName()+", Final Card:");
					for(Card c : ppp[i].getOneRoundCard()){
						c.printCard();
					}
				}
			}while(hit);
		
		
		}
		
		
	}
	
	private void ask_dealer_about_hits(){
		
		bobo.hit_me(this);//ask dealer needs one more card or not
		System.out.println("Dealer's hit is over!");
		
	}
	private void calculate_chips(){
		
		 System.out.println("\n");
		System.out.println("Dealer's card value is "+bobo.getTotalValue()+" ,Cards:");
		bobo.printAllCard();
		
		for(int i=0;i<=3;i++)
		{	
			System.out.println("\n");
			System.out.println(ppp[i].getName()+" 's cards: ");
			ppp[i].printAllCard();
			System.out.println(ppp[i].getName()+" card value is "+ppp[i].getTotalValue());
			if(ppp[i].getTotalValue()<=21&&ppp[i].getTotalValue()>bobo.getTotalValue())
			{	//player win 
				ppp[i].increaseChips( pos_betArray[i]);
				System.out.println(",Get "+pos_betArray[i]+" Chips, the Chips now is: "+ppp[i].getCurrentChips());
				
			}
			else if(ppp[i].getTotalValue()>21&&bobo.getTotalValue()>21||ppp[i].getTotalValue()==bobo.getTotalValue())
			{
				//draw
				System.out.println(",chips have no change! The Chips now is: "+ppp[i].getCurrentChips());
			}
			else
			{	//player lose
				ppp[i].increaseChips( -pos_betArray[i]);
				System.out.println(", Loss "+pos_betArray[i]+" Chips, the Chips now is: "+ppp[i].getCurrentChips());
				
			}
			
		}
			
			
		}
		
		


	public int[] get_palyers_bet(){
		
		return pos_betArray;
		
	}
	
	public void play(){
		ask_each_player_about_bets();
		distribute_cards_to_dealer_and_players();
		ask_each_player_about_hits();
		ask_dealer_about_hits();
		calculate_chips();
	}
	
	
	}

	
	
	
	
	



import java.util.ArrayList;

public class Player extends Person {
	private String name;
	private int chips;
	public ArrayList<Card> oneRoundCard=new ArrayList<Card>();
	
	public Player(String name, int chips) {
		//Player constructor :name and chips
		this.name = name;
		this.chips = chips;

	}

	public String getName() {

		return name;

	}

	public int makeBet() {
		//set default bet=1 and return
		int bet = 1;
		return bet;

	}

	
//remove the same  function function
/*	public boolean hitMe() {
		//create sum to add up all ranks 
		//create get to make the return boolean of the decision that get one more card or not 
		int sum=0;
		boolean get;
		//add up all ranks 
		sum = getTotalValue();
		//get one more card or not ,decide on sum is bigger than 16 or not 
		if (sum > 16)
			get = false;
		else
			get = true;
		return get;

	}
*/
	

	public int getCurrentChips() {

		return chips;

	}

	public void increaseChips(int diff) {

		chips += diff;

	}

	public void sayHello() {
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + " chips.");
	}

	@Override
	//override abstract method(from person)
	public boolean hit_me(Table table) {
		//create sum to add up all ranks 
				//create get to make the return boolean of the decision that get one more card or not 
				int sum;
				boolean get;
				//add up all ranks 
				sum = getTotalValue();
				//get one more card or not ,decide on sum is bigger than 16 or not 
				if (sum > 16)
					get = false;
				else
					get = true;
				return get;
	}

}

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> cards;
	private ArrayList<Card> usedCard;
	public int nUsed;
	private ArrayList<Card> openCard;

	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		usedCard = new ArrayList<Card>();
		openCard = new ArrayList<Card>();
		for (int n = 1; n <= nDeck; n++) {
			for (int i = 1; i <= 13; i++) {
				for (int j = 1; j <= 4; j++) {
					if (j == 1) {
						Card card = new Card(Card.Suit.Clubs, i);
						cards.add(card);
					} else if (j == 2) {
						Card card = new Card(Card.Suit.Diamonds, i);
						cards.add(card);
					} else if (j == 3) {
						Card card = new Card(Card.Suit.Hearts, i);
						cards.add(card);
					} else if (j == 4) {
						Card card = new Card(Card.Suit.Spades, i);
						cards.add(card);
					}
				}
			}
		}

	}

	public void printDeck() {

		for (Card a : cards)
			a.printCard();
	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}

	public void shuffle() {

		for (Card a : usedCard)
			cards.add(a);

		int i = cards.size();
		// System.out.println(i);

		for (int n = 0; n <= 100000; n++) {
			Random r = new Random();
			int j = r.nextInt(i);

			// System.out.println(j);
			Card temp = cards.get(j);
			cards.remove(j);
			cards.add(temp);

		}
		usedCard.clear();
		openCard.clear();
		nUsed = 0;

	}

	public Card getOneCard(boolean isOpened) {
		boolean empty = cards.isEmpty();

		if (!empty) {
			shuffle();

		}

		Card getc = cards.get(0);
		cards.remove(0);
		nUsed += 1;
		usedCard.add(getc);
		if (isOpened)
			openCard.add(getc);
		return getc;

	}

	public ArrayList getOpenedCard() {

		return openCard;

	}

}

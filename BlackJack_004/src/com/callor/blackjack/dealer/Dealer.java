package com.callor.blackjack.dealer;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
	private List<String> dealerCard = null;
	

	public Dealer() {
		

		dealerCard = new ArrayList<String>();
	}

	public void setDealerCard(String selctCard) {
		dealerCard.add(selctCard);
	}

	public void dealerShowDeck() {

		for (int i = 0; i < dealerCard.size(); i++) {

			System.out.println(dealerCard);
		}

	}

	public int totalScore() {
		int sum = 0;
		int cardScore = 0;
		for (int i = 0; i < dealerCard.size(); i++) {
			String card = dealerCard.get(i);

			sum += cardScore;
		}
		return sum;
	}

}

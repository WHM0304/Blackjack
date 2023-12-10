package com.whm0304.blackjack.dealer;

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
	public void plusDealerCard() {
		
	}

	public void dealerShowDeck() {
		System.out.println("딜러 덱");
		System.out.print("[");
		for (int i = 0; i < dealerCard.size(); i++) {
			System.out.printf("%s , ", dealerCard.get(i));
			
		}
		System.out.print("]\n");
		
	}
	
	public int totalScore() {
		int sum = 0;
		int cardScore = 0;
		for(int i = 0; i <dealerCard.size();i++ ) {
			String card = dealerCard.get(i);
			if(card.contains("A")) {
				cardScore = 1;
			} else if(card.contains("J")||card.contains("K")||card.contains("Q")) {
				cardScore = 10;
			} else {
	            cardScore = Integer.valueOf(dealerCard.get(i).replaceAll("[^0-9]", ""));
	         }
			sum += cardScore;
		}
		return sum;
	}
}

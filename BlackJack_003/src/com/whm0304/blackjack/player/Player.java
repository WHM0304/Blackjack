package com.whm0304.blackjack.player;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private List<String> playerCard = null;

	public Player() {

		
		playerCard = new ArrayList<String>();
	}
	
	public void setPlayerCard(String selectCard) {
		this.playerCard.add(selectCard);						
	}
	
	public void showDeck() {
		System.out.println("플레이어 덱");
		System.out.print("[");
		for(int i = 0 ; i <playerCard.size(); i++) {
			System.out.printf("%s ,",playerCard.get(i));	
			
		}		
		System.out.println("]");
		
	}
	// 
	public int totalScore() {
		int sum = 0;
		int cardScore = 0;
		for(int i = 0; i <playerCard.size();i++ ) {
			String card = playerCard.get(i);
			if(card.contains("A")) {
				cardScore = 1;
			} else if(card.contains("J")||card.contains("K")||card.contains("Q")) {
				cardScore = 10;
			} else {
	            cardScore = Integer.valueOf(playerCard.get(i).replaceAll("[^0-9]", ""));
	         }
			sum += cardScore;
		}
		return sum;
	}
	
	

}

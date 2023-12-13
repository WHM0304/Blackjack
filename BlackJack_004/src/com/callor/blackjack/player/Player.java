package com.callor.blackjack.player;

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
		for(int i = 0; i <playerCard.size(); i++) {
			
			System.out.println(playerCard);
		}
		
	}
	// 
	public int totalScore() {
		int sum = 0;
		int cardScore = 0;
		for(int i = 0; i <playerCard.size();i++ ) {
			String card = playerCard.get(i);			
			sum += cardScore;
		}
		return sum;
	}

}

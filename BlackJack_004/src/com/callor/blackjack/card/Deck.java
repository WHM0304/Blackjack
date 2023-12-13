package com.callor.blackjack.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private int cardIndex;
	List<CardDto> deckList = null;
	public Deck() {
		deckList = new ArrayList<CardDto>();
		cardIndex = 0;
		createCard();
	}
public  void createCard() {
		
		String strSuit = "◆♥♠♣";
		String strDenomination = "A234567890QJ";
		
		String[] suits = strSuit.split("");
		String[] denos = strDenomination.split("");
		
		
		deckList = new ArrayList<CardDto>();
		
		for(String suit : suits) {
			for(String deno : denos) {
				
				CardDto dto = new CardDto();
				dto.suit = suit;
				dto.denomination = deno;
				
				int value = 0;
				try {
					value = Integer.valueOf(deno);
					dto.value = value;
				} catch (Exception e) {
					if(deno.equals("A")) value = 1;						
					 else value = 10;
					dto.value = value;
				} 
				
				deckList.add(dto);
				
			}
		}
		Collections.shuffle(deckList);
		for(CardDto dto : deckList) {
			
			System.out.println(dto.suit + dto.denomination);
			for(String pattern : dto.getPattern()) {
				System.out.println(pattern);
			}
			
		}
		
		
		
	}

	public String select() {
		List<String> deckList = new ArrayList<String>();
		String selectCard = "";
		selectCard = deckList.get(cardIndex);
		cardIndex ++;
		return selectCard;
		
		
	}

}

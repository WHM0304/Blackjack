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
public void createCard() {
		
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
		
//		for(CardDto dto : deckList) {
//			
//			System.out.println(dto.suit + dto.denomination);
//			for(String pattern : dto.getPattern()) {
//				System.out.println(pattern);
//			}
//			
//		}
//		int cardLines = deckList.get(0).getPattern().length;
//		for(int line = 0 ; line < cardLines ; line ++) {
//			for(CardDto dto : deckList) {
//				System.out.printf("%10s",dto.getPattern()[line]);
//			}
//			System.out.println();
//		}
						
	}





public void DealerCardShow() {
	
	

	String[] cardDealer = {
			String.format("┌──────┐ "),
			String.format("│  %1s   │ ",""),
			String.format("│      │ "),
			String.format("│      │ "),
			String.format("│  %2s  │ ",""),
			String.format("└──────┘ ")

		};
	
	
	List<String[]> cardList = new ArrayList<>();
	
	cardList.add(cardDealer);
	
	
	
	// for(int list = 0 ; list < cardList.size() ; list ++ ) {
	//	for(int card = 0 ; card < cardList.get(list).length ;  card++) {
	//		System.out.println(cardList.get(list)[card]);
	//	}
	// }
	
	int cardLine = cardDealer.length;
	for(int arr = 0 ; arr < cardLine ; arr++) {
		int cardCount = cardList.size();
		for(int list = 0 ; list < cardCount ; list++) {
			String[] card = cardList.get(list);
			System.out.print(card[arr] + "\t");
		}
		System.out.println();
		
	}
}
public void PlayerCardShow() {
	
	
	String[] cardPlayer = {
		String.format("┌──────┐ "),
		String.format("│  %1s   │ ",""),
		String.format("│      │ "),
		String.format("│      │ "),
		String.format("│  %2s  │ ",""),
		String.format("└──────┘ ")

	};
	
	
	
	List<String[]> cardList = new ArrayList<>();
	cardList.add(cardPlayer);
	
	
	
	
	// for(int list = 0 ; list < cardList.size() ; list ++ ) {
	//	for(int card = 0 ; card < cardList.get(list).length ;  card++) {
	//		System.out.println(cardList.get(list)[card]);
	//	}
	// }
	
	int cardLine = cardPlayer.length;
	for(int arr = 0 ; arr < cardLine ; arr++) {
		int cardCount = cardList.size();
		for(int list = 0 ; list < cardCount ; list++) {
			String[] card = cardList.get(list);
			System.out.print(card[arr] + "\t");
		}
		System.out.println();
		
	}
}


	

}

package com.callor.blackjack.card;

public class CardDto {
	
	
	
	public static void getPattern(String suit, String denomination) {
		String pattern[] = {
				String.format("┌──────┐ "),
				String.format("│  %1s   │ ",suit),
				String.format("│      │ "),
				String.format("│      │ "),
				String.format("│  %2s  │ ",denomination ),
				String.format("└──────┘ ")
				
		};
		
	}

}

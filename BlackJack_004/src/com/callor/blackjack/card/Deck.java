package com.callor.blackjack.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Deck {
	private int cardIndex;
	List<CardDto> deckList = null;
	public String suit;
	public String denomination;
	public int value;
	public int pScore;
	public int dScore;
	private Scanner scan = null;

	public Deck() {
		deckList = new ArrayList<CardDto>();
		scan = new Scanner(System.in);
		cardIndex = 0;

		createCard();
	}

	public void createCard() {

		String strSuit = "◆♥♠♣";
		String strDenomination = "A234567890KQJ";

		String[] suits = strSuit.split("");
		String[] denos = strDenomination.split("");

		deckList = new ArrayList<CardDto>();

		for (String suit : suits) {
			for (String deno : denos) {

				CardDto dto = new CardDto();
				this.suit = suit;
				this.denomination = deno;

				int value = 0;
				try {
					value = Integer.valueOf(deno);
					this.value = value;
				} catch (Exception e) {
					if (deno.equals("A"))
						value = 1;
					else
						value = 10;
					this.value = value;
				}

				deckList.add(dto);

			}
		}
		Collections.shuffle(deckList);
		
		
		pScore = 0;
		dScore = 0;
		
		
		
		
		
		

	}

	public void Play() {

	}

}

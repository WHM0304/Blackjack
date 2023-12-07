package com.whm0304.blackjack.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {

	private String[] shape = { "스페이드", "클로버", "하트", "다이아" };
	private int cardIndex;

	// 52장 고정되어있다
	private List<String> card = null;

	public Card() {
		card = new ArrayList<String>();
		System.out.println("card 생성");
		cardIndex = 0;
		initSetCard();
	}

	// 카드생성
//createCard 는 숫자 집어넣기 밑에 initSetCard 는 문양 별로 집어넣기
	public void initSetCard() {
		for (int i = 0; i < 4; i++) {
			createCard(i);
		}
		Collections.shuffle(card);
		//카드 52장 확인 
//		for(int i = 0; i < 52; i++) {
//			System.out.println(card.get(i));
//		}

	}
	
// 1~ 13까지 숫자를 문양별로 집어넣기
	// A 는 1 , J 는 11 , Q 는 12 , K 는 13
	public void createCard(int shapeIndex) {
		String shapeName;

		for (int i = 1; i <= 13; i++) {
			shapeName = shape[shapeIndex];
			if (i == 1) {
				shapeName = shapeName + "A";
			} else if (i == 11) {
				shapeName = shapeName + "J";
			} else if (i == 12) {
				shapeName = shapeName + "Q";
			} else if (i == 13) {
				shapeName = shapeName + "K";
			} else {
				shapeName = shapeName + i;
			}
			card.add(shapeName);
		}
	}
	
	public String select() {
		String selectCard ="";
		selectCard = card.get(cardIndex);
				
		cardIndex++;
		return selectCard;
	}
	
	
	

}

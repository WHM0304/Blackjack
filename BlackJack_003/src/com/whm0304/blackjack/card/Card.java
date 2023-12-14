package com.whm0304.blackjack.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.whm0304.blackjack.util.AnsiConsol;

public class Card {

	private String[] shape = { "스페이드","클로버","하트", "다이아" };
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

	
// 1~ 13까지 숫자를 문양별로 집어넣기
	// A 는 1 , J 는 11 , Q 는 12 , K 는 13
	public void createCard(int shapeIndex) {
		String shapeNum;

		for (int i = 1; i <= 13; i++) {
			shapeNum= shape[shapeIndex];
			if (i == 1) {
				shapeNum = shapeNum + "A";
			} else if (i == 11) {
				shapeNum = shapeNum + "J";
			} else if (i == 12) {
				shapeNum = shapeNum + "Q";
			} else if (i == 13) {
				shapeNum = shapeNum + "K";
			} else {
				shapeNum = shapeNum + i;
			}
			card.add(shapeNum);
		}
	}
	
	
	//createCard 는 숫자 집어넣기 밑에 initSetCard 는 문양 별로 집어넣기
		public void initSetCard() {
			for (int i = 0; i < 4; i++) {
				createCard(i);
			}
			Collections.shuffle(card);
			//카드 52장 확인 
//			for(int i = 0; i < 52; i++) {
//				System.out.println(card.get(i));
//			}

		}
		public String select() {
			String selectCard ="";
			selectCard = card.get(cardIndex);
					
			cardIndex++;
			return selectCard;
		}
	// 카드 구성이 끝났으니 이제 게임 만들기
	
	

}

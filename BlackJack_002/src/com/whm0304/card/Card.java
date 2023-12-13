package com.whm0304.card;

public class Card {
	// 카드 구성부터해보자
	// 카드를 모두 구성했으니 카드 섞기 까지 만들어보기
	
	private String[] card = {
			"스페이드A", "스페이드2", "스페이드3", "스페이드4", "스페이드5"
			, "스페이드6", "스페이드7", "스페이드8", "스페이드9", "스페이드10"
			, "스페이드J", "스페이드Q", "스페이드K",
	         "클로버A", "클로버2", "클로버3", "클로버4", "클로버5"
	         , "클로버6", "클로버7", "클로버8", "클로버9", "클로버10"
	         , "클로버J", "클로버Q", "클로버K",
	         "하트A", "하트2", "하트3", "하트4", "하트5"
	         , "하트6", "하트7", "하트8", "하트9", "하트10"
	         , "하트J", "하트Q", "하트K",
	         "다이아A", "다이아2", "다이아3", "다이아4", "다이아5"
	         , "다이아6", "다이아7", "다이아8", "다이아9", "다이아10"
	         , "다이아J", "다이아Q", "다이아K",	
			
	};
	
	
	// 카드의 구성들을 만들었으니
	// 카드를 섞어놓는 method 를 만들기
	public void shuffle() {
		
		for(int i = 0; i<card.length; i++) {
			int ranNum = (int)(Math.random()* card.length);
			String _temp = card[i];
			card[i] = card[ranNum];
			card[ranNum] = _temp;
			
		}
		
		
	}
	// 카드 처음 2장을 받아야하므로 장수를 변수설정
	// 이후 카드를 받았을때도 체크
	private int cardIndex = 0;
	
	public String select() {
		String selectCard = card[cardIndex];
		cardIndex++;
		return selectCard;
	}
	
	
	
	
	
	
	// 문제점
	// 게임의 구성들을 만들다 보니까 배열안에 있는 카드 숫자 입력이 안되있음
	// 오늘 수업때 리스트 구성을 배움 
	// 리스트에 넣어서 진행
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}



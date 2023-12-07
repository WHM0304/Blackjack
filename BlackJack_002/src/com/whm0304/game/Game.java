package com.whm0304.game;

import java.util.Scanner;

import com.whm0304.card.Card;

public class Game {
	// 게임 플레이 규칙에 맞게 구성하기
	public void play() {
		System.out.println("==============================블랙잭===========================");
		Card card = new Card();
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("(1)게임시작 (2)게임종료 >> ");
		String gameStart = scan.nextLine();
		//게임종료만들기
		if(gameStart.equalsIgnoreCase("게임종료") || gameStart.equalsIgnoreCase("2")) {
			System.out.println("게임을 종료합니다");
			return;
		}
		// 게임시작만들기
		if(gameStart.equalsIgnoreCase("게임시작") || gameStart.equalsIgnoreCase("1")) {
			//카드섞기
			card.shuffle();
			System.out.println("게임을 시작합니다");
			
			String selectCard;
			//카드 뽑기
			for(int i = 0; i <2; i++) {
				selectCard = card.select();
				
				
			}
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

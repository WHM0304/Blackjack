package com.whm0304.blackjack.game;

import java.util.Scanner;

import com.whm0304.blackjack.card.Card;
import com.whm0304.blackjack.dealer.Dealer;
import com.whm0304.blackjack.gamerule.GameRule;
import com.whm0304.blackjack.player.Player;
import com.whm0304.blackjack.util.Line;

public class Game {

	private Card card = null;
	private Player player = null;
	private Dealer dealer = null;
	GameRule gameRule = null;
	
	public Game() {
		gameRule = new GameRule();
		
	}

	public Integer play() {

		System.out.println("=============블랙잭=================");
		Scanner scan = new Scanner(System.in);

		System.out.print("시작(1) or 종료(2) >> ");
		String gameStart = scan.nextLine();

		if (gameStart.equals("종료") || gameStart.equalsIgnoreCase("2")) {
			System.out.println("종료되었습니다");
			return null;
		}
		// 게임시작 여부 확인
		if (gameStart.equals("시작") || gameStart.equalsIgnoreCase("1")) {
			System.out.println("시작되었습니다");
			// 플레이어와 딜러 카드 1장씩 2번 뽑기
			// 그전에 카드가 있어야됨 카드 제작 및 셔플까지 진행
			card = new Card();
			player = new Player();
			dealer = new Dealer();
			gameRule = new GameRule();
			
			player.setPlayerCard(card.select());
			dealer.setDealerCard(card.select());
			System.out.println();
			Line.sLine(30);
			dealer.dealerShowDeck();
			System.out.println();
			player.showDeck();
			Line.sLine(30);
			System.out.println();
		}

		// 2장씩 확인하기
		gameRule.gameTempo("");
		dealer.setDealerCard(card.select());		
		Line.sLine(30);
		System.out.println();
		dealer.dealerShowDeck();
		System.out.println();
		player.showDeck();
		System.out.println();
		Line.sLine(30);
		gameRule.gameTempo("");
		player.setPlayerCard(card.select());		
		Line.sLine(30);
		System.out.println();
		dealer.dealerShowDeck();
		System.out.println();
		player.showDeck();
		System.out.println();
		Line.sLine(30);
		
		boolean dBust = gameRule.dealerBustCheck(dealer);
		boolean bust = gameRule.playerBustCheck(player);		
		// 시작 2장씩 뽑았고 플레이어 턴
		while (true) {
			
			System.out.println("hit(1) or stay(2) >> ");
			String game = scan.nextLine();

			if (game.equalsIgnoreCase("stay") || game.equals("2")) {
				break;
			}
			if (game.equalsIgnoreCase("hit") || game.equals("1")) {
				Line.sLine(30);
				System.out.println();
				player.setPlayerCard(card.select());
				dealer.dealerShowDeck();
				System.out.println();
				player.showDeck();	
				System.out.println();
				bust = gameRule.playerBustCheck(player);
				Line.sLine(30);
				
			}
			if (bust == true) {
				System.out.println("플레이어 버스트입니다.");
				break;
			}
			

		} // end while
			// 플레이어 턴 이후 딜러턴
			// 딜러 턴 딜러가 17미만일경우에 카드를 뽑고 아닐경우에 결과
		gameRule.gameTempo("딜러 턴을 확인");
		while (dealer.totalScore() < 17) {
			Line.sLine(30);
			dealer.setDealerCard(card.select());
			System.out.println();
			dealer.dealerShowDeck();
			System.out.println();
			player.showDeck();
			System.out.println();
			Line.sLine(30);
			dBust = gameRule.dealerBustCheck(dealer);
			if (dBust == true) {				
				System.out.print("딜러 버스트\t");				
				break;
			}			
		} // end 딜러 while
		gameRule.gameTempo("결과 확인");
		// 결과
		if(gameRule.gameResult(player.totalScore(), dealer.totalScore()) == false && dBust == false ) {
			Line.sLine(30);
			System.out.println();
			dealer.dealerShowDeck();
			System.out.println();
			player.showDeck();
			Line.dLine(30);
			System.out.println("딜러 승리");
		} else {
			System.out.println();
			Line.dLine(30);
			dealer.dealerShowDeck();
			System.out.println();
			player.showDeck();
			Line.dLine(30);
			System.out.println("플레이어 승리");
		}
		return 1;
	} // end play
	
	public  void plays() {
		
		while(true) {
			this.play();
			if(this.play() == null) {
				break;
			} else {
				continue;
			}
		}
	}
	
	
	
	
	
	
	
} // end Game

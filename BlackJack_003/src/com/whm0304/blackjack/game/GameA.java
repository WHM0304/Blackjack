package com.whm0304.blackjack.game;

import java.util.Scanner;

import com.whm0304.blackjack.card.Card;
import com.whm0304.blackjack.dealer.Dealer;
import com.whm0304.blackjack.gamerule.GameRule;
import com.whm0304.blackjack.player.Player;
import com.whm0304.blackjack.util.Line;

public class GameA {

	private Card card = null;
	private Player player = null;
	private Dealer dealer = null;
	GameRule gameRule = null;
	Line line = null;
	public GameA() {
		gameRule = new GameRule();
		line = new Line();
	}

	public void play() {

		System.out.println("=============블랙잭 시작=================");
		Scanner scan = new Scanner(System.in);

		System.out.print("시작(1) or 종료(2) >> ");
		String gameStart = scan.nextLine();

		if (gameStart.equals("종료") || gameStart.equalsIgnoreCase("2")) {
			System.out.println("종료되었습니다");
			return;
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
			System.out.println();
			dealer.setDealerCard(card.select());
			System.out.println();
			line.sLine(30);
			dealer.dealerShowDeck();
			player.showDeck();
			line.sLine(30);
		}

		// 2장씩 확인하기
		gameRule.gameTempo();
		dealer.setDealerCard(card.select());
		System.out.println();
		line.sLine(30);
		dealer.dealerShowDeck();
		player.showDeck();
		line.sLine(30);
		gameRule.gameTempo();
		player.setPlayerCard(card.select());
		System.out.println();
		line.sLine(30);
		dealer.dealerShowDeck();
		player.showDeck();
		line.sLine(30);
		
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
				line.sLine(30);
				player.setPlayerCard(card.select());
				dealer.dealerShowDeck();				
				player.showDeck();				
				bust = gameRule.playerBustCheck(player);
				line.sLine(30);
				
			}
			if (bust == true) {
				System.out.println("플레이어 버스트입니다.");
				break;
			}

		} // end while
			// 플레이어 턴 이후 딜러턴
			// 딜러 턴 딜러가 17미만일경우에 카드를 뽑고 아닐경우에 결과
		while (dealer.totalScore() < 17) {
			dealer.setDealerCard(card.select());
			line.sLine(40);
			dealer.dealerShowDeck();			
			player.showDeck();
			line.sLine(40);
			dBust = gameRule.dealerBustCheck(dealer);
			if (dBust == true) {
				line.dLine(40);
				System.out.println("딜러 버스트");
				line.dLine(40);
				break;
			}
		} // end 딜러 while

		// 결과
		if(gameRule.gameResult(player.totalScore(), dealer.totalScore()) == false && dBust == false ) {
			dealer.dealerShowDeck();
			player.showDeck();
			System.out.println("딜러 승리");
		} else if(player.totalScore() == dealer.totalScore() && dBust == false && bust ==false) {
			dealer.dealerShowDeck();
			player.showDeck();
			System.out.println("동점 무승부");
			
		} else  {
			dealer.dealerShowDeck();
			player.showDeck();
			System.out.println("플레이어 승리");
		}
	} // end play
} // end Game

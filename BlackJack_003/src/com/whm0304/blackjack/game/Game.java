package com.whm0304.blackjack.game;

import java.util.Scanner;

import com.whm0304.blackjack.card.Card;
import com.whm0304.blackjack.dealer.Dealer;
import com.whm0304.blackjack.gamerule.GameRule;
import com.whm0304.blackjack.player.Player;

public class Game {

	private Card card = null;
	private Player player = null;
	private Dealer dealer = null;
	GameRule gameRule = null;

	public Game() {
		gameRule = new GameRule();
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
			// 2장 받고 나서 확인하기

			player.setPlayerCard(card.select());
			System.out.println();
			dealer.setDealerCard(card.select());
			System.out.println();
			dealer.dealerShowDeck();
			player.showDeck();

		}
		gameRule.gameGo();
		dealer.setDealerCard(card.select());
		System.out.println();
		dealer.dealerShowDeck();
		player.showDeck();
		gameRule.gameGo();
		player.setPlayerCard(card.select());
		System.out.println();
		dealer.dealerShowDeck();
		player.showDeck();
		gameRule.gameGo();
		// 딜러 턴 딜러가 17미만일경우에 카드를 뽑고 아닐경우에 결과
		boolean dBust = gameRule.dealerBustCheck(dealer);

		System.out.println("딜러의 점수 : " + dealer.totalScore());
		System.out.println("플레이어의 점수 : " + player.totalScore());
		boolean bust = gameRule.playerBustCheck(player);
		// 2장씩 뽑았고 딜러도 카드를 뽑았으므로 이제 카드를 받을지 아니면 유지하고 결과볼지 확인
		while (true) {
			
			System.out.println("hit(1) or stay(2) >> ");
			String game = scan.nextLine();
			
			if (game.equalsIgnoreCase("stay") || game.equals("2")) {
				break;
			} if (game.equalsIgnoreCase("hit") || game.equals("1")) {
				player.setPlayerCard(card.select());
				player.showDeck();
				System.out.print("플레이어 점수 : ");
				System.out.println(player.totalScore());
				bust = gameRule.playerBustCheck(player);
			}
				if (bust == true) {
					System.out.println("플레이어 버스트입니다.");
					System.out.print("플레이어 점수 : ");
					System.out.println(player.totalScore());
					break;
				}

			

		} // end while
		while(dealer.totalScore()<17) {
			dealer.setDealerCard(card.select());
			dealer.dealerShowDeck();
			System.out.print("딜러 점수 : ");
			System.out.println(dealer.totalScore());
			dBust = gameRule.dealerBustCheck(dealer);
			if(dBust == true) {
				System.out.println("딜러 버스트");
				System.out.print("딜러 점수 : ");
				System.out.println(dealer.totalScore());
				break;
			}
		} 
		
		if (player.totalScore() == 21) {
			System.out.println("플레이어 !블랙잭!  ");
			System.out.println("플레이어 승리");
		}
		if (dealer.totalScore() == 21) {
			System.out.println("딜러 블랙잭");
			System.out.println("딜러 승리");
		}

		else if (dealer.totalScore() < player.totalScore() && bust == false) {			
			System.out.println("플레이어 승리");
		}
		else if (player.totalScore() < dealer.totalScore() && dBust == false) {
			System.out.println("딜러 승리");
		}

		else if (player.totalScore() == dealer.totalScore()) {
			System.out.println("동점 ! ");
		} else if(bust == true && dBust == false) {
			System.out.println("플레이어 버스트");
			System.out.println("딜러 승리");			
		} else if(dBust == true && bust == false) {
			System.out.println("딜러 버스트");
			System.out.println("플레이어 승리");
			
		}
	} // end play
} // end Game
// 승리조건 만들기

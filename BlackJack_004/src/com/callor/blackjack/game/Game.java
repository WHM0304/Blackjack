package com.callor.blackjack.game;

import java.util.Scanner;

import com.callor.blackjack.card.Deck;
import com.callor.blackjack.dealer.Dealer;
import com.callor.blackjack.gamerule.GameRule;
import com.callor.blackjack.player.Player;
import com.callor.blackjack.utils.Line;

public class Game {
	private Deck deck = null;
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
			deck = new Deck();
			player = new Player();
			dealer = new Dealer();
			gameRule = new GameRule();

			player.setPlayerCard(deck.select());
			System.out.println();
			dealer.setDealerCard(deck.select());
			System.out.println();
			Line.sLine(30);
			dealer.dealerShowDeck();
			player.showDeck();
			Line.sLine(30);
		}

		// 2장씩 확인하기
		gameRule.gameGo();
		dealer.setDealerCard(deck.select());
		System.out.println();
		Line.sLine(30);
		dealer.dealerShowDeck();
		player.showDeck();
		Line.sLine(30);
		gameRule.gameGo();
		player.setPlayerCard(deck.select());
		System.out.println();
		Line.sLine(30);
		dealer.dealerShowDeck();
		player.showDeck();
		Line.sLine(30);
		gameRule.gameGo();
		Line.sLine(30);
		boolean dBust = gameRule.dealerBustCheck(dealer);
		boolean bust = gameRule.playerBustCheck(player);
		dealer.dealerShowDeck();
		player.showDeck();
		Line.sLine(30);
		// 시작 2장씩 뽑았고 플레이어 턴
		while (true) {

			System.out.println("hit(1) or stay(2) >> ");
			String game = scan.nextLine();

			if (game.equalsIgnoreCase("stay") || game.equals("2")) {
				break;
			}
			if (game.equalsIgnoreCase("hit") || game.equals("1")) {
				Line.sLine(30);
				player.setPlayerCard(deck.select());
				dealer.dealerShowDeck();
				player.showDeck();
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
		while (dealer.totalScore() < 17) {
			dealer.setDealerCard(deck.select());
			Line.sLine(40);
			dealer.dealerShowDeck();
			player.showDeck();
			Line.sLine(40);
			dBust = gameRule.dealerBustCheck(dealer);
			if (dBust == true) {
				System.out.println("딜러 버스트");
				break;
			}
		} // end 딜러 while

		// 결과
		if (gameRule.gameResult(player.totalScore(), dealer.totalScore()) == false && dBust == false) {
			dealer.dealerShowDeck();
			player.showDeck();
			System.out.println("딜러 승리");
		} else {
			dealer.dealerShowDeck();
			player.showDeck();
			System.out.println("플레이어 승리");
		}

	}

}

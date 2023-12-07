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

	public void play() {

		System.out.println("=============블랙잭 시작=================");
		Scanner scan = new Scanner(System.in);

		System.out.print("시작 or 종료 >> ");
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
			GameRule gameRule = new GameRule();
			// 2장
			for (int i = 0; i < 2; i++) {
				player.setPlayerCard(card.select());
				System.out.println();
				dealer.setDealerCard(card.select());
				System.out.println();
				dealer.dealerDeck();
				player.showDeck();
			}
			// 2장씩 뽑았고 이제
			while (true) {
				System.out.println("hit(1) or stay(2) >> ");
				String game = scan.nextLine();
				if (game.equalsIgnoreCase("hit") || game.equals("1")) {
					player.setPlayerCard(card.select());
					player.showDeck();
					boolean bust = gameRule.playerBustCheck(player);
					if (bust == true) {
						System.out.println("버스트로 딜러승리했습니다.");
						return;
					}

				} if(game.equalsIgnoreCase("stay")|| game.equals("2")) {
					break;
				}

			}
			
			
		}

	}

}

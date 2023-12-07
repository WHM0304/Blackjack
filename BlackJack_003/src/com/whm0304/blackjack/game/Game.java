package com.whm0304.blackjack.game;

import java.util.Scanner;

import com.whm0304.blackjack.dealer.Dealer;
import com.whm0304.blackjack.player.Player;

public class Game {
		Player player = new Player();
		Dealer dealer = new Dealer();
	public void play() {
		System.out.println("=============블랙잭 시작=================");
		Scanner scan = new Scanner(System.in);

		System.out.print("시작 or 종료 >> ");
		String gameStart = scan.nextLine();

		if (gameStart.equalsIgnoreCase("종료") || gameStart.equalsIgnoreCase("2")) {
			System.out.println("종료되었습니다");
			return;
		}
		// 게임시작 여부 확인
		if (gameStart.equalsIgnoreCase("시작") || gameStart.equalsIgnoreCase("1")) {
			System.out.println("시작되었습니다");
			// 플레이어와 딜러 카드 1장씩 2번 뽑기
			// 그전에 카드가 있어야됨 카드 제작 및 셔플까지 진행
			

		}

	}

}

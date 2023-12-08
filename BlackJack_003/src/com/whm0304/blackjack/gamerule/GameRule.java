package com.whm0304.blackjack.gamerule;

import java.util.Scanner;

import com.whm0304.blackjack.dealer.Dealer;
import com.whm0304.blackjack.player.Player;

public class GameRule {
	private boolean bust ;
	private boolean dbust;
	Player player = null;
	Dealer dealer = null;
	Scanner scan = null;
	public GameRule() {
		player = new Player();
		dealer = new Dealer();
		scan = new Scanner(System.in);
	}
	
	public boolean playerBustCheck(Player player) {
		int score = player.totalScore();
		System.out.println(score);
		this.bust = false;
		if(score >21) {
			this.bust = true;
			return bust;
		}
		return false;
	}
	public boolean dealerBustCheck(Dealer dealer) {
		int dealerScore = dealer.totalScore();
		System.out.println(dealerScore);
		this.dbust = false;
		if(dealerScore> 21) {
			this.dbust = true;
			return dbust;
		}
		return false;
	}
	public void gameGo() {
		while(true) {
			System.out.print("다음 진행을 원하시면 1번(진행) >> ");
			String gameGo = scan.nextLine();
			if(gameGo.equals("진행")|| gameGo.equals("1")) {
				break;
			}
			
		}
	}


}

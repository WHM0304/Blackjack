package com.whm0304.blackjack.gamerule;

import java.util.Scanner;

import com.whm0304.blackjack.dealer.Dealer;
import com.whm0304.blackjack.player.Player;
import com.whm0304.blackjack.util.AnsiConsol;

public class GameRule {
	private boolean bust ;
	private boolean dBust;
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
		
		this.bust = false;
		if(score >21) {
			this.bust = true;
			
		}
		return bust;
	}
	public boolean dealerBustCheck(Dealer dealer) {
		int dealerScore = dealer.totalScore();
		
		this.dBust = false;
		if(dealerScore> 21) {
			this.dBust = true;
			
		}
		return dBust;
	}
	public void gameTempo() {
		while(true) {
			String str = AnsiConsol.YELLOW("다음 진행을 원하시면 1번(진행) >> ");
			System.out.println(str);
			String gameTempo = scan.nextLine();
			if(gameTempo.equals("진행")|| gameTempo.equals("1")) {
				break;
			}
			
		}
	}
	public void gameGo() {
		while(true) {
			System.out.println("다음 게임을 진행을 원하시면 1번(진행) ");
			System.out.print("다음 게임을 진행을 원하시면 2번(포기) >> ");
			String gameGo = scan.nextLine();
			if(gameGo.equals("진행")|| gameGo.equals("1")) {
				break;
			} else if(gameGo.equalsIgnoreCase("포기")|| gameGo.equals("2")) {
				return;
				
			}
			
		}
	}
	public boolean gameResult(int player, int dealer) {
		int dealerMin = 21 - dealer;
		int playerMin = 21 - player;
		
		
		if(dealerMin < playerMin && dBust == false) {
			
			return false;
		} else if(dealerMin > playerMin && bust == false){
			
			return true;
		} else if(dealerMin == 0 && playerMin != 0) {
			return false;
		} else if(dealerMin != 0 && playerMin == 0) {
			return true;
		} else if(dealerMin == 0 && playerMin == 0) {
			return true;
		} 
		return false;
	}
	


}

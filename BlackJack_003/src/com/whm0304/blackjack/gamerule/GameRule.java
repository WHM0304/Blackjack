package com.whm0304.blackjack.gamerule;

import com.whm0304.blackjack.dealer.Dealer;
import com.whm0304.blackjack.player.Player;

public class GameRule {
	private boolean bust ;
	
	public boolean playerBustCheck(Player player) {
		int score = player.totalScore();
		System.out.println(score);
		this.bust = false;
		if(score >21) {
			this.bust = true;
			return true;
		}
		return false;
	}
	public void dealerBustCheck(Dealer dealer) {
		
	}

}

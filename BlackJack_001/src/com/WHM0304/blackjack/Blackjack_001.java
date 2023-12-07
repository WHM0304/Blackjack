package com.WHM0304.blackjack;

import java.util.Scanner;
// 전에 했던 뤼팡게임을 반대로 뒤집어서 만들어 보기
// 숫자랜덤을 패로 받게끔 하고 입력값을 hit , stay 로 정하여 함
// 마지막에 딜러와 유저의 점수를 비교하여 승패정하기
// 기본규칙에 준수하여 만들기
// 추후 추가될 내용들을 생각하기

// 문제점 : 1. 카드 개수가 정해지지 않음
//			2. 카드 문양이 아예없음
//			3. 게임의 진행이 어떻게 되는지 확인이 힘듬
			

public class Blackjack_001 {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
        int playerTotal = 0;
        int dealerTotal = 0;
        
        System.out.println("Welcome to Blackjack!\n");
        
        // Player's turn
        playerTotal += (int)(Math.random() * 11 + 1);
        System.out.println("your first card are: " + playerTotal);
        playerTotal += (int)(Math.random() * 11 + 1);
        System.out.println("Your cards are: " + playerTotal);
        System.out.println("Do you want to hit or stand? (hit/stay)");
        String playerMove = input.nextLine();
        
        while (playerMove.equals("hit")) {
            int hit = (int)(Math.random() * 11 + 1);
            playerTotal += hit;
            System.out.println("You hit and got a " + hit + ". Your total is now " + playerTotal);
            if (playerTotal > 21) {
                System.out.println("You busted!");
                break;
            }
            System.out.println("Do you want to hit or stand? (hit/stay)");
            playerMove = input.nextLine();
        }
        
        // Dealer's turn
        dealerTotal += (int)(Math.random() * 11 + 1);
        System.out.println("\nDealer's first card are : " + dealerTotal);
        dealerTotal += (int)(Math.random() * 11 + 1);
        System.out.println("\nDealer's cards are: " + dealerTotal);
        
        while (dealerTotal < 17) {
            int hit = (int)(Math.random() * 11 + 1);
            dealerTotal += hit;
            System.out.println("Dealer hits and got a " + hit + ". Their total is now " + dealerTotal);
        }
        
        // Determine the winner
        if (dealerTotal > 21) {
            System.out.println("Dealer busted! You win!");
        } else if (dealerTotal > playerTotal) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("You win!");
        }
        
        input.close();
		
		
		
		
		
	}

}

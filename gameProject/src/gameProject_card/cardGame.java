package gameProject_card;

import java.util.Random;
import java.util.Scanner;

public class cardGame {

	public static void main(String[] args) {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		
		
		int card1 = ran.nextInt(10);
		int card2 = ran.nextInt(10);
		
		int bigger = card1 >= card2 ? card1*10 +card2 : card2*10 +card1;
		int opp = ran.nextInt(100);
		System.out.println("당신의 카드 >> card1 : " + card1 + ", card2 : " + card2);
		System.out.println("당신의 카드 조합 >> " + bigger);
		System.out.println();
		System.out.println("1. 이긴다.  2. 진다. 3. 비긴다.");
		System.out.print(">>> ");
		int select = sc.nextInt();
		
		if(select == 1) {
			if(bigger > opp) {
				System.out.println("WIN");
				System.out.println("나의 패 >>" + bigger + " : 상대 패 >> " + opp);
			}
			else if(bigger < opp)  {
				System.out.println("LOSE");
				System.out.println("나의 패 >>" + bigger + " : 상대 패 >> " + opp);
			}
			else  {
				System.out.println("LOSE");
				System.out.println("나의 패 >>" + bigger + " : 상대 패 >> " + opp);
			}
		}
		else if(select == 2) {
			if(bigger > opp) {
				System.out.println("LOSE");
				System.out.println("나의 패 >>" + bigger + " : 상대 패 >> " + opp);
			}
			else if(bigger < opp)  {
				System.out.println("WIN");
				System.out.println("나의 패 >>" + bigger + " : 상대 패 >> " + opp);
			}
			else  {
				System.out.println("LOSE");
				System.out.println("나의 패 >>" + bigger + " : 상대 패 >> " + opp);
			}
		}
		else {
				if(bigger > opp) {
					System.out.println("LOSE");
					System.out.println("나의 패 >>" + bigger + " : 상대 패 >> " + opp);
				}
				else if(bigger < opp)  {
					System.out.println("LOSE");
					System.out.println("나의 패 >>" + bigger + " : 상대 패 >> " + opp);
				}
				else  {
					System.out.println("WIN");
					System.out.println("나의 패 >>" + bigger + " : 상대 패 >> " + opp);
				}
		}
	}

}

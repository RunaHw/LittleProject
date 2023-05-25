package gameProject_card;

import java.util.Random;
import java.util.Scanner;

public class cardGame {

	public static void main(String[] args) {

		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		int winCount = 0;
		int loseCount = 0;
		int money = 10000;
		int start = 0;

		while (true) {
			System.out.println("1.GAME START!");
			System.out.println("2.GAME SCORE!");
			System.out.println("3.GAME EXIT!");
			System.out.print(">>>>");
			start = sc.nextInt();
			if (start == 1) {

			}

			else if (start == 2) {
				System.out.println("-------------------------------------------------------------------");
				System.out.println("결과 >> 승 : " + winCount + ", 패 : " + loseCount);
				System.out.println("-------------------------------------------------------------------");
				continue;
			}

			else if (start == 3)
				break;
			else {
				System.out.println("-------------------------------------------------------------------");
				System.out.println("잘 못입력했습니다.");
				System.out.println("1~3 사이의 숫자를 다시 입력해 주세요.");
				System.out.println("-------------------------------------------------------------------");
				continue;
			}

			int card1 = ran.nextInt(10);
			int card2 = ran.nextInt(10);
			int opp1 = ran.nextInt(10);
			int opp2 = ran.nextInt(10);

			int bigger = card1 >= card2 ? card1 * 10 + card2 : card2 * 10 + card1;
			int opp = card1 >= opp2 ? opp1 * 10 + opp2 : opp2 * 10 + opp1;
			System.out.println("-------------------------------------------------------------------");
			System.out.println("당신의 카드 >> card1 : " + card1 + ", card2 : " + card2);
			System.out.println("당신의 카드 조합 >> " + bigger);
			System.out.println("-------------------------------------------------------------------");
			System.out.println();
			System.out.println("1. 이긴다.  2. 진다. 3. SIMILAR>>(+-5차이)");
			System.out.print(">>> ");
			int select = sc.nextInt();
			System.out.println("-------------------------------------------------------------------");
			int batting = 0;
			int lastMoney = 0;

			while (true) {
				System.out.println("-------------------------------------------------------------------");
				System.out.println("배팅 금액을 적어주세요.");
				System.out.println("Your money = " + money);
				System.out.print(">>> ");
				batting = sc.nextInt();
				System.out.println("-------------------------------------------------------------------");
				lastMoney = money;
				money -= batting;
				if (money < 0) {
					System.out.println("소지금이 부족합니다.");
					money = lastMoney;
					continue;

				} else
					break;
			}

			System.out.println("money = " + money);

			for (int i = 1; i <= 3; i++) {
				if (select == i) {
					if (bigger > opp - 5 && bigger > opp + 5) {
						if (select == 1) {
							System.out.println("나의 패 >>" + bigger + " : 상대 패 >> " + opp);
							System.out.println("result = The total of your cards is greater than your opponent's");
							System.out.println("Summery >> YOU WIN");
							winCount++;
							money += batting * 1.5;
						} else if (select == 2) {
							System.out.println("나의 패 >>" + bigger + " : 상대 패 >> " + opp);
							System.out.println("result = The total of your cards is less than your opponent's");
							System.out.println("Summery >> YOU LOSE");
							loseCount++;
						} else {
							System.out.println("나의 패 >>" + bigger + " : 상대 패 >> " + opp);
							System.out.println("result = Your number and your opponent's number are the same.");
							System.out.println("Summery >> YOU LOSE");
							loseCount++;
						}

					} else if (bigger < opp - 5 && bigger < opp + 5) {
						if (select == 1) {
							System.out.println("나의 패 >>" + bigger + " : 상대 패 >> " + opp);
							System.out.println("result = The total of your cards is greater than your opponent's");
							System.out.println("Summery >> YOU LOSE");
							loseCount++;
						} else if (select == 2) {
							System.out.println("나의 패 >>" + bigger + " : 상대 패 >> " + opp);
							System.out.println("result = The total of your cards is less than your opponent's");
							System.out.println("Summery >> YOU WIN");
							winCount++;
							money += batting * 1.5;
						} else {
							System.out.println("나의 패 >>" + bigger + " : 상대 패 >> " + opp);
							System.out.println("result = Your number and your opponent's number are the same.");
							System.out.println("Summery >> YOU LOSE");
							loseCount++;
						}
					} else {
						if (select == 1) {
							System.out.println("나의 패 >>" + bigger + " : 상대 패 >> " + opp);
							System.out.println("result = The total of your cards is greater than your opponent's");
							System.out.println("Summery >> YOU LOSE");
							loseCount++;
						} else if (select == 2) {
							System.out.println("나의 패 >>" + bigger + " : 상대 패 >> " + opp);
							System.out.println("result = The total of your cards is less than your opponent's");
							System.out.println("Summery >> YOU LOSE");
							loseCount++;
						} else {
							System.out.println("나의 패 >>" + bigger + " : 상대 패 >> " + opp);
							System.out.println("result = Your number and your opponent's number are the same.");
							System.out.println("Summery >> YOU WIN");
							winCount++;
							money += batting * 2.5;
						}
					}
				}
			} // for
			System.out.println("money = " + money);
			System.out.println("-------------------------------------------------------------------");
			System.out.println();
			if (money <= 0) {
				System.out.println("풉ㅋ풉ㅋ 돈이 떨어졌네요~");
				break;

			}
			// while
		}
		System.out.println("-------------------------------------------------------------------");
		System.out.println("게임을 종료합니다.");
		System.out.println("결과 >> 승 : " + winCount + ", 패 : " + loseCount);
		System.out.println("Your money = " + money);
		System.out.println("-------------------------------------------------------------------");
		sc.close();
	}
}

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;


public class Main{
	static public void main(String[] arge) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat decFormat = new DecimalFormat("###,###");
		Random r = new Random();
		int gameCount = 0;
		int winCheck[] = new int[6];
		long money = 0;
		System.out.println("로또 자동추첨 체험 프로그램입니다.\n");
		System.out.println("[당첨금]");
		System.out.println("[1등] 2,000,000,000원");
		System.out.println("[2등] 50,000,000원");
		System.out.println("[3등] 1,500,000원");
		System.out.println("[4등] 50,000원");
		System.out.println("[5등] 5,000원\n");
		System.out.println("1 이상의 숫자를 입력해주세요. ※ 100000 이하 권장");
		System.out.println("주의사항) 숫자만 입력해주세요.");
		while(true) {
			System.out.print("\n게임 횟수를 입력해주세요 : ");
			int n = sc.nextInt();
			if(n <= 0) {
				System.out.println("1 이상의 숫자를 입력해주세요.");
				continue;
			}
			money -= n*1000;
			gameCount += n;
			
//			정답 번호 6자리 생성
			int answer[] = new int[46];
			int bonusN = 0;
			System.out.print("정답 : ");
			for(int i = 0; i < 7; i++) {
				int num = r.nextInt(45) + 1;
				if(answer[num] == 1) {
					i--;
					continue;
				}
				if(i < 6) {
					answer[num] = 1;
					System.out.printf("%2d ",num);
				}
				else {
					bonusN = num;
				}
			}
			System.out.println("보너스번호 : " + bonusN);
//			정답 번호 6자리 생성 끝			
//			예측 번호 6자리 n번 생성			
			for(int j = 0; j < n; j++) {
				int arr[] = new int[46]; //예측번호 저장 배열 생성
				int cnt = 0;
				boolean bonusCheck = false;
				System.out.print("예측 : ");
				for(int i = 0; i < 6; i++) {
					int num = r.nextInt(45) + 1;
					if(arr[num] == 1) {
						i--;
						continue;
					}
					arr[num] = 1;
					System.out.printf("%2d ",num);
					if(answer[num] == 1) {
						cnt++;
					}
					if(bonusN == num) {
						bonusCheck = true;
					}
				}
				if(cnt == 3) {
					winCheck[5] += 1;
					money += 5000;
					System.out.println("[5등]★");
				}
				else if(cnt == 4) {
					winCheck[4] += 1;
					money += 50000;
					System.out.println("[4등]★★");
				}
				else if(cnt == 5 && !bonusCheck) {
					winCheck[3] += 1;
					money += 1500000;
					System.out.println("[3등]★★★");
				}
				else if(cnt == 5 && bonusCheck) {
					winCheck[2] += 1;
					money += 50000000;
					System.out.println("[2등]★★★★");
				}
				else if(cnt == 6) {
					winCheck[1] += 1;
					money += 2000000000;
					System.out.println("[1등]★★★★★");
				}
				else {
					winCheck[0] += 1;
					System.out.println("[꽝]");
				}
//			정답 번호 6자리 n번 생성 끝			
			}
			String won = decFormat.format(money);
			System.out.println("---------------------------");
			System.out.println("게임 횟수 : " + gameCount);
			System.out.println("---------------------------");
			System.out.println("꽝 횟수  : " + winCheck[0]);
			System.out.println("1등 횟수 : " + winCheck[1]);
			System.out.println("2등 횟수 : " + winCheck[2]);
			System.out.println("3등 횟수 : " + winCheck[3]);
			System.out.println("4등 횟수 : " + winCheck[4]);
			System.out.println("5등 횟수 : " + winCheck[5]);
			System.out.println("---------------------------");
			System.out.printf("꽝 당첨률  : %f\n",(double)winCheck[0]/gameCount*100);
			System.out.printf("1등 당첨률 : %f\n",(double)winCheck[1]/gameCount*100);
			System.out.printf("2등 당첨률 : %f\n",(double)winCheck[2]/gameCount*100);
			System.out.printf("3등 당첨률 : %f\n",(double)winCheck[3]/gameCount*100);
			System.out.printf("4등 당첨률 : %f\n",(double)winCheck[4]/gameCount*100);
			System.out.printf("5등 당첨률 : %f\n",(double)winCheck[5]/gameCount*100);
			System.out.println("---------------------------");
			System.out.println("수익 : " + won + "원");
		}
	}
}
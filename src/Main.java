import java.util.Random;
import java.util.Scanner;


public class Main{
	static public void main(String[] arge) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int gameCount = 0;
		int winCheck[] = new int[6];
		long money = 0;
		while(true) {
			int n = sc.nextInt();
			money -= n*1000;
			gameCount += n;
			if(n <= 0) {
				break;
			}
//			정답 번호 6자리 생성
			int answer[] = new int[46];
			int bonusN = 0;
			for(int i = 0; i < 7; i++) {
				int num = r.nextInt(45) + 1;
				if(answer[num] == 1) {
					i--;
					continue;
				}
				if(i < 6) {
					answer[num] = 1;
				}
				else {
					bonusN = num;
				}
			}
			
			System.out.print("정답 : ");
			for(int i = 0; i < 46; i++) {
				if(answer[i] == 1) {
					System.out.print(i + " ");
				}
			}
			System.out.println("보너스번호 : " + bonusN);
			System.out.println();
//			정답 번호 6자리 생성 끝			
//			예측 번호 6자리 n번 생성			
			for(int j = 0; j < n; j++) {
				int arr[] = new int[46];
				for(int i = 0; i < 6; i++) {
					int num = r.nextInt(45) + 1;
					if(arr[num] == 1) {
						i--;
						continue;
					}
					arr[num]= 1;
				}
				
				System.out.print("예측 : ");
				int cnt = 0;
				boolean bonusCheck = false;
				for(int i = 0; i < 46; i++) {
					if(arr[i] == 1) {
						System.out.printf("%3s",(i + " "));
					}
					if(arr[i] == 1 && answer[i] == 1) {
						cnt++;
					}
					if(arr[i] == 1 && bonusN == i) {
						bonusCheck = true;
					}
				}
				if(cnt == 3) {
					winCheck[5] += 1;
					money += 5000;
					System.out.print("[5등]★");
				}
				else if(cnt == 4) {
					winCheck[4] += 1;
					money += 50000;
					System.out.print("[4등]★★");
				}
				else if(cnt == 5 && !bonusCheck) {
					winCheck[3] += 1;
					money += 1000000;
					System.out.print("[3등]★★★");
				}
				else if(cnt == 5 && bonusCheck) {
					winCheck[2] += 1;
					money += 20000000;
					System.out.print("[2등]★★★★");
				}
				else if(cnt == 6) {
					winCheck[1] += 1;
					money += 2000000000;
					System.out.print("[1등]★★★★★");
				}
				else {
					winCheck[0] += 1;
					System.out.print("[꽝]");
				}
				System.out.println();
//			정답 번호 6자리 n번 생성 끝			
			}
			System.out.println("게임 횟수 : " + gameCount);
			System.out.println("꽝 횟수 : " + winCheck[0]);
			System.out.println("1등 횟수 : " + winCheck[1]);
			System.out.println("2등 횟수 : " + winCheck[2]);
			System.out.println("3등 횟수 : " + winCheck[3]);
			System.out.println("4등 횟수 : " + winCheck[4]);
			System.out.println("5등 횟수 : " + winCheck[5]);
			System.out.println("수익 : " + money);
			System.out.println("숫자를 0 이하로 입력 시 종료");
		}
	}
}
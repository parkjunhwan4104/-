package Third;

import java.util.Scanner;  

import Third.ArticleController;

public class App {
	static Member loginedMember=null;
	Scanner scan=new Scanner(System.in);

	ArticleController ac = new ArticleController();
	MemberController mc=new MemberController();
	Controller ct=null;
	

	public void start() {
		while(true) {
			if(loginedMember==null) {
				System.out.print("명령어를 입력해주세요: ");
			}
			else {
				System.out.print("명령어를 입력해주세요["+loginedMember.getNickname()+"님]:");
			}
			String cmd=scan.nextLine();
			String[] divide=cmd.split(" ");
			
			if (divide.length < 2) {
				System.out.println("잘못된 명령어입니다.");
				continue;
			}
			
			String func=divide[1];
			
			if(divide[0].equals("article")) {
				ct=ac;
				
			}
			
			if(divide[0].equals("member")) {
				
				ct=mc;
			}
			
			if(cmd.equals("exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			ct.doCommand(func);
		}
		
		
		
	}



}

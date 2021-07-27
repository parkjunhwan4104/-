package Fifth;

import java.util.ArrayList;   
import java.util.Scanner;

public class MemberController extends Controller {

	ArrayList<Member> member=new ArrayList<Member>();
	Scanner scan=new Scanner(System.in);

	public void doCommand(String cmd) {


		if(cmd.equals("signup")) {

			signup();
		}
		else if(cmd.equals("signin")) {

			signin();
		}
		else if(cmd.equals("logout")) {
			logout();
			
		}
		else {
			System.out.println("명령어를 올바르게 입력해 주시기 바랍니다.");
			
		}

	}

	public void signup() {
		System.out.print("회원가입에 필요한 아이디를 입력해주세요: ");
		String id=scan.nextLine();

		System.out.print("회원가입에 필요한 비밀번호를 입력해주세요: ");
		String password=scan.nextLine();

		System.out.print("사용할 닉네임을 입력해주세요: ");
		String nickname=scan.nextLine();

		Member m=new Member(id,password,nickname);

		member.add(m);

		System.out.println("회원가입이 완료되었습니다.");

	}

	public void signin() {

		System.out.print("아이디를 입력해주세요: ");
		String id=scan.nextLine();

		System.out.print("비밀번호를 입력해주세요: ");
		String password=scan.nextLine();


		boolean islogined=false;
		if(member.size()!=0) {
			for(int i=0;i<member.size();i++) {
				
					if((!(id.equals(""))&&!(password.equals("")))) {
		
		
						if(member.get(i).getGuestId().equals(id)&&member.get(i).getGuestPassword().equals(password)) {
							App.loginedMember=member.get(i);
							islogined=true;
							System.out.println(member.get(i).getNickname()+"님 환영합니다.");
							
						}
						
					}
					else {
						
						System.out.println("해당 회원정보가 존재하지 않습니다.");
					}
				
				
			}
		}
		else {
			System.out.println("해당 회원정보가 존재하지 않습니다.");
			
		}
		
		if(!(islogined)) {
			System.out.println("해당 회원정보가 존재하지 않습니다.");
			
		}

	}
	public void logout() {
		App.loginedMember=null;
		System.out.println("로그아웃 되었습니다.");
		
	}

}

package article;

public abstract class Controller {
	public abstract void doCommand(String cmd);

	public boolean logined() {
		if(App.loginedMember!=null) {

			return true;
		}
		else {
			System.out.println("로그인이 필요한 기능입니다.");	
			return false;
		}
	}



}

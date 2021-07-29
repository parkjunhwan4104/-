package DB;

public class Member {
	
	private String guestId;
	private String guestPw;
	
	
	
	public Member(String guestId,String guestPw ) {
		super();
		
		this.guestId=guestId;
		this.guestPw=guestPw;
		
	}
	
	

	







	public String getGuestId() {
		return guestId;
	}
	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}
	public String getGuestPw() {
		return guestPw;
	}
	public void setGuestPw(String guestPw) {
		this.guestPw = guestPw;
	}

}

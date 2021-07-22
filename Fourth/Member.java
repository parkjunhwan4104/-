package Fourth;

public class Member {
	private String guestId;
	private String guestPassword;
	private String nickname;
	
	public Member(String guestId,String guestPassword,String nickname ) {
		
		this.guestId=guestId;
		this.guestPassword=guestPassword;
		this.nickname=nickname;
	}
	
	public String getGuestId() {
		return guestId;
	}
	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}
	public String getGuestPassword() {
		return guestPassword;
	}
	public void setGuestPassword(String guestPassword) {
		this.guestPassword = guestPassword;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}

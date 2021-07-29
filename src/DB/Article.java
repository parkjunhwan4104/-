package DB;


//설계도
public class Article {
	private int id;
	private	String title;
	private String body;
	private String nickname;
	private String regDate;
	private int hit;
	
	
	
	
	// 설계도에 객체가 만들어 질 때 (new)무조건 실행되는 메서드 -> 생성자 
		// 1. 클래스명과 동일.
		// 2. 리턴타입이 없음.
	public Article(int id, String title, String body, String nickname,String regDate, int hit) {
		//this는 article객체가 생성되었을 떄의 article을 의미함
		this.id = id;
		this.title = title;
		this.body = body;
		this.nickname = nickname;
		this.regDate = regDate;
		this.hit = hit;
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
}

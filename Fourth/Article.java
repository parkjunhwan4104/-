package Fourth;

public class Article {
	
	private int articleId;
	private String title;
	private String body;
	private String writer;
	private String regDate;
	private int hit;
	
	public Article(int articleId, String title, String body, String writer,String regDate, int hit) {
		
		this.articleId = articleId;
		this.title = title;
		this.body = body;
		this.writer = writer;
		this.regDate = regDate;
		this.hit = hit;
		
		
	}
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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

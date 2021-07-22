package Fourth;

public class Comment {
	
	private String writer;
	private String regDate;
	private String body;
	private int articleNum;
	
	public Comment(int articleNum, String writer,String body,String regDate) {
		
		this.articleNum=articleNum;
		this.writer=writer;
		this.body=body;
		this.regDate=regDate;
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
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getArticleNum() {
		return articleNum;
	}
	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}

}

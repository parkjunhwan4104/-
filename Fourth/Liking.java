package Fourth;

public class Liking {
	private int articleId;
	private String Writer;
	
	
	
	

	public Liking(int articleId,String Writer) {
		
		this.articleId=articleId;
		this.Writer=Writer;
		
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getWriter() {
		return Writer;
	}

	public void setWriter(String writer) {
		Writer = writer;
	}

}

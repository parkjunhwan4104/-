package Fifth;

import java.util.Comparator;

public class ArticleSorter implements Comparator<Article>{
	private String sortTarget;
	private String sortType;
	public String getSortTarget() {
		return sortTarget;
	}
	public void setSortTarget(String sortTarget) {
		this.sortTarget = sortTarget;
	}
	public String getSortType() {
		return sortType;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	
	
	@Override
	public int compare(Article o1, Article o2) {
		
		if(sortTarget.equals("articleId")) {
			if(sortType.equals("asc")) {
				if(o1.getArticleId()>o2.getArticleId()) {
					return 1;
				}
			}
			else if(sortType.equals("desc")) {
				
				if(o1.getArticleId()<o2.getArticleId()) {
					
					return 1;
				}
			}
			
		}
		
		if(sortTarget.equals("title")) {
			if(sortType.equals("asc")) {
				if(o1.getTitle().compareTo(o2.getTitle())>0) {
					return 1;
				}
			}
			else if(sortType.equals("desc")) {
				
				if(o1.getTitle().compareTo(o2.getTitle())<0) {
					
					return 1;
				}
			}
			
		}
		
		if(sortTarget.equals("hit")) {
			if(sortType.equals("asc")) {
				if(o1.getHit()>o2.getHit()) {
					return 1;
				}
			}
			else if(sortType.equals("desc")) {
				
				if(o1.getHit()<o2.getHit()) {
					
					return 1;
				}
			}
			
		}
		
		
		return -1;
	}

}

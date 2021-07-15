package First;

import java.util.Scanner; 

import First.ArticleController;

public class App {
	
	Scanner scan=new Scanner(System.in);

	ArticleController ac = new ArticleController();
	
	

	public void start() {
		
		ac.doCommand();
		
		
	}



}

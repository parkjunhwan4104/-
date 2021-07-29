package JSP;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.Article;


@WebServlet("/ArticleController/*")
public class ArticleController extends HttpServlet {
	ArrayList<Article> articles = new ArrayList<Article>();
	Article a1 = new Article(1, "제목1", "내용1", "홍길동", "2021.07.29", 10);
	Article a2 = new Article(2, "제목2", "내용2", "이순신", "2021.07.29", 30);
	Article a3 = new Article(3, "제목3", "내용3", "을지문덕", "2021.07.29", 20);
	int ArticleNum=3;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		
		String[] uriBits=uri.split("/");
		
		if(uriBits.length<4) {
			
			return;
			
		}
		if(articles.isEmpty()) {
			articles.add(a1);
			articles.add(a2);
			articles.add(a3);
		}
		
		
		String cmd=uriBits[3];
		
		if(cmd.equals("List")) {
			
			request.setAttribute("articles", articles);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/List.jsp");
			dispatcher.forward(request, response);
				
			
		}
		
		if(cmd.equals("add")) {
			String title=request.getParameter("title");
			String body=request.getParameter("body");
			
			ArticleNum++;
			Article a=new Article(ArticleNum,title,body,"test","2021.07.29",10);
			articles.add(a);
			
			request.setAttribute("articles", articles);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/List.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		

	}

}
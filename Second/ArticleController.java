package Second;

import java.util.ArrayList;
import java.util.Scanner;

import Second.Article;

public class ArticleController extends Controller {

	Scanner scan=new Scanner(System.in);
	ArrayList<Article> articles=new ArrayList<Article>();
	private int LastId;

	public void doCommand(String cmd) {
		if(articles.isEmpty()) {
			MakeExample();

		}



		if(cmd.equals("add")) {
			if(logined()) {
				add();
			}
		}
		else if(cmd.equals("list")) {

			list();
		}

		else if(cmd.equals("delete")) {
			if(logined()) {
				delete();
			}
			
		}
		else if(cmd.equals("update")){
			if(logined()) {
				update();
			}
			
		}

		else if(cmd.equals("search")){

			search();
		}
		else {

			System.out.println("article에 맞는 명령어를 올바르게 입력해 주시기 바랍니다.");
		}


	}



	public void search(){
		System.out.print("몇 번 게시물을 보시겠습니까? ");
		String numStr=scan.nextLine();
		int num=Integer.parseInt(numStr);

		Article target=null;
		for(int i=0;i<articles.size();i++) {
			if(articles.get(i).getArticleId()==num) {
				target=articles.get(i);
				System.out.println("===========================");
				System.out.println("게시물 번호: "+articles.get(i).getArticleId());
				System.out.println("제목 : " + articles.get(i).getTitle());
				System.out.println("내용 : " + articles.get(i).getBody());
				System.out.println("등록날짜: " + articles.get(i).getRegDate());
				System.out.println("조회수 : " + articles.get(i).getHit());
				System.out.println("작성자 : " + articles.get(i).getWriter());
				System.out.println("===========================");

			}

		}
		if(target==null) {
			System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
		}


	}

	public void list() {
		System.out.println("===========================");
		for(int i=0;i<articles.size();i++) {

			System.out.println("게시물 번호: "+articles.get(i).getArticleId());
			System.out.println("제목 : " + articles.get(i).getTitle());
			System.out.println("내용 : " + articles.get(i).getBody());
			System.out.println("등록날짜: " + articles.get(i).getRegDate());
			System.out.println("조회수 : " + articles.get(i).getHit());
			System.out.println("작성자 : " + articles.get(i).getWriter());
			System.out.println("===========================");

		}

	}


	public void add() {
		System.out.print("게시물 제목을 입력해주세요: ");
		String title=scan.nextLine();

		System.out.print("게시물 내용을 입력해주세요: ");
		String body=scan.nextLine();

		LastId++;

		Article a=new Article(LastId,title,body,"익명","2021.07.13",50);
		articles.add(a);

	}

	public void delete() {
		if(articles.size()==0) {
			System.out.println("삭제할 게시물이 없습니다.");

		}
		else {
			System.out.print("몇 번 게시물을 삭제하시겠습니까?:");
			String numStr=scan.nextLine();
			int num=Integer.parseInt(numStr);

			Article target=null;

			for(int i=0;i<articles.size();i++) {
				if(articles.get(i).getArticleId()==num) {
					target=articles.get(i);
					articles.remove(target);

				}


			}
			if(target==null) {

				System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
			}
		}

	}
	public void update() {
		System.out.print("수정할 게시물 번호를 입력하세요: ");
		String numStr=scan.nextLine();
		int num=Integer.parseInt(numStr);

		Article target=null;

		for(int i=0;i<articles.size();i++) {

			if(articles.get(i).getArticleId()==num) {
				target=articles.get(i);

				System.out.print("새로운 제목을 입력해주세요:");
				String newTitle=scan.nextLine();

				System.out.print("새로운 내용을 입력해주세요:");
				String newBody=scan.nextLine();

				target.setTitle(newTitle);
				target.setBody(newBody);
			}

		}
		if(target==null) {

			System.out.println("입력한 게시물 번호가 존재하지 않습니다.");
		}

	}

	public void MakeExample() {

		Article a1 = new Article(1, "고구려", "내용1", "홍길동", "2021.07.13", 10);
		Article a2 = new Article(2, "강아지", "내용2", "이도", "2021.07.13", 30);
		Article a3 = new Article(3, "신라", "내용3", "이순신", "2021.07.13", 20);

		articles.add(a1);
		articles.add(a2);
		articles.add(a3);

		LastId=3;
	}

}

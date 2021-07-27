package Fifth;

import java.text.SimpleDateFormat;  
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;

import Fifth.Article;

public class ArticleController extends Controller {

	Scanner scan=new Scanner(System.in);
	static ArrayList<Article> articles=new ArrayList<Article>();
	ArrayList<Comment> comments=new ArrayList<Comment>();
	ArrayList<Liking> likes=new ArrayList<Liking>();
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
			if(logined()) {
				search();
			}
		}else if(cmd.equals("sort")) {

			sort();
		}
		else if(cmd.equals("page")) {

			page();
		}


		else {

			System.out.println("명령어를 올바르게 입력해 주시기 바랍니다.");
		}


	}



	private void page() {
		int unitArticle=3;		
		int currentPageNo=1;
		int unitPageBlock=5;

		int startArticleIndex;
		int endArticleIndex;

		int currentPageBlock=(int)Math.ceil((double)currentPageNo/unitPageBlock);
		
		int startPageNum=unitPageBlock*(currentPageBlock-1)+1;
		int endPageNum=unitPageBlock*(currentPageBlock);

		int totalItemCount = articles.size();
		int lastPageNo = (int)Math.ceil((double)totalItemCount / unitArticle);	
		if(endPageNum>lastPageNo) {
			endPageNum=lastPageNo;
		}


		for(int i=0;i<=2;i++) {
			
			System.out.println("===========================");
			System.out.println("게시물 번호: "+articles.get(i).getArticleId());
			System.out.println("제목 : " + articles.get(i).getTitle());
			System.out.println("내용 : " + articles.get(i).getBody());
			System.out.println("등록날짜: " + articles.get(i).getRegDate());
			System.out.println("조회수 : " + articles.get(i).getHit());
			System.out.println("작성자 : " + articles.get(i).getWriter());
			System.out.println("===========================");


			for(int j=0;j<comments.size();j++) {

				if(articles.get(i).getArticleId()==comments.get(j).getArticleNum()) {
					System.out.println("==========댓글==============");
					System.out.println("작성자: "+comments.get(j).getWriter());
					System.out.println("댓글 내용: "+comments.get(j).getBody());
					System.out.println("등록 시간: "+comments.get(j).getRegDate());	
					System.out.println("===========================");


				}
			}
			System.out.println();

		}

		for(int j=startPageNum;j<=endPageNum;j++) {
			if(currentPageNo==j) {
				System.out.print(" ["+j+"] ");
			}
			else {
				System.out.print(j+" ");
			}


		}
		System.out.println();
		while(true) {


			System.out.print("페이징 명령어를 입력해주세요 ((1 : 이전,  2 : 다음,  3 : 선택,  4 : 돌아가기):");
			int cmd=Integer.parseInt(scan.nextLine());

			if(cmd==1) {
				
				if(currentPageNo==1) {
					System.out.println("현재 페이지번호가  1이므로 해당 명령어를 실행할 수 없습니다.");
				}
				else {
					
					
					currentPageNo=currentPageNo-1;
					startArticleIndex=(currentPageNo-1)*unitArticle;
					endArticleIndex=startArticleIndex+2;
					
					startPageNum=unitPageBlock*(currentPageBlock-1)+1;
					endPageNum=unitPageBlock*(currentPageBlock);
					
					for(int i=startArticleIndex;i<=endArticleIndex;i++) {
						System.out.println("===========================");
						System.out.println("게시물 번호: "+articles.get(i).getArticleId());
						System.out.println("제목 : " + articles.get(i).getTitle());
						System.out.println("내용 : " + articles.get(i).getBody());
						System.out.println("등록날짜: " + articles.get(i).getRegDate());
						System.out.println("조회수 : " + articles.get(i).getHit());
						System.out.println("작성자 : " + articles.get(i).getWriter());
						System.out.println("===========================");
						for(int j=0;j<comments.size();j++) {

							if(articles.get(i).getArticleId()==comments.get(j).getArticleNum()) {
								System.out.println("==========댓글==============");
								System.out.println("작성자: "+comments.get(j).getWriter());
								System.out.println("댓글 내용: "+comments.get(j).getBody());
								System.out.println("등록 시간: "+comments.get(j).getRegDate());	
								System.out.println("===========================");


							}
						}
						System.out.println();
					}
					for(int j=startPageNum;j<=endPageNum;j++) {

						if(currentPageNo==j) {
							System.out.print(" ["+j+"] ");

						}
						else {
							System.out.print(" "+j+" ");

						}
					}
					System.out.println();
				}
			}

			if(cmd==2) {

				if(currentPageNo==lastPageNo) {
					System.out.println("현재 페이지가 마지막 페이지이므로 해당 해당 명령어를 실행할 수 없습니다.");
				}
				else {
					
					currentPageNo=currentPageNo+1;
					startArticleIndex=(currentPageNo-1)*unitArticle;
					endArticleIndex=startArticleIndex+2;
					
					startPageNum=unitPageBlock*(currentPageBlock-1)+1;
					endPageNum=unitPageBlock*(currentPageBlock);
					
					if(endArticleIndex>totalItemCount-1) {
						endArticleIndex=totalItemCount-1;
					}
					
					for(int i=startArticleIndex;i<=endArticleIndex;i++) {
						System.out.println("===========================");
						System.out.println("게시물 번호: "+articles.get(i).getArticleId());
						System.out.println("제목 : " + articles.get(i).getTitle());
						System.out.println("내용 : " + articles.get(i).getBody());
						System.out.println("등록날짜: " + articles.get(i).getRegDate());
						System.out.println("조회수 : " + articles.get(i).getHit());
						System.out.println("작성자 : " + articles.get(i).getWriter());
						System.out.println("===========================");
						for(int j=0;j<comments.size();j++) {

							if(articles.get(i).getArticleId()==comments.get(j).getArticleNum()) {
								System.out.println("==========댓글==============");
								System.out.println("작성자: "+comments.get(j).getWriter());
								System.out.println("댓글 내용: "+comments.get(j).getBody());
								System.out.println("등록 시간: "+comments.get(j).getRegDate());	
								System.out.println("===========================");


							}
						}
						System.out.println();

					}
					for(int j=startPageNum;j<=endPageNum;j++) {


						if(currentPageNo==j) {
							System.out.print(" ["+j+"] ");

						}
						else {
							System.out.print(" "+j+" ");

						}
					}
					System.out.println();

				}


			}

			if(cmd==3) {
				
				
				System.out.print("페이지 번호를 입력하십시오:");
				int page_num=Integer.parseInt(scan.nextLine());
				
				
				
				currentPageNo=page_num;
				startArticleIndex=(currentPageNo-1)*unitArticle;
				endArticleIndex=startArticleIndex+2;
				
				startPageNum=unitPageBlock*(currentPageBlock-1)+1;
				endPageNum=unitPageBlock*(currentPageBlock);
				
				if(endArticleIndex>totalItemCount-1) {
					endArticleIndex=totalItemCount-1;
				}
				
				
				for(int i=startArticleIndex;i<=endArticleIndex;i++) {
					System.out.println("===========================");
					System.out.println("게시물 번호: "+articles.get(i).getArticleId());
					System.out.println("제목 : " + articles.get(i).getTitle());
					System.out.println("내용 : " + articles.get(i).getBody());
					System.out.println("등록날짜: " + articles.get(i).getRegDate());
					System.out.println("조회수 : " + articles.get(i).getHit());
					System.out.println("작성자 : " + articles.get(i).getWriter());
					System.out.println("===========================");
					for(int j=0;j<comments.size();j++) {

						if(articles.get(i).getArticleId()==comments.get(j).getArticleNum()) {
							System.out.println("==========댓글==============");
							System.out.println("작성자: "+comments.get(j).getWriter());
							System.out.println("댓글 내용: "+comments.get(j).getBody());
							System.out.println("등록 시간: "+comments.get(j).getRegDate());	
							System.out.println("===========================");


						}
					}
					System.out.println();

				}
				for(int j=startPageNum;j<=endPageNum;j++) {


					if(currentPageNo==j) {
						System.out.print(" ["+j+"] ");

					}
					else {
						System.out.print(" "+j+" ");

					}
				}
				System.out.println();


			}

			if(cmd==4) {
				System.out.println("돌아가기를 수행합니다.");
				break;

			}

		}


	}



	private void sort() {
		ArticleSorter as=new ArticleSorter();

		System.out.print("정렬 대상을 입력해주세요(게시물 번호:articleId, 제목:title, 조회수:hit):");
		String sortTarget=scan.nextLine();

		System.out.print("정렬 방법을 입력해주세요(asc:오름차순, desc:내림차순):");
		String sortType=scan.nextLine();

		as.setSortTarget(sortTarget);
		as.setSortType(sortType);
		Collections.sort(articles, as);
		System.out.println("정렬이 완료되었습니다.");
		list();
	}



	public void search(){
		System.out.print("몇 번 게시물을 보시겠습니까? ");
		String numStr=scan.nextLine();
		int num=Integer.parseInt(numStr);

		Article target=null;
		for(int i=0;i<articles.size();i++) {
			if(articles.get(i).getArticleId()==num) {
				target=articles.get(i);
				printArticle(target);
				searchFunction(target);

			}

		}
		if(target==null) {
			System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
		}




	}

	private void searchFunction(Article article) {

		while(true) {
			System.out.print("수행하실 자세히보기 기능을 선택해주세요:(1.댓글, 2.좋아요, 3.돌아가기  ):");
			int num=Integer.parseInt(scan.nextLine());

			if(num==1) {
				writeComment(article);

			}

			else if(num==2) {

				liking(article);
				printArticle(article);

			}


			else if(num==3) {
				System.out.println("돌아가기를 수행합니다.");
				break;
			}
			else {

				System.out.println("잘못된 번호를 입력하셨습니다.");
			}
		}

	}



	private void liking(Article article) {

		int articleNum=article.getArticleId();
		String liker=App.loginedMember.getNickname();


		Liking target=getLike(articleNum,liker);




		if(target==null) {	

			Liking like=new Liking(articleNum,liker);
			likes.add(like);			
			System.out.println("해당 게시물을 좋아합니다.");			
		}
		else {

			likes.remove(target);

			System.out.println("해당 게시물의 좋아요를 해제합니다.");


		}


	}

	private Liking getLike(int articleNum,String liker) {
		Liking target=null;

		for(Liking like:likes) {
			if((like.getArticleId()==articleNum)&&(like.getWriter()==liker)) {
				target=like;

			}
		}
		return target;
	}

	private void printArticle(Article article) {
		int LikeNum;


		System.out.println("===========================");
		System.out.println("게시물 번호: "+article.getArticleId());
		System.out.println("제목 : " + article.getTitle());
		System.out.println("내용 : " + article.getBody());
		System.out.println("등록날짜: " + article.getRegDate());
		System.out.println("조회수 : " + article.getHit());
		System.out.println("작성자 : " + article.getWriter());

		Liking target=getLike(article.getArticleId(),App.loginedMember.getNickname());
		LikeNum=getLikeNum(article.getArticleId());

		if(target==null) {
			System.out.println("좋아요 수:  ♡ "+LikeNum);
		}

		else {
			System.out.println("좋아요 수: ♥ "+LikeNum);

		}
		System.out.println("===========================");
		for(int j=0;j<comments.size();j++) {

			if(article.getArticleId()==comments.get(j).getArticleNum()) {
				System.out.println("==========댓글==============");
				System.out.println("작성자: "+comments.get(j).getWriter());
				System.out.println("댓글 내용: "+comments.get(j).getBody());
				System.out.println("등록 시간: "+comments.get(j).getRegDate());	
				System.out.println("===========================");


			}
		}

	}

	private int getLikeNum(int articleNum) {
		int LikeNum=0;

		for(Liking liking:likes) {
			if(liking.getArticleId()==articleNum) {
				LikeNum++;
			}

		}
		return LikeNum;
	}



	private void writeComment(Article article) {

		SimpleDateFormat format=new SimpleDateFormat("yyyy.MM.dd. HH:mm");
		Date time=new Date();
		String time1=format.format(time);

		String nickname=App.loginedMember.getNickname();
		String regdate=time1;

		System.out.print("댓글 내용을 입력해 주세요:");
		String body=scan.nextLine();

		Comment c=new Comment(article.getArticleId(),nickname,body,regdate);
		comments.add(c);

		System.out.println("==========댓글==============");
		System.out.println("작성자: "+nickname);
		System.out.println("댓글 내용: "+body);
		System.out.println("등록 시간: "+regdate);		
		System.out.println("===========================");

	}



	public void list() {

		for(int i=0;i<articles.size();i++) {
			System.out.println("===========================");
			System.out.println("게시물 번호: "+articles.get(i).getArticleId());
			System.out.println("제목 : " + articles.get(i).getTitle());
			System.out.println("내용 : " + articles.get(i).getBody());
			System.out.println("등록날짜: " + articles.get(i).getRegDate());
			System.out.println("조회수 : " + articles.get(i).getHit());
			System.out.println("작성자 : " + articles.get(i).getWriter());
			System.out.println("===========================");


			for(int j=0;j<comments.size();j++) {

				if(articles.get(i).getArticleId()==comments.get(j).getArticleNum()) {
					System.out.println("==========댓글==============");
					System.out.println("작성자: "+comments.get(j).getWriter());
					System.out.println("댓글 내용: "+comments.get(j).getBody());
					System.out.println("등록 시간: "+comments.get(j).getRegDate());	
					System.out.println("===========================");


				}
			}
			System.out.println();

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
		Article a4 = new Article(4, "신라", "내용3", "이순신", "2021.07.13", 20);
		Article a5 = new Article(5, "강아지", "내용2", "이도", "2021.07.13", 30);
		Article a6 = new Article(6, "신라", "내용3", "이순신", "2021.07.13", 20);
		Article a7 = new Article(7, "신라", "내용3", "이순신", "2021.07.13", 20);

		Article a8 = new Article(8, "강아지", "내용2", "이도", "2021.07.13", 30);
		Article a9 = new Article(9, "신라", "내용3", "이순신", "2021.07.13", 20);
		Article a10 = new Article(10, "신라", "내용3", "이순신", "2021.07.13", 20);

		Article a11 = new Article(11, "강아지", "내용2", "이도", "2021.07.13", 30);
		Article a12 = new Article(12, "신라", "내용3", "이순신", "2021.07.13", 20);
		Article a13= new Article(13, "신라", "내용3", "이순신", "2021.07.13", 20);
		
		Article a14 = new Article(14, "강아지", "내용2", "이도", "2021.07.13", 30);
		Article a15 = new Article(15, "신라", "내용3", "이순신", "2021.07.13", 20);
		Article a16= new Article(16, "신라", "내용3", "이순신", "2021.07.13", 20);
		
		Article a17 = new Article(17, "강아지", "내용2", "이도", "2021.07.13", 30);
		Article a18 = new Article(18, "신라", "내용3", "이순신", "2021.07.13", 20);
		Article a19= new Article(19, "신라", "내용3", "이순신", "2021.07.13", 20);


		articles.add(a1);
		articles.add(a2);
		articles.add(a3);
		articles.add(a4);
		articles.add(a5);
		articles.add(a6);
		articles.add(a7);
		articles.add(a8);
		articles.add(a9);
		articles.add(a10);
		articles.add(a11);
		articles.add(a12);
		articles.add(a13);
		articles.add(a14);
		articles.add(a15);
		articles.add(a16);
		articles.add(a17);
		articles.add(a18);
		articles.add(a19);

		LastId=19;
	}

}

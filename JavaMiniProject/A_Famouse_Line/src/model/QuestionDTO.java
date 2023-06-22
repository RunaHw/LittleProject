package model;

public class QuestionDTO {
	
	// DTO : Data Transfer Object : 계층간 데이터 전송을 위한 객체
	// 데이터를 편하게 주고받기 위해 만드는 바구니(자료형)
	
	// 필드 필요! 
	// entity 라고 지칭하기도 함!!
	// DB의 테이블과 직접적인 연관성을 가짐
	// DTO 도 1테이블 당, 1개씩 만들어야 한다.
	// 테이블의 각각의 컬럼안 데이터를 저장할 필드가 필요하다.
	
	
	// field
	// 반드시!!!!!!!!!!!  테이블의 컬럼명 == 필드명 일치
	// private도 선언
	
	private int question_number ;
	private String title ;
	private String answer ;
	private String path ;
	private String genre ;
	private String explication ;
	private String path2 ;
	
	
	
	// 메서드
	
	public QuestionDTO(int question_number, String title, String answer, String path, String genre,
			String explication, String path2) {
		super();
		this.question_number = question_number;
		this.title = title;
		this.answer = answer;
		this.path = path;
		this.genre = genre;
		this.explication = explication;
		this.path2 = path2;
	}
	
	// 기본생성자 반드시 위 메서드는 3개의 매개변수가 고정되어있기때문에
	// 유연성 있는 기본 생성자 생성
	public QuestionDTO() {

	}



	public int getQuestion_number() {
		return question_number;
	}



	public void setQuestion_number(int question_number) {
		this.question_number = question_number;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAnswer() {
		return answer;
	}



	public void setAnswer(String answer) {
		this.answer = answer;
	}



	public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public String getGenre() {
		return genre;
	}



	public void setGenre(String genre) {
		this.genre = genre;
	}



	public String getExplication() {
		return explication;
	}



	public void setExplication(String explication) {
		this.explication = explication;
	}



	public String getPath2() {
		return path2;
	}



	public void setPath2(String path2) {
		this.path2 = path2;
	}





}

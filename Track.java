package game;

public class Track {
	
	private String titleImage;// 제목부분 이미지
	private String startImage;// 게임선택창 표지 이미지
	private String gameImage;// 해당 곡을 실행했을때 표지이미지
	private String startMusic;// 게임선택창 음악
	private String gameMusic;// 해당곡을 실행했을때 음악
	private String title_name;//곡제목
	
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	public String gettitle_name() {
		return title_name;
	}
	public void settitle_name(String title_name) {
		this.title_name = title_name;
	}
	public Track(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic, String title_name) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.title_name = title_name;
	}
	
	
	

}


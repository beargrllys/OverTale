package game2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DynamicBeat extends JFrame {
	
	private Image screenImage;
	//jdk에서 이미지를 저장/지정해주는 private 함수
	//private 함수: 클래스내에 존재한다면 그 클래스 안에서만 사용가능하며 이처럼 클래스 초장에 전역변수로서 지정되어있다면 이 클래서 내에서만 사용가능하다.
	private Graphics screenGraphic;
	//그래픽 게체를 하면에 그려넣어준다.
	
	private Image introBackground;
	//배경 이미지 저장
	
	public DynamicBeat() {
		//다이나믹비트 생성자
		//생성자란? 클래스가 들어올때 해당클래스를 초기화 해줌->클래스의 초기세팅을 설정해준다.
		setTitle("Dynamic Beat");
		//제목지정
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		//화면 크기 지정
		setResizable(false);
		//화면 크기변화 모드 설정
		setLocationRelativeTo(null);
		//화면이 창의 어디에 정렬할것인가
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//우측 상단에 x표시를 누르면 프로그램실행종료
		setVisible(true);
		//가시화 여부 설정
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introbackground.jpg")).getImage();
		//이미지 파일을 이미지 객체로 생성
	}
	
	public void paint(Graphics g) {
		//paint클래스:Graphic모듈에 들어있는 라이브러리로 이미지파일을 화면에 그려주는 역할을 한다.
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		//사진이 나올 크기를 설정해준다.
		screenGraphic = screenImage.getGraphics();
		//위의 설정값에 따라 그래픽 게체로 취급시켜줌 
		screenDraw(screenGraphic);
		// 위 설정값을 가진 그래픽 게체를 screendraw클래스에 설정해줌
		g.drawImage(screenImage, 0, 0, this);
		//위 설정으로 화면에 그림을 그려줌
	}
	
	//Graphics g: 위에서 따로 import해준 그래픽모듈로 현재 g라는 이름의 객체로 사용되어지고 있다. 따라서 paint(Graphics g)에서는 "g.~~"으로 그래픽게체를 출력한다면 일관된 설정값을 가지게 된다.
	
	public void screenDraw(Graphics g) {
		//실질적으로 사진을 출력해주는 클래스이다.
		g.drawImage(introBackground, 0, 0, null);
		//위에 private로 저장해준 이미지파일 introbackground를 paint의 그래픽설정으로 출력한다. 메게변수는 (사진객체이름, x축 위치, y축위치, image observer(지금은 모르셔도 됩니다.))
		this.repaint();
		//이미지객체를 지속적으로 그려줌으로서 이미지가 계속 보이도록 해줍니다. 
		
	}

}

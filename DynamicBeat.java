package game;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main2.class.getResource("../images/EXITbotton2.png"));
	private ImageIcon exitButtonbasicImage = new ImageIcon(Main2.class.getResource("../images/EXITbotton1.png"));
	
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main2.class.getResource("../images/start2.png"));
	private ImageIcon startButtonbasicImage = new ImageIcon(Main2.class.getResource("../images/start1.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main2.class.getResource("../images/exit2.png"));
	private ImageIcon quitButtonbasicImage = new ImageIcon(Main2.class.getResource("../images/exit1.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main2.class.getResource("../images/left2.png"));
	private ImageIcon leftButtonbasicImage = new ImageIcon(Main2.class.getResource("../images/left1.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main2.class.getResource("../images/right2.png"));
	private ImageIcon rightButtonbasicImage = new ImageIcon(Main2.class.getResource("../images/right.png"));
	
	private ImageIcon easyEnteredImage = new ImageIcon(Main2.class.getResource("../images/easy2.png"));
	private ImageIcon easybasicImage = new ImageIcon(Main2.class.getResource("../images/easy.png"));
	private ImageIcon hardEnteredImage = new ImageIcon(Main2.class.getResource("../images/HARD2.png"));
	private ImageIcon hardbasicImage = new ImageIcon(Main2.class.getResource("../images/HARD.png"));
	
	private ImageIcon backEnteredImage = new ImageIcon(Main2.class.getResource("../images/back2.png"));
	private ImageIcon backbasicImage = new ImageIcon(Main2.class.getResource("../images/back.png"));
	
	private Image background = new ImageIcon(Main2.class.getResource("../images/tom_clancys_ghost_recon_wildlands_season_pass-wallpaper-1280x720.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main2.class.getResource("../images/menubar.png")));
	
	
	private JButton exitButton = new JButton(exitButtonbasicImage);
	private JButton startButton = new JButton(startButtonbasicImage);
	private JButton quitButton = new JButton(quitButtonbasicImage);
	private JButton leftButton = new JButton(leftButtonbasicImage);
	private JButton rightButton = new JButton(rightButtonbasicImage);
	private JButton easyButton = new JButton(easybasicImage);
	private JButton hardButton = new JButton(hardbasicImage);
	private JButton backButton = new JButton(backbasicImage);
	
	private int mouseX, mouseY;
	
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	private Image titleImage;
	private Image selectedImage;
	private Music selectedMusic;
	private int nowSelected=0;
	private Music introMusic = new Music("Sogno di Volare.mp3",true);
	
	public static Game game;
	
	public DynamicBeat(){
		trackList.add(new Track("HALO.png","halo_wars_2_int.jpg","halo_wars_2_BG.jpg","Freefall_halo.mp3","Freefall_halo.mp3","Freefall"));
		trackList.add(new Track("MASS EFFECT.png","mass_effect_int.jpg","mass_effect_BG.jpg","Elation_mass.mp3","Elation_mass.mp3","Elation"));
		trackList.add(new Track("HIT MAN.png","hitman_int.jpg","hitman_BG.jpg","CharlieClouser_hit.mp3","CharlieClouser_hit.mp3","CharlieClouser"));
		setUndecorated(true);
		setTitle("Dynamic Beat");
		setSize(Main2.SCREEN_WIDTH, Main2.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0,0,0,0));
		setLayout(null);
		
		addKeyListener(new KeyListener());
		
		introMusic.start();
		
		exitButton.setBounds(1245,0,30,30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
				exitButton.setIcon(exitButtonEnteredImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("SE.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				exitButton.setIcon(exitButtonbasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.exit(0);
			}
		});
		add(exitButton);
		
		startButton.setBounds(40,200,400,100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("SE.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				startButton.setIcon(startButtonbasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonEnteredMusic = new Music("SE.mp3",false);
				buttonEnteredMusic.start();
				introMusic.close();
				enterMain();
			}
		});
		add(startButton);
		
		quitButton.setBounds(40,330,400,100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("SE.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				quitButton.setIcon(quitButtonbasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				System.exit(0);
			}
		});
		add(quitButton);
		
		leftButton.setVisible(false);
		leftButton.setBounds(140,310,60,60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("SE.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				leftButton.setIcon(leftButtonbasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonEnteredMusic = new Music("SE.mp3",false);
				buttonEnteredMusic.start();
				selectLeft();
			}
		});
		add(leftButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080,310,60,60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				rightButton.setIcon(rightButtonEnteredImage);
				Music buttonEnteredMusic = new Music("SE.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				rightButton.setIcon(rightButtonbasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonEnteredMusic = new Music("SE.mp3",false);
				buttonEnteredMusic.start();
				selectRight();
			}
		});
		add(rightButton);
		
		backButton.setVisible(false);
		easyButton.setVisible(false);
		easyButton.setBounds(357,580,250,67);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				easyButton.setIcon(easyEnteredImage);
				Music buttonEnteredMusic = new Music("SE.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				easyButton.setIcon(easybasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonEnteredMusic = new Music("SE.mp3",false);
				buttonEnteredMusic.start();
				gameStart(nowSelected,"Easy");
			}
		});
		add(easyButton);
		
		hardButton.setVisible(false);
		hardButton.setBounds(655,580,250,67);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				hardButton.setIcon(hardEnteredImage);
				Music buttonEnteredMusic = new Music("SE.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				hardButton.setIcon(hardbasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonEnteredMusic = new Music("SE.mp3",false);
				buttonEnteredMusic.start();
				gameStart(nowSelected,"Hard");
			}
		});
		add(hardButton);
		
		backButton.setVisible(false);
		backButton.setBounds(50,50,250,67);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent e){
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				backButton.setIcon(backEnteredImage);
				Music buttonEnteredMusic = new Music("SE.mp3",false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e){
				backButton.setIcon(backbasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Music buttonEnteredMusic = new Music("SE.mp3",false);
				buttonEnteredMusic.start();
				backMain();
			}
		});
		add(backButton);
		
		menuBar.setBounds(0,0,1280,30);
		menuBar.addMouseListener(new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
			mouseX=e.getX();
			mouseY=e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter(){
			@Override
			public void mouseDragged(MouseEvent e){
				int x= e.getXOnScreen();
				int y= e.getYOnScreen();
				setLocation(x-mouseX, y-mouseY);
			}
		});
		add(menuBar);
		
	}
	
	public void paint(Graphics g){
		screenImage = createImage(Main2.SCREEN_WIDTH, Main2.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}
	
	public void screenDraw(Graphics2D g){
		g.drawImage(background, 0, 0, null);
		if(isMainScreen){
			g.drawImage(selectedImage, 450, 250, null);
			g.drawImage(titleImage,  340,  70, null);
		}
		if(isGameScreen){
			game.screenDraw(g);
		}
		paintComponents(g);
		try{
			Thread.sleep(5);
		} catch(Exception e){
			e.printStackTrace();		
		}
		this.repaint();
	}
	
	public void selectTrack(int nowSelected){
		if(selectedMusic != null){
			selectedMusic.close();
		}
			titleImage = new ImageIcon(Main2.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
			selectedImage = new ImageIcon(Main2.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
			
			selectedMusic =  new Music(trackList.get(nowSelected).getStartMusic(),true);
			selectedMusic.start();
	}
	
	public void selectLeft(){
		if(nowSelected == 0){
			nowSelected = trackList.size()-1;
		}
		else{
			nowSelected--;
		}
		selectTrack(nowSelected);
	}
	
	public void selectRight(){
		if(nowSelected == trackList.size()-1){
			nowSelected = 0;
		}
		else{
			nowSelected++;
		}
		selectTrack(nowSelected);
	}

	public void gameStart(int nowselected, String difficulty){
		if (selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main2.class.getResource("../images/" + trackList.get(nowselected).getGameImage())).getImage();
		backButton.setVisible(true);
		isGameScreen = true;
		game = new Game(trackList.get(nowSelected).gettitle_name(),difficulty,trackList.get(nowselected).getGameMusic());
		game.start();
		setFocusable(true);
	}
	
	public void backMain(){
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		background = new ImageIcon(Main2.class.getResource("../images/horizon_zero_dawn_a_post_apocalyptic_land_ruled_by_machines-wallpaper-1280x720.jpg")).getImage();
		selectTrack(nowSelected);
		isGameScreen = false;
		game.close();
		
	}
	public void enterMain(){
		startButton.setVisible(false);
		background = new ImageIcon(Main2.class.getResource("../images/horizon_zero_dawn_a_post_apocalyptic_land_ruled_by_machines-wallpaper-1280x720.jpg")).getImage();
		isMainScreen = true;
		quitButton.setVisible(false);
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		introMusic.close();
		selectTrack(0);
		
	}
}

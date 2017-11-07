package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{
	private Image judgementLineImage = new ImageIcon(Main2.class.getResource("../images/judgement.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main2.class.getResource("../images/gameinfo.png")).getImage();
	private Image barImage = new ImageIcon(Main2.class.getResource("../images/bar.png")).getImage();
	private Image noteLineSImage = new ImageIcon(Main2.class.getResource("../images/noteLine.png")).getImage();
	private Image noteLineDImage = new ImageIcon(Main2.class.getResource("../images/noteLine.png")).getImage();
	private Image noteLineFImage = new ImageIcon(Main2.class.getResource("../images/noteLine.png")).getImage();
	private Image noteLineSpace1Image = new ImageIcon(Main2.class.getResource("../images/noteLine.png")).getImage();
	private Image noteLineSpace2Image = new ImageIcon(Main2.class.getResource("../images/noteLine.png")).getImage();
	private Image noteLineJImage = new ImageIcon(Main2.class.getResource("../images/noteLine.png")).getImage();
	private Image noteLineKImage = new ImageIcon(Main2.class.getResource("../images/noteLine.png")).getImage();
	private Image noteLineLImage = new ImageIcon(Main2.class.getResource("../images/noteLine.png")).getImage();
	//private Image blueFlareImage = new ImageIcon(Main2.class.getResource("../images/images.jpg")).getImage();
	
	private String title_name;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String title_name, String difficulty, String musicTitle){
		this.title_name = title_name;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle,false);
	}
	
	public void screenDraw(Graphics2D g){
		g.drawImage(noteLineSImage,224,30,null);
		g.drawImage(noteLineDImage,328,30,null);
		g.drawImage(noteLineFImage,432,30,null);
		g.drawImage(noteLineSpace1Image,536,30,null);
		g.drawImage(noteLineSpace2Image,740,30,null);
		g.drawImage(noteLineJImage,844,30,null);
		g.drawImage(noteLineKImage,948,30,null);
		g.drawImage(noteLineLImage,1052,30,null);
		g.drawImage(barImage, 0, 228, null);
		g.drawImage(barImage, 0, 332, null);
		g.drawImage(barImage, 0, 436, null);
		g.drawImage(barImage, 0, 540, null);
		g.drawImage(barImage, 0, 640, null);
		g.drawImage(barImage, 0, 744, null);
		g.drawImage(barImage, 0, 848, null);
		g.drawImage(barImage, 0, 952, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		for(int i = 0;i<noteList.size(); i++){
			Note note = noteList.get(i);
			if(!note.isproceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDraw(g);
			}
		}
		g.setColor(Color.black);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial",Font.BOLD,30));
		g.setColor(Color.DARK_GRAY);
		g.drawString(title_name,20,702);
		g.drawString(difficulty,1190,702);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setFont(new Font("Elephant",Font.BOLD,30));
		g.drawString("000000",565,702);
		//g.drawImage(blueFlareImage, 320, 370, null);
	}
	
	public void pressS(){
		judge("S");
		noteLineSImage = new ImageIcon(Main2.class.getResource("../images/bar2.png")).getImage();
		new Music("SE.mp3",false).start();
		
	}
	public void releaseS(){
		noteLineSImage = new ImageIcon(Main2.class.getResource("../images/noteLine.png")).getImage();
		
	}
	public void pressD(){
		judge("D");
		noteLineDImage = new ImageIcon(Main2.class.getResource("../images/bar2.png")).getImage();
		new Music("SE.mp3",false).start();
		
	}
	public void releaseD(){
		noteLineDImage = new ImageIcon(Main2.class.getResource("../images/noteLine.png")).getImage();
		
	}
	public void pressF(){
		judge("F");
		noteLineFImage = new ImageIcon(Main2.class.getResource("../images/bar2.png")).getImage();
		new Music("SE.mp3",false).start();
		
	}
	public void releaseF(){
		noteLineFImage = new ImageIcon(Main2.class.getResource("../images/noteLine.png")).getImage();
		
	}
	public void pressSpace(){
		judge("Space");
		noteLineSpace1Image = new ImageIcon(Main2.class.getResource("../images/bar2.png")).getImage();
		noteLineSpace2Image = new ImageIcon(Main2.class.getResource("../images/bar2.png")).getImage();
		
	}
	public void releaseSpace(){
		noteLineSpace1Image = new ImageIcon(Main2.class.getResource("../images/noteLine.png")).getImage();
		noteLineSpace2Image = new ImageIcon(Main2.class.getResource("../images/noteLine.png")).getImage();
		new Music("SE.mp3",false).start();
	}
	public void pressJ(){
		judge("J");
		noteLineJImage = new ImageIcon(Main2.class.getResource("../images/bar2.png")).getImage();
		
	}
	public void releaseJ(){
		noteLineJImage = new ImageIcon(Main2.class.getResource("../images/noteLine.png")).getImage();
		new Music("SE.mp3",false).start();
		
	}
	public void pressK(){
		judge("K");
		noteLineKImage = new ImageIcon(Main2.class.getResource("../images/bar2.png")).getImage();
		
	}
	public void releaseK(){
		noteLineKImage = new ImageIcon(Main2.class.getResource("../images/noteLine.png")).getImage();
		new Music("SE.mp3",false).start();
		
	}
	public void pressL(){
		judge("L");
		noteLineLImage = new ImageIcon(Main2.class.getResource("../images/bar2.png")).getImage();
		
	}
	public void releaseL(){
		noteLineLImage = new ImageIcon(Main2.class.getResource("../images/noteLine.png")).getImage();
		new Music("SE.mp3",false).start();
		
	}
	@Override
	public void run(){
		dropNotes(this.title_name);
	}
	
	public void close(){
		gameMusic.close();this.interrupt();
	}
	
	public void dropNotes(String titleName){
		Beat[] beats = null;{
				if(title_name.equals("Freefall")  && difficulty.equals("Easy")){
					int startTime = 4460-Main2.REACH_TIME*1000;
					int gap = 125;
					beats = new Beat[]{
							new Beat(startTime+gap*6,"Space"),
							new Beat(startTime+gap*8,"S"),
							new Beat(startTime+gap*10,"D"),
							new Beat(startTime+gap*12,"F"),
							new Beat(startTime+gap*14,"Space"),
							new Beat(startTime+gap*16,"J"),
							new Beat(startTime+gap*18,"K"),
							new Beat(startTime+gap*20,"L"),
							new Beat(startTime+gap*22,"D"),
							new Beat(startTime+gap*24,"Space"),
							new Beat(startTime+gap*26,"K"),
							new Beat(startTime+gap*28,"F"),
							new Beat(startTime+gap*30,"L"),
							new Beat(startTime+gap*32,"J"),
							new Beat(startTime+gap*34,"Space"),
							new Beat(startTime+gap*36,"Space"),
							new Beat(startTime+gap*38,"Space"),
							new Beat(startTime+gap*40,"D"),
							new Beat(startTime+gap*42,"Space"),
							new Beat(startTime+gap*44,"Space"),
							new Beat(startTime+gap*46,"Space"),
							new Beat(startTime+gap*48,"Space"),
							new Beat(startTime+gap*50,"Space"),
							new Beat(startTime+gap*52,"Space"),
							new Beat(startTime+gap*54,"Space"),
							new Beat(startTime+gap*56,"Space"),
							new Beat(startTime+gap*58,"Space"),
							new Beat(startTime+gap*60,"Space"),
							new Beat(startTime+gap*62,"Space"),
							new Beat(startTime+gap*64,"Space"),
					};
					}
				else if(title_name.equals("Freefall")&& difficulty.equals("Hard")){
					int startTime = 1000;
					int gap =125;
					beats = new Beat[]{
							new Beat(startTime,"Space"),
							new Beat(startTime+gap*6,"Space"),
							new Beat(startTime+gap*8,"S"),
							new Beat(startTime+gap*10,"D"),
							new Beat(startTime+gap*12,"F"),
							new Beat(startTime+gap*14,"Space"),
							new Beat(startTime+gap*16,"J"),
							new Beat(startTime+gap*18,"K"),
							new Beat(startTime+gap*20,"L"),
							new Beat(startTime+gap*22,"D"),
							new Beat(startTime+gap*24,"Space"),
							new Beat(startTime+gap*26,"K"),
							new Beat(startTime+gap*28,"F"),
							new Beat(startTime+gap*30,"L"),
							new Beat(startTime+gap*32,"J"),
							new Beat(startTime+gap*34,"Space"),
							new Beat(startTime+gap*36,"Space"),
							new Beat(startTime+gap*38,"Space"),
							new Beat(startTime+gap*40,"D"),
							new Beat(startTime+gap*42,"Space"),
							new Beat(startTime+gap*44,"Space"),
							new Beat(startTime+gap*46,"Space"),
							new Beat(startTime+gap*48,"Space"),
							new Beat(startTime+gap*50,"Space"),
							new Beat(startTime+gap*52,"Space"),
							new Beat(startTime+gap*54,"Space"),
							new Beat(startTime+gap*56,"Space"),
							new Beat(startTime+gap*58,"Space"),
							new Beat(startTime+gap*60,"Space"),
							new Beat(startTime+gap*62,"Space"),
							new Beat(startTime+gap*64,"Space"),
					};
				}
				
				else if(title_name.equals("Elation")&& difficulty.equals("Easy")){
					int startTime = 1000;
					int gap = 125;
					beats = new Beat[]{
							new Beat(startTime,"Space"),
							new Beat(startTime+gap*6,"Space"),
							new Beat(startTime+gap*8,"S"),
							new Beat(startTime+gap*10,"D"),
							new Beat(startTime+gap*12,"F"),
							new Beat(startTime+gap*14,"Space"),
							new Beat(startTime+gap*16,"J"),
							new Beat(startTime+gap*18,"K"),
							new Beat(startTime+gap*20,"L"),
							new Beat(startTime+gap*22,"D"),
							new Beat(startTime+gap*24,"Space"),
							new Beat(startTime+gap*26,"K"),
							new Beat(startTime+gap*28,"F"),
							new Beat(startTime+gap*30,"L"),
							new Beat(startTime+gap*32,"J"),
							new Beat(startTime+gap*34,"Space"),
							new Beat(startTime+gap*36,"Space"),
							new Beat(startTime+gap*38,"Space"),
							new Beat(startTime+gap*40,"D"),
							new Beat(startTime+gap*42,"Space"),
							new Beat(startTime+gap*44,"Space"),
							new Beat(startTime+gap*46,"Space"),
							new Beat(startTime+gap*48,"Space"),
							new Beat(startTime+gap*50,"Space"),
							new Beat(startTime+gap*52,"Space"),
							new Beat(startTime+gap*54,"Space"),
							new Beat(startTime+gap*56,"Space"),
							new Beat(startTime+gap*58,"Space"),
							new Beat(startTime+gap*60,"Space"),
							new Beat(startTime+gap*62,"Space"),
							new Beat(startTime+gap*64,"Space"),
					};
				}
				else if(title_name.equals("Elation")&& difficulty.equals("Hard")){
					int startTime = 1000;
					int gap = 125;
					beats = new Beat[]{
							new Beat(startTime,"Space"),
							new Beat(startTime+gap*6,"Space"),
							new Beat(startTime+gap*8,"S"),
							new Beat(startTime+gap*10,"D"),
							new Beat(startTime+gap*12,"F"),
							new Beat(startTime+gap*14,"Space"),
							new Beat(startTime+gap*16,"J"),
							new Beat(startTime+gap*18,"K"),
							new Beat(startTime+gap*20,"L"),
							new Beat(startTime+gap*22,"D"),
							new Beat(startTime+gap*24,"Space"),
							new Beat(startTime+gap*26,"K"),
							new Beat(startTime+gap*28,"F"),
							new Beat(startTime+gap*30,"L"),
							new Beat(startTime+gap*32,"J"),
							new Beat(startTime+gap*34,"Space"),
							new Beat(startTime+gap*36,"Space"),
							new Beat(startTime+gap*38,"Space"),
							new Beat(startTime+gap*40,"D"),
							new Beat(startTime+gap*42,"Space"),
							new Beat(startTime+gap*44,"Space"),
							new Beat(startTime+gap*46,"Space"),
							new Beat(startTime+gap*48,"Space"),
							new Beat(startTime+gap*50,"Space"),
							new Beat(startTime+gap*52,"Space"),
							new Beat(startTime+gap*54,"Space"),
							new Beat(startTime+gap*56,"Space"),
							new Beat(startTime+gap*58,"Space"),
							new Beat(startTime+gap*60,"Space"),
							new Beat(startTime+gap*62,"Space"),
							new Beat(startTime+gap*64,"Space"),
					};
				}
				else if(title_name.equals("CharlieClouser")&& difficulty.equals("Easy")){
					int startTime = 1000;
					int gap = 125;
					beats = new Beat[]{
							new Beat(startTime,"Space"),
							new Beat(startTime+gap*6,"Space"),
							new Beat(startTime+gap*8,"S"),
							new Beat(startTime+gap*10,"D"),
							new Beat(startTime+gap*12,"F"),
							new Beat(startTime+gap*14,"Space"),
							new Beat(startTime+gap*16,"J"),
							new Beat(startTime+gap*18,"K"),
							new Beat(startTime+gap*20,"L"),
							new Beat(startTime+gap*22,"D"),
							new Beat(startTime+gap*24,"Space"),
							new Beat(startTime+gap*26,"K"),
							new Beat(startTime+gap*28,"F"),
							new Beat(startTime+gap*30,"L"),
							new Beat(startTime+gap*32,"J"),
							new Beat(startTime+gap*34,"Space"),
							new Beat(startTime+gap*36,"Space"),
							new Beat(startTime+gap*38,"Space"),
							new Beat(startTime+gap*40,"D"),
							new Beat(startTime+gap*42,"Space"),
							new Beat(startTime+gap*44,"Space"),
							new Beat(startTime+gap*46,"Space"),
							new Beat(startTime+gap*48,"Space"),
							new Beat(startTime+gap*50,"Space"),
							new Beat(startTime+gap*52,"Space"),
							new Beat(startTime+gap*54,"Space"),
							new Beat(startTime+gap*56,"Space"),
							new Beat(startTime+gap*58,"Space"),
							new Beat(startTime+gap*60,"Space"),
							new Beat(startTime+gap*62,"Space"),
							new Beat(startTime+gap*64,"Space"),
					};
					}
				else if(title_name.equals("CharlieClouser")&& difficulty.equals("Hard")){
					int startTime = 1000;
					int gap = 125;
					beats = new Beat[]{
							new Beat(startTime,"Space"),
							new Beat(startTime+gap*6,"Space"),
							new Beat(startTime+gap*8,"S"),
							new Beat(startTime+gap*10,"D"),
							new Beat(startTime+gap*12,"F"),
							new Beat(startTime+gap*14,"Space"),
							new Beat(startTime+gap*16,"J"),
							new Beat(startTime+gap*18,"K"),
							new Beat(startTime+gap*20,"L"),
							new Beat(startTime+gap*22,"D"),
							new Beat(startTime+gap*24,"Space"),
							new Beat(startTime+gap*26,"K"),
							new Beat(startTime+gap*28,"F"),
							new Beat(startTime+gap*30,"L"),
							new Beat(startTime+gap*32,"J"),
							new Beat(startTime+gap*34,"Space"),
							new Beat(startTime+gap*36,"Space"),
							new Beat(startTime+gap*38,"Space"),
							new Beat(startTime+gap*40,"D"),
							new Beat(startTime+gap*42,"Space"),
							new Beat(startTime+gap*44,"Space"),
							new Beat(startTime+gap*46,"Space"),
							new Beat(startTime+gap*48,"Space"),
							new Beat(startTime+gap*50,"Space"),
							new Beat(startTime+gap*52,"Space"),
							new Beat(startTime+gap*54,"Space"),
							new Beat(startTime+gap*56,"Space"),
							new Beat(startTime+gap*58,"Space"),
							new Beat(startTime+gap*60,"Space"),
							new Beat(startTime+gap*62,"Space"),
							new Beat(startTime+gap*64,"Space"),
					};
					}
				}
				int i = 0;
				gameMusic.start();
				while(i<beats.length && !isInterrupted()){
					boolean dropped = false;
					if(beats[i].getTime() <= gameMusic.getTime()){
						Note note = new Note(beats[i].getNoteName());
						note.start();
						noteList.add(note);
						i++;
						dropped = true;
					}
					if(!dropped){
						try{
							Thread.sleep(5);
							
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}
	}
	public void judge (String input) {
		for(int i = 0; i<noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				note.judge();
				break;
			}
		}
	}
	
}

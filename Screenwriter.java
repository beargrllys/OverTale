package pptprogram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Screenwriter extends JFrame implements ActionListener, ItemListener, 
KeyListener{
	
	JFileChooser chooser;
	JColorChooser colorchooser;
	JButton butt;
	JTextField tf;
	
	 Screenwriter(){
		
		basic();
		
		setTitle("Dynamic Presentation");
		setSize(ProjectMain.WIDTH,ProjectMain.HEIGTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//.getContentPane().add(this);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setVisible(true);
		
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, ProjectMain.WIDTH, ProjectMain.HEIGTH);
		
		
	}
	
	public void basic() {
		
		butt = new JButton("확인");
		butt.addActionListener(this);
		
		JPanel menubar = new JPanel();
		menubar.setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		//BorderLayout이 무엇인가?
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("파일");
		JMenu draw = new JMenu("도형");
		JMenu animation = new JMenu("애니메이션");
		
		
		JMenuItem menu1 = new JMenuItem("새 프로젝트");
		JMenuItem menu2 = new JMenuItem("파일 열기");
		JMenuItem menu3 = new JMenuItem("파일 저장");
		JMenuItem menu4 = new JMenuItem("내보내기");
		JMenuItem menu5 = new JMenuItem("가져오기");
		JMenuItem menu6 = new JMenuItem("그리기");
		JMenuItem menu7 = new JMenuItem("도형 움직이기");
		JMenuItem menu8 = new JMenuItem("도형 변형");
		JMenuItem menu9 = new JMenuItem("도형 회전");
		
		menu1.addActionListener(this);
		menu2.addActionListener(this);
		menu3.addActionListener(this);
		menu4.addActionListener(this);
		menu5.addActionListener(this);
		menu6.addActionListener(this);
		menu7.addActionListener(this);
		menu8.addActionListener(this);
		menu9.addActionListener(this);
		
		menu.add(file);
		file.add(menu1);
		file.add(menu2);
		file.add(menu3);
		file.add(menu4);
		file.add(menu5);
		
		menu.add(draw);
		draw.add(menu6);
		
		menu.add(animation);
		animation.add(menu7);
		animation.add(menu8);
		animation.add(menu9);
		
		menubar.add("Center", menu);
		
		p1.add("North", menubar);
		
		add("North",p1);
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String gac = e.getActionCommand();
		
		if((JButton)obj == butt) {
			String text = tf.getText();
			//panel.data = text
			tf.setText("");
		}
		
		if(gac.equals("새 프로젝트")) {
			imageLabel.setIcon(null);
		}
		
	}
	

}

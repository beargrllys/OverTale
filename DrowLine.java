package pptprogram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DrowLine extends JFrame implements ActionListener, ItemListener,
		KeyListener {

	JFileChooser chooser;
	JColorChooser colorchooser;
	paint2 panel = new paint2();
	JLabel imageLabel = new JLabel();
	JButton butt;
	JTextField tf;

	DrowLine() {

		init();

		setTitle("exam");
		setSize(500, 500); // 창 크기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료버틍 활성화
		setVisible(true); // 화면에 보이기
		// 스크린 사이즈 가져와 screenSize에 저장
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// 프레임을 화면 중간에서 열리게 함
		setLocation((screenSize.width - 500) / 2, (screenSize.height - 500) / 2);

	}

	public static void main(String[] args) {
		// JFrame.setDefaultLookAndFeelDecorated(true);
		DrowLine drow = new DrowLine();
	}

	public void init() {


		butt = new JButton("확인");
		butt.addActionListener(this);

		tf = new JTextField(20);
		tf.addKeyListener(this);

		JPanel base = new JPanel();
		base.setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		JMenuBar menu = new JMenuBar();
		JMenu file = new JMenu("파일");
		JMenu draw = new JMenu("그리기");
		JMenu color = new JMenu("색상");

		JMenuItem menu1 = new JMenuItem("새그림");
		JMenuItem menu2 = new JMenuItem("열기");
		JMenuItem menu3 = new JMenuItem("저장");
		JMenuItem menu4 = new JMenuItem("종료");
		JMenuItem menu5 = new JMenuItem("사각형");
		JMenuItem menu6 = new JMenuItem("타원");
		JMenuItem menu7 = new JMenuItem("둥근사각형");
		JMenuItem menu8 = new JMenuItem("직선");
		JMenuItem menu9 = new JMenuItem("윤각선");
		JMenuItem menu10 = new JMenuItem("채우기");

		menu1.addActionListener(this);
		menu2.addActionListener(this);
		menu3.addActionListener(this);
		menu4.addActionListener(this);
		menu5.addActionListener(this);
		menu6.addActionListener(this);
		menu7.addActionListener(this);
		menu8.addActionListener(this);
		menu9.addActionListener(this);
		menu10.addActionListener(this);


		menu.add(file);
		file.add(menu1);
		file.add(menu2);
		file.add(menu3);
		file.add(menu4);

		menu.add(draw);
		draw.add(menu5);
		draw.add(menu6);
		draw.add(menu7);
		draw.add(menu8);

		menu.add(color);
		color.add(menu9);
		color.add(menu10);

		p1.add("Center", menu);
		p1.add("East", tf);

		base.add("North", p1);

		panel.add(imageLabel);
		add("North", base);
		add("Center", panel);
		add("South",butt);
		butt.setVisible(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) { // 액션이벤트
		Object obj = e.getSource();
		String gac = e.getActionCommand();


		/*if ((JButton) obj == butt) {
			String text = tf.getText();
			panel.data=text;
			tf.setText("");


		}*/



		if (gac.equals("새그림")) {

			imageLabel.setIcon(null);
			panel.vf.removeAllElements();
			panel.vs.removeAllElements();
			panel.text.removeAllElements();
			panel.text11.removeAllElements();
			panel.select.removeAllElements();
			panel.linetype.removeAllElements();
			panel.colorchois.removeAllElements();
			panel.repaint();


		} else if (gac.equals("열기")) {
			chooser = new JFileChooser();

			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"JPG & GIF Images", "jpg", "gif");
			chooser.setFileFilter(filter);
			int ret = chooser.showOpenDialog(null);
			if (ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			String filePath = chooser.getSelectedFile().getPath();
			imageLabel.setIcon(new ImageIcon(filePath));
			pack();

		} else if (gac.equals("저장")) {
			JOptionPane.showMessageDialog(this, "저장되었습니다.",
					"저장", JOptionPane.INFORMATION_MESSAGE);

		} else if (gac.equals("종료")) {
			System.exit(0);

		} else if (gac.equals("사각형")) {
			panel.chois ="사각형";

		} else if (gac.equals("타원")) {
			panel.chois ="타원";

		} else if (gac.equals("둥근사각형")) {
			panel.chois ="둥근사각형";

		} else if (gac.equals("직선")) {
			panel.chois ="직선";

		} else if (gac.equals("윤각선")) {

			panel.type="윤각선";
			colorchooser = new JColorChooser();

			Color selectedColor = colorchooser.showDialog(null, "Color",
					Color.YELLOW);
			panel.color = selectedColor;

		} else if (gac.equals("채우기")) {
			panel.type="채우기";
			Color selectedColor = colorchooser.showDialog(null, "Color",
					Color.YELLOW);
			panel.color = selectedColor;

		}

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) { // 콤보박스 상태가 변할때마다 호출됨
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
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10) { // 엔터가 눌리면
			String text = tf.getText();
			panel.data=text;
			tf.setText("");
			panel.textcheck = true;
		}
	}


}

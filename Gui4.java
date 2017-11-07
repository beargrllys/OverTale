package pptprogram;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Gui4 extends JFrame{
	JLabel label = new JLabel("마우스 드래그 해보자");
	JTextField jtextfiled = new JTextField();
	
	public Gui4() {
		add(label, "North");
		add(jtextfiled,"South");
		
		setSize(300,400);
		setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				jtextfiled.setText("("+e.getX()+","+e.getY() +")");
				
			}
		});
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				jtextfiled.setText("마우스 안쪽?");
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				jtextfiled.setText("마우스 바깥쪽?");
				
			}
			
		});
		
	}
	public static void main (String[] args) {
		new Gui4();
	}

}

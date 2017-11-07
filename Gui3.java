package pptprogram;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Gui3 extends JFrame implements MouseMotionListener, MouseListener{
	
	JLabel label = new JLabel("마우스를 드래그 해보자");
	JTextField jtextfiled = new JTextField();
	
	public Gui3() {
		this.add(label,"North");
		this.add(jtextfiled, "South");
		
		this.setSize(300,400);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
		
	}
	
	public static void main(String[] args) {
		new Gui3();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		jtextfiled.setText("("+ e.getX() + ","+ e.getY()+ ")");
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {}
	
	@Override
	public void mouseClicked(MouseEvent e) {}
	
	@Override
	public void mousePressed(MouseEvent e) {}
	
	@Override
	public void mouseReleased(MouseEvent e) {}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		jtextfiled.setText("마우스 안쪽");
	}
	@Override
	public void mouseExited(MouseEvent e) {
		jtextfiled.setText("마우스 바깥쪽");
	}
	

}

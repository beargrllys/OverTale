package pptprogram;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Gui1 extends Frame implements ActionListener{
	
	JButton bnt1 = new JButton("클릭1");
	JButton bnt2 = new JButton("클릭2");
	
	public Gui1()
	{
		this.setLayout(new FlowLayout());
		
		this.add(bnt1);
		this.add(bnt2);
		
		this.setSize(300, 200);
		this.setVisible(true);
		
		bnt1.addActionListener(this);
		bnt2.addActionListener(this);
	}
	
	
	public static void main(String[] args) {
		new Gui1();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(bnt1)) {
			JOptionPane.showMessageDialog(this, "1번 버튼 눌렀네");
		}
		else {
			JOptionPane.showMessageDialog(this, "2번 버튼 눌렀네");
		}
		
	}

}

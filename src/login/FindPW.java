package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindPW extends JFrame{
	
	private MainProcess main;
	private JTextField userText;
	private JTextField userText1;
	private JTextField userText2;
	private JButton btnInit;
	private JButton btnin;
	private boolean b, b1, b2;
	private int k;
	
	private String[][] a = new String[1000][4];

	public static void main(String[] args) {
		new FindPW();
	}
	
	public FindPW() {
		setTitle("Find PW");
		setSize(260, 200);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		placeSignPanel(panel);
		add(panel);
		setVisible(true);
	}
	
	public void placeSignPanel(JPanel panel) {
		panel.setLayout(null);
		JLabel userLabel1 = new JLabel("ID");
		userLabel1.setBounds(10, 10, 60, 25);
		panel.add(userLabel1);
		
		JLabel userLabel2 = new JLabel("이름");
		userLabel2.setBounds(10, 50, 60, 25);
		panel.add(userLabel2);
		
		JLabel userLabel3 = new JLabel("핸드폰");
		userLabel3.setBounds(10, 90, 60, 25);
		panel.add(userLabel3);
		
		userText = new JTextField(20);
		userText.setBounds(100, 10, 130, 25);
		panel.add(userText);
		
		userText1 = new JTextField(20);
		userText1.setBounds(100, 50, 130, 25);
		panel.add(userText1);
		
		userText2 = new JTextField(20);
		userText2.setBounds(100, 90, 130, 25);
		panel.add(userText2);
		
		JButton btnInit = new JButton("확인");
		btnInit.setBounds(130, 120, 100, 25);
		panel.add(btnInit);
		btnInit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isidcheck() && !userText.getText().equals("")) {
					if(isfindcheck() && !userText1.getText().equals("")) {
						if(ispc() && !userText2.getText().equals("")) {
							JOptionPane.showMessageDialog(null, a[k][1]);
							main.showlogin();
						}
						else {
							JOptionPane.showMessageDialog(null, "Check your phone number!\n if you don't write '-' please write that.");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Check your name!\n we don't have your name.");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Check your ID!\n we don't have your ID.");
				}
			}
		});
		
		btnin = new JButton("돌아가기");
		btnin.setBounds(10, 120, 100, 25);
		panel.add(btnin);
		btnin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				main.showlogin();
			}
		});
	}
	
	public boolean isidcheck() {
		a = new test2().a1();
		for(int i = 0; i < 1000; i++) {
			if(userText.getText().equals(a[i][0])) {
				k = i;
				b = true;
			}
		}
		return b;
	}
	
	public boolean isfindcheck() {
		a = new test2().a1();
		if(userText1.getText().equals(a[k][2])) {
			b1 = true;
		}
		return b1;
	}
	
	public boolean ispc() {
		a = new test2().a1();
		if(userText2.getText().equals(a[k][3])) {
			b2 = true;
		}
		return b2;
	}	
	
	public void setMain(MainProcess main) {
		this.main = main;
	}

}

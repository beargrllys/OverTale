package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FindID extends JFrame{
	
	private MainProcess main;
	private JTextField userText;
	private JTextField userText1;
	private JButton btnInit;
	private JButton btnin;
	private boolean b, b1;
	private int k;
	
	private String[][] a = new String[1000][4];

	public static void main(String[] args) {
		new FindID();
	}
	
	public FindID() {
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
		JLabel userLabel1 = new JLabel("이름");
		userLabel1.setBounds(10, 10, 60, 25);
		panel.add(userLabel1);
		
		JLabel userLabel2 = new JLabel("핸드폰");
		userLabel2.setBounds(10, 50, 60, 25);
		panel.add(userLabel2);
		
		userText = new JTextField(20);
		userText.setBounds(100, 10, 130, 25);
		panel.add(userText);
		
		userText1 = new JTextField(20);
		userText1.setBounds(100, 50, 130, 25);
		panel.add(userText1);
		
		JButton btnInit = new JButton("확인");
		btnInit.setBounds(130, 80, 100, 25);
		panel.add(btnInit);
		btnInit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isfindcheck() && !userText.getText().equals("")) {
					if(ispc() && !userText1.getText().equals("")) {
						JOptionPane.showMessageDialog(null, a[k][0]);
						main.showLogin();
					}
					else {
						JOptionPane.showMessageDialog(null, "Check your phone number!\n if you don't write '-' please write that.");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Check your name!\n we don't have your name.");
				}
			}
		});
		
		btnin = new JButton("돌아가기");
		btnin.setBounds(10, 80, 100, 25);
		panel.add(btnin);
		btnin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				main.showLogin();
			}
		});
	}
	
	public boolean isfindcheck() {
		a = new test2().a1();
		for(int i = 0; i < 1000; i++) {
			if(userText.getText().equals(a[i][2])) {
				k = i;
				b = true;
			}
		}
		return b;
	}
	
	public boolean ispc() {
		a = new test2().a1();
		if(userText1.getText().equals(a[k][3])) {
			b1 = true;
		}
		return b1;
	}
	
	public void setMain(MainProcess main) {
		this.main = main;
	}

}

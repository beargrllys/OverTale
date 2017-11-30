package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp extends JFrame {

	private MainProcess main;
	private boolean bIDCheck;
	private boolean bPWCheck;
	private JButton btnInit;
	private JPasswordField passText;
	private JPasswordField passText1;
	private JTextField userText;
	private JTextField userText1;
	private JTextField userText2;

	private String[][] a = new String[1000][4];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignUp();

	}

	public SignUp() {
		setTitle("Sign Up");
		setSize(360, 400);
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
		JLabel userLabel = new JLabel("아이디");
		userLabel.setBounds(10, 10, 60, 25);
		panel.add(userLabel);

		JLabel passLabel = new JLabel("비밀번호");
		passLabel.setBounds(10, 50, 60, 25);
		panel.add(passLabel);

		JLabel passLabel1 = new JLabel("비밀번호재입력");
		passLabel1.setBounds(10, 90, 100, 25);
		panel.add(passLabel1);

		JLabel userLabel1 = new JLabel("이름");
		userLabel1.setBounds(10, 130, 60, 25);
		panel.add(userLabel1);

		JLabel userLabel2 = new JLabel("핸드폰");
		userLabel2.setBounds(10, 170, 60, 25);
		panel.add(userLabel2);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 130, 25);
		panel.add(userText);

		passText = new JPasswordField(20);
		passText.setBounds(100, 50, 130, 25);
		panel.add(passText);

		passText1 = new JPasswordField(20);
		passText1.setBounds(100, 90, 130, 25);
		panel.add(passText1);

		userText1 = new JTextField(20);
		userText1.setBounds(100, 130, 130, 25);
		panel.add(userText1);

		userText2 = new JTextField(20);
		userText2.setBounds(100, 170, 130, 25);
		panel.add(userText2);

		btnInit = new JButton("Sign Up");
		btnInit.setBounds(10, 200, 100, 25);
		panel.add(btnInit);
		btnInit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!checkid() && userText.getText().length() != 0) {
					if (checkPW() && new String(passText.getPassword()).length() != 0) {
						new texttest2().f(userText.getText());
						new texttest2().f(new String(passText.getPassword()));
						new texttest2().f(userText1.getText());
						new texttest2().f(userText2.getText());
						main.showLoginView();
					} else {
						JOptionPane.showMessageDialog(null, "check your password.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Check your ID.");
				}
			}
		});

		btnInit = new JButton("중복 확인");
		btnInit.setBounds(240, 10, 100, 25);
		panel.add(btnInit);
		btnInit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bIDCheck = false;
				if (checkid() || userText.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "Check your ID.");
				} else {
					JOptionPane.showMessageDialog(null, "You will use this ID.");
				}
			}
		});
	}

	public void setMain(MainProcess main) {
		this.main = main;
	}

	public boolean checkid() {
		a = new test2().a1();
		for (int i = 0; i < 1000; i++) {
			if (userText.getText().equals(a[i][0])) {
				bIDCheck = true;
			}
		}
		return bIDCheck;
	}

	public boolean checkPW() {
		if (new String(passText.getPassword()).equals(new String(passText1.getPassword()))) {
			bPWCheck = true;
		}
		return bPWCheck;
	}

}

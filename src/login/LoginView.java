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

public class LoginView extends JFrame {
	private MainProcess main;
	private TestFrm testFrm;
	private JButton btnLogin;
	private JButton btnInit;
	private JButton btnFid;
	private JButton btnFpw;
	private JPasswordField passText;
	private JTextField userText;
	private boolean bLoginCheck;

	private String[][] a = new String[1000][4];

	public static void main(String[] args) {
		new LoginView();
	}

	public LoginView() {
		setTitle("login");
		setSize(280, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		placeLoginPanel(panel);
		add(panel);
		setVisible(true);
	}

	public void placeLoginPanel(JPanel panel) {
		panel.setLayout(null);
		JLabel userLabel = new JLabel("User");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		JLabel passLabel = new JLabel("Pass");
		passLabel.setBounds(10, 40, 80, 25);
		panel.add(passLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		passText = new JPasswordField(20);
		passText.setBounds(100, 40, 160, 25);
		panel.add(passText);
		passText.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isLoginCheck();
			}
		});

		btnInit = new JButton("Sign Up");
		btnInit.setBounds(10, 80, 100, 25);
		panel.add(btnInit);
		btnInit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				main.showSignUp();
			}
		});

		btnLogin = new JButton("Login");
		btnLogin.setBounds(160, 80, 100, 25);
		panel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				isLoginCheck();
			}
		});
		
		btnFid = new JButton("Find ID");
		btnFid.setBounds(10, 120, 100, 25);
		panel.add(btnFid);
		btnFid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				main.showFindID();
			}
		});
		
		btnFpw = new JButton("Find PW");
		btnFpw.setBounds(160, 120, 100, 25);
		panel.add(btnFpw);
		btnFpw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				main.showFindPW();
			}
		});
	}

	public void isLoginCheck() {
		int t = 0;
		a = new test2().a1();
		for(int i = 0; i < 100; i++) {
			if (userText.getText().equals(a[i][0]) && new String(passText.getPassword()).equals(a[i][1])) {
				JOptionPane.showMessageDialog(null, "Success");
				bLoginCheck = true;
				// �α��� �����̶�� �Ŵ���â �ٿ��
				if (isLogin()) {
					main.showFrameTest(); // ����â �޼ҵ带 �̿��� â�ٿ��
				}
				t = i;
			}
		}
		if (!userText.getText().equals(a[t][0]) || !new String(passText.getPassword()).equals(a[t][1])){
			JOptionPane.showMessageDialog(null, "Failed");
		}
		passText.setText("");
	}

	// mainProcess�� ����
	public void setMain(MainProcess main) {
		this.main = main;
	}

	public boolean isLogin() {
		return bLoginCheck;
	}
}

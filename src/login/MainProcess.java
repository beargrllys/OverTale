package login;

public class MainProcess {
	LoginView loginView;
	FindID findid;
	FindPW findpw;
	TestFrm testFrm;
	SignUp signUp;

	public static void main(String[] args) {
		MainProcess main = new MainProcess();
		main.loginView = new LoginView();
		main.loginView.setMain(main);
	}

	public void showFrameTest() {
		loginView.dispose();
		this.testFrm = new TestFrm();
	}
	
	public void showSignUp() {
		loginView.dispose();
		MainProcess main = new MainProcess();
		main.signUp = new SignUp();
		main.signUp.setMain(main);
	}
	
	public void showLoginView() {
		signUp.dispose();
		MainProcess main = new MainProcess();
		main.loginView = new LoginView();
		main.loginView.setMain(main);
	}
	
	public void showFindID() {
		loginView.dispose();
		MainProcess main = new MainProcess();
		main.findid = new FindID();
		main.findid.setMain(main);
	}
	
	public void showFindPW() {
		loginView.dispose();
		MainProcess main = new MainProcess();
		main.findpw = new FindPW();
		main.findpw.setMain(main);
	}
	
	public void showLogin() {
		findid.dispose();
		MainProcess main = new MainProcess();
		main.loginView = new LoginView();
		main.loginView.setMain(main);
	}
	
	public void showlogin() {
		findpw.dispose();
		MainProcess main = new MainProcess();
		main.loginView = new LoginView();
		main.loginView.setMain(main);
	}
}
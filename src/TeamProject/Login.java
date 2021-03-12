package TeamProject;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *	������Ʈ Login JFrame
 * @author user
 */
@SuppressWarnings("serial")
public class Login extends JFrame{
	
	private JButton jbtnLogin;
	private JTextField jtfId;
	private JPasswordField jpfPw;
	
	public Login() {
		super("Login");
		
		jbtnLogin = new JButton("Login");
		jtfId = new JTextField("ID");
		jpfPw = new JPasswordField("Pass",4);
		JLabel jlIfm = new JLabel("Ver1.0 Log Information system");
		
		JLabel jlImg = new JLabel();
		URL imageURL = Login.class.getClassLoader().getResource("Imagesist.jpg");
		ImageIcon img = new ImageIcon(imageURL);
		jlImg.setIcon(img);


		
		//������� ���߿� �����ϱ�!!!!!!!!!!!!!!!!!!!!!!!!
//		ImageIcon iiImg = new ImageIcon("c:/dev/group_prj1/Imagesist.jpg");
//		jlImg.setIcon(iiImg);
		
		Font jbtnfont = new Font("�������",Font.BOLD, 30);
		Font loginfont = new Font("�������",Font.PLAIN, 20);
		jbtnLogin.setFont(jbtnfont);
		jtfId.setFont(loginfont);
		jpfPw.setFont(loginfont);
		
		jbtnLogin.setForeground(Color.white);
		jbtnLogin.setBackground(Color.pink);
		getContentPane().setBackground(Color.white);
		
//		TitledBorder tb = new TitledBorder("Login");
		
		setLayout(null);
		setBounds(300, 200, 530, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(jbtnLogin);
		add(jtfId);
		add(jpfPw);
		add(jlImg);
		add(jlIfm);
		
		jtfId.setBounds(70, 150, 380, 50);
		jpfPw.setBounds(70, 210, 380, 50);
		jbtnLogin.setBounds(70, 270, 380, 50);
		jlImg.setBounds(60, 30, 397, 100);
		jlIfm.setBounds(170, 325, 200, 30);
		
		LoginEvt le = new LoginEvt(this);
		jbtnLogin.addActionListener(le);
		
	}
	
	
	public JButton getJbtnLogin() {
		return jbtnLogin;
	}

	public JTextField getJtfId() {
		return jtfId;
	}

	public JPasswordField getJpfPw() {
		return jpfPw;
	}
	
}

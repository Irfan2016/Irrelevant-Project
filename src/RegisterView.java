package com;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class RegisterView extends JFrame {
	public static void main(String[] args) {
		new RegisterView(null).setVisible(true);
	}

	public RegisterView(JFrame parent) {
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("Sign Up");
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				RegisterView.this.cancelBtnClick();
			}
		});

		this.parent = parent;

		title = new JLabel("Sign Up");
		title.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 40));
		title.setBounds(new Rectangle(20, 15, WIDTH - 40, 40));
		this.add(title);

		userName = new JTextField();
		password = new JPasswordField();
		password0 = new JPasswordField();
		firstName = new JTextField();
		lastName = new JTextField();
		telephone = new JTextField();
		birthday = new JTextField();
		city = new JTextField();

		Panel p1 = new Panel();

		p1.setLayout(new GridLayout(8, 2));
		p1.add(new JLabel("UserName: "));
		p1.add(userName);
		p1.add(new JLabel("Password: "));
		p1.add(password);
		p1.add(new JLabel("Confirm: "));
		p1.add(password0);
		p1.add(new JLabel("First Name: "));
		p1.add(firstName);
		p1.add(new JLabel("Last Name: "));
		p1.add(lastName);
		p1.add(new JLabel("Telephone: "));
		p1.add(telephone);
		p1.add(new JLabel("Birthday: "));
		p1.add(birthday);
		p1.add(new JLabel("City: "));
		p1.add(city);

		p1.setBounds(new Rectangle(40, 70, WIDTH - 100, 220));
		this.add(p1);

		cancelBtn = new JButton("Cancel");
		registerBtn = new JButton("Confirm");

		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelBtnClick();
			}
		});

		registerBtn.registerKeyboardAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (registerBtn == e.getSource()) {
					registerBtnClick();
				}
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registerBtnClick();
			}
		});

		Panel p2 = new Panel();

		p2.add(cancelBtn);
		p2.add(registerBtn);
		p2.setBounds(new Rectangle(0, 305, WIDTH, 40));
		this.add(p2);
	}

	@SuppressWarnings("deprecation")
	private void registerBtnClick() {

		String strPwd = password.getText();
		String strPwd0 = password0.getText();
		String strTel = telephone.getText();

		if (!strPwd.equals(strPwd0)) {
			JOptionPane.showMessageDialog(null, "Passwords not match", "Error", 
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		if (!strTel.startsWith("44")) {
			JOptionPane.showMessageDialog(null, "!telephone.startsWith(\"44\" ) ", "Error",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		// TODO: Check UserName
		// TODO: Create New User
	}

	private void cancelBtnClick() {

		if (JOptionPane.YES_OPTION != JOptionPane.showConfirmDialog(null, "Are you sure?", "Warning",
				JOptionPane.YES_NO_OPTION)) {
			return;
		}

		if (null != parent) {
			parent.setVisible(true);
			this.dispose();
		} else {
			System.exit(0);
		}
	}

	private JFrame parent;

	private JLabel title;

	private JTextField userName;
	private JPasswordField password;
	private JPasswordField password0;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField telephone;
	private JTextField birthday;
	private JTextField city;

	private JButton cancelBtn;
	private JButton registerBtn;

	private static final int WIDTH = 500;
	private static final int HEIGHT = 400;

}

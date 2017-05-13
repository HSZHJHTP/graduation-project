package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.sun.org.apache.bcel.internal.generic.NEW;

import biz.MessageManage;

import entity.Login;

public class LoginFrame {
	JFrame frame;
	JTextField nameText;
	JPasswordField passwordField;
	MessageManage messageManage = new MessageManage();
	List<Login> list = new ArrayList<Login>();

	public static void main(String[] args) {
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.init();
	}

	public void init() {
		frame = new JFrame();
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel mainPanel = (JPanel) frame.getContentPane();
		BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(layout);

		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 0));
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 0));
		JPanel panel4 = new JPanel();
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));

		JLabel nameLabel = new JLabel("小葵花短信通信平台");
		panel1.add(nameLabel);

		JLabel sexLabel = new JLabel("姓名：");
		panel2.add(sexLabel);
		nameText = new JTextField();
		nameText.setPreferredSize(new Dimension(200, 30));
		panel2.add(nameText);

		JLabel ageLabel = new JLabel("密码：");
		panel3.add(ageLabel);
		 passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(200, 30));
		panel3.add( passwordField);

		JButton registeredButton = new JButton("注册");
		registeredButton.setPreferredSize(new Dimension(60, 30));
		registeredButton.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {

				Login login = new Login();
				login.setName(nameText.getText());
				login.setPassword(passwordField.getText());
				if(login.getName().equals("")||login.getPassword().equals("")){
					JOptionPane.showMessageDialog(null, "注册失败");
					return;
				}
				boolean flag = messageManage.addLogin(login);
				String message = "注册成功";
				if (!flag){
					message = "注册失败";
				}
				JOptionPane.showMessageDialog(null, message);
				nameText.setText(null);
				passwordField.setText(null);
			}
		});
		JButton loginButton = new JButton("登录");
		loginButton.setPreferredSize(new Dimension(60, 30));

		loginButton.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				SearchFrame searchFrame = new SearchFrame();
				list = messageManage.findLogin();
				for (int i = 0; i < list.size(); i++) {
					if (nameText.getText().equals(list.get(i).getName())
							&& passwordField.getText().equals(
									list.get(i).getPassword())) {
					
						searchFrame.init();
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "姓名或密码错误,请重新再试");
					}
				}
				
			}
		});
		panel4.add(registeredButton);
		panel4.add(loginButton);

		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);

		frame.setVisible(true);
	}
}

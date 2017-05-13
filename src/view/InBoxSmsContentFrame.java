package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.org.apache.bcel.internal.generic.NEW;

import entity.Inbox;
import entity.Outbox;

import biz.MessageManage;

public class InBoxSmsContentFrame {
	JFrame frame;
	JTextArea contentText;
	int id;
	MessageManage messageManage = new MessageManage();
	
	public InBoxSmsContentFrame(int id){
		this.id = id;
	}

	public void init() {
		Inbox inbox = new Inbox();
		inbox.setSmsContent(messageManage.findInBoxById(id).getSmsContent());
		frame = new JFrame();
		frame.setSize(700, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel mainPanel = (JPanel) frame.getContentPane();
		BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(layout);

		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 0));
		
		JLabel nameLabel = new JLabel("收件箱内容");
		panel1.add(nameLabel);

		
		contentText = new JTextArea();
		contentText.setPreferredSize(new Dimension(500, 300));
		contentText.setText(inbox.getSmsContent());
		panel2.add(contentText);
		
		mainPanel.add(panel1);
		mainPanel.add(panel2);

		frame.setVisible(true);
	}
}

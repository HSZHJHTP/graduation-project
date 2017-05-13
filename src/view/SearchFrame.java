package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Inbox;

public class SearchFrame {
	JFrame frame;
	public void init() {
		frame = new JFrame();
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel mainPanel = (JPanel) frame.getContentPane();
		BoxLayout layout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
		mainPanel.setLayout(layout);

		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 0));
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 60, 0));
		
		JButton sendButton = new JButton("发短信");
		sendButton.setPreferredSize(new Dimension(100, 30));
		panel1.add(sendButton);
		sendButton.addActionListener(new ActionListener(
				) {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SendFrame sendFrame = new SendFrame();
				sendFrame.init();
			}
		});
		
		JButton outButton = new JButton("发件箱");
		outButton.setPreferredSize(new Dimension(100, 30));
		panel2.add(outButton);
		outButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OutBoxFrame outBoxFrame = new OutBoxFrame();
				outBoxFrame.init();
			}
		});
		
		JButton inButton = new JButton("收件箱");
		inButton.setPreferredSize(new Dimension(100, 30));
		panel3.add(inButton);
		inButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InBoxFrame inBoxFrame = new InBoxFrame();
				inBoxFrame.init();
				
			}
		});
		
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);

		frame.setVisible(true);
	}
}

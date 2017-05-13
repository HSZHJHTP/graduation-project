package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SendFrame {
	JFrame frame;
	JTextField telephoneText;
	JTextArea contentText;
	JTextArea  messageText;
	JButton sendbButton;

	public void init() {
		frame = new JFrame();
		frame.setSize(800, 600);
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

		JLabel sexLabel = new JLabel("联系电话：");
		panel1.add(sexLabel);
		telephoneText = new JTextField();
		telephoneText.setPreferredSize(new Dimension(420, 30));
		panel1.add(telephoneText);

		contentText = new JTextArea();
		contentText.setPreferredSize(new Dimension(520, 200));
		contentText.setLineWrap(true);
		contentText.setWrapStyleWord(true);
		panel2.add(contentText);

		messageText = new JTextArea();
		messageText.setPreferredSize(new Dimension(400, 60));
		contentText.setLineWrap(true);
		contentText.setWrapStyleWord(true);
		panel3.add(messageText);
		sendbButton = new JButton("发送");
		sendbButton.setPreferredSize(new Dimension(60, 60));
		panel3.add(sendbButton);
		sendbButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);

		frame.setVisible(true);

	}
}

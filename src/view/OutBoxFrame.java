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
import javax.swing.JScrollPane;
import javax.swing.JTable;


import com.sun.org.apache.bcel.internal.generic.NEW;

import biz.MessageManage;

import entity.Outbox;

import model.OutboxTableModel;

public class OutBoxFrame {
	List<Outbox> list;
	JFrame frame;
	OutboxTableModel outboxTableModel;
	JTable table;
	MessageManage messageManage = new MessageManage();
	JScrollPane scrollPane;

	public void init() {
		frame = new JFrame();
		frame.setSize(1000, 800);
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

		JLabel nameLabel = new JLabel("发件箱");
		panel1.add(nameLabel);
		list = new ArrayList<Outbox>();
		list = messageManage.findOutbox();
		outboxTableModel = new OutboxTableModel(list);
		table = new JTable(outboxTableModel);
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(800, 500));
		panel2.add(scrollPane);
		mainPanel.add(panel2);
		JButton watchbButton = new JButton("查看");
		watchbButton.setPreferredSize(new Dimension(60, 30));
		panel3.add(watchbButton);
		watchbButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index > -1) {
					Outbox outbox = list.get(index);
					OutBoxSmsContentFrame outBoxSmsContentFrame = new OutBoxSmsContentFrame(
							outbox.getId());
					outBoxSmsContentFrame.init();

				} else {
					JOptionPane.showMessageDialog(null, "请选中要查看的短信");
				}

			}
		});
		JButton deleteButton = new JButton("删除");
		deleteButton.setPreferredSize(new Dimension(60, 30));
		panel3.add(deleteButton);
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				if (index > -1) {
					Outbox outbox = list.get(index);
					messageManage.delete(outbox);
				} else {
					JOptionPane.showMessageDialog(null, "请选中要删除的学生");
				}
				// Outbox outbox = list.get(index);

				refreshTable();
			}
		});
		mainPanel.add(panel1);
		mainPanel.add(panel2);
		mainPanel.add(panel3);

		frame.setVisible(true);

	}

	public void refreshTable() {
		list = messageManage.findOutbox();
		outboxTableModel.setData(list);// 刷新表格
	}

}

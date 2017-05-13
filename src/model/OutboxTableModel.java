package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Outbox;

/**
 * 
 * JTable、JTree 是界面所有空间中最为复杂的，需要用一个model来控制展示的数据，此处模仿即可。
 */
public class OutboxTableModel extends AbstractTableModel {
	String[] columnNames = { "序号", "电话号码", "短信内容"};

	private List<Outbox> data;

	public OutboxTableModel(List<Outbox> data) {
		this.data = data;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public int getColumnCount() {
		// 根据实际情况返回列数
		return columnNames.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// 根据实际情况返回列名
		return columnNames[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) { // rowIndex行的索引，columnIndex列的索引
		// 拿到list中的数据
		Outbox outbox = data.get(rowIndex);
		if (columnIndex == 0) {
			return rowIndex + 1;
		} else if (columnIndex == 1) {
			return outbox.getTelephoneNumber();
		} else if (columnIndex == 2) {
			return outbox.getSmsContent();
		}
		return null;

	}

	public void setData(List<Outbox> data) {
		if (data == null) {
			throw new IllegalArgumentException("参数data不能为null。");
		}
		this.data = data;

		fireTableDataChanged();
	}
}
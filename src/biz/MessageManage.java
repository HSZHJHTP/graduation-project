package biz;

import java.util.List;
import java.util.Scanner;

import dao.MessageDao;

import entity.Inbox;
import entity.Login;
import entity.Outbox;

public class MessageManage {
	MessageDao messageDao = new MessageDao();
	List<Login> lsit;

	public List<Login> findLogin() {
		return messageDao.findLogin();
	}
	public List<Outbox> findOutbox() {
		return messageDao.findOutbox();
	}
	public List<Inbox> findInbox() {
		return messageDao.findInbox();
	}

	public boolean addLogin(Login login) {
		int rs = messageDao.insertLogin(login);
		if (rs > 0) {
			return true;
		} else {
			return false;
		}
	}
	public boolean addInBox(Inbox inbox) {
		int rs = messageDao.insertInBox(inbox);
		if (rs > 0) {
			return true;
		} else {
			return false;
		}
	}
	public boolean addOutBox(Outbox outbox) {
		int rs = messageDao.insertOutBox(outbox);
		if (rs > 0) {
			return true;
		} else {
			return false;
		}
	}
	public void delete(Outbox outbox) {
		messageDao.delete(outbox);
	}
	public void delete(Inbox inbox) {
		messageDao.delete(inbox);
	}
	public Outbox findOutBoxById(int id) {
		return messageDao.findOutBoxById(id);
	}
	public Inbox findInBoxById(int id) {
		return messageDao.findInBoxById(id);
	}

}

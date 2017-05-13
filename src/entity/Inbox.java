package entity;

public class Inbox {
	private int id;
	private String telephoneNumber;
	private String smsContent;

	public Inbox() {
	}

	public Inbox(int id, String telephoneNumber, String smsContent) {
		this.id = id;
		this.telephoneNumber = telephoneNumber;
		this.smsContent = smsContent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}
	
}

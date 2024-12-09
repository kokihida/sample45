package model.entity;

import java.util.Date;

public class UserBean {
	/**
	 * @author 肥田
	 */

	//ユーザーid
	private String userId;

	//パスワード
	private String password;

	//ユーザー名
	private String userName;

	//日付
	private Date timeStamp;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}

package kr.co.domain;

import java.util.Date;

public class MemberVO {
    
	private String userId;
	private String userPass;
	private String userName;
	private String userPhon;
	private String userAddr1;
	private String userAddr2;
	private String userAddr3;
	private Date regiDate;
	private int verify;
	
	public MemberVO() {}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhon() {
		return userPhon;
	}

	public void setUserPhon(String userPhon) {
		this.userPhon = userPhon;
	}

	public String getUserAddr1() {
		return userAddr1;
	}

	public void setUserAddr1(String userAddr1) {
		this.userAddr1 = userAddr1;
	}

	public String getUserAddr2() {
		return userAddr2;
	}

	public void setUserAddr2(String userAddr2) {
		this.userAddr2 = userAddr2;
	}

	public String getUserAddr3() {
		return userAddr3;
	}

	public void setUserAddr3(String userAddr3) {
		this.userAddr3 = userAddr3;
	}

	public Date getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}

	public int getVerify() {
		return verify;
	}

	public void setVerify(int verify) {
		this.verify = verify;
	}

	public MemberVO(String userId, String userPass, String userName, String userPhon, String userAddr1,
			String userAddr2, String userAddr3, Date regiDate, int verify) {
		super();
		this.userId = userId;
		this.userPass = userPass;
		this.userName = userName;
		this.userPhon = userPhon;
		this.userAddr1 = userAddr1;
		this.userAddr2 = userAddr2;
		this.userAddr3 = userAddr3;
		this.regiDate = regiDate;
		this.verify = verify;
	}

	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", userPass=" + userPass + ", userName=" + userName + ", userPhon="
				+ userPhon + ", userAddr1=" + userAddr1 + ", userAddr2=" + userAddr2 + ", userAddr3=" + userAddr3
				+ ", regiDate=" + regiDate + ", verify=" + verify + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regiDate == null) ? 0 : regiDate.hashCode());
		result = prime * result + ((userAddr1 == null) ? 0 : userAddr1.hashCode());
		result = prime * result + ((userAddr2 == null) ? 0 : userAddr2.hashCode());
		result = prime * result + ((userAddr3 == null) ? 0 : userAddr3.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPass == null) ? 0 : userPass.hashCode());
		result = prime * result + ((userPhon == null) ? 0 : userPhon.hashCode());
		result = prime * result + verify;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberVO other = (MemberVO) obj;
		if (regiDate == null) {
			if (other.regiDate != null)
				return false;
		} else if (!regiDate.equals(other.regiDate))
			return false;
		if (userAddr1 == null) {
			if (other.userAddr1 != null)
				return false;
		} else if (!userAddr1.equals(other.userAddr1))
			return false;
		if (userAddr2 == null) {
			if (other.userAddr2 != null)
				return false;
		} else if (!userAddr2.equals(other.userAddr2))
			return false;
		if (userAddr3 == null) {
			if (other.userAddr3 != null)
				return false;
		} else if (!userAddr3.equals(other.userAddr3))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPass == null) {
			if (other.userPass != null)
				return false;
		} else if (!userPass.equals(other.userPass))
			return false;
		if (userPhon == null) {
			if (other.userPhon != null)
				return false;
		} else if (!userPhon.equals(other.userPhon))
			return false;
		if (verify != other.verify)
			return false;
		return true;
	}

}

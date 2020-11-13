package kr.co.domain;

import java.util.Date;

public class ReplyVO {
	
	private int gdsNum;
	private String userId;
	private int repNum;
	private String repCon;
	private Date repDate;
	
	public ReplyVO() {}

	public int getGdsNum() {
		return gdsNum;
	}

	public void setGdsNum(int gdsNum) {
		this.gdsNum = gdsNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getRepNum() {
		return repNum;
	}

	public void setRepNum(int repNum) {
		this.repNum = repNum;
	}

	public String getRepCon() {
		return repCon;
	}

	public void setRepCon(String repCon) {
		this.repCon = repCon;
	}

	public Date getRepDate() {
		return repDate;
	}

	public void setRepDate(Date repDate) {
		this.repDate = repDate;
	}

	public ReplyVO(int gdsNum, String userId, int repNum, String repCon, Date repDate) {
		super();
		this.gdsNum = gdsNum;
		this.userId = userId;
		this.repNum = repNum;
		this.repCon = repCon;
		this.repDate = repDate;
	}

	@Override
	public String toString() {
		return "ReplyVO [gdsNum=" + gdsNum + ", userId=" + userId + ", repNum=" + repNum + ", repCon=" + repCon
				+ ", repDate=" + repDate + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + gdsNum;
		result = prime * result + ((repCon == null) ? 0 : repCon.hashCode());
		result = prime * result + ((repDate == null) ? 0 : repDate.hashCode());
		result = prime * result + repNum;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		ReplyVO other = (ReplyVO) obj;
		if (gdsNum != other.gdsNum)
			return false;
		if (repCon == null) {
			if (other.repCon != null)
				return false;
		} else if (!repCon.equals(other.repCon))
			return false;
		if (repDate == null) {
			if (other.repDate != null)
				return false;
		} else if (!repDate.equals(other.repDate))
			return false;
		if (repNum != other.repNum)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}

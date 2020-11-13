package kr.co.domain;

import java.util.Date;

public class CartVO {
	
	private int cartNum;
	private String userId;
	private int gdsNum;
	private int cartStock;
	private Date addDate;
	
	public CartVO() {}

	public int getCartNum() {
		return cartNum;
	}

	public void setCartNum(int cartNum) {
		this.cartNum = cartNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getGdsNum() {
		return gdsNum;
	}

	public void setGdsNum(int gdsNum) {
		this.gdsNum = gdsNum;
	}

	public int getCartStock() {
		return cartStock;
	}

	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public CartVO(int cartNum, String userId, int gdsNum, int cartStock, Date addDate) {
		super();
		this.cartNum = cartNum;
		this.userId = userId;
		this.gdsNum = gdsNum;
		this.cartStock = cartStock;
		this.addDate = addDate;
	}

	@Override
	public String toString() {
		return "CartVO [cartNum=" + cartNum + ", userId=" + userId + ", gdsNum=" + gdsNum + ", cartStock=" + cartStock
				+ ", addDate=" + addDate + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addDate == null) ? 0 : addDate.hashCode());
		result = prime * result + cartNum;
		result = prime * result + cartStock;
		result = prime * result + gdsNum;
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
		CartVO other = (CartVO) obj;
		if (addDate == null) {
			if (other.addDate != null)
				return false;
		} else if (!addDate.equals(other.addDate))
			return false;
		if (cartNum != other.cartNum)
			return false;
		if (cartStock != other.cartStock)
			return false;
		if (gdsNum != other.gdsNum)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}

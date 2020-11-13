package kr.co.domain;

import java.util.Date;

public class CartListVO {
	
	private int cartNum;
	private String userId;
	private int gdsNum;
	private int cartStock;
	private Date addDate;
	private int num;
	private String gdsName;
	private int gdsPrice;
	private String gdsThumbImg;
	
	public CartListVO() {}

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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getGdsName() {
		return gdsName;
	}

	public void setGdsName(String gdsName) {
		this.gdsName = gdsName;
	}

	public int getGdsPrice() {
		return gdsPrice;
	}

	public void setGdsPrice(int gdsPrice) {
		this.gdsPrice = gdsPrice;
	}

	public String getGdsThumbImg() {
		return gdsThumbImg;
	}

	public void setGdsThumbImg(String gdsThumbImg) {
		this.gdsThumbImg = gdsThumbImg;
	}

	public CartListVO(int cartNum, String userId, int gdsNum, int cartStock, Date addDate, int num, String gdsName,
			int gdsPrice, String gdsThumbImg) {
		super();
		this.cartNum = cartNum;
		this.userId = userId;
		this.gdsNum = gdsNum;
		this.cartStock = cartStock;
		this.addDate = addDate;
		this.num = num;
		this.gdsName = gdsName;
		this.gdsPrice = gdsPrice;
		this.gdsThumbImg = gdsThumbImg;
	}

	@Override
	public String toString() {
		return "CartListVO [cartNum=" + cartNum + ", userId=" + userId + ", gdsNum=" + gdsNum + ", cartStock="
				+ cartStock + ", addDate=" + addDate + ", num=" + num + ", gdsName=" + gdsName + ", gdsPrice="
				+ gdsPrice + ", gdsThumbImg=" + gdsThumbImg + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addDate == null) ? 0 : addDate.hashCode());
		result = prime * result + cartNum;
		result = prime * result + cartStock;
		result = prime * result + ((gdsName == null) ? 0 : gdsName.hashCode());
		result = prime * result + gdsNum;
		result = prime * result + gdsPrice;
		result = prime * result + ((gdsThumbImg == null) ? 0 : gdsThumbImg.hashCode());
		result = prime * result + num;
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
		CartListVO other = (CartListVO) obj;
		if (addDate == null) {
			if (other.addDate != null)
				return false;
		} else if (!addDate.equals(other.addDate))
			return false;
		if (cartNum != other.cartNum)
			return false;
		if (cartStock != other.cartStock)
			return false;
		if (gdsName == null) {
			if (other.gdsName != null)
				return false;
		} else if (!gdsName.equals(other.gdsName))
			return false;
		if (gdsNum != other.gdsNum)
			return false;
		if (gdsPrice != other.gdsPrice)
			return false;
		if (gdsThumbImg == null) {
			if (other.gdsThumbImg != null)
				return false;
		} else if (!gdsThumbImg.equals(other.gdsThumbImg))
			return false;
		if (num != other.num)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
}

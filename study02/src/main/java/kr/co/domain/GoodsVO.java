package kr.co.domain;

import java.util.Date;

public class GoodsVO {
	
	private int gdsNum;
	private String gdsName;
	private String cateCode;
	private int gdsPrice;
	private int gdsStock;
	private String gdsDes;
	private String gdsImg;
	private Date gdsDate;
	private String gdsThumbImg;
	
	public GoodsVO() {}

	public int getGdsNum() {
		return gdsNum;
	}

	public void setGdsNum(int gdsNum) {
		this.gdsNum = gdsNum;
	}

	public String getGdsName() {
		return gdsName;
	}

	public void setGdsName(String gdsName) {
		this.gdsName = gdsName;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public int getGdsPrice() {
		return gdsPrice;
	}

	public void setGdsPrice(int gdsPrice) {
		this.gdsPrice = gdsPrice;
	}

	public int getGdsStock() {
		return gdsStock;
	}

	public void setGdsStock(int gdsStock) {
		this.gdsStock = gdsStock;
	}

	public String getGdsDes() {
		return gdsDes;
	}

	public void setGdsDes(String gdsDes) {
		this.gdsDes = gdsDes;
	}

	public String getGdsImg() {
		return gdsImg;
	}

	public void setGdsImg(String gdsImg) {
		this.gdsImg = gdsImg;
	}

	public Date getGdsDate() {
		return gdsDate;
	}

	public void setGdsDate(Date gdsDate) {
		this.gdsDate = gdsDate;
	}

	public String getGdsThumbImg() {
		return gdsThumbImg;
	}

	public void setGdsThumbImg(String gdsThumbImg) {
		this.gdsThumbImg = gdsThumbImg;
	}

	public GoodsVO(int gdsNum, String gdsName, String cateCode, int gdsPrice, int gdsStock, String gdsDes,
			String gdsImg, Date gdsDate, String gdsThumbImg) {
		super();
		this.gdsNum = gdsNum;
		this.gdsName = gdsName;
		this.cateCode = cateCode;
		this.gdsPrice = gdsPrice;
		this.gdsStock = gdsStock;
		this.gdsDes = gdsDes;
		this.gdsImg = gdsImg;
		this.gdsDate = gdsDate;
		this.gdsThumbImg = gdsThumbImg;
	}

	@Override
	public String toString() {
		return "GoodsVO [gdsNum=" + gdsNum + ", gdsName=" + gdsName + ", cateCode=" + cateCode + ", gdsPrice="
				+ gdsPrice + ", gdsStock=" + gdsStock + ", gdsDes=" + gdsDes + ", gdsImg=" + gdsImg + ", gdsDate="
				+ gdsDate + ", gdsThumbImg=" + gdsThumbImg + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cateCode == null) ? 0 : cateCode.hashCode());
		result = prime * result + ((gdsDate == null) ? 0 : gdsDate.hashCode());
		result = prime * result + ((gdsDes == null) ? 0 : gdsDes.hashCode());
		result = prime * result + ((gdsImg == null) ? 0 : gdsImg.hashCode());
		result = prime * result + ((gdsName == null) ? 0 : gdsName.hashCode());
		result = prime * result + gdsNum;
		result = prime * result + gdsPrice;
		result = prime * result + gdsStock;
		result = prime * result + ((gdsThumbImg == null) ? 0 : gdsThumbImg.hashCode());
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
		GoodsVO other = (GoodsVO) obj;
		if (cateCode == null) {
			if (other.cateCode != null)
				return false;
		} else if (!cateCode.equals(other.cateCode))
			return false;
		if (gdsDate == null) {
			if (other.gdsDate != null)
				return false;
		} else if (!gdsDate.equals(other.gdsDate))
			return false;
		if (gdsDes == null) {
			if (other.gdsDes != null)
				return false;
		} else if (!gdsDes.equals(other.gdsDes))
			return false;
		if (gdsImg == null) {
			if (other.gdsImg != null)
				return false;
		} else if (!gdsImg.equals(other.gdsImg))
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
		if (gdsStock != other.gdsStock)
			return false;
		if (gdsThumbImg == null) {
			if (other.gdsThumbImg != null)
				return false;
		} else if (!gdsThumbImg.equals(other.gdsThumbImg))
			return false;
		return true;
	}
	
} 
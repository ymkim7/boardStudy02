package kr.co.domain;

import java.util.Date;

public class OrderVO {
	
	private String orderId;
	private String userId;
	private String orderRec;
	private String userAddr1;
	private String userAddr2;
	private String userAddr3;
	private String orderPhon;
	private int amount;
	private Date orderDate;
	private String delivery;
	
	public OrderVO() {}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderRec() {
		return orderRec;
	}

	public void setOrderRec(String orderRec) {
		this.orderRec = orderRec;
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

	public String getOrderPhon() {
		return orderPhon;
	}

	public void setOrderPhon(String orderPhon) {
		this.orderPhon = orderPhon;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public OrderVO(String orderId, String userId, String orderRec, String userAddr1, String userAddr2, String userAddr3,
			String orderPhon, int amount, Date orderDate, String delivery) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.orderRec = orderRec;
		this.userAddr1 = userAddr1;
		this.userAddr2 = userAddr2;
		this.userAddr3 = userAddr3;
		this.orderPhon = orderPhon;
		this.amount = amount;
		this.orderDate = orderDate;
		this.delivery = delivery;
	}

	@Override
	public String toString() {
		return "OrderVO [orderId=" + orderId + ", userId=" + userId + ", orderRec=" + orderRec + ", userAddr1="
				+ userAddr1 + ", userAddr2=" + userAddr2 + ", userAddr3=" + userAddr3 + ", orderPhon=" + orderPhon
				+ ", amount=" + amount + ", orderDate=" + orderDate + ", delivery=" + delivery + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((delivery == null) ? 0 : delivery.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((orderPhon == null) ? 0 : orderPhon.hashCode());
		result = prime * result + ((orderRec == null) ? 0 : orderRec.hashCode());
		result = prime * result + ((userAddr1 == null) ? 0 : userAddr1.hashCode());
		result = prime * result + ((userAddr2 == null) ? 0 : userAddr2.hashCode());
		result = prime * result + ((userAddr3 == null) ? 0 : userAddr3.hashCode());
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
		OrderVO other = (OrderVO) obj;
		if (amount != other.amount)
			return false;
		if (delivery == null) {
			if (other.delivery != null)
				return false;
		} else if (!delivery.equals(other.delivery))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderPhon == null) {
			if (other.orderPhon != null)
				return false;
		} else if (!orderPhon.equals(other.orderPhon))
			return false;
		if (orderRec == null) {
			if (other.orderRec != null)
				return false;
		} else if (!orderRec.equals(other.orderRec))
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
		return true;
	}

}

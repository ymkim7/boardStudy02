package kr.co.domain;

public class OrderDetailVO {
	
	private int orderDetailsNum;
	private String orderId;
	private int gdsNum;
	private int cartStock;
	
	public OrderDetailVO() {}

	public int getOrderDetailsNum() {
		return orderDetailsNum;
	}

	public void setOrderDetailsNum(int orderDetailsNum) {
		this.orderDetailsNum = orderDetailsNum;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
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

	public OrderDetailVO(int orderDetailsNum, String orderId, int gdsNum, int cartStock) {
		super();
		this.orderDetailsNum = orderDetailsNum;
		this.orderId = orderId;
		this.gdsNum = gdsNum;
		this.cartStock = cartStock;
	}

	@Override
	public String toString() {
		return "OrderDetailVO [orderDetailsNum=" + orderDetailsNum + ", orderId=" + orderId + ", gdsNum=" + gdsNum
				+ ", cartStock=" + cartStock + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartStock;
		result = prime * result + gdsNum;
		result = prime * result + orderDetailsNum;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
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
		OrderDetailVO other = (OrderDetailVO) obj;
		if (cartStock != other.cartStock)
			return false;
		if (gdsNum != other.gdsNum)
			return false;
		if (orderDetailsNum != other.orderDetailsNum)
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

}

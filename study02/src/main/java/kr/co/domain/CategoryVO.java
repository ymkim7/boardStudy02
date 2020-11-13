package kr.co.domain;

public class CategoryVO {
	
	private String cateName;
	private String cateCode;
	private String cateCodeRef;
	private int level;
	
	public CategoryVO() {}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public String getCateCodeRef() {
		return cateCodeRef;
	}

	public void setCateCodeRef(String cateCodeRef) {
		this.cateCodeRef = cateCodeRef;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public CategoryVO(String cateName, String cateCode, String cateCodeRef, int level) {
		super();
		this.cateName = cateName;
		this.cateCode = cateCode;
		this.cateCodeRef = cateCodeRef;
		this.level = level;
	}

	@Override
	public String toString() {
		return "CategoryVO [cateName=" + cateName + ", cateCode=" + cateCode + ", cateCodeRef=" + cateCodeRef
				+ ", level=" + level + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cateCode == null) ? 0 : cateCode.hashCode());
		result = prime * result + ((cateCodeRef == null) ? 0 : cateCodeRef.hashCode());
		result = prime * result + ((cateName == null) ? 0 : cateName.hashCode());
		result = prime * result + level;
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
		CategoryVO other = (CategoryVO) obj;
		if (cateCode == null) {
			if (other.cateCode != null)
				return false;
		} else if (!cateCode.equals(other.cateCode))
			return false;
		if (cateCodeRef == null) {
			if (other.cateCodeRef != null)
				return false;
		} else if (!cateCodeRef.equals(other.cateCodeRef))
			return false;
		if (cateName == null) {
			if (other.cateName != null)
				return false;
		} else if (!cateName.equals(other.cateName))
			return false;
		if (level != other.level)
			return false;
		return true;
	}

}

package com.xinrui.demo.bean;

public class PageParam implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private int totalNumber;

	private int currentPage;

	private int totalPage;

	private int pageNumber = 15;

	private int dbIndex;

	private int dbNumber;

	public void count() {

		int totalPageTemp = this.totalNumber / this.pageNumber;
		int plus = (this.totalNumber % this.pageNumber) == 0 ? 0 : 1;
		totalPageTemp = totalPageTemp + plus;
		if (totalPageTemp <= 0) {
			totalPageTemp = 1;
		}
		this.totalPage = totalPageTemp;

		if (this.totalPage < this.currentPage) {
			this.currentPage = this.totalPage;
		}
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}

		this.dbIndex = (this.currentPage - 1) * this.pageNumber;
		this.dbNumber = this.pageNumber;
	}

	public int getTotalNumber() {

		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {

		this.totalNumber = totalNumber;
		this.count();
	}

	public int getCurrentPage() {

		return currentPage;
	}

	public void setCurrentPage(int currentPage) {

		this.currentPage = currentPage;
	}

	public int getTotalPage() {

		return totalPage;
	}

	public void setTotalPage(int totalPage) {

		this.totalPage = totalPage;
	}

	public int getPageNumber() {

		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {

		this.pageNumber = pageNumber;
		this.count();
	}

	public int getDbIndex() {

		return dbIndex;
	}

	public void setDbIndex(int dbIndex) {

		this.dbIndex = dbIndex;
	}

	public int getDbNumber() {

		return dbNumber;
	}

	public void setDbNumber(int dbNumber) {

		this.dbNumber = dbNumber;
	}
}

package com.wipro.ots.entity;

public class TrackingUpdate {
	 private String updateId;
	 private String orderId;
	 private String date;
	 private String notes;

	public TrackingUpdate(String updateId,String orderId,String date,String notes) {
		this.updateId=updateId;
		this.orderId=orderId;
		this.date=date;
		this.notes=notes;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "TrackingUpdate [updateId=" + updateId + ", orderId=" + orderId + ", date=" + date + ", notes=" + notes
				+ "]";
	}

}

package com.po;

public class Log {
	private String logId;
	private String logCreater;
	private String logDate;
	private String logContent;
	
	public String getLogId() {
		return logId;
	}
	public void setLogId(String logId) {
		this.logId = logId;
	}
	public String getLogCreater() {
		return logCreater;
	}
	public void setLogCreater(String logCreater) {
		this.logCreater = logCreater;
	}
	public String getLogDate() {
		return logDate;
	}
	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}
	public String getLogContent() {
		return logContent;
	}
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	@Override
	public String toString() {
		return "Log [logId=" + logId + ", logCreater=" + logCreater + ", logDate=" + logDate + ", logContent="
				+ logContent + "]";
	}

	
}

package com.xsintech.model;

public class AnswerCountInfo {

	private Integer subId;

	private String optionValue;

	private Integer attend;

	private Integer undetermined;

	private Integer cancel;

	private Integer status;

	public Integer getSubId() {
		return subId;
	}

	public void setSubId(Integer subId) {
		this.subId = subId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public Integer getAttend() {
		return attend;
	}

	public void setAttend(Integer attend) {
		this.attend = attend;
	}

	public Integer getUndetermined() {
		return undetermined;
	}

	public void setUndetermined(Integer undetermined) {
		this.undetermined = undetermined;
	}

	public Integer getCancel() {
		return cancel;
	}

	public void setCancel(Integer cancel) {
		this.cancel = cancel;
	}

}

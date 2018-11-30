package com.jd.util;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class AjaxRult {
	@JsonProperty("success")
	private boolean Success;
	@JsonProperty("message")
	private String Message;
	@JsonProperty("code")
	private int Code;
	@JsonProperty("value")
	private Object Value;

	public static AjaxRult create(int code, boolean success, String message, Object value) {
		AjaxRult rult = new AjaxRult();
		rult.setCode(code);
		rult.setMessage(message);
		rult.setSuccess(success);
		rult.setValue(value);
		return rult;
	}

	public static AjaxRult create(Object value) {
		return create(0, true, "OK", value);
	}

	public static AjaxRult create(int code, String message) {
		return create(code, false, message, null);
	}

	public static AjaxRult create(String message) {
		return create(-1, message);
	}

	public static AjaxRult create(boolean status) {
		if (status) {
			return create(0, true, "OK", null);
		} else {
			return create(-1, false, "", null);
		}
	}

	@JsonIgnore
	public boolean isSuccess() {
		return Success;
	}

	@JsonIgnore
	public void setSuccess(boolean success) {
		Success = success;
	}

	@JsonIgnore
	public String getMessage() {
		return Message;
	}

	@JsonIgnore
	public void setMessage(String message) {
		Message = message;
	}
	@JsonIgnore
	public int getCode() {
		return Code;
	}
	@JsonIgnore
	public void setCode(int code) {
		Code = code;
	}
	@JsonIgnore
	public Object getValue() {
		return Value;
	}
	@JsonIgnore
	public void setValue(Object value) {
		Value = value;
	}

}

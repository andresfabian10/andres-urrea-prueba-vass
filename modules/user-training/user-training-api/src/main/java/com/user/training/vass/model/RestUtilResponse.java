package com.user.training.vass.model;

import com.liferay.portal.kernel.json.JSONObject;


public class RestUtilResponse {
	private JSONObject body;
	private int statusCode;
	/**
	 * @return the body
	 */
	public JSONObject getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(JSONObject body) {
		this.body = body;
	}
	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @param body
	 * @param statusCode
	 */
	public RestUtilResponse(JSONObject body, int statusCode) {
		super();
		this.body = body;
		this.statusCode = statusCode;
	}
	/**
	 * 
	 */
	public RestUtilResponse() {
		super();
	}
	@Override
	public String toString() {
		return "RestUtilResponse [body=" + body + ", statusCode=" + statusCode + "]";
	}
	
	
	
	
	
	
	
}

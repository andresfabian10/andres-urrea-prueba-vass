package com.user.training.vass.api;

import com.user.training.vass.exception.ClientException;
import com.user.training.vass.model.RestUtilResponse;

import java.util.Map;

public interface TrainingVassClientApi {
	
	public RestUtilResponse callRestServiceByPost(String url, String request, Map<String, String> headers,
			Map<String, String> parameters, String contentType, int timeOut) throws ClientException;
	
	public RestUtilResponse callRestServiceByGet(String url, Map<String, String> headers,
			Map<String, String> parameters, int timeOut) throws ClientException;

}

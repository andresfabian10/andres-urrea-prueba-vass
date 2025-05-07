package com.user.training.vass.service.client;

import com.user.training.vass.api.TrainingVassClientApi;
import com.user.training.vass.api.TrainingVassRestApi;
import com.user.training.vass.constant.Constants;
import com.user.training.vass.exception.ClientException;
import com.user.training.vass.model.CreateUser;
import com.user.training.vass.model.RestUtilResponse;


import java.util.LinkedHashMap;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import javax.ws.rs.core.MediaType;

public class TrainingVassRestService implements TrainingVassRestApi {
	
	private static final Log LOG = LogFactoryUtil.getLog(TrainingVassRestService.class);
	private static TrainingVassClientApi clientApi = new TrainingVassClientService();

	@Override
	public RestUtilResponse createUserwithObject(CreateUser createUser) {
		final String URL_CREATE_USER = PropsUtil.get(Constants.PROP_URL_CREATE_USER_POST);
		LinkedHashMap<String, String> parameters = new LinkedHashMap<>();
		LinkedHashMap<String, String> headers = new LinkedHashMap<>();
		
		JSONObject jsonObjectRequest = JSONFactoryUtil.createJSONObject();
		jsonObjectRequest.put(Constants.JSON_NAME, createUser.getName());
		jsonObjectRequest.put(Constants.JSON_EMAIL, createUser.getEmail());
		try {
			
			RestUtilResponse response = clientApi.callRestServiceByPost(URL_CREATE_USER, jsonObjectRequest.toJSONString(),
					headers, parameters, MediaType.APPLICATION_JSON, getTimeoutServices());
			LOG.info("[TRAINING VASS SERVICE] -> createUserwithObject : response :: " + response);
			return response;
		} catch (ClientException e) {
			LOG.error("[TRAINING VASS SERVICE] -> Error send notification", e);
			return new RestUtilResponse(JSONFactoryUtil.createJSONObject(), 500);
		}
	}
	
	
	private int getTimeoutServices() {
		try {
			final String PROP_TIMEOUT_SERVICES = PropsUtil.get(Constants.PROP_TIMEOUT_SERVICES);
			return Integer.parseInt(PROP_TIMEOUT_SERVICES);
		} catch (Exception e) {
			LOG.error("[TRAINING VASS] -> Variable timeout otp no definida ", e);
			return 10000;
		}

	}
	


	
}

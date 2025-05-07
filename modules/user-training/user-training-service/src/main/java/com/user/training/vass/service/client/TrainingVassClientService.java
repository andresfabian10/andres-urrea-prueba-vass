package com.user.training.vass.service.client;


import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.user.training.vass.api.TrainingVassClientApi;
import com.user.training.vass.constant.Constants;
import com.user.training.vass.exception.ClientException;
import com.user.training.vass.model.RestUtilResponse;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.IOUtils;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

import java.util.Map;

public class TrainingVassClientService implements TrainingVassClientApi {
	
	private static final Log LOG = LogFactoryUtil.getLog(TrainingVassClientService.class);

	@Override
	public RestUtilResponse callRestServiceByPost(String url, String request, Map<String, String> headers,
			Map<String, String> parameters, String contentType, int timeOut) throws ClientException {
		RestUtilResponse response = new RestUtilResponse();
		final HttpClient client = new HttpClient();
		final PostMethod mPost = new PostMethod(url);
		if (request != null && !request.isEmpty()) {
			try {
				RequestEntity requestEntity = new InputStreamRequestEntity(
						IOUtils.toInputStream(request, StandardCharsets.UTF_8.name()), contentType);
				mPost.setRequestEntity(requestEntity);
			} catch (IOException e) {
				throw new ClientException(e);
			}
		}
		
		for (Map.Entry<String, String> entry : headers.entrySet()) {
			mPost.addRequestHeader(entry.getKey(), entry.getValue());
		}

		for (Map.Entry<String, String> entry : parameters.entrySet()) {
			mPost.setParameter(entry.getKey(), entry.getValue());
		}

		try {
			client.executeMethod(mPost);
			if (mPost.getResponseBodyAsStream() != null) {
				String responseService = IOUtils.toString(mPost.getResponseBodyAsStream(),
						StandardCharsets.UTF_8.name());
				JSONObject jsonParseResponse = JSONFactoryUtil.createJSONObject(responseService);
				response.setBody(jsonParseResponse);
				response.setStatusCode(mPost.getStatusCode());
			} else {
				int codeResponse = mPost.getStatusLine().getStatusCode();
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put(Constants.CLIENT_CODE_RESPONSE, codeResponse);
				response.setBody(jsonObject);
				response.setStatusCode(codeResponse);
			}
		} catch (final JSONException e) {
			LOG.error(Constants.CLIENT_ERROR_SERVICE.concat(url) + " :: status :: " + mPost.getStatusCode());
			int codeResponse = mPost.getStatusLine().getStatusCode();
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put(Constants.CLIENT_CODE_RESPONSE, codeResponse);
			response.setBody(jsonObject);
			response.setStatusCode(mPost.getStatusLine().getStatusCode());
		} catch (final IOException e) {
			LOG.error(Constants.CLIENT_ERROR.concat(e.getMessage()));
			throw new ClientException(e);
		} catch (Exception e) {
			LOG.error(Constants.CLIENT_ERROR_SERVICE.concat(url));
			throw new ClientException(e);
		} finally {
			mPost.releaseConnection();
		}

		return response;
	}

	@Override
	public RestUtilResponse callRestServiceByGet(String url, Map<String, String> headers,
			Map<String, String> parameters, int timeOut) throws ClientException {
		RestUtilResponse response = new RestUtilResponse();

		final HttpClient client = new HttpClient();
		client.getHttpConnectionManager().getParams().setConnectionTimeout(timeOut);
		client.getHttpConnectionManager().getParams().setSoTimeout(timeOut);
		HttpMethodParams httpMethodParams = new HttpMethodParams();
		final GetMethod mGet = new GetMethod(url);

		for (Map.Entry<String, String> entry : headers.entrySet()) {
			mGet.addRequestHeader(entry.getKey(), entry.getValue());
		}

		if (!parameters.keySet().isEmpty()) {
			parameters.entrySet().forEach(entry -> httpMethodParams.setParameter(entry.getKey(), entry.getValue()));
			mGet.setParams(httpMethodParams);
		}

		try {
			client.executeMethod(mGet);
			if (mGet.getResponseBodyAsStream() != null) {
				String responseService = IOUtils.toString(mGet.getResponseBodyAsStream(),
						StandardCharsets.UTF_8.name());
				JSONObject jsonParseResponse = JSONFactoryUtil.createJSONObject(responseService);
				response.setBody(jsonParseResponse);
				response.setStatusCode(mGet.getStatusCode());
			} else {
				int codeResponse = mGet.getStatusLine().getStatusCode();
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put(Constants.CLIENT_CODE_RESPONSE, codeResponse);
				response.setBody(jsonObject);
				response.setStatusCode(codeResponse);
			}
		} catch (final JSONException e) {
			LOG.error(Constants.CLIENT_ERROR_SERVICE.concat(url) + " :: status :: " + mGet.getStatusCode());
			int codeResponse = mGet.getStatusLine().getStatusCode();
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put(Constants.CLIENT_CODE_RESPONSE, codeResponse);
			response.setBody(jsonObject);
			response.setStatusCode(mGet.getStatusLine().getStatusCode());
		} catch (final IOException e) {
			LOG.error(Constants.CLIENT_ERROR.concat(e.getMessage()));
			throw new ClientException(e);
		} catch (Exception e) {
			LOG.error(Constants.CLIENT_ERROR_SERVICE.concat(url));
			throw new ClientException(e);
		} finally {
			mGet.releaseConnection();
		}

		return response;
	}
	
	
	

}

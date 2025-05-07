package com.user.training.vass.web.portlet;

import com.liferay.portal.configuration.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.user.training.vass.constant.Constants;
import com.user.training.vass.model.Training;
import com.user.training.vass.service.TrainingLocalServiceUtil;
import com.user.training.vass.web.configuration.CustomWebConfiguration;
import com.user.training.vass.web.constants.UserTrainingPortletKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Andres Urrea
 */
@Component(configurationPid = "com.user.training.vass.web.configuration.CustomWebConfiguration",
		property = {
		"com.liferay.portlet.display-category=category.sample", "com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=UserTraining",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + UserTrainingPortletKeys.USERTRAINING, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class UserTrainingPortlet extends MVCPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(UserTrainingPortlet.class);
	
	@Reference
	private ConfigurationProvider _configurationProvider;

	@Reference
	private Portal _portal;
	

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		try {
			isAdmin(renderRequest);
		} catch (Exception e) {
			LOG.error("Error: " + e);
			e.printStackTrace();
		}

		super.doView(renderRequest, renderResponse);
	}
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)throws IOException, PortletException {

		try {
			renderRequest.setAttribute(
				CustomWebConfiguration.class.getName(),
				_configurationProvider.getCompanyConfiguration(
					CustomWebConfiguration.class,
					_portal.getCompanyId(renderRequest)));
		}
		catch (ConfigurationException configurationException) {
			throw new PortletException(configurationException);
		}

		super.render(renderRequest, renderResponse);
	}
	
	private void isAdmin(RenderRequest renderRequest) throws Exception {
		 ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		    renderRequest.setAttribute("signedIn", themeDisplay.isSignedIn());
	
		    if (themeDisplay.isSignedIn()) {
		    	SessionMessages.add(renderRequest, "admin-message");
				renderRequest.setAttribute("isAdmin", true);
		    }

	}
}
package com.user.training.vass.web.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.user.training.vass.model.Training;
import com.user.training.vass.service.TrainingLocalServiceUtil;
import com.user.training.vass.web.constants.UserTrainingPortletKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Andres Urrea
 */
@Component(
        immediate = true, 
        property = { 
                "com.liferay.portlet.display-category=category.hidden",
                "com.liferay.portlet.scopeable=true", 
                "javax.portlet.display-name=Paymentez Bin",
                "javax.portlet.expiration-cache=0", 
                "javax.portlet.init-param.portlet-title-based-navigation=true",
                "javax.portlet.init-param.template-path=/", 
                "javax.portlet.init-param.view-template=/viewAdmin.jsp",
                "javax.portlet.name=" + UserTrainingPortletKeys.USERTRAINING_ADMIN,
                "javax.portlet.resource-bundle=content.Language", 
                "javax.portlet.security-role-ref=administrator",
                "javax.portlet.supports.mime-type=text/html",
                "com.liferay.portlet.add-default-resource=true"
        }, 
        service = Portlet.class
    )
public class UserTrainingPanelApp extends MVCPortlet {

	private static final Log LOG = LogFactoryUtil.getLog(UserTrainingPanelApp.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		 ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);


		        List<Training> registers = TrainingLocalServiceUtil.getTrainings(-1, -1);
		        LOG.info("----------->: " + registers.toString());
		        renderRequest.setAttribute("registers", registers);
		 
		super.doView(renderRequest, renderResponse);
	}
	
}
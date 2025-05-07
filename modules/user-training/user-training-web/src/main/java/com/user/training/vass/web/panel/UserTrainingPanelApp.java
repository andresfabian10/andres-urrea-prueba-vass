package com.user.training.vass.web.panel;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;
import com.user.training.vass.web.constants.UserTrainingPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "panel.app.order:Integer=100", "panel.category.key=" + "TRAININGVASS"

}, service = PanelApp.class)
public class UserTrainingPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return UserTrainingPortletKeys.USERTRAINING_ADMIN;
	}

	@Reference(target = "(javax.portlet.name=" + UserTrainingPortletKeys.USERTRAINING_ADMIN + ")", unbind = "-")
	private Portlet _portlet;

	@Override
	public Portlet getPortlet() {
		// TODO Auto-generated method stub
		return _portlet;
	}

}
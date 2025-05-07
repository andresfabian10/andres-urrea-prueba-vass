package com.user.training.vass.web.panel;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;
import com.user.training.vass.web.constants.PruebaPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
	    immediate = true,
	    property = {
	        "panel.app.order:Integer=100",
	        "panel.category.key=" +  "control_panel.apps"

	    },
	    service = PanelApp.class
	)
public class UserTrainingPanelApp extends BasePanelApp {

	 @Override
	    public String getPortletId() {
	        return PruebaPortletKeys.PRUEBA; // Usa tu constante de portletId
	    }

	   

	    @Reference(
	            target = "(javax.portlet.name=" + PruebaPortletKeys.PRUEBA + ")",
	            unbind = "-"
	        )
	        private Portlet _portlet;



		@Override
		public Portlet getPortlet() {
			// TODO Auto-generated method stub
			return _portlet;
		}
	
	
}

package com.user.training.vass.web.panel;

import com.liferay.application.list.BasePanelCategory;
import com.liferay.application.list.PanelCategory;
import com.liferay.application.list.constants.PanelCategoryKeys;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;


@Component(
	    immediate = true,
	    property = {
	        "panel.category.order:Integer=100",
	        "panel.category.key=" +  PanelCategoryKeys.SITE_ADMINISTRATION

	    },
	    service = PanelCategory.class
	)
public class UserTrainingPanelCategory extends BasePanelCategory {
	
	
	@Override
    public String getKey() {
        return "TRAININGVASS";
    }

    @Override
    public String getLabel(Locale locale) {
       

        return "Training Vass";
    }
	
	
}

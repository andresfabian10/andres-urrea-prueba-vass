package com.user.training.vass.web.configuration;

import com.liferay.configuration.admin.category.ConfigurationCategory;

public class CustomWebConfigurationCategory implements ConfigurationCategory {

	@Override
	public String getCategoryIcon() {
		return _CATEGORY_ICON;
	}

	@Override
	public String getCategoryKey() {
		return _CATEGORY_KEY;
	}

	@Override
	public String getCategorySection() {
		return _CATEGORY_SECTION;
	}

	private static final String _CATEGORY_ICON = "foobar";

	private static final String _CATEGORY_KEY = "foobar";

	private static final String _CATEGORY_SECTION = "foobar";

}

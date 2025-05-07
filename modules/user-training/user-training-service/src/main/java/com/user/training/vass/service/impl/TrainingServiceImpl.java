/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.user.training.vass.service.impl;

import com.liferay.portal.aop.AopService;

import com.user.training.vass.service.base.TrainingServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=training",
		"json.web.service.context.path=Training"
	},
	service = AopService.class
)
public class TrainingServiceImpl extends TrainingServiceBaseImpl {
}
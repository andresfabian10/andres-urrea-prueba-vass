/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.user.training.vass.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TrainingService}.
 *
 * @author Brian Wing Shun Chan
 * @see TrainingService
 * @generated
 */
public class TrainingServiceWrapper
	implements ServiceWrapper<TrainingService>, TrainingService {

	public TrainingServiceWrapper() {
		this(null);
	}

	public TrainingServiceWrapper(TrainingService trainingService) {
		_trainingService = trainingService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _trainingService.getOSGiServiceIdentifier();
	}

	@Override
	public TrainingService getWrappedService() {
		return _trainingService;
	}

	@Override
	public void setWrappedService(TrainingService trainingService) {
		_trainingService = trainingService;
	}

	private TrainingService _trainingService;

}
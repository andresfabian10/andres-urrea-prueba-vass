/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.user.training.vass.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Training service. Represents a row in the &quot;TRAINING_Training&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TrainingModel
 * @generated
 */
@ImplementationClassName("com.user.training.vass.model.impl.TrainingImpl")
@ProviderType
public interface Training extends PersistedModel, TrainingModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.user.training.vass.model.impl.TrainingImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Training, Long> TRAINING_ID_ACCESSOR =
		new Accessor<Training, Long>() {

			@Override
			public Long get(Training training) {
				return training.getTrainingId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Training> getTypeClass() {
				return Training.class;
			}

		};

}
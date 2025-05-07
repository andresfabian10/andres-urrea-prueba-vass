/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.user.training.vass.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Training}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Training
 * @generated
 */
public class TrainingWrapper
	extends BaseModelWrapper<Training>
	implements ModelWrapper<Training>, Training {

	public TrainingWrapper(Training training) {
		super(training);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("trainingId", getTrainingId());
		attributes.put("userName", getUserName());
		attributes.put("email", getEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long trainingId = (Long)attributes.get("trainingId");

		if (trainingId != null) {
			setTrainingId(trainingId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}
	}

	@Override
	public Training cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the email of this training.
	 *
	 * @return the email of this training
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the primary key of this training.
	 *
	 * @return the primary key of this training
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the training ID of this training.
	 *
	 * @return the training ID of this training
	 */
	@Override
	public long getTrainingId() {
		return model.getTrainingId();
	}

	/**
	 * Returns the user name of this training.
	 *
	 * @return the user name of this training
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the uuid of this training.
	 *
	 * @return the uuid of this training
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the email of this training.
	 *
	 * @param email the email of this training
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the primary key of this training.
	 *
	 * @param primaryKey the primary key of this training
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the training ID of this training.
	 *
	 * @param trainingId the training ID of this training
	 */
	@Override
	public void setTrainingId(long trainingId) {
		model.setTrainingId(trainingId);
	}

	/**
	 * Sets the user name of this training.
	 *
	 * @param userName the user name of this training
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the uuid of this training.
	 *
	 * @param uuid the uuid of this training
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected TrainingWrapper wrap(Training training) {
		return new TrainingWrapper(training);
	}

}
/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.user.training.vass.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.user.training.vass.model.Training;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Training in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TrainingCacheModel
	implements CacheModel<Training>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TrainingCacheModel)) {
			return false;
		}

		TrainingCacheModel trainingCacheModel = (TrainingCacheModel)object;

		if (trainingId == trainingCacheModel.trainingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, trainingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", trainingId=");
		sb.append(trainingId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", email=");
		sb.append(email);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Training toEntityModel() {
		TrainingImpl trainingImpl = new TrainingImpl();

		if (uuid == null) {
			trainingImpl.setUuid("");
		}
		else {
			trainingImpl.setUuid(uuid);
		}

		trainingImpl.setTrainingId(trainingId);

		if (userName == null) {
			trainingImpl.setUserName("");
		}
		else {
			trainingImpl.setUserName(userName);
		}

		if (email == null) {
			trainingImpl.setEmail("");
		}
		else {
			trainingImpl.setEmail(email);
		}

		trainingImpl.resetOriginalValues();

		return trainingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		trainingId = objectInput.readLong();
		userName = objectInput.readUTF();
		email = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(trainingId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}
	}

	public String uuid;
	public long trainingId;
	public String userName;
	public String email;

}
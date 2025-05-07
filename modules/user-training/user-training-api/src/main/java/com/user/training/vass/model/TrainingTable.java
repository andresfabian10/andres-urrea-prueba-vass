/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.user.training.vass.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;TRAINING_Training&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Training
 * @generated
 */
public class TrainingTable extends BaseTable<TrainingTable> {

	public static final TrainingTable INSTANCE = new TrainingTable();

	public final Column<TrainingTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TrainingTable, Long> trainingId = createColumn(
		"trainingId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<TrainingTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<TrainingTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private TrainingTable() {
		super("TRAINING_Training", TrainingTable::new);
	}

}
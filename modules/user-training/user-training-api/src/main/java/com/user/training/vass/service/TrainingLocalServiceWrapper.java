/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.user.training.vass.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link TrainingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TrainingLocalService
 * @generated
 */
public class TrainingLocalServiceWrapper
	implements ServiceWrapper<TrainingLocalService>, TrainingLocalService {

	public TrainingLocalServiceWrapper() {
		this(null);
	}

	public TrainingLocalServiceWrapper(
		TrainingLocalService trainingLocalService) {

		_trainingLocalService = trainingLocalService;
	}

	/**
	 * Adds the training to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param training the training
	 * @return the training that was added
	 */
	@Override
	public com.user.training.vass.model.Training addTraining(
		com.user.training.vass.model.Training training) {

		return _trainingLocalService.addTraining(training);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new training with the primary key. Does not add the training to the database.
	 *
	 * @param trainingId the primary key for the new training
	 * @return the new training
	 */
	@Override
	public com.user.training.vass.model.Training createTraining(
		long trainingId) {

		return _trainingLocalService.createTraining(trainingId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the training with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param trainingId the primary key of the training
	 * @return the training that was removed
	 * @throws PortalException if a training with the primary key could not be found
	 */
	@Override
	public com.user.training.vass.model.Training deleteTraining(long trainingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingLocalService.deleteTraining(trainingId);
	}

	/**
	 * Deletes the training from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param training the training
	 * @return the training that was removed
	 */
	@Override
	public com.user.training.vass.model.Training deleteTraining(
		com.user.training.vass.model.Training training) {

		return _trainingLocalService.deleteTraining(training);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _trainingLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _trainingLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _trainingLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _trainingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.user.training.vass.model.impl.TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _trainingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.user.training.vass.model.impl.TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _trainingLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _trainingLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _trainingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.user.training.vass.model.Training fetchTraining(
		long trainingId) {

		return _trainingLocalService.fetchTraining(trainingId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _trainingLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _trainingLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _trainingLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the training with the primary key.
	 *
	 * @param trainingId the primary key of the training
	 * @return the training
	 * @throws PortalException if a training with the primary key could not be found
	 */
	@Override
	public com.user.training.vass.model.Training getTraining(long trainingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _trainingLocalService.getTraining(trainingId);
	}

	/**
	 * Returns a range of all the trainings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.user.training.vass.model.impl.TrainingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainings
	 * @param end the upper bound of the range of trainings (not inclusive)
	 * @return the range of trainings
	 */
	@Override
	public java.util.List<com.user.training.vass.model.Training> getTrainings(
		int start, int end) {

		return _trainingLocalService.getTrainings(start, end);
	}

	/**
	 * Returns the number of trainings.
	 *
	 * @return the number of trainings
	 */
	@Override
	public int getTrainingsCount() {
		return _trainingLocalService.getTrainingsCount();
	}

	/**
	 * Updates the training in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TrainingLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param training the training
	 * @return the training that was updated
	 */
	@Override
	public com.user.training.vass.model.Training updateTraining(
		com.user.training.vass.model.Training training) {

		return _trainingLocalService.updateTraining(training);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _trainingLocalService.getBasePersistence();
	}

	@Override
	public TrainingLocalService getWrappedService() {
		return _trainingLocalService;
	}

	@Override
	public void setWrappedService(TrainingLocalService trainingLocalService) {
		_trainingLocalService = trainingLocalService;
	}

	private TrainingLocalService _trainingLocalService;

}
/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.user.training.vass.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import com.user.training.vass.exception.NoSuchTrainingException;
import com.user.training.vass.model.Training;
import com.user.training.vass.service.TrainingLocalServiceUtil;
import com.user.training.vass.service.persistence.TrainingPersistence;
import com.user.training.vass.service.persistence.TrainingUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class TrainingPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.user.training.vass.service"));

	@Before
	public void setUp() {
		_persistence = TrainingUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Training> iterator = _trainings.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Training training = _persistence.create(pk);

		Assert.assertNotNull(training);

		Assert.assertEquals(training.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Training newTraining = addTraining();

		_persistence.remove(newTraining);

		Training existingTraining = _persistence.fetchByPrimaryKey(
			newTraining.getPrimaryKey());

		Assert.assertNull(existingTraining);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addTraining();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Training newTraining = _persistence.create(pk);

		newTraining.setUuid(RandomTestUtil.randomString());

		newTraining.setUserName(RandomTestUtil.randomString());

		newTraining.setEmail(RandomTestUtil.randomString());

		_trainings.add(_persistence.update(newTraining));

		Training existingTraining = _persistence.findByPrimaryKey(
			newTraining.getPrimaryKey());

		Assert.assertEquals(existingTraining.getUuid(), newTraining.getUuid());
		Assert.assertEquals(
			existingTraining.getTrainingId(), newTraining.getTrainingId());
		Assert.assertEquals(
			existingTraining.getUserName(), newTraining.getUserName());
		Assert.assertEquals(
			existingTraining.getEmail(), newTraining.getEmail());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Training newTraining = addTraining();

		Training existingTraining = _persistence.findByPrimaryKey(
			newTraining.getPrimaryKey());

		Assert.assertEquals(existingTraining, newTraining);
	}

	@Test(expected = NoSuchTrainingException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Training> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"TRAINING_Training", "uuid", true, "trainingId", true, "userName",
			true, "email", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Training newTraining = addTraining();

		Training existingTraining = _persistence.fetchByPrimaryKey(
			newTraining.getPrimaryKey());

		Assert.assertEquals(existingTraining, newTraining);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Training missingTraining = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingTraining);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Training newTraining1 = addTraining();
		Training newTraining2 = addTraining();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTraining1.getPrimaryKey());
		primaryKeys.add(newTraining2.getPrimaryKey());

		Map<Serializable, Training> trainings = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, trainings.size());
		Assert.assertEquals(
			newTraining1, trainings.get(newTraining1.getPrimaryKey()));
		Assert.assertEquals(
			newTraining2, trainings.get(newTraining2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Training> trainings = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(trainings.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Training newTraining = addTraining();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTraining.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Training> trainings = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, trainings.size());
		Assert.assertEquals(
			newTraining, trainings.get(newTraining.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Training> trainings = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(trainings.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Training newTraining = addTraining();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newTraining.getPrimaryKey());

		Map<Serializable, Training> trainings = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, trainings.size());
		Assert.assertEquals(
			newTraining, trainings.get(newTraining.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			TrainingLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Training>() {

				@Override
				public void performAction(Training training) {
					Assert.assertNotNull(training);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Training newTraining = addTraining();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Training.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"trainingId", newTraining.getTrainingId()));

		List<Training> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Training existingTraining = result.get(0);

		Assert.assertEquals(existingTraining, newTraining);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Training.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"trainingId", RandomTestUtil.nextLong()));

		List<Training> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Training newTraining = addTraining();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Training.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("trainingId"));

		Object newTrainingId = newTraining.getTrainingId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"trainingId", new Object[] {newTrainingId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingTrainingId = result.get(0);

		Assert.assertEquals(existingTrainingId, newTrainingId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Training.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("trainingId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"trainingId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Training addTraining() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Training training = _persistence.create(pk);

		training.setUuid(RandomTestUtil.randomString());

		training.setUserName(RandomTestUtil.randomString());

		training.setEmail(RandomTestUtil.randomString());

		_trainings.add(_persistence.update(training));

		return training;
	}

	private List<Training> _trainings = new ArrayList<Training>();
	private TrainingPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}
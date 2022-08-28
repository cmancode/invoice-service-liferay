/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.cmancode.invoice.service.app.service.persistence.impl;

import com.cmancode.invoice.service.app.exception.NoSuchInvoiceException;
import com.cmancode.invoice.service.app.model.Invoice;
import com.cmancode.invoice.service.app.model.InvoiceTable;
import com.cmancode.invoice.service.app.model.impl.InvoiceImpl;
import com.cmancode.invoice.service.app.model.impl.InvoiceModelImpl;
import com.cmancode.invoice.service.app.service.persistence.InvoicePersistence;
import com.cmancode.invoice.service.app.service.persistence.InvoiceUtil;
import com.cmancode.invoice.service.app.service.persistence.impl.constants.InvoiceServicePersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the invoice service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {InvoicePersistence.class, BasePersistence.class})
public class InvoicePersistenceImpl
	extends BasePersistenceImpl<Invoice> implements InvoicePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>InvoiceUtil</code> to access the invoice persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		InvoiceImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByInvoiceNumber;
	private FinderPath _finderPathWithoutPaginationFindByInvoiceNumber;
	private FinderPath _finderPathCountByInvoiceNumber;

	/**
	 * Returns all the invoices where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @return the matching invoices
	 */
	@Override
	public List<Invoice> findByInvoiceNumber(String invoiceNumber) {
		return findByInvoiceNumber(
			invoiceNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the invoices where invoiceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceNumber the invoice number
	 * @param start the lower bound of the range of invoices
	 * @param end the upper bound of the range of invoices (not inclusive)
	 * @return the range of matching invoices
	 */
	@Override
	public List<Invoice> findByInvoiceNumber(
		String invoiceNumber, int start, int end) {

		return findByInvoiceNumber(invoiceNumber, start, end, null);
	}

	/**
	 * Returns an ordered range of all the invoices where invoiceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceNumber the invoice number
	 * @param start the lower bound of the range of invoices
	 * @param end the upper bound of the range of invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching invoices
	 */
	@Override
	public List<Invoice> findByInvoiceNumber(
		String invoiceNumber, int start, int end,
		OrderByComparator<Invoice> orderByComparator) {

		return findByInvoiceNumber(
			invoiceNumber, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the invoices where invoiceNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param invoiceNumber the invoice number
	 * @param start the lower bound of the range of invoices
	 * @param end the upper bound of the range of invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching invoices
	 */
	@Override
	public List<Invoice> findByInvoiceNumber(
		String invoiceNumber, int start, int end,
		OrderByComparator<Invoice> orderByComparator, boolean useFinderCache) {

		invoiceNumber = Objects.toString(invoiceNumber, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByInvoiceNumber;
				finderArgs = new Object[] {invoiceNumber};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByInvoiceNumber;
			finderArgs = new Object[] {
				invoiceNumber, start, end, orderByComparator
			};
		}

		List<Invoice> list = null;

		if (useFinderCache) {
			list = (List<Invoice>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (Invoice invoice : list) {
					if (!invoiceNumber.equals(invoice.getInvoiceNumber())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_INVOICE_WHERE);

			boolean bindInvoiceNumber = false;

			if (invoiceNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_3);
			}
			else {
				bindInvoiceNumber = true;

				sb.append(_FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(InvoiceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindInvoiceNumber) {
					queryPos.add(invoiceNumber);
				}

				list = (List<Invoice>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first invoice in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invoice
	 * @throws NoSuchInvoiceException if a matching invoice could not be found
	 */
	@Override
	public Invoice findByInvoiceNumber_First(
			String invoiceNumber, OrderByComparator<Invoice> orderByComparator)
		throws NoSuchInvoiceException {

		Invoice invoice = fetchByInvoiceNumber_First(
			invoiceNumber, orderByComparator);

		if (invoice != null) {
			return invoice;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("invoiceNumber=");
		sb.append(invoiceNumber);

		sb.append("}");

		throw new NoSuchInvoiceException(sb.toString());
	}

	/**
	 * Returns the first invoice in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invoice, or <code>null</code> if a matching invoice could not be found
	 */
	@Override
	public Invoice fetchByInvoiceNumber_First(
		String invoiceNumber, OrderByComparator<Invoice> orderByComparator) {

		List<Invoice> list = findByInvoiceNumber(
			invoiceNumber, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last invoice in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invoice
	 * @throws NoSuchInvoiceException if a matching invoice could not be found
	 */
	@Override
	public Invoice findByInvoiceNumber_Last(
			String invoiceNumber, OrderByComparator<Invoice> orderByComparator)
		throws NoSuchInvoiceException {

		Invoice invoice = fetchByInvoiceNumber_Last(
			invoiceNumber, orderByComparator);

		if (invoice != null) {
			return invoice;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("invoiceNumber=");
		sb.append(invoiceNumber);

		sb.append("}");

		throw new NoSuchInvoiceException(sb.toString());
	}

	/**
	 * Returns the last invoice in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invoice, or <code>null</code> if a matching invoice could not be found
	 */
	@Override
	public Invoice fetchByInvoiceNumber_Last(
		String invoiceNumber, OrderByComparator<Invoice> orderByComparator) {

		int count = countByInvoiceNumber(invoiceNumber);

		if (count == 0) {
			return null;
		}

		List<Invoice> list = findByInvoiceNumber(
			invoiceNumber, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the invoices before and after the current invoice in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceId the primary key of the current invoice
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next invoice
	 * @throws NoSuchInvoiceException if a invoice with the primary key could not be found
	 */
	@Override
	public Invoice[] findByInvoiceNumber_PrevAndNext(
			long invoiceId, String invoiceNumber,
			OrderByComparator<Invoice> orderByComparator)
		throws NoSuchInvoiceException {

		invoiceNumber = Objects.toString(invoiceNumber, "");

		Invoice invoice = findByPrimaryKey(invoiceId);

		Session session = null;

		try {
			session = openSession();

			Invoice[] array = new InvoiceImpl[3];

			array[0] = getByInvoiceNumber_PrevAndNext(
				session, invoice, invoiceNumber, orderByComparator, true);

			array[1] = invoice;

			array[2] = getByInvoiceNumber_PrevAndNext(
				session, invoice, invoiceNumber, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Invoice getByInvoiceNumber_PrevAndNext(
		Session session, Invoice invoice, String invoiceNumber,
		OrderByComparator<Invoice> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_INVOICE_WHERE);

		boolean bindInvoiceNumber = false;

		if (invoiceNumber.isEmpty()) {
			sb.append(_FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_3);
		}
		else {
			bindInvoiceNumber = true;

			sb.append(_FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(InvoiceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindInvoiceNumber) {
			queryPos.add(invoiceNumber);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(invoice)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Invoice> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the invoices where invoiceNumber = &#63; from the database.
	 *
	 * @param invoiceNumber the invoice number
	 */
	@Override
	public void removeByInvoiceNumber(String invoiceNumber) {
		for (Invoice invoice :
				findByInvoiceNumber(
					invoiceNumber, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(invoice);
		}
	}

	/**
	 * Returns the number of invoices where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @return the number of matching invoices
	 */
	@Override
	public int countByInvoiceNumber(String invoiceNumber) {
		invoiceNumber = Objects.toString(invoiceNumber, "");

		FinderPath finderPath = _finderPathCountByInvoiceNumber;

		Object[] finderArgs = new Object[] {invoiceNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_INVOICE_WHERE);

			boolean bindInvoiceNumber = false;

			if (invoiceNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_3);
			}
			else {
				bindInvoiceNumber = true;

				sb.append(_FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindInvoiceNumber) {
					queryPos.add(invoiceNumber);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_2 =
		"invoice.invoiceNumber = ?";

	private static final String _FINDER_COLUMN_INVOICENUMBER_INVOICENUMBER_3 =
		"(invoice.invoiceNumber IS NULL OR invoice.invoiceNumber = '')";

	public InvoicePersistenceImpl() {
		setModelClass(Invoice.class);

		setModelImplClass(InvoiceImpl.class);
		setModelPKClass(long.class);

		setTable(InvoiceTable.INSTANCE);
	}

	/**
	 * Caches the invoice in the entity cache if it is enabled.
	 *
	 * @param invoice the invoice
	 */
	@Override
	public void cacheResult(Invoice invoice) {
		entityCache.putResult(
			InvoiceImpl.class, invoice.getPrimaryKey(), invoice);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the invoices in the entity cache if it is enabled.
	 *
	 * @param invoices the invoices
	 */
	@Override
	public void cacheResult(List<Invoice> invoices) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (invoices.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Invoice invoice : invoices) {
			if (entityCache.getResult(
					InvoiceImpl.class, invoice.getPrimaryKey()) == null) {

				cacheResult(invoice);
			}
		}
	}

	/**
	 * Clears the cache for all invoices.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(InvoiceImpl.class);

		finderCache.clearCache(InvoiceImpl.class);
	}

	/**
	 * Clears the cache for the invoice.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Invoice invoice) {
		entityCache.removeResult(InvoiceImpl.class, invoice);
	}

	@Override
	public void clearCache(List<Invoice> invoices) {
		for (Invoice invoice : invoices) {
			entityCache.removeResult(InvoiceImpl.class, invoice);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(InvoiceImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(InvoiceImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new invoice with the primary key. Does not add the invoice to the database.
	 *
	 * @param invoiceId the primary key for the new invoice
	 * @return the new invoice
	 */
	@Override
	public Invoice create(long invoiceId) {
		Invoice invoice = new InvoiceImpl();

		invoice.setNew(true);
		invoice.setPrimaryKey(invoiceId);

		return invoice;
	}

	/**
	 * Removes the invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invoiceId the primary key of the invoice
	 * @return the invoice that was removed
	 * @throws NoSuchInvoiceException if a invoice with the primary key could not be found
	 */
	@Override
	public Invoice remove(long invoiceId) throws NoSuchInvoiceException {
		return remove((Serializable)invoiceId);
	}

	/**
	 * Removes the invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the invoice
	 * @return the invoice that was removed
	 * @throws NoSuchInvoiceException if a invoice with the primary key could not be found
	 */
	@Override
	public Invoice remove(Serializable primaryKey)
		throws NoSuchInvoiceException {

		Session session = null;

		try {
			session = openSession();

			Invoice invoice = (Invoice)session.get(
				InvoiceImpl.class, primaryKey);

			if (invoice == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInvoiceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(invoice);
		}
		catch (NoSuchInvoiceException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Invoice removeImpl(Invoice invoice) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(invoice)) {
				invoice = (Invoice)session.get(
					InvoiceImpl.class, invoice.getPrimaryKeyObj());
			}

			if (invoice != null) {
				session.delete(invoice);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (invoice != null) {
			clearCache(invoice);
		}

		return invoice;
	}

	@Override
	public Invoice updateImpl(Invoice invoice) {
		boolean isNew = invoice.isNew();

		if (!(invoice instanceof InvoiceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(invoice.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(invoice);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in invoice proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Invoice implementation " +
					invoice.getClass());
		}

		InvoiceModelImpl invoiceModelImpl = (InvoiceModelImpl)invoice;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(invoice);
			}
			else {
				invoice = (Invoice)session.merge(invoice);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(InvoiceImpl.class, invoiceModelImpl, false, true);

		if (isNew) {
			invoice.setNew(false);
		}

		invoice.resetOriginalValues();

		return invoice;
	}

	/**
	 * Returns the invoice with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the invoice
	 * @return the invoice
	 * @throws NoSuchInvoiceException if a invoice with the primary key could not be found
	 */
	@Override
	public Invoice findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInvoiceException {

		Invoice invoice = fetchByPrimaryKey(primaryKey);

		if (invoice == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInvoiceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return invoice;
	}

	/**
	 * Returns the invoice with the primary key or throws a <code>NoSuchInvoiceException</code> if it could not be found.
	 *
	 * @param invoiceId the primary key of the invoice
	 * @return the invoice
	 * @throws NoSuchInvoiceException if a invoice with the primary key could not be found
	 */
	@Override
	public Invoice findByPrimaryKey(long invoiceId)
		throws NoSuchInvoiceException {

		return findByPrimaryKey((Serializable)invoiceId);
	}

	/**
	 * Returns the invoice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param invoiceId the primary key of the invoice
	 * @return the invoice, or <code>null</code> if a invoice with the primary key could not be found
	 */
	@Override
	public Invoice fetchByPrimaryKey(long invoiceId) {
		return fetchByPrimaryKey((Serializable)invoiceId);
	}

	/**
	 * Returns all the invoices.
	 *
	 * @return the invoices
	 */
	@Override
	public List<Invoice> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of invoices
	 * @param end the upper bound of the range of invoices (not inclusive)
	 * @return the range of invoices
	 */
	@Override
	public List<Invoice> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of invoices
	 * @param end the upper bound of the range of invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of invoices
	 */
	@Override
	public List<Invoice> findAll(
		int start, int end, OrderByComparator<Invoice> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>InvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of invoices
	 * @param end the upper bound of the range of invoices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of invoices
	 */
	@Override
	public List<Invoice> findAll(
		int start, int end, OrderByComparator<Invoice> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Invoice> list = null;

		if (useFinderCache) {
			list = (List<Invoice>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_INVOICE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_INVOICE;

				sql = sql.concat(InvoiceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Invoice>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the invoices from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Invoice invoice : findAll()) {
			remove(invoice);
		}
	}

	/**
	 * Returns the number of invoices.
	 *
	 * @return the number of invoices
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_INVOICE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "invoiceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_INVOICE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return InvoiceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the invoice persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByInvoiceNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInvoiceNumber",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"invoiceNumber"}, true);

		_finderPathWithoutPaginationFindByInvoiceNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInvoiceNumber",
			new String[] {String.class.getName()},
			new String[] {"invoiceNumber"}, true);

		_finderPathCountByInvoiceNumber = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInvoiceNumber",
			new String[] {String.class.getName()},
			new String[] {"invoiceNumber"}, false);

		_setInvoiceUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setInvoiceUtilPersistence(null);

		entityCache.removeCache(InvoiceImpl.class.getName());
	}

	private void _setInvoiceUtilPersistence(
		InvoicePersistence invoicePersistence) {

		try {
			Field field = InvoiceUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, invoicePersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = InvoiceServicePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = InvoiceServicePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = InvoiceServicePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_INVOICE =
		"SELECT invoice FROM Invoice invoice";

	private static final String _SQL_SELECT_INVOICE_WHERE =
		"SELECT invoice FROM Invoice invoice WHERE ";

	private static final String _SQL_COUNT_INVOICE =
		"SELECT COUNT(invoice) FROM Invoice invoice";

	private static final String _SQL_COUNT_INVOICE_WHERE =
		"SELECT COUNT(invoice) FROM Invoice invoice WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "invoice.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Invoice exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Invoice exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		InvoicePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private InvoiceModelArgumentsResolver _invoiceModelArgumentsResolver;

}
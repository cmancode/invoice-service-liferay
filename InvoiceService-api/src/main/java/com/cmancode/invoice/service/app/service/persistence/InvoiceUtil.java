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

package com.cmancode.invoice.service.app.service.persistence;

import com.cmancode.invoice.service.app.model.Invoice;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the invoice service. This utility wraps <code>com.cmancode.invoice.service.app.service.persistence.impl.InvoicePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvoicePersistence
 * @generated
 */
public class InvoiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Invoice invoice) {
		getPersistence().clearCache(invoice);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Invoice> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Invoice> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Invoice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Invoice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Invoice> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Invoice update(Invoice invoice) {
		return getPersistence().update(invoice);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Invoice update(
		Invoice invoice, ServiceContext serviceContext) {

		return getPersistence().update(invoice, serviceContext);
	}

	/**
	 * Returns all the invoices where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @return the matching invoices
	 */
	public static List<Invoice> findByInvoiceNumber(String invoiceNumber) {
		return getPersistence().findByInvoiceNumber(invoiceNumber);
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
	public static List<Invoice> findByInvoiceNumber(
		String invoiceNumber, int start, int end) {

		return getPersistence().findByInvoiceNumber(invoiceNumber, start, end);
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
	public static List<Invoice> findByInvoiceNumber(
		String invoiceNumber, int start, int end,
		OrderByComparator<Invoice> orderByComparator) {

		return getPersistence().findByInvoiceNumber(
			invoiceNumber, start, end, orderByComparator);
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
	public static List<Invoice> findByInvoiceNumber(
		String invoiceNumber, int start, int end,
		OrderByComparator<Invoice> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByInvoiceNumber(
			invoiceNumber, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first invoice in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invoice
	 * @throws NoSuchInvoiceException if a matching invoice could not be found
	 */
	public static Invoice findByInvoiceNumber_First(
			String invoiceNumber, OrderByComparator<Invoice> orderByComparator)
		throws com.cmancode.invoice.service.app.exception.
			NoSuchInvoiceException {

		return getPersistence().findByInvoiceNumber_First(
			invoiceNumber, orderByComparator);
	}

	/**
	 * Returns the first invoice in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invoice, or <code>null</code> if a matching invoice could not be found
	 */
	public static Invoice fetchByInvoiceNumber_First(
		String invoiceNumber, OrderByComparator<Invoice> orderByComparator) {

		return getPersistence().fetchByInvoiceNumber_First(
			invoiceNumber, orderByComparator);
	}

	/**
	 * Returns the last invoice in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invoice
	 * @throws NoSuchInvoiceException if a matching invoice could not be found
	 */
	public static Invoice findByInvoiceNumber_Last(
			String invoiceNumber, OrderByComparator<Invoice> orderByComparator)
		throws com.cmancode.invoice.service.app.exception.
			NoSuchInvoiceException {

		return getPersistence().findByInvoiceNumber_Last(
			invoiceNumber, orderByComparator);
	}

	/**
	 * Returns the last invoice in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invoice, or <code>null</code> if a matching invoice could not be found
	 */
	public static Invoice fetchByInvoiceNumber_Last(
		String invoiceNumber, OrderByComparator<Invoice> orderByComparator) {

		return getPersistence().fetchByInvoiceNumber_Last(
			invoiceNumber, orderByComparator);
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
	public static Invoice[] findByInvoiceNumber_PrevAndNext(
			long invoiceId, String invoiceNumber,
			OrderByComparator<Invoice> orderByComparator)
		throws com.cmancode.invoice.service.app.exception.
			NoSuchInvoiceException {

		return getPersistence().findByInvoiceNumber_PrevAndNext(
			invoiceId, invoiceNumber, orderByComparator);
	}

	/**
	 * Removes all the invoices where invoiceNumber = &#63; from the database.
	 *
	 * @param invoiceNumber the invoice number
	 */
	public static void removeByInvoiceNumber(String invoiceNumber) {
		getPersistence().removeByInvoiceNumber(invoiceNumber);
	}

	/**
	 * Returns the number of invoices where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @return the number of matching invoices
	 */
	public static int countByInvoiceNumber(String invoiceNumber) {
		return getPersistence().countByInvoiceNumber(invoiceNumber);
	}

	/**
	 * Caches the invoice in the entity cache if it is enabled.
	 *
	 * @param invoice the invoice
	 */
	public static void cacheResult(Invoice invoice) {
		getPersistence().cacheResult(invoice);
	}

	/**
	 * Caches the invoices in the entity cache if it is enabled.
	 *
	 * @param invoices the invoices
	 */
	public static void cacheResult(List<Invoice> invoices) {
		getPersistence().cacheResult(invoices);
	}

	/**
	 * Creates a new invoice with the primary key. Does not add the invoice to the database.
	 *
	 * @param invoiceId the primary key for the new invoice
	 * @return the new invoice
	 */
	public static Invoice create(long invoiceId) {
		return getPersistence().create(invoiceId);
	}

	/**
	 * Removes the invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invoiceId the primary key of the invoice
	 * @return the invoice that was removed
	 * @throws NoSuchInvoiceException if a invoice with the primary key could not be found
	 */
	public static Invoice remove(long invoiceId)
		throws com.cmancode.invoice.service.app.exception.
			NoSuchInvoiceException {

		return getPersistence().remove(invoiceId);
	}

	public static Invoice updateImpl(Invoice invoice) {
		return getPersistence().updateImpl(invoice);
	}

	/**
	 * Returns the invoice with the primary key or throws a <code>NoSuchInvoiceException</code> if it could not be found.
	 *
	 * @param invoiceId the primary key of the invoice
	 * @return the invoice
	 * @throws NoSuchInvoiceException if a invoice with the primary key could not be found
	 */
	public static Invoice findByPrimaryKey(long invoiceId)
		throws com.cmancode.invoice.service.app.exception.
			NoSuchInvoiceException {

		return getPersistence().findByPrimaryKey(invoiceId);
	}

	/**
	 * Returns the invoice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param invoiceId the primary key of the invoice
	 * @return the invoice, or <code>null</code> if a invoice with the primary key could not be found
	 */
	public static Invoice fetchByPrimaryKey(long invoiceId) {
		return getPersistence().fetchByPrimaryKey(invoiceId);
	}

	/**
	 * Returns all the invoices.
	 *
	 * @return the invoices
	 */
	public static List<Invoice> findAll() {
		return getPersistence().findAll();
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
	public static List<Invoice> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Invoice> findAll(
		int start, int end, OrderByComparator<Invoice> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<Invoice> findAll(
		int start, int end, OrderByComparator<Invoice> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the invoices from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of invoices.
	 *
	 * @return the number of invoices
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static InvoicePersistence getPersistence() {
		return _persistence;
	}

	private static volatile InvoicePersistence _persistence;

}
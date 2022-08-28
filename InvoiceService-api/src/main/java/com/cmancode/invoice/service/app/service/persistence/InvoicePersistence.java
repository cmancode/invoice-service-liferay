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

import com.cmancode.invoice.service.app.exception.NoSuchInvoiceException;
import com.cmancode.invoice.service.app.model.Invoice;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the invoice service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvoiceUtil
 * @generated
 */
@ProviderType
public interface InvoicePersistence extends BasePersistence<Invoice> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InvoiceUtil} to access the invoice persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the invoices where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @return the matching invoices
	 */
	public java.util.List<Invoice> findByInvoiceNumber(String invoiceNumber);

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
	public java.util.List<Invoice> findByInvoiceNumber(
		String invoiceNumber, int start, int end);

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
	public java.util.List<Invoice> findByInvoiceNumber(
		String invoiceNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Invoice>
			orderByComparator);

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
	public java.util.List<Invoice> findByInvoiceNumber(
		String invoiceNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Invoice>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first invoice in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invoice
	 * @throws NoSuchInvoiceException if a matching invoice could not be found
	 */
	public Invoice findByInvoiceNumber_First(
			String invoiceNumber,
			com.liferay.portal.kernel.util.OrderByComparator<Invoice>
				orderByComparator)
		throws NoSuchInvoiceException;

	/**
	 * Returns the first invoice in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching invoice, or <code>null</code> if a matching invoice could not be found
	 */
	public Invoice fetchByInvoiceNumber_First(
		String invoiceNumber,
		com.liferay.portal.kernel.util.OrderByComparator<Invoice>
			orderByComparator);

	/**
	 * Returns the last invoice in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invoice
	 * @throws NoSuchInvoiceException if a matching invoice could not be found
	 */
	public Invoice findByInvoiceNumber_Last(
			String invoiceNumber,
			com.liferay.portal.kernel.util.OrderByComparator<Invoice>
				orderByComparator)
		throws NoSuchInvoiceException;

	/**
	 * Returns the last invoice in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching invoice, or <code>null</code> if a matching invoice could not be found
	 */
	public Invoice fetchByInvoiceNumber_Last(
		String invoiceNumber,
		com.liferay.portal.kernel.util.OrderByComparator<Invoice>
			orderByComparator);

	/**
	 * Returns the invoices before and after the current invoice in the ordered set where invoiceNumber = &#63;.
	 *
	 * @param invoiceId the primary key of the current invoice
	 * @param invoiceNumber the invoice number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next invoice
	 * @throws NoSuchInvoiceException if a invoice with the primary key could not be found
	 */
	public Invoice[] findByInvoiceNumber_PrevAndNext(
			long invoiceId, String invoiceNumber,
			com.liferay.portal.kernel.util.OrderByComparator<Invoice>
				orderByComparator)
		throws NoSuchInvoiceException;

	/**
	 * Removes all the invoices where invoiceNumber = &#63; from the database.
	 *
	 * @param invoiceNumber the invoice number
	 */
	public void removeByInvoiceNumber(String invoiceNumber);

	/**
	 * Returns the number of invoices where invoiceNumber = &#63;.
	 *
	 * @param invoiceNumber the invoice number
	 * @return the number of matching invoices
	 */
	public int countByInvoiceNumber(String invoiceNumber);

	/**
	 * Caches the invoice in the entity cache if it is enabled.
	 *
	 * @param invoice the invoice
	 */
	public void cacheResult(Invoice invoice);

	/**
	 * Caches the invoices in the entity cache if it is enabled.
	 *
	 * @param invoices the invoices
	 */
	public void cacheResult(java.util.List<Invoice> invoices);

	/**
	 * Creates a new invoice with the primary key. Does not add the invoice to the database.
	 *
	 * @param invoiceId the primary key for the new invoice
	 * @return the new invoice
	 */
	public Invoice create(long invoiceId);

	/**
	 * Removes the invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param invoiceId the primary key of the invoice
	 * @return the invoice that was removed
	 * @throws NoSuchInvoiceException if a invoice with the primary key could not be found
	 */
	public Invoice remove(long invoiceId) throws NoSuchInvoiceException;

	public Invoice updateImpl(Invoice invoice);

	/**
	 * Returns the invoice with the primary key or throws a <code>NoSuchInvoiceException</code> if it could not be found.
	 *
	 * @param invoiceId the primary key of the invoice
	 * @return the invoice
	 * @throws NoSuchInvoiceException if a invoice with the primary key could not be found
	 */
	public Invoice findByPrimaryKey(long invoiceId)
		throws NoSuchInvoiceException;

	/**
	 * Returns the invoice with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param invoiceId the primary key of the invoice
	 * @return the invoice, or <code>null</code> if a invoice with the primary key could not be found
	 */
	public Invoice fetchByPrimaryKey(long invoiceId);

	/**
	 * Returns all the invoices.
	 *
	 * @return the invoices
	 */
	public java.util.List<Invoice> findAll();

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
	public java.util.List<Invoice> findAll(int start, int end);

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
	public java.util.List<Invoice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Invoice>
			orderByComparator);

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
	public java.util.List<Invoice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Invoice>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the invoices from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of invoices.
	 *
	 * @return the number of invoices
	 */
	public int countAll();

}
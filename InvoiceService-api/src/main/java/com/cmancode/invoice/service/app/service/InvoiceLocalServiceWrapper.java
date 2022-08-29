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

package com.cmancode.invoice.service.app.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link InvoiceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see InvoiceLocalService
 * @generated
 */
public class InvoiceLocalServiceWrapper
	implements InvoiceLocalService, ServiceWrapper<InvoiceLocalService> {

	public InvoiceLocalServiceWrapper() {
		this(null);
	}

	public InvoiceLocalServiceWrapper(InvoiceLocalService invoiceLocalService) {
		_invoiceLocalService = invoiceLocalService;
	}

	/**
	 * Adds the invoice to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InvoiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param invoice the invoice
	 * @return the invoice that was added
	 */
	@Override
	public com.cmancode.invoice.service.app.model.Invoice addInvoice(
		com.cmancode.invoice.service.app.model.Invoice invoice) {

		return _invoiceLocalService.addInvoice(invoice);
	}

	@Override
	public com.cmancode.invoice.service.app.model.Invoice addInvoice(
		String invoiceNumber, String client, String total,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _invoiceLocalService.addInvoice(
			invoiceNumber, client, total, serviceContext);
	}

	/**
	 * Creates a new invoice with the primary key. Does not add the invoice to the database.
	 *
	 * @param invoiceId the primary key for the new invoice
	 * @return the new invoice
	 */
	@Override
	public com.cmancode.invoice.service.app.model.Invoice createInvoice(
		long invoiceId) {

		return _invoiceLocalService.createInvoice(invoiceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _invoiceLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the invoice from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InvoiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param invoice the invoice
	 * @return the invoice that was removed
	 */
	@Override
	public com.cmancode.invoice.service.app.model.Invoice deleteInvoice(
		com.cmancode.invoice.service.app.model.Invoice invoice) {

		return _invoiceLocalService.deleteInvoice(invoice);
	}

	/**
	 * Deletes the invoice with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InvoiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param invoiceId the primary key of the invoice
	 * @return the invoice that was removed
	 * @throws PortalException if a invoice with the primary key could not be found
	 */
	@Override
	public com.cmancode.invoice.service.app.model.Invoice deleteInvoice(
			long invoiceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _invoiceLocalService.deleteInvoice(invoiceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _invoiceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _invoiceLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _invoiceLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _invoiceLocalService.dynamicQuery();
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

		return _invoiceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.cmancode.invoice.service.app.model.impl.InvoiceModelImpl</code>.
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

		return _invoiceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.cmancode.invoice.service.app.model.impl.InvoiceModelImpl</code>.
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

		return _invoiceLocalService.dynamicQuery(
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

		return _invoiceLocalService.dynamicQueryCount(dynamicQuery);
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

		return _invoiceLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.cmancode.invoice.service.app.model.Invoice fetchInvoice(
		long invoiceId) {

		return _invoiceLocalService.fetchInvoice(invoiceId);
	}

	@Override
	public java.util.List<com.cmancode.invoice.service.app.model.Invoice>
		findInvoices() {

		return _invoiceLocalService.findInvoices();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _invoiceLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _invoiceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the invoice with the primary key.
	 *
	 * @param invoiceId the primary key of the invoice
	 * @return the invoice
	 * @throws PortalException if a invoice with the primary key could not be found
	 */
	@Override
	public com.cmancode.invoice.service.app.model.Invoice getInvoice(
			long invoiceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _invoiceLocalService.getInvoice(invoiceId);
	}

	/**
	 * Returns a range of all the invoices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.cmancode.invoice.service.app.model.impl.InvoiceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of invoices
	 * @param end the upper bound of the range of invoices (not inclusive)
	 * @return the range of invoices
	 */
	@Override
	public java.util.List<com.cmancode.invoice.service.app.model.Invoice>
		getInvoices(int start, int end) {

		return _invoiceLocalService.getInvoices(start, end);
	}

	/**
	 * Returns the number of invoices.
	 *
	 * @return the number of invoices
	 */
	@Override
	public int getInvoicesCount() {
		return _invoiceLocalService.getInvoicesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _invoiceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _invoiceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the invoice in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InvoiceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param invoice the invoice
	 * @return the invoice that was updated
	 */
	@Override
	public com.cmancode.invoice.service.app.model.Invoice updateInvoice(
		com.cmancode.invoice.service.app.model.Invoice invoice) {

		return _invoiceLocalService.updateInvoice(invoice);
	}

	@Override
	public com.cmancode.invoice.service.app.model.Invoice updateInvoice(
			long invoiceId, String invoiceNumber, String client, String total,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _invoiceLocalService.updateInvoice(
			invoiceId, invoiceNumber, client, total, serviceContext);
	}

	@Override
	public InvoiceLocalService getWrappedService() {
		return _invoiceLocalService;
	}

	@Override
	public void setWrappedService(InvoiceLocalService invoiceLocalService) {
		_invoiceLocalService = invoiceLocalService;
	}

	private InvoiceLocalService _invoiceLocalService;

}
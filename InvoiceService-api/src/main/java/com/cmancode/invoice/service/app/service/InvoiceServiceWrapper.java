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
 * Provides a wrapper for {@link InvoiceService}.
 *
 * @author Brian Wing Shun Chan
 * @see InvoiceService
 * @generated
 */
public class InvoiceServiceWrapper
	implements InvoiceService, ServiceWrapper<InvoiceService> {

	public InvoiceServiceWrapper() {
		this(null);
	}

	public InvoiceServiceWrapper(InvoiceService invoiceService) {
		_invoiceService = invoiceService;
	}

	@Override
	public com.cmancode.invoice.service.app.model.Invoice addInvoice(
		String invoiceNumber, String client, String total,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		return _invoiceService.addInvoice(
			invoiceNumber, client, total, serviceContext);
	}

	@Override
	public com.cmancode.invoice.service.app.model.Invoice findInvoiceById(
		long invoiceId) {

		return _invoiceService.findInvoiceById(invoiceId);
	}

	@Override
	public java.util.List<com.cmancode.invoice.service.app.model.Invoice>
		findInvoices() {

		return _invoiceService.findInvoices();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _invoiceService.getOSGiServiceIdentifier();
	}

	@Override
	public com.cmancode.invoice.service.app.model.Invoice updateInvoice(
			long invoiceId, String invoiceNumber, String client, String total,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _invoiceService.updateInvoice(
			invoiceId, invoiceNumber, client, total, serviceContext);
	}

	@Override
	public InvoiceService getWrappedService() {
		return _invoiceService;
	}

	@Override
	public void setWrappedService(InvoiceService invoiceService) {
		_invoiceService = invoiceService;
	}

	private InvoiceService _invoiceService;

}
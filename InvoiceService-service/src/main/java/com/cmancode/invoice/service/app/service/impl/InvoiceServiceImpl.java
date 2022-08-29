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

package com.cmancode.invoice.service.app.service.impl;

import com.cmancode.invoice.service.app.model.Invoice;
import com.cmancode.invoice.service.app.service.base.InvoiceServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=invoiceservice",
		"json.web.service.context.path=Invoice"
	},
	service = AopService.class
)
public class InvoiceServiceImpl extends InvoiceServiceBaseImpl {
	
	public Invoice addInvoice(String invoiceNumber, String client, String total, ServiceContext serviceContext) {
		 return super.invoiceLocalService.addInvoice(invoiceNumber, client, total, serviceContext);
	}
	
	public Invoice updateInvoice(long invoiceId, String invoiceNumber, String client, String total, ServiceContext serviceContext) throws PortalException {
		return super.invoiceLocalService.updateInvoice(invoiceId, invoiceNumber, client, total, serviceContext);
	}
	
	public List<Invoice> findInvoices() {
		return super.invoiceLocalService.findInvoices();
	}
	
	public Invoice findInvoiceById(long invoiceId) {
		return this.invoiceLocalService.findInvoiceById(invoiceId);
	}
	
}
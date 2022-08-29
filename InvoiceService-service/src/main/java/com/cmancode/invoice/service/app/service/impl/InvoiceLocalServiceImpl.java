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
import com.cmancode.invoice.service.app.service.base.InvoiceLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.cmancode.invoice.service.app.model.Invoice",
	service = AopService.class
)
public class InvoiceLocalServiceImpl extends InvoiceLocalServiceBaseImpl {
	
	
	//Method for generate invoice
	public Invoice addInvoice(String invoiceNumber, String client, String total, ServiceContext serviceContext) {
		
		// Increment Id
		long invoiceId = super.counterLocalService.increment(Invoice.class.getName());
		
		// Creating of Invoice with ID generated
		Invoice invoice = super.createInvoice(invoiceId);
		
		//Setting values in attributes in object
		invoice.setInvoiceNumber(invoiceNumber);
		invoice.setClient(client);
		invoice.setTotal(total);
		
		//Adding info in database
		return super.addInvoice(invoice);
	}
	
	public Invoice updateInvoice(long invoiceId, String invoiceNumber, String client, String total, ServiceContext serviceContext) throws PortalException {
		
		Invoice invoice = getInvoice(invoiceId);
		
		invoice.setInvoiceNumber(invoiceNumber);
		invoice.setClient(client);
		invoice.setTotal(total);
		
		return super.updateInvoice(invoice);
	}
	
	public List<Invoice> findInvoices() {
		return super.invoicePersistence.findAll();
	}
	
	public Invoice findInvoiceById(long invoiceId) {
		Invoice invoice = null;
		try {
			invoice = super.getInvoice(invoiceId);
			return invoice;
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	

	}
	
}
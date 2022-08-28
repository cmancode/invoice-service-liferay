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

package com.cmancode.invoice.service.app.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Invoice}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Invoice
 * @generated
 */
public class InvoiceWrapper
	extends BaseModelWrapper<Invoice>
	implements Invoice, ModelWrapper<Invoice> {

	public InvoiceWrapper(Invoice invoice) {
		super(invoice);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("invoiceId", getInvoiceId());
		attributes.put("invoiceNumber", getInvoiceNumber());
		attributes.put("client", getClient());
		attributes.put("total", getTotal());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long invoiceId = (Long)attributes.get("invoiceId");

		if (invoiceId != null) {
			setInvoiceId(invoiceId);
		}

		String invoiceNumber = (String)attributes.get("invoiceNumber");

		if (invoiceNumber != null) {
			setInvoiceNumber(invoiceNumber);
		}

		String client = (String)attributes.get("client");

		if (client != null) {
			setClient(client);
		}

		String total = (String)attributes.get("total");

		if (total != null) {
			setTotal(total);
		}
	}

	@Override
	public Invoice cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the client of this invoice.
	 *
	 * @return the client of this invoice
	 */
	@Override
	public String getClient() {
		return model.getClient();
	}

	/**
	 * Returns the invoice ID of this invoice.
	 *
	 * @return the invoice ID of this invoice
	 */
	@Override
	public long getInvoiceId() {
		return model.getInvoiceId();
	}

	/**
	 * Returns the invoice number of this invoice.
	 *
	 * @return the invoice number of this invoice
	 */
	@Override
	public String getInvoiceNumber() {
		return model.getInvoiceNumber();
	}

	/**
	 * Returns the primary key of this invoice.
	 *
	 * @return the primary key of this invoice
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the total of this invoice.
	 *
	 * @return the total of this invoice
	 */
	@Override
	public String getTotal() {
		return model.getTotal();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the client of this invoice.
	 *
	 * @param client the client of this invoice
	 */
	@Override
	public void setClient(String client) {
		model.setClient(client);
	}

	/**
	 * Sets the invoice ID of this invoice.
	 *
	 * @param invoiceId the invoice ID of this invoice
	 */
	@Override
	public void setInvoiceId(long invoiceId) {
		model.setInvoiceId(invoiceId);
	}

	/**
	 * Sets the invoice number of this invoice.
	 *
	 * @param invoiceNumber the invoice number of this invoice
	 */
	@Override
	public void setInvoiceNumber(String invoiceNumber) {
		model.setInvoiceNumber(invoiceNumber);
	}

	/**
	 * Sets the primary key of this invoice.
	 *
	 * @param primaryKey the primary key of this invoice
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the total of this invoice.
	 *
	 * @param total the total of this invoice
	 */
	@Override
	public void setTotal(String total) {
		model.setTotal(total);
	}

	@Override
	protected InvoiceWrapper wrap(Invoice invoice) {
		return new InvoiceWrapper(invoice);
	}

}
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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Invoice service. Represents a row in the &quot;InvoiceService_Invoice&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.cmancode.invoice.service.app.model.impl.InvoiceModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.cmancode.invoice.service.app.model.impl.InvoiceImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Invoice
 * @generated
 */
@ProviderType
public interface InvoiceModel extends BaseModel<Invoice> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a invoice model instance should use the {@link Invoice} interface instead.
	 */

	/**
	 * Returns the primary key of this invoice.
	 *
	 * @return the primary key of this invoice
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this invoice.
	 *
	 * @param primaryKey the primary key of this invoice
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the invoice ID of this invoice.
	 *
	 * @return the invoice ID of this invoice
	 */
	public long getInvoiceId();

	/**
	 * Sets the invoice ID of this invoice.
	 *
	 * @param invoiceId the invoice ID of this invoice
	 */
	public void setInvoiceId(long invoiceId);

	/**
	 * Returns the invoice number of this invoice.
	 *
	 * @return the invoice number of this invoice
	 */
	@AutoEscape
	public String getInvoiceNumber();

	/**
	 * Sets the invoice number of this invoice.
	 *
	 * @param invoiceNumber the invoice number of this invoice
	 */
	public void setInvoiceNumber(String invoiceNumber);

	/**
	 * Returns the client of this invoice.
	 *
	 * @return the client of this invoice
	 */
	@AutoEscape
	public String getClient();

	/**
	 * Sets the client of this invoice.
	 *
	 * @param client the client of this invoice
	 */
	public void setClient(String client);

	/**
	 * Returns the total of this invoice.
	 *
	 * @return the total of this invoice
	 */
	@AutoEscape
	public String getTotal();

	/**
	 * Sets the total of this invoice.
	 *
	 * @param total the total of this invoice
	 */
	public void setTotal(String total);

	@Override
	public Invoice cloneWithOriginalValues();

}
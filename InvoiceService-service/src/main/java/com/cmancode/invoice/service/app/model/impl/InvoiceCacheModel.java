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

package com.cmancode.invoice.service.app.model.impl;

import com.cmancode.invoice.service.app.model.Invoice;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Invoice in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class InvoiceCacheModel implements CacheModel<Invoice>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof InvoiceCacheModel)) {
			return false;
		}

		InvoiceCacheModel invoiceCacheModel = (InvoiceCacheModel)object;

		if (invoiceId == invoiceCacheModel.invoiceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, invoiceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{invoiceId=");
		sb.append(invoiceId);
		sb.append(", invoiceNumber=");
		sb.append(invoiceNumber);
		sb.append(", client=");
		sb.append(client);
		sb.append(", total=");
		sb.append(total);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Invoice toEntityModel() {
		InvoiceImpl invoiceImpl = new InvoiceImpl();

		invoiceImpl.setInvoiceId(invoiceId);

		if (invoiceNumber == null) {
			invoiceImpl.setInvoiceNumber("");
		}
		else {
			invoiceImpl.setInvoiceNumber(invoiceNumber);
		}

		if (client == null) {
			invoiceImpl.setClient("");
		}
		else {
			invoiceImpl.setClient(client);
		}

		if (total == null) {
			invoiceImpl.setTotal("");
		}
		else {
			invoiceImpl.setTotal(total);
		}

		invoiceImpl.resetOriginalValues();

		return invoiceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		invoiceId = objectInput.readLong();
		invoiceNumber = objectInput.readUTF();
		client = objectInput.readUTF();
		total = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(invoiceId);

		if (invoiceNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(invoiceNumber);
		}

		if (client == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(client);
		}

		if (total == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(total);
		}
	}

	public long invoiceId;
	public String invoiceNumber;
	public String client;
	public String total;

}
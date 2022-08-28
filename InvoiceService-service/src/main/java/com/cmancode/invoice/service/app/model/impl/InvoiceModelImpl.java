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
import com.cmancode.invoice.service.app.model.InvoiceModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Invoice service. Represents a row in the &quot;InvoiceService_Invoice&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>InvoiceModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link InvoiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see InvoiceImpl
 * @generated
 */
@JSON(strict = true)
public class InvoiceModelImpl
	extends BaseModelImpl<Invoice> implements InvoiceModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a invoice model instance should use the <code>Invoice</code> interface instead.
	 */
	public static final String TABLE_NAME = "InvoiceService_Invoice";

	public static final Object[][] TABLE_COLUMNS = {
		{"invoiceId", Types.BIGINT}, {"invoiceNumber", Types.VARCHAR},
		{"client", Types.VARCHAR}, {"total", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("invoiceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("invoiceNumber", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("client", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("total", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table InvoiceService_Invoice (invoiceId LONG not null primary key,invoiceNumber VARCHAR(75) null,client VARCHAR(75) null,total VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table InvoiceService_Invoice";

	public static final String ORDER_BY_JPQL =
		" ORDER BY invoice.invoiceId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY InvoiceService_Invoice.invoiceId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long INVOICENUMBER_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long INVOICEID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public InvoiceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _invoiceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInvoiceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _invoiceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Invoice.class;
	}

	@Override
	public String getModelClassName() {
		return Invoice.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Invoice, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Invoice, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Invoice, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Invoice)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Invoice, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Invoice, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Invoice)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Invoice, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Invoice, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<Invoice, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Invoice, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Invoice, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Invoice, Object>>();
		Map<String, BiConsumer<Invoice, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Invoice, ?>>();

		attributeGetterFunctions.put("invoiceId", Invoice::getInvoiceId);
		attributeSetterBiConsumers.put(
			"invoiceId", (BiConsumer<Invoice, Long>)Invoice::setInvoiceId);
		attributeGetterFunctions.put(
			"invoiceNumber", Invoice::getInvoiceNumber);
		attributeSetterBiConsumers.put(
			"invoiceNumber",
			(BiConsumer<Invoice, String>)Invoice::setInvoiceNumber);
		attributeGetterFunctions.put("client", Invoice::getClient);
		attributeSetterBiConsumers.put(
			"client", (BiConsumer<Invoice, String>)Invoice::setClient);
		attributeGetterFunctions.put("total", Invoice::getTotal);
		attributeSetterBiConsumers.put(
			"total", (BiConsumer<Invoice, String>)Invoice::setTotal);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getInvoiceId() {
		return _invoiceId;
	}

	@Override
	public void setInvoiceId(long invoiceId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_invoiceId = invoiceId;
	}

	@JSON
	@Override
	public String getInvoiceNumber() {
		if (_invoiceNumber == null) {
			return "";
		}
		else {
			return _invoiceNumber;
		}
	}

	@Override
	public void setInvoiceNumber(String invoiceNumber) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_invoiceNumber = invoiceNumber;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalInvoiceNumber() {
		return getColumnOriginalValue("invoiceNumber");
	}

	@JSON
	@Override
	public String getClient() {
		if (_client == null) {
			return "";
		}
		else {
			return _client;
		}
	}

	@Override
	public void setClient(String client) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_client = client;
	}

	@JSON
	@Override
	public String getTotal() {
		if (_total == null) {
			return "";
		}
		else {
			return _total;
		}
	}

	@Override
	public void setTotal(String total) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_total = total;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Invoice.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Invoice toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Invoice>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		InvoiceImpl invoiceImpl = new InvoiceImpl();

		invoiceImpl.setInvoiceId(getInvoiceId());
		invoiceImpl.setInvoiceNumber(getInvoiceNumber());
		invoiceImpl.setClient(getClient());
		invoiceImpl.setTotal(getTotal());

		invoiceImpl.resetOriginalValues();

		return invoiceImpl;
	}

	@Override
	public Invoice cloneWithOriginalValues() {
		InvoiceImpl invoiceImpl = new InvoiceImpl();

		invoiceImpl.setInvoiceId(
			this.<Long>getColumnOriginalValue("invoiceId"));
		invoiceImpl.setInvoiceNumber(
			this.<String>getColumnOriginalValue("invoiceNumber"));
		invoiceImpl.setClient(this.<String>getColumnOriginalValue("client"));
		invoiceImpl.setTotal(this.<String>getColumnOriginalValue("total"));

		return invoiceImpl;
	}

	@Override
	public int compareTo(Invoice invoice) {
		long primaryKey = invoice.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Invoice)) {
			return false;
		}

		Invoice invoice = (Invoice)object;

		long primaryKey = invoice.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Invoice> toCacheModel() {
		InvoiceCacheModel invoiceCacheModel = new InvoiceCacheModel();

		invoiceCacheModel.invoiceId = getInvoiceId();

		invoiceCacheModel.invoiceNumber = getInvoiceNumber();

		String invoiceNumber = invoiceCacheModel.invoiceNumber;

		if ((invoiceNumber != null) && (invoiceNumber.length() == 0)) {
			invoiceCacheModel.invoiceNumber = null;
		}

		invoiceCacheModel.client = getClient();

		String client = invoiceCacheModel.client;

		if ((client != null) && (client.length() == 0)) {
			invoiceCacheModel.client = null;
		}

		invoiceCacheModel.total = getTotal();

		String total = invoiceCacheModel.total;

		if ((total != null) && (total.length() == 0)) {
			invoiceCacheModel.total = null;
		}

		return invoiceCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Invoice, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Invoice, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Invoice, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Invoice)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Invoice, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Invoice, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Invoice, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Invoice)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Invoice>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Invoice.class, ModelWrapper.class);

	}

	private long _invoiceId;
	private String _invoiceNumber;
	private String _client;
	private String _total;

	public <T> T getColumnValue(String columnName) {
		Function<Invoice, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Invoice)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("invoiceId", _invoiceId);
		_columnOriginalValues.put("invoiceNumber", _invoiceNumber);
		_columnOriginalValues.put("client", _client);
		_columnOriginalValues.put("total", _total);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("invoiceId", 1L);

		columnBitmasks.put("invoiceNumber", 2L);

		columnBitmasks.put("client", 4L);

		columnBitmasks.put("total", 8L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Invoice _escapedModel;

}
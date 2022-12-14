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

package com.cmancode.invoice.service.app.service.http;

import com.cmancode.invoice.service.app.service.InvoiceServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>InvoiceServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class InvoiceServiceHttp {

	public static com.cmancode.invoice.service.app.model.Invoice addInvoice(
		HttpPrincipal httpPrincipal, String invoiceNumber, String client,
		String total,
		com.liferay.portal.kernel.service.ServiceContext serviceContext) {

		try {
			MethodKey methodKey = new MethodKey(
				InvoiceServiceUtil.class, "addInvoice",
				_addInvoiceParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, invoiceNumber, client, total, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.cmancode.invoice.service.app.model.Invoice)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.cmancode.invoice.service.app.model.Invoice updateInvoice(
			HttpPrincipal httpPrincipal, long invoiceId, String invoiceNumber,
			String client, String total,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				InvoiceServiceUtil.class, "updateInvoice",
				_updateInvoiceParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, invoiceId, invoiceNumber, client, total,
				serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.cmancode.invoice.service.app.model.Invoice)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.cmancode.invoice.service.app.model.Invoice>
		findInvoices(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				InvoiceServiceUtil.class, "findInvoices",
				_findInvoicesParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.cmancode.invoice.service.app.model.Invoice>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.cmancode.invoice.service.app.model.Invoice
		findInvoiceById(HttpPrincipal httpPrincipal, long invoiceId) {

		try {
			MethodKey methodKey = new MethodKey(
				InvoiceServiceUtil.class, "findInvoiceById",
				_findInvoiceByIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, invoiceId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.cmancode.invoice.service.app.model.Invoice)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(InvoiceServiceHttp.class);

	private static final Class<?>[] _addInvoiceParameterTypes0 = new Class[] {
		String.class, String.class, String.class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _updateInvoiceParameterTypes1 =
		new Class[] {
			long.class, String.class, String.class, String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _findInvoicesParameterTypes2 =
		new Class[] {};
	private static final Class<?>[] _findInvoiceByIdParameterTypes3 =
		new Class[] {long.class};

}
create table InvoiceService_Invoice (
	invoiceId LONG not null primary key,
	invoiceNumber VARCHAR(75) null,
	client VARCHAR(75) null,
	total VARCHAR(75) null
);
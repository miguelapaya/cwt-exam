package com.exam.cwttest.builder;

import com.exam.cwttest.model.from.AccountingLineXYZ;
import com.exam.cwttest.to.AccountingLine;
import com.exam.cwttest.to.AccountingLineStatus;
import com.exam.cwttest.to.MonetaryAmount;
import com.exam.cwttest.to.MonetaryPercentage;

import javax.persistence.ElementCollection;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AccountingLineBuilder {

    @Id
    // @NotNull(message = "ID cannot be blank!")
    private String accountingLineID;

    // @NotNull(message = "AccountingLineStatus cannot be blank!")
    private AccountingLineStatus accountingLineStatus;

    // @NotNull(message = "VendorCode cannot be null or blank!")
    private String accountingVendorCode;

    //  @NotNull(message = "AirLineCode cannot be null or blank!")
    private String airlineCode;

    // @NotNull(message = "ChargeCategoryCode cannot be null or blank!")
    private String chargeCategoryCode;

    private String formattedReceiptNumber;

    //   @NotNull(message = "InvoiceNumber cannot be null or blank!")
    private String invoiceNumber;

    //  @NotNull(message = "LinkCode cannot be null or blank!")
    private String linkCode;

    //   @NotNull(message = "NumberOfConjuctedDocuments cannot be null or blank!")
    private String numberOfConjunctedDocuments;

    //  @NotNull(message = "OriginalTicketNumber cannot be null or blank!")
    private String originalTicketNumber;

    //  @NotNull(message = "ReceiptNumber cannot be null or blank!")
    private String receiptNumber;

    @ElementCollection
    private List<String> segmentRefIDList = new ArrayList<>();

    private String travelerName;

    @ElementCollection
    private List<String> travelerRefIDList = new ArrayList<>();

    //  @NotNull(message = "typeIndicator cannot be null or blank!")
    private String typeIndicator;

    //  @NotNull(message = "ElementNumber cannot be null or blank!")
    private String elementNumber;

    //   @NotNull(message = "fareApplication cannot be null or blank!")
    private String fareApplication;

    private MonetaryAmount baseFare;

    private MonetaryAmount taxAmount;

    private MonetaryAmount totalTaxAmount;

    private MonetaryAmount totalTaxSurcharge;

    private MonetaryAmount gstAmount;

    private String gstCode;

    private MonetaryAmount qstAmount;

    private String qstCode;

    private MonetaryPercentage commission;

    private String freeFormText;


    public AccountingLine build() {

        AccountingLine accountingLine = new AccountingLine();
        accountingLine.setAccountingLineID(accountingLineID);
        accountingLine.setAccountingLineStatus(AccountingLineStatus.ACTIVE);
        accountingLine.setAccountingVendorCode(accountingVendorCode);
        accountingLine.setChargeCategoryCode(chargeCategoryCode);
        accountingLine.setInvoiceNumber(invoiceNumber);
        accountingLine.setLinkCode(linkCode);
        accountingLine.setNumberOfConjunctedDocuments(numberOfConjunctedDocuments);
        accountingLine.setOriginalTicketNumber(originalTicketNumber);
        accountingLine.setReceiptNumber(receiptNumber);
        accountingLine.setSegmentRefIDList(segmentRefIDList);
        accountingLine.setTravelerName(travelerName);
        accountingLine.setTravelerRefIDList(travelerRefIDList);
        accountingLine.setTypeIndicator(typeIndicator);
        accountingLine.setElementNumber(elementNumber);
        accountingLine.setFareApplication(fareApplication);
        accountingLine.setBaseFare(baseFare);
        accountingLine.setTaxAmount(taxAmount);
        accountingLine.setGstAmount(gstAmount);
        accountingLine.setGstCode(gstCode);
        accountingLine.setQstAmount(qstAmount);
        accountingLine.setQstCode(qstCode);
        accountingLine.setCommission(commission);
        accountingLine.setFreeFormText(freeFormText);
        accountingLine.setTotalTaxSurcharge(totalTaxSurcharge);
        accountingLine.setTotalTaxAmount(totalTaxAmount);


        return accountingLine;

    }

    public AccountingLineBuilder withId(String id) {
        accountingLineID = id;
        return this;
    }

    public AccountingLineBuilder withVendorCode(String vendorCode) {
        accountingVendorCode = vendorCode;
        return this;
    }

    public AccountingLineBuilder withAccountingLineStatus() {
        accountingLineStatus = AccountingLineStatus.ACTIVE;
        return this;
    }

    public AccountingLineBuilder withChargeCategoryCode(String chargeCategoryCode1) {
        chargeCategoryCode = chargeCategoryCode1;
        return this;
    }

    public AccountingLineBuilder withInvoiceNumber(String invoiceNumber1) {
        invoiceNumber = invoiceNumber1;
        return this;
    }

    public AccountingLineBuilder withLinkCode(String linkCode1) {
        linkCode = linkCode1;
        return this;
    }

    public AccountingLineBuilder withNumberOfConjuctedDocument(String numberOfConjunctedDocuments1) {
        numberOfConjunctedDocuments = numberOfConjunctedDocuments1;
        return this;
    }

    public AccountingLineBuilder withOriginalTicketNumber(String orginialTicketNumber1) {
        originalTicketNumber = orginialTicketNumber1;
        return this;
    }

    public AccountingLineBuilder withReceiptNumber(String receiptNumber1) {
        receiptNumber = receiptNumber1;
        return this;
    }

    public AccountingLineBuilder withSegmentRefIdList() {
        AccountingLineXYZ accountingLineXYZ = new AccountingLineXYZ();
        segmentRefIDList.add(accountingLineXYZ.getSegmentNumber());
        return this;
    }

    public AccountingLineBuilder withTravelerName(String travelerName1) {
        travelerName = travelerName1;
        return this;
    }

    public AccountingLineBuilder withTravelerRefIDList() {
        List<String> travelerRefIDList1 = new ArrayList<>();
        travelerRefIDList1.add("1");
        travelerRefIDList = travelerRefIDList1;
        return this;
    }

    public AccountingLineBuilder withTypeIndicator(String typeIndicator1) {
        typeIndicator = typeIndicator1;
        return this;
    }

    public AccountingLineBuilder withElementNumber(String elementNumber1) {
        elementNumber = elementNumber1;
        return this;
    }

    public AccountingLineBuilder withFareApplication(String fareApplication1) {
        fareApplication = fareApplication1;
        return this;
    }

    public AccountingLineBuilder withBaseFare(String b_baseFare, String currencyCode) {
        AccountingLineXYZ accountingLineXYZ = new AccountingLineXYZ();
        MonetaryAmount baseFare1 = new MonetaryAmount();
        baseFare1.setValue((long)Double.parseDouble(b_baseFare));
        baseFare1.setFormattedValue(b_baseFare);
        baseFare1.setCurrencyCode(currencyCode);
        baseFare1.setNumberOfDecimals(b_baseFare.length() - b_baseFare.lastIndexOf('.'));

        baseFare = baseFare1;

        return this;
    }

    public AccountingLineBuilder withTaxAmount(String b_taxAmount, String currencyCode){

        taxAmount = new MonetaryAmount(b_taxAmount, currencyCode,
                ((long)Double.parseDouble(b_taxAmount)),
                b_taxAmount.length() - b_taxAmount
                        .lastIndexOf('.') - 1);

        return this;
    }

    public AccountingLineBuilder withGstAmount(String b_gstAmount, String currencyCode){

        gstAmount = new MonetaryAmount(b_gstAmount,
                currencyCode, Long.valueOf(b_gstAmount),
                b_gstAmount.length() - b_gstAmount
                        .lastIndexOf('.') - 1);
        return this;
    }

    public  AccountingLineBuilder withGstCode(String gstCode1){
        gstCode = gstCode1;
        return this;
    }

    public  AccountingLineBuilder withQstAmount(String b_qstAmount, String currencyCode){

        qstAmount = new MonetaryAmount(b_qstAmount, currencyCode, Long.valueOf(b_qstAmount),
                b_qstAmount.length() - b_qstAmount
                        .lastIndexOf('.') - 1);

        return this;
    }

    public AccountingLineBuilder withQstCode(String qstCode1){
        qstCode = qstCode1;
        return this;
    }

    public AccountingLineBuilder withCommission(String b_commissionPercentage, String b_commissionAmount, String currencyCode){

        MonetaryPercentage monetaryPercentage = new MonetaryPercentage();
        monetaryPercentage.setPercentage(BigDecimal.valueOf(Double.parseDouble(b_commissionPercentage)));
        monetaryPercentage.setAmount(new MonetaryAmount(b_commissionAmount,
                currencyCode,
                ((long)Double.parseDouble(b_commissionAmount)),
                b_commissionAmount.length() - b_commissionAmount
                        .lastIndexOf('.')-1));

        commission = monetaryPercentage;
        return this;
    }

    public AccountingLineBuilder withFreeFormText(String freeFormText1){
        freeFormText = freeFormText1;
        return this;
    }

    public AccountingLineBuilder withTotalTaxSurchage(String b_gstAmount, String b_qstAmount, String b_taxAmount, String currencyCode){

        MonetaryAmount newTotalTaxSurcharge = new MonetaryAmount();
        newTotalTaxSurcharge.setFormattedValue(String.valueOf(Long.valueOf(b_gstAmount) + Long.valueOf(b_qstAmount)));
        newTotalTaxSurcharge.setValue((long)(Double.parseDouble(b_gstAmount) + Double.parseDouble(b_qstAmount)));
        newTotalTaxSurcharge.setNumberOfDecimals(b_taxAmount.length() - b_taxAmount.lastIndexOf('.') -1);
        newTotalTaxSurcharge.setCurrencyCode(currencyCode);

        totalTaxSurcharge = newTotalTaxSurcharge;
        return this;
    }

    public AccountingLineBuilder withTotalTaxAmount(String b_taxAmount, String currencyCode){
        totalTaxAmount = new MonetaryAmount(String.valueOf(this.taxAmount.getValue() + this.totalTaxSurcharge.getValue()),
                currencyCode,
                (this.taxAmount.getValue() + this.totalTaxSurcharge.getValue()),
                b_taxAmount.length() - b_taxAmount.lastIndexOf('.')-1);

        return this;
    }

    public AccountingLineBuilder withAirLineCode(String code){
        airlineCode = code;
        return this;
    }




}

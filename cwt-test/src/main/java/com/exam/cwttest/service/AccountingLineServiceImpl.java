package com.exam.cwttest.service;

import com.exam.cwttest.entitymodel.AccountingLineModel;
import com.exam.cwttest.exception.AccountingLineException;
import com.exam.cwttest.builder.AccountingLineBuilder;
import com.exam.cwttest.model.from.AccountingLineXYZ;
import com.exam.cwttest.repository.AccountingLineRepository;
import com.exam.cwttest.to.AccountingLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountingLineServiceImpl implements AccountingLineService{

    @Autowired
    private AccountingLineRepository accountingLineRepository;


    @Override
    public AccountingLine save(AccountingLineXYZ accountingLineXYZ) {

        return accountingLineRepository.save(convertToAccountingLine(accountingLineXYZ));
    }

    @Override
    public AccountingLineModel getAll() throws AccountingLineException {
        List<AccountingLine> accountingLineList = accountingLineRepository.findAll();
        AccountingLineModel accountingLineModel = new AccountingLineModel();
        accountingLineModel.setAccountingLineList(accountingLineList);

        if (accountingLineModel.getAccountingLineList().isEmpty()){
            throw new AccountingLineException("AccountingLine is Empty! ");
        }

        return accountingLineModel;
    }

    @Override
    public List<AccountingLine> getAccountingLineByField(String field) {
        return accountingLineRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    private AccountingLine convertToAccountingLine(AccountingLineXYZ accountingLineXYZ) {
        AccountingLineBuilder accountingLineBuilder = new AccountingLineBuilder();
        accountingLineBuilder.withId(accountingLineXYZ.getId())
                .withVendorCode(accountingLineXYZ.getAccountingVendorCode())
                .withChargeCategoryCode(accountingLineXYZ.getChargeCategoryCoded())
                .withAccountingLineStatus()
                .withChargeCategoryCode(accountingLineXYZ.getChargeCategoryCoded())
                .withInvoiceNumber(accountingLineXYZ.getOriginalInvoice())
                .withLinkCode(accountingLineXYZ.getLinkCode())
                .withNumberOfConjuctedDocument(accountingLineXYZ.getNumberOfConjunctedDocuments())
                .withOriginalTicketNumber(accountingLineXYZ.getOriginalTicketNumber())
                .withSegmentRefIdList()
                .withTravelerName(accountingLineXYZ.getPassengerName())
                .withTravelerRefIDList()
                .withTypeIndicator(accountingLineXYZ.getTypeIndicator())
                .withElementNumber(accountingLineXYZ.getElementId())
                .withFareApplication(accountingLineXYZ.getFareApplication())
                .withBaseFare(accountingLineXYZ.getBaseFare(), accountingLineXYZ.getCurrencyCode())
                .withReceiptNumber(accountingLineXYZ.getDocumentNumber())
                .withTaxAmount(accountingLineXYZ.getTaxAmount(), accountingLineXYZ.getCurrencyCode())
                .withGstAmount(accountingLineXYZ.getGstAmount(), accountingLineXYZ.getCurrencyCode())
                .withGstCode(accountingLineXYZ.getGstCode())
                .withQstAmount(accountingLineXYZ.getQstAmount(), accountingLineXYZ.getCurrencyCode())
                .withQstCode(accountingLineXYZ.getQstCode())
                .withCommission(accountingLineXYZ.getCommissionPercentage(), accountingLineXYZ.getCommissionAmount(), accountingLineXYZ.getCurrencyCode())
                .withFreeFormText(accountingLineXYZ.getFreeFormText())
                .withTotalTaxSurchage(accountingLineXYZ.getGstAmount(), accountingLineXYZ.getQstAmount(), accountingLineXYZ.getTaxAmount(), accountingLineXYZ.getCurrencyCode())
                .withTotalTaxAmount(accountingLineXYZ.getTaxAmount(), accountingLineXYZ.getCurrencyCode())
                .withAirLineCode("XYZ");

        return accountingLineBuilder.build();
    }
}

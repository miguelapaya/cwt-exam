package com.exam.cwttest.service;

import com.exam.cwttest.entitymodel.AccountingLineModel;
import com.exam.cwttest.exception.AccountingLineException;
import com.exam.cwttest.model.from.AccountingLineXYZ;
import com.exam.cwttest.to.AccountingLine;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AccountingLineService {

    //AccountingLine save(@RequestBody AccountingLineXYZ accountingLineXYZ);
    AccountingLine save(AccountingLineXYZ accountingLineXYZ);
    AccountingLineModel getAll() throws AccountingLineException;
    List<AccountingLine> getAccountingLineByField(String field);
}

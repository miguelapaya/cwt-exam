package com.exam.cwttest.controller;

import com.exam.cwttest.api.APIResponse;
import com.exam.cwttest.entitymodel.AccountingLineModel;
import com.exam.cwttest.exception.AccountingLineException;
import com.exam.cwttest.model.from.AccountingLineXYZ;
import com.exam.cwttest.service.AccountingLineService;
import com.exam.cwttest.to.AccountingLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/accounting-line")
public class AccountingLineController {

    @Autowired
    AccountingLineService accountingLineService;

    @PostMapping("/new")
    public AccountingLine createAccountingLine(@RequestBody AccountingLineXYZ accountingLine){
        return accountingLineService.save(accountingLine);
    }

    @GetMapping(value = "/accountingline")
    public AccountingLineModel findAccountingLine() throws AccountingLineException {return accountingLineService.getAll();}

    @GetMapping("/{field}")
    public APIResponse<List<AccountingLine>> getAccountingLineByField(@PathVariable String field){
        List<AccountingLine> accountingLineList = accountingLineService.getAccountingLineByField(field);

        return new APIResponse<>(accountingLineList.size(), accountingLineList);
    }
}

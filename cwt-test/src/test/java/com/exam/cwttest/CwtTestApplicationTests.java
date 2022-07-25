package com.exam.cwttest;

import com.exam.cwttest.model.from.AccountingLineXYZ;
import com.exam.cwttest.repository.AccountingLineRepository;
import com.exam.cwttest.to.AccountingLine;
import com.exam.cwttest.to.AccountingLineStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class CwtTestApplicationTests {

    @Autowired
    private AccountingLineRepository accountingLineRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void testFindTravelerName(){
        String name = "Thanos";
        AccountingLine accountingLine = accountingLineRepository.findAccountingLineByTravelerName(name);

        assertThat(accountingLine.getTravelerName()).isEqualTo(name);

    }
    @Test
    public void testFindTravelerNameIfNotExisting(){
        String name = "Thanos";
        AccountingLine accountingLine = accountingLineRepository.findAccountingLineByTravelerName(name);

        assertNull(accountingLine);

    }

    @Test
    public void testDeleteAccountingLineById(){
    }

}

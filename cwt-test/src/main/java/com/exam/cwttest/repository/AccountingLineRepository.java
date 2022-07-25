package com.exam.cwttest.repository;

import com.exam.cwttest.to.AccountingLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingLineRepository extends JpaRepository<AccountingLine, Long> {

    AccountingLine findAccountingLineByTravelerName(String name);
}

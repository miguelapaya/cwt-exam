package com.exam.cwttest.entitymodel;

import com.exam.cwttest.to.AccountingLine;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@JacksonXmlRootElement
public class AccountingLineModel implements Serializable {

    public static final long serialVersionUID = 22L;


    @JacksonXmlProperty(localName = "AccountingLine")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<AccountingLine> accountingLineList = new ArrayList<>();
}

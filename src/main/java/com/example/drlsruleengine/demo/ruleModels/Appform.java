package com.example.drlsruleengine.demo.ruleModels;

public class Appform extends  RuleSummaryBase{
    private String loanProductCode;

    private Integer loanAmount;

    private Integer loanAssetValue;


    public String getLoanProductCode() {
        return loanProductCode;
    }

    public void setLoanProductCode(String loanProductCode) {
        this.loanProductCode = loanProductCode;
    }

    public Integer getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Integer loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getLoanAssetValue() {
        return loanAssetValue;
    }

    public void setLoanAssetValue(Integer loanAssetValue) {
        this.loanAssetValue = loanAssetValue;
    }
}

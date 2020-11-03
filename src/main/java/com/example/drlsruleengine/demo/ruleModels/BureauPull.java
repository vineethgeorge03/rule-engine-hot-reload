package com.example.drlsruleengine.demo.ruleModels;

/**
 *  Previous loan application -  booked/rejected
 *  - Previous Lpc - same/different
 *  - Previous Bureau pull - success/failure
 *  - Previous Time of Bureau Pull
 * */
public class BureauPull extends RuleSummaryBase {
    private boolean previousLoanApplicationStatus;
    private String previousLpc;
    private String currentLpc;
    private String previousBureauPullStatus;
    private String previousBureauPullTime;

    private String deducedBureauPullValue;


    public boolean isPreviousLoanApplicationStatus() {
        return previousLoanApplicationStatus;
    }

    public void setPreviousLoanApplicationStatus(boolean previousLoanApplicationStatus) {
        this.previousLoanApplicationStatus = previousLoanApplicationStatus;
    }

    public String getPreviousLpc() {
        return previousLpc;
    }

    public void setPreviousLpc(String previousLpc) {
        this.previousLpc = previousLpc;
    }

    public String getCurrentLpc() {
        return currentLpc;
    }

    public void setCurrentLpc(String currentLpc) {
        this.currentLpc = currentLpc;
    }

    public String getPreviousBureauPullStatus() {
        return previousBureauPullStatus;
    }

    public void setPreviousBureauPullStatus(String previousBureauPullStatus) {
        this.previousBureauPullStatus = previousBureauPullStatus;
    }

    public String getPreviousBureauPullTime() {
        return previousBureauPullTime;
    }

    public void setPreviousBureauPullTime(String previousBureauPullTime) {
        this.previousBureauPullTime = previousBureauPullTime;
    }

    public String getDeducedBureauPullValue() {
        return deducedBureauPullValue;
    }

    public void setDeducedBureauPullValue(String deducedBureauPullValue) {
        this.deducedBureauPullValue = deducedBureauPullValue;
    }
}

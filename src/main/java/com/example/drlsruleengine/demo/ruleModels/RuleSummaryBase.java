package com.example.drlsruleengine.demo.ruleModels;

import java.util.ArrayList;
import java.util.List;

public abstract class RuleSummaryBase {

    List<String> rulesFired = new ArrayList<>();
    Boolean hasPassed = false;
    Integer totalRulesPassed;

    public Integer getTotalRulesPassed() {
        return totalRulesPassed;
    }

    public void setTotalRulesPassed(Integer totalRulesPassed) {
        this.totalRulesPassed = totalRulesPassed;
    }

    public List<String> getRulesFired() {
        return rulesFired;
    }

    public void setRulesFired(List<String> rulesFired) {
        this.rulesFired = rulesFired;
    }

    public Boolean getHasPassed() {
        return hasPassed;
    }

    public void setHasPassed(Boolean hasPassed) {
        this.hasPassed = hasPassed;
    }
}

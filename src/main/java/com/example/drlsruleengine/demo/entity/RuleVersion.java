package com.example.drlsruleengine.demo.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "rule_version")
public class RuleVersion {
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private int id;

    @Column(name="rule_version")
    private String ruleVersion;

    @Column(name="source")
    private String source;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRuleVersion() {
        return ruleVersion;
    }

    public void setRuleVersion(String ruleVersion) {
        this.ruleVersion = ruleVersion;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

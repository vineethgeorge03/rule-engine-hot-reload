package com.example.drlsruleengine.demo.services;

import com.example.drlsruleengine.demo.ruleModels.Appform;

public interface RulesService {
    void updateRulesVersion(String newVersion, String source);
    Appform runRulesForAppform(Appform appform);
};

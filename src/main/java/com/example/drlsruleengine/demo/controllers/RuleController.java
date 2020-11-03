package com.example.drlsruleengine.demo.controllers;


import com.example.drlsruleengine.demo.ruleModels.Appform;
import com.example.drlsruleengine.demo.services.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RuleController {

    @Autowired
    private RulesService rulesService;

    @PostMapping("/version/update")
    public ResponseEntity updateVersion(@RequestBody Map<String,String> version) {
        String newVersion = version.get("version");
        String source = version.get("source");
        rulesService.updateRulesVersion(newVersion, source);
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @PostMapping("/run/rules/appForm")
    public ResponseEntity<Appform> runRulesOnAppform(@RequestBody Appform appform) {
        Appform runAppform = rulesService.runRulesForAppform(appform);
        return  new ResponseEntity<>(runAppform, HttpStatus.OK);
    }

}

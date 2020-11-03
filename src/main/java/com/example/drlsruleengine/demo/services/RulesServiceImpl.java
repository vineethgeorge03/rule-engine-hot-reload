package com.example.drlsruleengine.demo.services;

import com.example.drlsruleengine.demo.eventListeners.TrackingAgendaEventListener;
import com.example.drlsruleengine.demo.config.DroolsConfig;
import com.example.drlsruleengine.demo.entity.RuleVersion;
import com.example.drlsruleengine.demo.repository.RulesVersionRepository;
import com.example.drlsruleengine.demo.ruleModels.Appform;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;
import org.kie.api.runtime.rule.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RulesServiceImpl implements RulesService {

    @Autowired
    private RulesVersionRepository versionRepository;

    @Autowired
    private DroolsConfig droolsConfig;

    @Autowired
    private KieContainer kieContainer;

    @Override
    @Transactional
    public void updateRulesVersion(String newVersion, String source) {
        droolsConfig.scanNow();
        RuleVersion ruleVersion = new RuleVersion();
        ruleVersion.setRuleVersion(newVersion);
        ruleVersion.setSource(source);
        versionRepository.save(ruleVersion);
    }


    @Override
    public Appform runRulesForAppform(Appform appform) {
        /** initializing kieSession and attaching event listeners */
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        AgendaEventListener agendaEventListener = new TrackingAgendaEventListener();
        kieSession.addEventListener(agendaEventListener);
        kieSession.addEventListener(new DebugRuleRuntimeEventListener(System.out));

        /** focusing on agendas*/
        String loanProduct = appform.getLoanProductCode();
        Agenda agenda = kieSession.getAgenda();
        agenda.getAgendaGroup(loanProduct).setFocus();

        kieSession.insert(appform);

        int rulesFired = kieSession.fireAllRules();
        // System.out.println("total rules fired " + rulesFired);
        List<Match> matches =  ((TrackingAgendaEventListener) agendaEventListener).getMatchList();
        // System.out.println("matched rules are" + matches);
        /** disposing session */
        kieSession.dispose();

        List<String> firedRules = new ArrayList<>();
        for(Match match: matches) {
            firedRules.add(match.getRule().getName());
        }
        appform.setRulesFired(firedRules);
        appform.setTotalRulesPassed(rulesFired);
        return appform;
    }


}

package com.example.drlsruleengine.demo;

import com.example.drlsruleengine.demo.eventListeners.TrackingAgendaEventListener;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.DebugRuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;
import org.kie.api.runtime.rule.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TaxiFareCalculatorService {

    @Autowired
    private KieContainer kieContainer;

    public Double calculateFare(TaxiRide taxiRide, Fare rideFare) {

        // KieSession kieSession = kieContainer.newKieSession();
        KieSession kieSession = kieContainer.newKieSession("rulesSession");
        // StatelessKieSession kieSession1 = kieContainer.newStatelessKieSession();
        // kieSession1.execute(pojo)
        AgendaEventListener agendaEventListener = new TrackingAgendaEventListener();
        kieSession.addEventListener(agendaEventListener);
        kieSession.addEventListener(new DebugRuleRuntimeEventListener(System.out));
        /*fixes the multiple rules problem */
        Agenda agenda = kieSession.getAgenda();
        agenda.getAgendaGroup("calculation").setFocus();
        kieSession.setGlobal("rideFare", rideFare);
        kieSession.insert(taxiRide);
        int rulesFired = kieSession.fireAllRules();
        System.out.println("total rules fired " + rulesFired);
        List<Match> matches =  ((TrackingAgendaEventListener) agendaEventListener).getMatchList();
        System.out.println(matches);
        kieSession.dispose();
        System.out.println("fares are " + rideFare.getRideFare());
        System.out.println("fares are " + rideFare.getNightSurcharge());


        return rideFare.getRideFare();
    }
}

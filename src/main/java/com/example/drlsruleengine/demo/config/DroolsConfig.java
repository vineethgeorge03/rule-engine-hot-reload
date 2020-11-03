package com.example.drlsruleengine.demo.config;

import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.event.kiescanner.KieScannerEventListener;
import org.kie.api.event.kiescanner.KieScannerStatusChangeEvent;
import org.kie.api.event.kiescanner.KieScannerUpdateResultsEvent;
import org.kie.api.runtime.KieContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {
    private static final String drlFile = "rules/offers.drl";

    private KieScanner kieScanner;

    /*@Bean
    public KieContainer kieContainer() {
        KieServices kieServices = KieServices.Factory.get();

        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource(drlFile));
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        return kieServices.newKieContainer(kieModule.getReleaseId());
    }*/

    @Bean
    public KieContainer kieContainer() {
        KieServices ks = KieServices.Factory.get();
        ReleaseId releaseId =  ks.newReleaseId("test.example", "example-rules", "LATEST");
        KieContainer kContainer = ks.newKieContainer(releaseId);
        kieScanner = ks.newKieScanner(kContainer);
        KieScannerEventListener listener = new KieScannerEventListener() {

            public void onKieScannerStatusChangeEvent(KieScannerStatusChangeEvent statusChange) {
                System.out.println("status change" + statusChange.toString());
            }

            public void onKieScannerUpdateResultsEvent(KieScannerUpdateResultsEvent updateResults) {
                System.out.println("status changed" + updateResults.toString());
            }
        };
        kieScanner.addListener(listener);
        // kieScanner.start(5000L);
        return kContainer;
    }

    public void scanNow() {
        kieScanner.scanNow();
    }

}

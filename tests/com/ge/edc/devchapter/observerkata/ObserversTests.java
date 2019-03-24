package com.ge.edc.devchapter.observerkata;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class ObserversTests {

    PrintStream out;

    @Test
    public void tvStripTest() {
        out = Mockito.spy(new PrintStream(new ByteArrayOutputStream()));
        System.setOut(out);
        TvStrip obj = new TvStrip();
        HashMap<String, Double> indices = new HashMap<>();
        HashMap<String, Double> rates = new HashMap<>();

        rates.put("ZychoCorp", 1000.234);
        rates.put("SolInvictus", 43.4432);
        rates.put("EDC", 34.4342);

        indices.put("WIG20", 20d);
        indices.put("wig30", 13.43);
        indices.put("RESPECT", 43.);

        obj.update(rates, indices);

        Mockito.verify(out, times(3)).printf(anyString(), anyString(), anyDouble());
    }

    @Test
    public void smartphoneAppTest() {
        out = Mockito.spy(new PrintStream(new ByteArrayOutputStream()));
        System.setOut(out);
        SmartphoneApp app = new SmartphoneApp();
        HashMap<String, Double> indices = new HashMap<>();
        HashMap<String, Double> rates = new HashMap<>();

        rates.put("ZychoCorp", 1000.234);
        rates.put("SolInvictus", 43.4432);
        rates.put("EDC", 34.4342);

        indices.put("WIG20", 20d);
        indices.put("wig30", 13.43);
        indices.put("RESPECT", 43.);

        app.update(rates, indices);
        String s = "Phone is buzzing because there is new data from Stock Exchange!";
        Mockito.verify(out, times(1)).println(eq(s));
    }

    @Test
    public void websiteChartTest() {
        out = Mockito.spy(new PrintStream(new ByteArrayOutputStream()));
        System.setOut(out);
        WebsiteChart websiteChart = new WebsiteChart();
        HashMap<String, Double> indices = new HashMap<>();
        HashMap<String, Double> rates = new HashMap<>();

        rates.put("ZychoCorp", 1000.234);
        rates.put("SolInvictus", 43.4432);
        rates.put("EDC", 34.4342);

        indices.put("WIG20", 20d);
        indices.put("WIG30", 13.43);
        indices.put("RESPECT", 43.);
        indices.put("OTHER INDEX", 66.234);

        websiteChart.update(rates, indices);
        String s = "Phone is buzzing because there is new data from Stock Exchange!";
        Mockito.verify(out, times(4)).println(anyString());
    }

}

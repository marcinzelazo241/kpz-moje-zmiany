package pl.epsy.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.epsy.backend.xml.surefire.TestSuite;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SurefireService {

    private final XMLParserService xmlParserService;

    public void parse(List<String> files){
        for(String file : files){
            TestSuite testSuite = xmlParserService.parse("/reports/junit/"+file, TestSuite.class);
        }
    }

}

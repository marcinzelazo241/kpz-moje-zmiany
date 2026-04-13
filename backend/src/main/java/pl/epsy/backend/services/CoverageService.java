package pl.epsy.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.epsy.backend.xml.jacoco.Report;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoverageService {

    private final XMLParserService xmlParserService;

    public void parse(List<String> files){
        for(String file : files){
            Report report = xmlParserService.parse("/reports/jacoco/"+file, Report.class);
        }
    }

}

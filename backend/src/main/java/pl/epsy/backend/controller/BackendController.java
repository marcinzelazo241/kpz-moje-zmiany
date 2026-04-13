package pl.epsy.backend.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.epsy.backend.services.CoverageService;
import pl.epsy.backend.services.SurefireService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Paths.get;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/")
public class BackendController {

    private final CoverageService coverageService;
    private final SurefireService surefireService;

    @PostMapping("jenkins_post")
    @Hidden
    public void parseJenkinsOutput() throws IOException {
        log.warn("Starting parsing services");
        Path jacocoPath = get("/reports/jacoco");
        Path surefirePath = get("/reports/junit");
        if(!Files.exists(jacocoPath)){
            log.error("No jacoco reports found!");
        }else{
            coverageService.parse(Files.list(jacocoPath).map(Path::getFileName).map(Path::toString).toList());
        }
        if(!Files.exists(surefirePath)){
            log.error("No surefire reports found!");
        }else{
            surefireService.parse(Files.list(surefirePath).map(Path::getFileName).map(Path::toString).toList());
        }
    }

}

package pl.epsy.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.epsy.backend.jenkins.JenkinsJob;
import pl.epsy.backend.services.JenkinsService;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController

@RequestMapping("/api/jenkins")
@CrossOrigin(origins = "*")
@Tag(name="${api.jenkins.controller.name}", description = "${api.jenkins.controller.desc}")
public class JenkinsController {

    private final JenkinsService jenkinsService;

    public JenkinsController(JenkinsService jenkinsService) {
        this.jenkinsService = jenkinsService;
    }

    @GetMapping("/getJobs")
    @Operation(summary = "${api.jenkins.getJobs.summary}")
    public ResponseEntity<List<JenkinsJob>> getJenkinsJobs(){
            List<JenkinsJob> jenkinsJobs = jenkinsService.getJobs();
            return ResponseEntity.ok(jenkinsJobs);
    }

    @PostMapping("/run/{name}")
    @Operation(summary = "${api.jenkins.runJob.summary}")
    public ResponseEntity<String> runJob(
            @Parameter(description = "${api.jenkins.runJob.parameter1}")
            @PathVariable String name) {
            jenkinsService.runJob(name);
            return ResponseEntity.ok().build();
    }

}

package pl.epsy.backend.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.epsy.backend.jenkins.JenkinsCrumb;
import pl.epsy.backend.jenkins.JenkinsJob;
import pl.epsy.backend.jenkins.JenkinsJobResponse;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class JenkinsService {
    private final RestTemplate restTemplate;

    public JenkinsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private JenkinsCrumb fetchCrumb() {
        String url = "http://projekt_jenkins:8080/crumbIssuer/api/json";
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin", "admin");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<JenkinsCrumb> response = restTemplate.exchange(url, HttpMethod.GET, entity, JenkinsCrumb.class);
        if(response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody();
        }else{
            throw new RuntimeException("Unknown status code " + response.getStatusCode());
        }
    }

    public List<JenkinsJob> getJobs() {
        String url = "http://projekt_jenkins:8080/api/json?tree=jobs[name,url,color,lastBuild[number,result]]";

        HttpEntity<String> entity = new HttpEntity<>(jenkinsHeader());

        ResponseEntity<JenkinsJobResponse> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, JenkinsJobResponse.class
        );

        if(response.getBody() == null || response.getBody().getJenkinsJobs() == null){
            return Collections.emptyList();
        }

        return response.getBody().getJenkinsJobs().stream()
                .map(job -> new JenkinsJob(
                        job.getName(),
                        job.getUrl(),
                        job.getLastBuild())
                ).toList();
    }

    public void runJob(String jobName){
        String url = "http://projekt_jenkins:8080/job/" + jobName + "/build";
        HttpEntity<String> request = new HttpEntity<>(null, jenkinsHeader());

        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        if(response.getStatusCode() != HttpStatus.CREATED){
            log.error("Job {} could not be created", jobName);
            throw new RuntimeException("Job could not be created: " + response.getStatusCode());
        }
    }

    private HttpHeaders jenkinsHeader(){
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("admin", "admin");
        JenkinsCrumb crumbInfo = fetchCrumb();
        assert crumbInfo != null;
        headers.set(crumbInfo.getCrumbRequestField(), crumbInfo.getCrumb());
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return headers;
    }

}

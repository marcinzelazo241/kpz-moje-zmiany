package pl.epsy.backend.jenkins;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class JenkinsJobResponse {
    @JsonProperty("jobs")
    private List<JenkinsJob> jenkinsJobs;
}

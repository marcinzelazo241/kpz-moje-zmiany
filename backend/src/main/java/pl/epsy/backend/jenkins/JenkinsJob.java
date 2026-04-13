package pl.epsy.backend.jenkins;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JenkinsJob {
    private String name;
    private String url;
    private LastBuild lastBuild;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LastBuild{
        private Integer number;
        private String result;
    }
}

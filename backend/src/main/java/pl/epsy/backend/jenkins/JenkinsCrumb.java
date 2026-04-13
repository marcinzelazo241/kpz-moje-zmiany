package pl.epsy.backend.jenkins;

import lombok.Data;

@Data
public class JenkinsCrumb {
    private String crumb;
    private String crumbRequestField;
}

package pl.epsy.backend.xml.surefire;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

@JacksonXmlRootElement(localName = "rerun")
@Getter
public class RerunFailure {
    private String stackTrace;
    //@JacksonXmlProperty(localName = "system-out")
    private String systemOut;
    //@JacksonXmlProperty(localName = "system-err")
    private String systemErr;
    @JacksonXmlProperty(isAttribute = true)
    private String message;
    @JacksonXmlProperty(isAttribute = true)
    private String type;
}

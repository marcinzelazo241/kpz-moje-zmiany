package pl.epsy.backend.xml.surefire;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

@JacksonXmlRootElement(localName = "flakyFailure")
@Getter
public class FlakyFailure {
    private String stackTrace;
    //@XmlElement(name = "system-out")
    private String systemOut;
    //@XmlElement(name = "system-err")
    private String systemErr;
    @JacksonXmlProperty(isAttribute = true)
    private String message;
    @JacksonXmlProperty(isAttribute = true)
    protected String type;
}

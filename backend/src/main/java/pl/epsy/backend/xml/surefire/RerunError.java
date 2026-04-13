package pl.epsy.backend.xml.surefire;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

@JacksonXmlRootElement(localName = "rerunError")
@Getter
public class RerunError {
    private String stackTrace;
    //@JacksonXmlProperty(localName = "system-out")
    private String systemOut;
    //@XmlElement(name = "system-err")
    private String systemErr;
    @JacksonXmlProperty(isAttribute = true)
    private String message;
    @JacksonXmlProperty(isAttribute = true)
    private String type;
}

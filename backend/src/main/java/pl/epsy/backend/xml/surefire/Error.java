package pl.epsy.backend.xml.surefire;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

@JacksonXmlRootElement(localName = "error")
@Getter
public class Error {
    private String value;
    @JacksonXmlProperty(isAttribute = true)
    private String message;
    @JacksonXmlProperty(isAttribute = true)
    private String type;
}

package pl.epsy.backend.xml.surefire;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

import java.lang.Error;
import java.util.List;

@JacksonXmlRootElement(localName = "testCase")
@Getter
public class TestCase {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "failure")
    private List<Failure> failures;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "rerunFailure")
    private List<RerunFailure> rerunFailures;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "flakyFailure")
    private List<FlakyFailure> flakyFailures;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "skipped")
    private List<Skipped> skippedList;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "error")
    private List<Error> errors;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "rerunError")
    private List<RerunError> rerunErrors;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "flakyError")
    private List<FlakyError> flakyErrors;
    //@XmlElement(name = "system-out")
    private String systemOut;
    //@XmlElement(name = "system-err")
    private String systemErr;
    @JacksonXmlProperty(isAttribute = true)
    private String name;
    @JacksonXmlProperty(isAttribute = true)
    private String classname;
    @JacksonXmlProperty(isAttribute = true)
    private String group;
    @JacksonXmlProperty(isAttribute = true)
    private double time;
}

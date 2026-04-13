package pl.epsy.backend.xml.surefire;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;

import java.util.List;

@JacksonXmlRootElement(localName = "properties")
@Getter
public class Properties {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "property")
    private List<Property> propertyList;
}

package pl.epsy.backend.xml.jacoco;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CounterType {
    INSTRUCTION("INSTRUCTION"),
    BRANCH("BRANCH"),
    LINE("LINE"),
    COMPLEXITY("COMPLEXITY"),
    METHOD("METHOD"),
    CLASS("CLASS");

    private final String xmlValue;

    @JsonValue
    public String getXmlValue() {
        return xmlValue;
    }
}

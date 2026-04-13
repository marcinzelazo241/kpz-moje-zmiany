package pl.epsy.backend.services;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class XMLParserService {

    private final XmlMapper xmlMapper;

    public <T> T parse(String filePath, Class<T> targetClass) {
        try {
            File file = new File(filePath);
            return xmlMapper.readValue(file, targetClass);
        } catch (IOException e) {
            log.error("Error while parsing XML file: {}", e.getMessage());
            throw new RuntimeException("Failed to read report: " + filePath);
        }
    }

}

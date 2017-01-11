import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class XmlSerializer {

    public void serialize(Object obj, String fileName) throws IOException {
        XmlMapper mapper = new XmlMapper();
        String serialized = mapper.writeValueAsString(obj);
        Files.write(Paths.get(fileName), serialized.getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
    }

    public <T> T deserialize(String fileName, TypeReference<T> ref) throws IOException {
        XmlMapper mapper = new XmlMapper();
        return mapper.readValue(new File(fileName), ref);
    }
}

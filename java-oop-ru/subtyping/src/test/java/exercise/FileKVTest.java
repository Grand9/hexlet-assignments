package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import java.util.Map;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    public void testFileKV() throws Exception {
        String expected = "value";
        KeyValueStorage storage = new FileKV("src/test/resources/file",
                Map.of("key", "value"));
        var result = storage.get("key", "default");
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void testFileKVLongMap() throws Exception {
        String expected = "value2";
        KeyValueStorage storage = new FileKV("src/test/resources/file",
                Map.of("key1", "value1", "key2", "value2", "key3", "value3"));
        var result = storage.get("key2", "default");
        assertThat(result).isEqualTo(expected);
    }
    @Test
    public void testFileShortMap() throws Exception {
        String expected = "valueshort";
        KeyValueStorage storage = new FileKV("src/test/resources/file",
                Map.of("keyshort", "valueshort"));
        var result = storage.get("keyshort", "default");
        assertThat(result).isEqualTo(expected);
    }
    // END
}

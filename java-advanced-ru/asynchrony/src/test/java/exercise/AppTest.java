package exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static com.github.stefanbirkner.systemlambda.SystemLambda.tapSystemOut;
import java.util.concurrent.CompletableFuture;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

class AppTest {
    private String destPath;

    private static Path getFullPath(String filePath) {
        return Paths.get(filePath).toAbsolutePath().normalize();
    }

    @BeforeEach
    void beforeEach() throws Exception {
        destPath = Files.createTempFile("test", "tmp").toString();
    }

    @Test
    void testUnion() throws Exception {
        CompletableFuture<String> result = App.unionFiles(
            "src/test/resources/file1.txt",
            "src/test/resources/file2.txt",
            destPath
        );
        result.get();

        String actual = Files.readString(getFullPath(destPath));
        assertThat(actual).contains("Test", "Message");
    }

    @Test
    void testUnionWithNonExistedFile() throws Exception {

        String result = tapSystemOut(() -> {
            App.unionFiles("nonExistingFile", "file", destPath).get();
        });

        assertThat(result.trim()).contains("NoSuchFileException");
    }

    // BEGIN
    @Test
    void testGetDirectorySize() throws Exception {
        Path tempDir = Files.createTempDirectory("testDir");
        Path file1 = Files.createTempFile(tempDir, "file1", ".txt");
        Path file2 = Files.createTempFile(tempDir, "file2", ".txt");

        Files.writeString(file1, "Some content");
        Files.writeString(file2, "More content");

        CompletableFuture<Long> sizeFuture = App.getDirectorySize(tempDir.toString());
        long expectedSize = Files.size(file1) + Files.size(file2);

        assertThat(sizeFuture.get()).isEqualTo(expectedSize);
    }

    @Test
    void testGetDirectorySizeEmptyDirectory() throws Exception {
        Path emptyDir = Files.createTempDirectory("emptyDir");
        CompletableFuture<Long> sizeFuture = App.getDirectorySize(emptyDir.toString());

        assertThat(sizeFuture.get()).isEqualTo(0L);
    }
    // END
}

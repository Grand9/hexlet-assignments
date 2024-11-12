package exercise;

import java.util.concurrent.CompletableFuture;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

class App {

    public static CompletableFuture<String> unionFiles(String filePath1, String filePath2, String destFilePath) {
        return CompletableFuture.supplyAsync(() -> {
            Path path1 = Paths.get(filePath1);
            Path path2 = Paths.get(filePath2);
            Path destPath = Paths.get(destFilePath);

            try {
                if (!Files.exists(path1) || !Files.exists(path2)) {
                    throw new java.nio.file.NoSuchFileException("One or both source files do not exist.");
                }

                String content1 = Files.readString(path1);
                String content2 = Files.readString(path2);
                String combinedContent = content1 + System.lineSeparator() + content2;
                Files.writeString(destPath, combinedContent, StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING);

                return "File successfully created at: " + destPath.toString();
            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
                return "Failed to create the file.";
            }
        });
    }

    public static CompletableFuture<Long> getDirectorySize(String dirPath) {
        return CompletableFuture.supplyAsync(() -> {
            Path path = Paths.get(dirPath);
            try (Stream<Path> files = Files.list(path)) {
                return files
                        .filter(Files::isRegularFile)
                        .mapToLong(p -> {
                            try {
                                return Files.size(p);
                            } catch (IOException e) {
                                System.out.println("Failed to get size for file: " + p);
                                return 0L;
                            }
                        })
                        .sum();
            } catch (IOException e) {
                System.out.println("An error occurred while calculating directory size: " + e.getMessage());
                return 0L;
            }
        });
    }

    public static void main(String[] args) throws Exception {
        CompletableFuture<String> result = App.unionFiles("src/main/resources/file1.txt",
                "src/main/resources/file2.txt", "src/main/resources/result.txt");
        System.out.println(result.get());

        CompletableFuture<Long> size = App.getDirectorySize("src/main/resources");
        System.out.println("Directory size: " + size.get() + " bytes");
    }
}

package lifegame.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileRead {
    private static final Logger log = LoggerFactory.getLogger(FileRead.class);

    private FileRead() {
    }

    public static List<String> readInStream(String fileName) {
        // TODO 추후에 properties로 경로 분리
        ClassLoader classLoader = FileRead.class.getClassLoader();
        URL url = Optional.ofNullable(classLoader.getResource("file/" + fileName)).orElseThrow(() -> new RuntimeException("파일 에러"));
        File file = new File(url.getFile());

        Stream<String> returnStream = null;
        try {
            returnStream = Files.lines(file.toPath());
        } catch (IOException e) {
            e.getStackTrace();
            log.info("file exception : {}", e.getMessage());
        }

        return Objects.requireNonNull(returnStream).collect(Collectors.toList());
    }
}

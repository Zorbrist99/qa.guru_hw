package eighthlesson;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchFail {


    @Test
    void downloadedFail() throws Exception {

        //Позволяет скачивать документ без href
        Configuration.fileDownload = FileDownloadMode.PROXY;


        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File file = $(".react-blob-header-edit-and-raw-actions  [href*='main/README.md']").download();

        // Развёрнутая версия чтения файла в строку
        try (InputStream is = new FileInputStream(file);) {
            byte[] fileContent = is.readAllBytes();
            String strContent = new String(fileContent, StandardCharsets.UTF_8);
//            Проверка совпадения текста в файле и того, что нам нужно
//            Assertions.assertTrue(strContent.contains("Contributions to JUnit 5 are both welcomed and appreciated."));
            System.out.println(strContent.contains("Contributions to JUnit 5 are both welcomed and appreciated."));
        }

        //Компактное решение чтения файла в строку, при помощи библиотеки
      String fileContestString =   FileUtils.readFileToString(file, StandardCharsets.UTF_8);

    }


}

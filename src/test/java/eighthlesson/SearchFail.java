package eighthlesson;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.*;

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

//        //Компактное решение чтения файла в строку, при помощи библиотеки
//      String fileContestString =   FileUtils.readFileToString(file, StandardCharsets.UTF_8);

    }

    @Test
    void upLoudFile() {
        open("https://vms.drweb.ru/scan_file/");
        //Все кнопки загрузки файла можно найти при помощи этого локатора
        $("input[type='file']").uploadFromClasspath("foto/my1.jpg");
        $("#chooseFile").shouldHave(value("my1.jpg"));
    }

    @Test
    void upLoudPdfFile () throws Exception {
        open("https://www.formatpdf.com/en/blog/test-pdf/");
        File pdfFile = $("[href*='test-pdf-free-sample-pdf.pdf']").download();
        PDF pdf = new PDF(pdfFile);
        Assertions.assertEquals("Welcome to FormatPDF.com!\n" +
                "Feel free to edit this sample PDF according to your needs. \uD83D\uDE42\n" +
                "Yours PDFly,\n" +
                "The FormatPDF Team", pdf.text);
        System.out.println();
    }
}

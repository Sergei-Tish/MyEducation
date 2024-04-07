package io;

/** 27.8. Проект */

import model.Statistics;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {
    private XlsWriter() {
    }

    public static void writeXlsStatistics(List<Statistics> statisticsList,
                                          String filePath) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet statisticsSheet = workbook.createSheet("Статистика");

        int rowNum = 0;         // счетчик для строк

        Font font = workbook.createFont();
        font.setBold(true);
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);

        Row headerRow = statisticsSheet.createRow(rowNum++);
        headerRow.createCell(0).setCellValue("Профиль");
        headerRow.createCell(1).setCellValue("Сред.оценка");
        headerRow.createCell(2).setCellValue("Число студентов");
        headerRow.createCell(3).setCellValue("Число унив.");
        headerRow.createCell(4).setCellValue("Названия унив.");
        for (Cell cellInRow :
                headerRow) {
            cellInRow.setCellStyle(cellStyle);
        }

        for (Statistics statistics :
                statisticsList) {
            Row row = statisticsSheet.createRow(rowNum++);
            row.createCell(0).setCellValue(statistics.getStudyProfile().getProfileName());
            row.createCell(1).setCellValue(statistics.getAvgExamScore());
            row.createCell(2).setCellValue(statistics.getNumberOfStudents());
            row.createCell(3).setCellValue(statistics.getNumberOfUniversities());
            row.createCell(4).setCellValue(statistics.getUniversityNames());
        }



        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
    }
}

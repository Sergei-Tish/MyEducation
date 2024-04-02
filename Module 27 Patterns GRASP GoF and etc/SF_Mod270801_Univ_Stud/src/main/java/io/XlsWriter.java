package io;

import model.Statistics;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsWriter {
    private XlsWriter() {
    }

    public static void writeXlsStatistics(Statistics statistics, String filePath) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet statisticsSheet = workbook.createSheet("Статистика");

        // счетчик для строк
        int rowNum = 0;

        Row row = statisticsSheet.createRow(rowNum);
        row.createCell(0).setCellValue(Профиль);

    }
}

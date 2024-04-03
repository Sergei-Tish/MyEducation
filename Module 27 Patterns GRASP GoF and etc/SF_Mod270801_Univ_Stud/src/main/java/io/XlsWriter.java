package io;

import model.Statistics;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public class XlsWriter {
    private XlsWriter() {
    }

    public static void writeXlsStatistics(List<Statistics> statisticsList, String filePath) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet statisticsSheet = workbook.createSheet("Статистика");

        int rowNum = 0;         // счетчик для строк

        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight((short) 13);
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setFont(font);

        Row headerRow = statisticsSheet.createRow(0);
//        Cell cell = headerRow.createCell(0);  // как указано в решении
//        cell.setCellValue("Профиль");
//        cell.setCellStyle(cellStyle);
        headerRow.createCell(0).setCellValue("Профиль");
        headerRow.createCell(1).setCellValue("Сред.оценка");
        headerRow.createCell(2).setCellValue("Число студентов");
        headerRow.createCell(3).setCellValue("Число унив.");
        headerRow.createCell(4).setCellValue("Названия унив.");

        for (Cell cellInRow : // пробую не как в решении, а перебором
                headerRow) {
            cellInRow.setCellStyle(cellStyle);
        }


    }
}

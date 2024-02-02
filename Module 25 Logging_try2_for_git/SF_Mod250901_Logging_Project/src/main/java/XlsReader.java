import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import enums.StudyProfile;
import model.Student;
import model.University;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsReader {
    private XlsReader() {
    }

    public static List<model.University> readXlsUniversities(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Университеты");
        List<model.University> universities = new ArrayList<>();

        Iterator rowIter = sheet.rowIterator();
        if (rowIter.hasNext()) rowIter.next();
        while (rowIter.hasNext()) {
            XSSFRow row = (XSSFRow) rowIter.next();
            model.University university = new University();
            university.setId(row.getCell(0).getRichStringCellValue().getString())
                    .setFullName(row.getCell(1).getRichStringCellValue().getString())
                    .setShortName(row.getCell(2).getRichStringCellValue().getString())
                    .setYearOfFoundation((int) row.getCell(3).getNumericCellValue())
                    .setMainProfile(StudyProfile.valueOf(row.getCell(4).getRichStringCellValue().getString()));

            universities.add(university);
        }
        return universities;
    }

    public static List<model.Student> readXlsStudents(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Студенты");
        List<model.Student> students = new ArrayList<>();

        Iterator rowIter = sheet.rowIterator();
        if (rowIter.hasNext()) rowIter.next();
        while (rowIter.hasNext()) {
            XSSFRow row = (XSSFRow) rowIter.next();
            model.Student student = new Student();
            student.setFullName(row.getCell(1).getRichStringCellValue().getString())
                    .setUniversityId(row.getCell(0).getRichStringCellValue().getString())
                    .setCurrentCourseNumber((int) row.getCell(2).getNumericCellValue())
                    .setAvgExamScore((float) row.getCell(3).getNumericCellValue());

            students.add(student);
        }
        return students;
    }
}
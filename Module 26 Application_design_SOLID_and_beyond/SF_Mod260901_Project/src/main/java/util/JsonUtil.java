package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Student;
import model.University;

import java.util.List;

public class JsonUtil {
    private JsonUtil() {
    }

    /**
     * В классе JsonUtil реализовать 4 метода сериализации в JSON и 4 метода десериализации из JSON в объекты:
     * сериализация/десериализация отдельных объектов студентов и университетов,
     * сериализация/десериализация коллекций этих объектов.
     * Сериализация должна выполняться в форматированном виде (PrettyPrinting).
     */

    private static Gson getGsonFromGsonBuilderPrettyPrinting() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson;
    }

    public static String universityToJson(University university) {
        Gson gson = JsonUtil.getGsonFromGsonBuilderPrettyPrinting();
        return gson.toJson(university);
    }

    public static String studentToJson(Student student) {
        Gson gson = JsonUtil.getGsonFromGsonBuilderPrettyPrinting();
        return gson.toJson(student);
    }

    public static String universityListToJson(List<model.University> universityList) {
        Gson gson = JsonUtil.getGsonFromGsonBuilderPrettyPrinting();
        return gson.toJson(universityList);
    }

    public static String studentListToJson(List<model.Student> studentList) {
        Gson gson = JsonUtil.getGsonFromGsonBuilderPrettyPrinting();
        return gson.toJson(studentList);
    }

    public static model.University jsonToUniversity(String json) {
        return new Gson().fromJson(json, model.University.class);
    }

    public static model.Student jsonToStudent(String json) {
        return new Gson().fromJson(json, model.Student.class);
    }

    public static List<model.University> jsonToUniversityList(String json) {
        return new Gson().fromJson(json, new TypeToken<List<model.University>>(){}.getType());
    }

    public static List<model.Student> jsonToStudentList(String json) {
        return new Gson().fromJson(json, new TypeToken<List<model.Student>>(){}.getType());
    }
}

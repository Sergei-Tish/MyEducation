//класс для работы с бд
class DatabaseWorker implements Database{

    @Override
    public String connect(String ConnectionString) {
        System.out.println("Connected to DB");
        return "Connected to DB "+ ConnectionString;
    }

    @Override
    public String query(String SQL) {
        return "0 row affected";
    }
}
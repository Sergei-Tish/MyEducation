public class Main {
    public static void main(String[] args) {
        //Создаем наши объекты
        //Вкладывая их друг в друга как матрёшка
        DatabaseWorker databaseWorker =new DatabaseWorker();
        DatabaseCache databaseCache = new DatabaseCache(databaseWorker);
        DatabaseManager databaseManager = new DatabaseManager(databaseCache);

        databaseManager.makeConnection("192.168.0.1");
        databaseManager.runQuerry("Select * from *");
    }
}
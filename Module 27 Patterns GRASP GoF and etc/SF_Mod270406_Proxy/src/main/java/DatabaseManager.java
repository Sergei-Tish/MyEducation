// Класс GUI, который использует сервисный объект. Вместо
// реального сервиса мы подсовываем ему объект-заместитель.
// Клиент ничего не заметит, так как заместитель имеет тот же
// интерфейс, что и сервис.
class DatabaseManager{
    DatabaseWorker databaseWorker;
    DatabaseManager(DatabaseWorker databaseWorker){
        this.databaseWorker=databaseWorker;
    }
    void makeConnection(String connectionString){
        databaseWorker.connect(connectionString);
    }
    String runQuerry(String SQL){
        return databaseWorker.query(SQL);
    }
}
//Интерфейс  с для работы с бд (мб какой библиотеки по типу jdbc
interface Database{
    String connect(String ConnectionString);
    String query(String SQL);
}
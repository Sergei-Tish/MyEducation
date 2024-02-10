package configuration;

public class DatabaseConfiguration {
    public void configure() {
        if ("IN_MEMORY".equals(System.getProperty("DB"))) {
            // Если задана эта конфигурация то Апп не будет подключаться к реальной БД
        } else if ("REAL_DB".equals(System.getProperty("DB"))) {
            // если эта, то должно подключится к реальной БД
        }
    }
}

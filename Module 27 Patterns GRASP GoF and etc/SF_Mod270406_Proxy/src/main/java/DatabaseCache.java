//класс для кэширования
class DatabaseCache extends DatabaseWorker{
    private DatabaseWorker service;
    private boolean needReset;
    private String connectCache;
    private String queryCache;
    DatabaseCache(DatabaseWorker service){
        this.service=service;
        this.needReset=false;
    }

    @Override
    public String connect(String ConnectionString) {
        if ((connectCache==null)||(needReset)){
            connectCache =service.connect(ConnectionString);
        }
        return connectCache;
    }

    @Override
    public String query(String SQL) {
        if ((queryCache ==null)||(needReset)){
            queryCache =service.query(SQL);
        }
        return queryCache;
    }
}
public class Article1 implements interfaces.Deletable {
    @Override
    public void delete(String articleId) {
        System.out.println("I deleted the entire article linked to the ID article \"" + articleId + "\"");
    }
//    public void delete() {
//        System.out.println("I deleted the entire article linked to the ID article \"" + "\"");
//    }
}

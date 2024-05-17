package package1;

public class Article implements interfaces.Deletable {
    @Override
    public void delete(String articleId) {
        System.out.println("I deleted all the " + this.getClass().getSimpleName() + " with the ID article \"" + articleId + "\"");
    }
//    public void delete() {
//        System.out.println("I deleted the entire article linked to the ID article \"" + "\"");
//    }
}

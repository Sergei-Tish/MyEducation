package package1;

public class Picture implements interfaces.Deletable {
    @Override
    public void delete(String articleId) {
        System.out.println("I deleted all the pictures associated with the ID article \"" + articleId + "\"");
    }
}

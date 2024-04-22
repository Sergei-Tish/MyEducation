public class Picture1 implements interfaces.Deletable {
    @Override
    public void delete(String articleId) {
        System.out.println("I deleted all the pictures associated with the ID article \"" + articleId + "\"");
    }
}

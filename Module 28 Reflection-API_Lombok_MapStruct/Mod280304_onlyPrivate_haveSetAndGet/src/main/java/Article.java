public class Article implements interfaces.Deletable {
    @Override
    public void delete(String articleId) {
        System.out.println("I deleted all the " + this.getClass().getSimpleName() + " with the ID article \"" + articleId + "\"");
    }

    private String id;

    protected String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

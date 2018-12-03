package lesson4_5.insert_and_update;

public class Main2 {
    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();
        ah.updateAuthor("Nikolas2", "Gogol", 4);
        System.out.println(ah.getAuthoById(4));
    }
}

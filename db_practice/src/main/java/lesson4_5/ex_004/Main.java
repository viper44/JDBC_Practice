package lesson4_5.ex_004;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();
        //ah.updateAuthor("Nikolas2", "Gogol", 4);
        //System.out.println(ah.getAuthoById(4));
        List<Author> authors = ah.getAuthorList();
        for (Author author : authors) {
            System.out.println(author);
        }
    }
}

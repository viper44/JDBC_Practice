package lesson4_5;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AuthorHelper authorHelper = new AuthorHelper();

        Author author = new Author();
        author.setName("Petro");
        authorHelper.addAuthor(author);

        List<Author> authorList = authorHelper.getAuthorList();

        for (Author author1 : authorList) {
            System.out.println(author1);
        }
        System.out.println(authorHelper.getAuthoById(2));
    }
}

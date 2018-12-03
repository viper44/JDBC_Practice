package lesson6;

import lesson6.ex001.AuthorHelper;

public class Main {
    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();
        System.out.println(ah.getAuthoById(1));
    }
}

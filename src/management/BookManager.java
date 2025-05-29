package management;

import datastructures.maps.CustomHashMap;
import library.Book;
import library.Member;

public class BookManager {
    // TODO: Define a data structure that stores ISBNs and their matching Book objects
    private CustomHashMap<String, Book> bookIsbns;

    private MemberManager memberManager;

    public BookManager(MemberManager memberManager) {
        // TODO: Initialize your data structure here
        bookIsbns = new CustomHashMap<>();
        this.memberManager = memberManager;
    }

    public void addBook(Book book) {
        // TODO: Add the book and its ISBN to your data structure
        bookIsbns.put(book.getIsbn(), book);
    }

    public Book getBookByIsbn(String isbn) {
        // TODO
        return bookIsbns.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        // TODO

        return getBookByIsbn(isbn).isAvailable();
    }

    public void setBookAvailability(String isbn, boolean available) {
        // TODO
        getBookByIsbn(isbn).setAvailable(available);
    }

    public void addToWaitlist(String isbn, String memberId) {
        // TODO
        getBookByIsbn(isbn).addToWaitlist(memberManager.getMember(memberId));
    }

    public Member getNextFromWaitlist(String isbn) {
        // TODO
        Book theBook = getBookByIsbn(isbn);
        return theBook.getNextInWaitlist();
    }

    public boolean hasWaitlist(String isbn) {
        // TODO
        Book theBook = getBookByIsbn(isbn);
        return theBook.hasWaitlist();
    }
}
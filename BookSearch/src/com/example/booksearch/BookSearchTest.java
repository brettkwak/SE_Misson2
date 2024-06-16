package com.example.booksearch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookSearchTest {

    private BookSearch.Book[] books;

    @BeforeEach
    public void setup() {
        books = new BookSearch.Book[]{
            new BookSearch.Book(1, "Java Programming"),
            new BookSearch.Book(2, "Effective Java"),
            new BookSearch.Book(3, "Clean Code"),
            new BookSearch.Book(4, "Head First Java"),
            new BookSearch.Book(5, "Java Concurrency")
        };
    }

    @Test
    public void testSearchFound() {
        int index = BookSearch.search_bs(books, 3);
        assertEquals(2, index, "책 'Clean Code'는 인덱스 2에 위치해야 합니다.");
        System.out.println("테스트 'testSearch' 성공");
    }

    @Test
    public void testSearchNotFound() {
        int index = BookSearch.search_bs(books, 6);
        assertEquals(-1, index, "존재하지 않는 고유 아이디는 -1을 반환해야 합니다.");
        System.out.println("테스트 'testSearchNotFound' 성공");
    }

    @Test
    public void testSearchFirstElement() {
        int index = BookSearch.search_bs(books, 1);
        assertEquals(0, index, "책 'Java Programming'은 인덱스 0에 위치해야 합니다.");
        System.out.println("테스트 'testSearchFirstElement' 성공");
    }

    @Test
    public void testSearchLastElement() {
        int index = BookSearch.search_bs(books, 5);
        assertEquals(4, index, "책 'Java Concurrency'는 인덱스 4에 위치해야 합니다.");
        System.out.println("테스트 'testSearchLastElement' 성공");
    }

    @Test
    public void testSearchMiddleElement() {
        int index = BookSearch.search_bs(books, 4);
        assertEquals(3, index, "책 'Head First Java'는 인덱스 3에 위치해야 합니다.");
        System.out.println("테스트 'testSearchMiddleElement' 성공");
    }

    @Test
    public void testEmptyArray() {
        BookSearch.Book[] emptyBooks = {};
        int index = BookSearch.search_bs(emptyBooks, 1);
        assertEquals(-1, index, "빈 배열에서는 항상 -1을 반환해야 합니다.");
        System.out.println("테스트 'testEmptyArray' 성공");
    }
}

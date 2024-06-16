package com.example.booksearch;

public class BookSearch {

    /**
     * 고유 아이디로 정렬된 책 배열에서 이진 탐색을 수행하여 책을 찾는 함수
     * @param books 정렬된 책 배열
     * @param bookId 찾고자 하는 책의 고유 아이디
     * @return 해당 고유 아이디를 가진 책의 인덱스, 존재하지 않으면 -1을 반환
     */
    public static int search_bs(Book[] books, int bookId) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (books[mid].getBookId() == bookId) {
                return mid; // 찾은 경우 인덱스 반환
            } else if (books[mid].getBookId() < bookId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // 찾지 못한 경우
    }

    public static class Book {
        private int bookId;
        private String title;

        public Book(int bookId, String title) {
            this.bookId = bookId;
            this.title = title;
        }

        public int getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }
    }
}

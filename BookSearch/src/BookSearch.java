

public class BookSearch {

    /*
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
    
    
    /*
     * 고유 아이디로 정렬된 책 배열에서 순차 탐색을 수행하여 책을 찾는 함수
     * @param books 정렬된 책 배열
     * @param bookId 찾고자 하는 책의 고유 아이디
     * @return 해당 고유 아이디를 가진 책의 인덱스, 존재하지 않으면 -1을 반환
     */
	public static int search_linear (Book[] books, int bookId) {
		int current = 0;
		int last = books.length;
		while (current < last) {
			if (bookId == books[current].getBookId()) {
				return current;
			}
			current++;
		}
		// 책이 없을 경우
		return -1;
	}
    
	
    public static int comparePerformance(Book[] books, int bookId) {
        System.out.println(bookId +"번 책 찾기");
        // 선형 검색 성능 테스트
        long startTime = System.nanoTime();
        int result_linear = search_linear(books, bookId);
        long endTime = System.nanoTime();
        long linearDuration = endTime - startTime;
        System.out.println("Linear Search Time: " + linearDuration + " ns");

        // 이진 검색 성능 테스트
        startTime = System.nanoTime();
        int result_bs = search_bs(books, bookId);
        endTime = System.nanoTime();
        long binaryDuration = endTime - startTime;
        System.out.println("Binary Search Time: " + binaryDuration + " ns");
        long difference = linearDuration - binaryDuration;
        System.out.println("Performance Difference: " + difference  + " ns");
        return result_bs;
    }
}

import java.util.Arrays;

public class LibraryManagementSystem {
    static class Book {
        String bookId;
        String title;
        String author;

        Book(String bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        @Override
        public String toString() {
            return String.format("Book{id=%s, title=%s, author=%s}", bookId, title, author);
        }
    }

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] sortedBooks, String title) {
        int left = 0;
        int right = sortedBooks.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = sortedBooks[mid].title.compareToIgnoreCase(title);
            if (compare == 0) {
                return sortedBooks[mid];
            }
            if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book("B101", "Algorithms", "Robert Sedgewick"),
                new Book("B102", "Data Structures", "Mark Allen"),
                new Book("B103", "Clean Code", "Robert Martin"),
                new Book("B104", "Design Patterns", "Erich Gamma")
        };

        System.out.println("Linear search for Design Patterns:");
        System.out.println(linearSearch(books, "Design Patterns"));

        Book[] sortedBooks = Arrays.copyOf(books, books.length);
        Arrays.sort(sortedBooks, (a, b) -> a.title.compareToIgnoreCase(b.title));

        System.out.println("\nBinary search for Clean Code:");
        System.out.println(binarySearch(sortedBooks, "Clean Code"));
    }
}

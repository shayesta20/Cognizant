using System;

public class LibraryManagementSystem
{
    public class Book
    {
        public string BookId { get; set; }
        public string Title { get; set; }
        public string Author { get; set; }

        public Book(string bookId, string title, string author)
        {
            BookId = bookId;
            Title = title;
            Author = author;
        }

        public override string ToString()
        {
            return $"Book{{id={BookId}, title={Title}, author={Author}}}";
        }
    }

    public static Book LinearSearch(Book[] books, string title)
    {
        foreach (Book book in books)
        {
            if (string.Equals(book.Title, title, StringComparison.OrdinalIgnoreCase))
            {
                return book;
            }
        }
        return null;
    }

    public static Book BinarySearch(Book[] sortedBooks, string title)
    {
        int left = 0;
        int right = sortedBooks.Length - 1;

        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            int compare = string.Compare(sortedBooks[mid].Title, title, StringComparison.OrdinalIgnoreCase);

            if (compare == 0)
            {
                return sortedBooks[mid];
            }
            if (compare < 0)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void Main(string[] args)
    {
        Book[] books = new Book[]
        {
            new Book("B101", "Algorithms", "Robert Sedgewick"),
            new Book("B102", "Data Structures", "Mark Allen"),
            new Book("B103", "Clean Code", "Robert Martin"),
            new Book("B104", "Design Patterns", "Erich Gamma")
        };

        Console.WriteLine("Linear search for Design Patterns:");
        Book linearResult = LinearSearch(books, "Design Patterns");
        Console.WriteLine(linearResult != null ? linearResult.ToString() : "Not Found");

        Book[] sortedBooks = new Book[books.Length];
        Array.Copy(books, sortedBooks, books.Length);
        
        Array.Sort(sortedBooks, (a, b) => string.Compare(a.Title, b.Title, StringComparison.OrdinalIgnoreCase));

        Console.WriteLine("\nBinary search for Clean Code:");
        Book binaryResult = BinarySearch(sortedBooks, "Clean Code");
        Console.WriteLine(binaryResult != null ? binaryResult.ToString() : "Not Found");
    }
}

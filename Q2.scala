object Q2 extends App {
    case class Book(title: String, author: String, isbn: String)

    var books = List(
        Book("The Catcher in the Rye", "J.D. Salinger", "9780316769174"),
        Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"),
        Book("To Kill a Mockingbird", "Harper Lee", "9780446310789"),
        Book("1984", "George Orwell", "9780451524935"),
        Book("Pride and Prejudice", "Jane Austen", "9780141439518"),
        Book("The Lord of the Rings", "J.R.R. Tolkien", "9780544003415"),
        Book("The Hobbit", "J.R.R. Tolkien", "9780544003415")
    )

    def addBook(): Unit = {
        val title = scala.io.StdIn.readLine("Enter book title: ")
        val author = scala.io.StdIn.readLine("Enter book author: ")
        val isbn = scala.io.StdIn.readLine("Enter book ISBN: ")
        val book = Book(title, author, isbn)
        books = books :+ book

        println("\nBook added successfully")

        displayCurrentLibraryCollection(books)
    }

    def removeBookIsbn(): Unit = {
        val isbn = scala.io.StdIn.readLine("Enter book ISBN: ")
        books = books.filterNot(b => b.isbn == isbn)

        println(s"\nRemoving book with ISBN ${isbn}")
        println("Book removed successfully")

        displayCurrentLibraryCollection(books)
    }

    def checkBookIsbn(): Unit = {
        val isbn = scala.io.StdIn.readLine("Enter book ISBN: ")
        if(books.exists(b => b.isbn == isbn)) {
            println("\nBook exists")
        }
        else {
            println("\nBook does not exist")
        }

        displayCurrentLibraryCollection(books)
    }

    def displayCurrentLibraryCollection(books: List[Book]): Unit = {
        println("\nCurrent library collection:")
        for(book <- books) {
            println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
        }
    }

    def searchByTitle(): Unit = {
        val title = scala.io.StdIn.readLine("Enter book title: ")
        val book = books.find(b => b.title == title)

        if(book.isDefined) {
            println("\nBook found:")
            println(s"Title: ${book.get.title}, Author: ${book.get.author}, ISBN: ${book.get.isbn}")
        }
        else {
            println("\nBook not found")
        }

        println(s"\nAll books by the same author: ${book.get.author}")
        
        val bookByAuthor = books.filter(b => b.author == book.get.author)

        displayCurrentLibraryCollection(bookByAuthor)
    }

    println("Welcome to the library management system")
    println("Enter your choice: \n1. Add book\n2. Remove book by ISBN\n3. Check if book exists\n4. Search by title\n5. Display current library collection\n6. Exit")

    val choice = scala.io.StdIn.readInt()
    choice match {
        case 1 => addBook()
        case 2 => removeBookIsbn()
        case 3 => checkBookIsbn()
        case 4 => searchByTitle()
        case 5 => displayCurrentLibraryCollection(books)
        case 6 => println("Exiting...")
        case _ => println("Invalid choice")
    }
}
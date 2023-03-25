package com.testcoverage.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.testcoverage.code.Exception.CustomExcep;
import com.testcoverage.code.entity.Book;
import com.testcoverage.code.service.BookService;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CodeApplicationTests {

	@BeforeAll
    static void initialMsg(){
        System.out.println("initilizing only ....");
    }

    @Test
    void testingAssertTrue(){
        System.out.println(" i am inside assertTrue method!!");
        BookService ser = new BookService();
        ser.addBook(new Book());
        List<Book> listOfBooks = ser.books();
        assertTrue(!listOfBooks.isEmpty(), "all is not good till now");
    }

    @Test
    void testingGetById(){
        int BOOK_ID = 8;
        System.out.println("i am inside testingId");
        BookService ser = new BookService();
        ser.addBook(new Book(BOOK_ID, "Kotlin","Jet-Brains"));
        Book returnedBook = ser.getById(BOOK_ID);
        assertEquals(ser.books().get(0), returnedBook, ()-> "Well well, the objects are not equal");
        assertNull(ser.getById(BOOK_ID+1));
    }

    @Test 
    void testingGetByPublisher(){
        BookService ser = new BookService();
        int BOOK_ID = 8;
        ser.addBook(new Book(BOOK_ID, "Kotlin","Jet-Brains"));
        List<Integer> listOfReturnedBookIds = ser.getBookByIdPublisher("Jet-Brains");
        assertTrue(listOfReturnedBookIds.get(0)==8, "all is not good till now");

    }

    @Test
    void testingGetByTitle() throws CustomExcep{
        BookService ser = new BookService();
        int BOOK_ID = 8;
        ser.addBook(new Book(BOOK_ID, "Kotlin","Jet-Brains"));
        String bokTitle = ser.getByTitle("Kotlin");
        assertEquals("Kotlin", bokTitle);
    }

    @Test
    void testingSetters(){
        final int ID = 99;
        final String TITLE = "Hero";
        final  String AUTHOR = "Kilo";
        Book book = new Book();
        book.setId(ID);
        book.setTitle(TITLE);
        book.setAuthor(AUTHOR);
        assertNotNull(book.getId());
        assertNotNull(book.getTitle());
        assertNotNull(book.getAuthor());
    }

    @Test
    public void main() {
        CodeApplication.main(new String[] {});
   }

    // testing the reverse function
	Rev reverseString = new Rev();

	@Test
	void testRevString(){
		assertEquals("pot", reverseString.revString("top"));
	}

    @Test
    void testNull(){
        assertNull(reverseString.revString(null));
    }
    @Test
    void testEmpty(){
        assertTrue(reverseString.revString("").isEmpty());
    }

    @AfterAll
   static void printMsg(){
        System.out.println("exiting the code");
    }
}

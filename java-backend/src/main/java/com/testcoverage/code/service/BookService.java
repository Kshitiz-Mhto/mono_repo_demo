package com.testcoverage.code.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.testcoverage.code.Exception.CustomExcep;
import com.testcoverage.code.entity.Book;

public class BookService {
    private List<Book> list = new ArrayList<>();

    public void addBook(Book book){
        list.add(book);

    }

    public List<Book> books(){
        return Collections.unmodifiableList(list);

    }

    public Book getById(int id){
        for (Book book : list){
            if(book.getId()==id){
                return book;
            }
        }
        return null;
    }

    public List<Integer> getBookByIdPublisher(String publisher){
        List<Integer> ids = new ArrayList<>();
        for(Book book : list){
            if(publisher.equals(book.getAuthor())){
                ids.add(book.getId());
            }
        }
        return ids;

    }

    public String getByTitle(String title) throws CustomExcep {
        for (Book book : list){
            if(book.getTitle().equals(title)){
                return book.getTitle();
            }
        }
        throw new CustomExcep("hehe, exception is here lala");
    }
}

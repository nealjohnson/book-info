package com.interview.book.info.controller;

import com.interview.book.info.service.BookService;
import com.interview.book.info.domain.model.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/book/{bookId}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity bookName(@PathVariable("bookId")  Long id){
        BookVO result = bookService.findBook(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping(value = "/books" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity bookNames(@RequestParam("bookId") List<Long> bookIds){
        List<BookVO> result = bookService.findBooks(bookIds);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}

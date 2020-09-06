package com.interview.book.info.unit.controller;

import com.google.common.collect.Lists;
import com.interview.book.info.controller.BookController;
import com.interview.book.info.service.BookService;
import com.interview.book.info.domain.model.BookVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BookControllerUnitTest {

    @Mock
    BookService bookService;

    BookController bookController;
    @Before
    public void prepare(){
        bookController= new BookController(bookService);
    }

    @Test
    public void testRatingsList() {
        Long userId =1l;
        Long bookId =1l;
        String bookName = "book1";
        BookVO bookVO =new BookVO();
        bookVO.setId(bookId);
        bookVO.setName(bookName);
        List<BookVO> list =Lists.newArrayList(bookVO);
        Mockito.when(bookService.findBooks(Lists.newArrayList(userId))).thenReturn(list);
        ResponseEntity result = bookController.bookNames(Lists.newArrayList(userId));

        List<BookVO> resultList = (List<BookVO>) result.getBody();
        Assert.assertEquals(bookName,resultList.get(0).getName());
        Assert.assertEquals(userId,resultList.get(0).getId());
    }

}

package com.interview.book.info.integration;

import com.interview.book.info.controller.BookController;
import com.interview.book.info.service.BookService;
import com.interview.book.info.domain.model.BookVO;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MocksApplication.class)
public class IntegrationTest {


    BookController bookController;

    @Autowired
    BookService bookService;

    @Before
    public void prepare(){
        bookController= new BookController(bookService);
    }

    @Test
    public void testBookNames() {
        Long userId =1l;
        Long bookId =1l;
        ResponseEntity result = bookController.bookNames(Lists.newArrayList(userId));
        List<BookVO> bookList = (List<BookVO>) result.getBody();
        Assert.assertEquals(1,bookList.size());
        Assert.assertEquals(bookId, bookList.get(0).getId());
        Assert.assertEquals("book1", bookList.get(0).getName());
    }

    @Test
    public void testBookName() {
        Long userId =1l;
        Long bookId =1l;
        ResponseEntity result = bookController.bookName(userId);
        BookVO bookVO = (BookVO) result.getBody();
        Assert.assertEquals(bookId, bookVO.getId());
        Assert.assertEquals("book1", bookVO.getName());
    }
}

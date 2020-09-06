package com.interview.book.info.unit.service.impl;

import com.google.common.collect.Lists;

import com.interview.book.info.domain.entity.BookEntity;
import com.interview.book.info.domain.model.BookVO;
import com.interview.book.info.repository.BookRepository;
import com.interview.book.info.service.BookService;
import com.interview.book.info.service.impl.BookServiceImpl;
import com.interview.book.info.transformer.impl.BookTransformer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class RatingServiceUnitTest {
    @Mock
    BookRepository bookRepository;
    @Mock
    BookTransformer bookTransformer;

    BookService bookInfoService;

    @Before
    public void prepare(){
        bookInfoService= new BookServiceImpl(bookRepository, bookTransformer);
    }

    @Test
    public void testFindBooksRating() {
        Long bookId =2l;
        String bookName = "Book1";

        BookEntity bookEntity =new BookEntity();
        bookEntity.setName(bookName);
        bookEntity.setId(bookId);

        List<BookEntity> list = Lists.newArrayList(bookEntity);
        BookVO bookVO = new BookVO();
        bookVO.setName(bookName);
        bookVO.setId(bookId);
        Mockito.when(bookRepository.findById(bookId)).thenReturn(Optional.of(bookEntity));
        Mockito.when(bookTransformer.transformToModel(Mockito.isA(BookEntity.class))).thenReturn(bookVO);
        BookVO result = bookInfoService.findBook(bookId);
        Assert.assertEquals( bookId, result.getId());
        Assert.assertEquals( bookName,result.getName());
    }

}

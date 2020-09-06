package com.interview.book.info.unit;

import com.interview.book.info.domain.entity.BookEntity;
import com.interview.book.info.domain.model.BookVO;
import com.interview.book.info.transformer.Transformer;
import com.interview.book.info.transformer.impl.BookTransformer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BookInfoTransformerTest {

    Transformer transformer;

    @Before
    public void prepare(){
        transformer= new BookTransformer();
    }

    @Test
    public void testTransform() {
        Long bookId =2l;
        String bookName ="Book1";
        BookEntity bookEntity =new BookEntity();
        bookEntity.setId(bookId);
        bookEntity.setName(bookName);

        BookVO result = (BookVO) transformer.transformToModel(bookEntity);

        Assert.assertEquals( bookName, result.getName());
        Assert.assertEquals( bookId,result.getId());
    }

}

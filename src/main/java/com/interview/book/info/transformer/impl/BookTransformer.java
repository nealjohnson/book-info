package com.interview.book.info.transformer.impl;

import com.interview.book.info.domain.entity.BookEntity;
import com.interview.book.info.domain.model.BookVO;
import com.interview.book.info.transformer.Transformer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BookTransformer implements Transformer<BookEntity, BookVO> {
    @Override
    public BookVO transformToModel(BookEntity bookEntity) {
        BookVO bookVO =new BookVO();
        BeanUtils.copyProperties(bookEntity,bookVO);
        return bookVO;
    }
}

package com.interview.book.info.service;

import com.interview.book.info.domain.model.BookVO;

import java.util.List;

public interface BookService {
     BookVO findBook(Long id);
     List<BookVO> findBooks(List<Long> ids);
}

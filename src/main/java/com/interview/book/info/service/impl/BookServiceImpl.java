package com.interview.book.info.service.impl;

import com.interview.book.info.repository.BookRepository;
import com.interview.book.info.domain.entity.BookEntity;
import com.interview.book.info.domain.model.BookVO;
import com.interview.book.info.service.BookService;

import com.interview.book.info.transformer.impl.BookTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository repository;
    private BookTransformer transformer;
    @Override
    @Transactional(readOnly = true)
    public BookVO findBook(Long id) {
        BookEntity result = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The book doesn't exist"));
        return transformer.transformToModel(result);
    }

    @Override
    public List<BookVO> findBooks(List<Long> ids) {
        List<BookEntity> results = repository.findAllById(ids);
        return results.stream().map(transformer::transformToModel).collect(Collectors.toList());
    }

    @Autowired
    public BookServiceImpl(BookRepository repository, BookTransformer transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }
}

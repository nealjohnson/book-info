package com.interview.book.info.repository;

import com.interview.book.info.domain.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends  JpaRepository<BookEntity, Long> {
}

package com.interview.book.info.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "book")
public class BookEntity {
    @Id
    private Long id;
    @Column
    private String name;
}

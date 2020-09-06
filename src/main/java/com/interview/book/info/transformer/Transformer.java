package com.interview.book.info.transformer;

public interface  Transformer<T,R> {
     abstract R transformToModel(T t);
}

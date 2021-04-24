package com.minchanghsu.service;



import com.minchanghsu.entity.Book;

import java.util.List;

/**
 *
 * Created by Minchang Hsu
 */
public interface BookService {
    /**
     * 獲取所有 Book
     */
    List<Book> findAll();

    /**
     * 新增 Book
     *
     * @param book {@link Book}
     */
    Book insertByBook(Book book);

    /**
     * 更新 Book
     *
     * @param book {@link Book}
     */
    Book update(Book book);

    /**
     * 刪除 Book
     *
     * @param id 編號
     */
    Book delete(Long id);

    /**
     * 獲取 Book
     *
     * @param id 編號
     */
    Book findById(Long id);
}

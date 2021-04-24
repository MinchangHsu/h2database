package com.minchanghsu.entity;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Book 數據持久層操作接口
 *
 * Created by Minchang Hsu
 */
public interface BookRepository extends JpaRepository<Book, Long> {
}

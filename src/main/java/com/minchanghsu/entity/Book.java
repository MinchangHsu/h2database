package com.minchanghsu.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

/**
 * Book 实体类
 *
 * Created by Minchang Hsu
 */
@Data
@Accessors(chain = true)
@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String writer;

    private String introduction;
}

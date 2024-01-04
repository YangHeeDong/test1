package com.example.test1.domain.article.entity;

import com.example.test1.global.jpa.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Article extends BaseEntity {

    private String title;
    private String content;
}

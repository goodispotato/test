package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer bookmarkId;

    @ManyToOne //장소 하나 당 카테고리 여러 개
    @JoinColumn(name="placeId")
    private Place place;

    @Column(name="categoryName")
    private String categoryName;
}

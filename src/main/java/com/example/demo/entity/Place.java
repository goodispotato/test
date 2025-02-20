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
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int placeId;

    @Column
    private int categoryId;

    @Column
    private String placeName;

    @Column
    private String imageUrl;

    @Column
    private String address;

    @Column
    private String openTime;

    @Column
    private String contact;

    @Column
    private String categoryName;
}

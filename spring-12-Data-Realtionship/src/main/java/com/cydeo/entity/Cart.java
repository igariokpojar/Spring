package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // is creating primary key auto
    private Long id;

    @ManyToMany
    //create relationship b/w Cart and Item tables
    @JoinTable(name = "cart_item_rel",
            joinColumns = @JoinColumn(name = "c_id"),
            inverseJoinColumns = @JoinColumn(name = "i_id"))
    //joinColumns-inverseJoinColumns-> we used this annotation to be able to manipulate the columns only
    private List<Item> itemList;

    }

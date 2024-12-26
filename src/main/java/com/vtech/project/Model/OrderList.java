package com.vtech.project.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
@Entity
public class OrderList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long orderListId;

@OneToMany(cascade = CascadeType.ALL)
@JoinColumn(name = "oredrListItems",referencedColumnName ="orderListId")
private List<Items> items;


}

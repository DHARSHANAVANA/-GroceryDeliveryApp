package com.vtech.project.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Shopping {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long shoppingId;
	private int total;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ShoppingOrder")
	private Orders orders;

	private String paymentMode;

}

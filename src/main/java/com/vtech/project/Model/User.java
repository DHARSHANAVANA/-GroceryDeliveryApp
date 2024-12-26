package com.vtech.project.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    
    @NotBlank
    private String userName;
    
    @NotBlank
    @Email
    private String userEmail;
    
    @NotBlank
    private long userPhone;
    
    @NotBlank
    private String userPassword;

    // One-to-one relationship with Shopping
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shopping_id")
    private Shopping shopping;

    // One-to-many relationship with Address
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Address> address;

    // Many-to-many relationship with Items
    @ManyToMany
    @JoinTable(
        name = "user_items",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "items_id")
    )
    private List<Items> items;       
}

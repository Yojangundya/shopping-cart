package org.jsp.shoppingcart.dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String email;
private String password;
private boolean status;
private int otp;

@OneToMany
private List<Address> adresses;

@OneToOne
private Cart cart;

@OneToMany
private List<ShoppingOrder> orders;
}

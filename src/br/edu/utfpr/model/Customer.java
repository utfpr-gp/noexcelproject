package br.edu.utfpr.model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.utfpr.model.service.CustomerService;
import br.edu.utfpr.model.service.UserService;
import br.edu.utfpr.util.Role;

@Entity
public class Customer extends Person {
		
	private String login;
	private String type;
	private Long value;
	private String password;
	private String colleger;
	private String email;
	
	public Customer(){
		
	}
	
	public Customer(String name, String login, String type, Long value, String password, String colleger, String email){
		this.name = name;
		this.login = login;
		this.type = type;
		this.value = value;
		this.password = password;
		this.colleger = colleger;
		this.email = email;
		this.role = Role.CLIENT;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getColleger() {
		return colleger;
	}

	public void setColleger(String colleger) {
		this.colleger = colleger;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isUnique() {
		CustomerService customer = new CustomerService();
		if (customer.getByProperty("login", getLogin()) != null) {
			return false;
		}
		return true;
	}
	
	public static Customer findByRa(String ra){
		CustomerService customer = new CustomerService();
		return customer.getByProperty("login", ra);
	}
	
	public String getReal(){
		Locale br = new Locale("pt", "BR");
		NumberFormat money = NumberFormat.getCurrencyInstance(br);
		String real = money.format(value/100);
		return real;
	}
}

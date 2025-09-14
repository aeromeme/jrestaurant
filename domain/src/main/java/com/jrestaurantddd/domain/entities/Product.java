package com.jrestaurantddd.domain.entities;
import jakarta.persistence.*;
import com.jrestaurantddd.domain.converters.ProductIdConverter;
import com.jrestaurantddd.domain.exception.DomainException;
import com.jrestaurantddd.domain.valueobjects.Money;
import com.jrestaurantddd.domain.valueobjects.ProductId;

@Entity
@Table(name = "Products")
public class Product {
	@Id
	@Embedded
	@AttributeOverride(name = "value", column = @Column(name = "Id", columnDefinition = "uniqueidentifier"))
	private ProductId id;

	@Column(name = "Name", nullable = false)
	private String name;

	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "amount", column = @Column(name = "PriceAmount", nullable = false)),
		@AttributeOverride(name = "currency", column = @Column(name = "PriceCurrency", nullable = false))
	})
	private Money price;

	@Column(name = "Stock", nullable = false)
	private int stock;

	@Column(name = "IsActive", nullable = false)
	private boolean isActive;

	@ManyToOne(optional = false)
	@JoinColumn(name = "CategoryId", referencedColumnName = "Id", nullable = false)
	private Category category;

	public Product(String name, Money price, int stock, boolean isActive, Category category) {
        if (name == null || name.isEmpty()) {
            throw new DomainException("Product name cannot be null or empty");
        }
        if (price == null || price.getAmount() < 0) {
            throw new DomainException("Product price cannot be null or negative");
        }
		if (category == null) {
			throw new DomainException("Product category cannot be null");
		}
		this.id = ProductId.newId();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.isActive = isActive;
		this.category = category;
	}
	protected Product() {
	    // For JPA
	}
	public Category getCategory() {
		return category;
	}

	public ProductId getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Money getPrice() {   
		return price;
	}

	public int getStock() {
		return stock;
	}

	public boolean isActive() {
		return isActive;
	}
}



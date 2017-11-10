package com.springproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="productId")
    private int productId;
	
	@NotNull(message ="is required")
	@Size(min=1, max=20, message="size must be less then 20 and grater then 0")
	@Column(name="productName")
    private String productName;

	
	@Column(name="productCategory")
    private String productCategory;
	
	@NotNull(message ="is required")
	@Size(min=1, max=20, message="size must be less then 20 and grater then 0")
	@Column(name="productDescription")
    private String productDescription;
	
	@NotNull(message= "is required")
	@Min(value=0, message="Product price must not be less then zero")
	@Column(name="productPrice")
    private double productPrice;
	
	@Column(name="productCondition")
    private String productCondition;

	@Column(name="productStatus")
    private String productStatus;
	
	@NotNull(message= "is required")
	@Min(value=0, message="Product unit must not be less then zero")
	@Column(name="unitInStock")
    private int unitInStock;
	
	@NotNull(message ="is required")
	@Size(min=1, max=20, message="size must be less then 20 and grater then 0")
	@Column(name="productManufacturer")
    private String productManufacturer;
	
	@OneToMany(mappedBy="product")
	private List<CartItem> cartItemList;
    
	@Transient
	private MultipartFile productImage;
    
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductCondition() {
		return productCondition;
	}
	public void setProductCondition(String productCondition) {
		this.productCondition = productCondition;
	}
	public String getProductStatus() {
		return productStatus;
	}
	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}
	public int getUnitInStock() {
		return unitInStock;
	}
	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}
	public String getProductManufacturer() {
		return productManufacturer;
	}
	public void setProductManufacturer(String productManufacturer) {
		this.productManufacturer = productManufacturer;
	}	
	
	public MultipartFile getProductImage() {
		return productImage;
	}
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productDescription=" + productDescription + ", productPrice=" + productPrice
				+ ", productCondition=" + productCondition + ", productStatus=" + productStatus + ", unitInStock="
				+ unitInStock + ", productManufacturer=" + productManufacturer + "]";
	}

}

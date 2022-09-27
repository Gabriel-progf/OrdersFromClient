package entities;

public class OrderItem {

	private Integer quantity;
	private Double price;
	
	private Product product;
	
	public OrderItem() {
	}


	public OrderItem(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
		
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public Double subTotal() {
		return product.getPrice() * quantity;
	}


	

	
	
	
	
	
	
	
	
	
	
	
	
}

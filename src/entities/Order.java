package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;
	
	private Client client;
	
	private List<OrderItem> items = new ArrayList<>();
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<OrderItem> getItems(){
		return items;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void remove(OrderItem item) {
		items.remove(item);
	}
	
	
	
	public Double total() {
		double sum = 0;
		for (OrderItem orderI: items ) {
			sum += orderI.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: "+ client.getName() + " ("+ sdf.format(client.getBirthDate()) + ") - " + client.getEmail() + "\n");
		sb.append("Order Items: \n");
		
		for (OrderItem orderI: items ) {
			sb.append(orderI.getProduct().getName() + ", ");
			sb.append("Quantity: " + orderI.getQuantity() + ", ");
			sb.append("Subtotal: $" + String.format("%.2f", orderI.subTotal()) + "\n");
		}
		
		sb.append("Total price: " + String.format("%.2f",total()));
		
		return sb.toString(); 
		
	}
	
	
	
	
	
}

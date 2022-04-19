package service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.douglas.entity.Order;
import com.example.douglas.repositorie.OrderRepository;

@RestController
@RequestMapping(path="/orders")
public class OrderService {

	private OrderRepository orderRepository;
	
	public OrderService(OrderRepository orderRepository) {
		super();
		this.orderRepository=orderRepository;
	}
	
	@PostMapping
	public ResponseEntity<Order> save(@RequestBody Order order){
		orderRepository.save(order);
		return new ResponseEntity<>(order, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> getAll(){
		List<Order> orders = new ArrayList<>();
		orders=orderRepository.findAll();
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}
	
	@GetMapping(path="/{ordernumber}")
	public ResponseEntity<Optional<Order>> getByOrderNum(@PathVariable long ordernumber){
		Optional<Order> order;
		try {
			order=orderRepository.findById(ordernumber);
			return new ResponseEntity<Optional<Order>>(order, HttpStatus.OK);
		}catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Order>>(HttpStatus.NOT_FOUND);
		}
	}
		
	@DeleteMapping(path="/{ordernumber}")
	public ResponseEntity<Optional<Order>> deleteByOrderNum(@PathVariable long ordernumber){
		try {
			orderRepository.findById(ordernumber);
			return new ResponseEntity<Optional<Order>>(HttpStatus.OK);
		}catch (NoSuchElementException nsee) {
			return new ResponseEntity<Optional<Order>>(HttpStatus.NOT_FOUND);
		}
	
	}
	
	@PutMapping(value="/{ordernumber}")
	public ResponseEntity<Order> update(@PathVariable long ordernumber, @RequestBody Order newOrder){
	return orderRepository.findById(ordernumber)
			.map(order -> {
				order.setProductcode(newOrder.getProductcode());
				order.setCPF(newOrder.getCPF());
				order.setAmount(newOrder.getAmount());
				order.setDate(newOrder.getDate());
				order.setValue(newOrder.getValue());
				Order orderupdated = orderRepository.save(order);
				return ResponseEntity.ok().body(orderupdated);
			}).orElse(ResponseEntity.notFound().build());
			
	}
	
	
	
	
	

	
	
}

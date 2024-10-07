package com.lucianna.mendonca.onlineorderformwebapp.controller;

import com.lucianna.mendonca.onlineorderformwebapp.model.Customer;
import com.lucianna.mendonca.onlineorderformwebapp.model.Order;
import com.lucianna.mendonca.onlineorderformwebapp.model.Product;
import com.lucianna.mendonca.onlineorderformwebapp.repository.CustomerRepository;
import com.lucianna.mendonca.onlineorderformwebapp.repository.OrderRepository;
import com.lucianna.mendonca.onlineorderformwebapp.repository.ProductRepository;
import com.lucianna.mendonca.onlineorderformwebapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.util.*;

@Controller
@RequestMapping("")
public class OrderController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;


//    @PostMapping
//    public ResponseEntity<Order> saveOrder(@ModelAttribute Order order){
//        // save order
//        Order savedOrder = orderRepository.save(order);
//        // return saved order
//        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
//    }

    @GetMapping("/show-order")
    public String getOrder(){
        return "show-order";
    }

    @GetMapping
    public String order(Model model){

        List<Product> products = productService.getProducts();

        model.addAttribute("productsMap", buildBrandProductsMap(products));

        return "index";
    }

    private Map<String, List<Product>> buildBrandProductsMap(List<Product> products) {
        Map<String, List<Product>> productsMap = new LinkedHashMap<>();

        for (Product product :  products) {
            String brand = product.getPhoneBrand();
            if (productsMap.get(brand) != null) {
                productsMap.get(brand).add(product);
                continue;
            }

            List<Product> list = new ArrayList<>();
            list.add(product);
            productsMap.put(product.getPhoneBrand(), list);
        }
        return productsMap;
    }

    @PostMapping("/submit-order")
    public RedirectView submitOrder(@ModelAttribute Customer customer, @ModelAttribute Product product,
            @ModelAttribute Order order, @RequestParam("productNumber") String productNumberString) {

        try{
            customerRepository.save(customer);

            // Convert productNumberString to integer
            int productNumber = Integer.parseInt(productNumberString);
            product.setProductNumber(productNumber);

            BigDecimal unitPrice = productRepository.findById(product.getProductId()).get().getUnitPrice();
            BigDecimal totalAmount = unitPrice.multiply(BigDecimal.valueOf(order.getQuantity()));
            order.setProduct(product);
            order.setCustomer(customer);
            order.setTotalAmount(totalAmount);

            orderRepository.save(order);

            // Redirect
            return new RedirectView("show-order");

        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid product number: " + productNumberString);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    @GetMapping("/orderConfirmation/{customerId}/{orderId}")
//    public String getOrderConfirmation(@PathVariable Long customerId, @PathVariable Long orderId, Model model) {
//        // Fetch the customer and order from the database
//        Optional<Customer> customer = customerRepository.findById(customerId);
//        Optional<Order> order = orderRepository.findById(orderId);
//
//        // Add customer and order data to the model
//        if (customer.isPresent() && order.isPresent()) {
//            model.addAttribute("customer", customer.get());
//            model.addAttribute("order", order.get());
//            return ("show-order");
//        }
//        return ("error");
//    }

}

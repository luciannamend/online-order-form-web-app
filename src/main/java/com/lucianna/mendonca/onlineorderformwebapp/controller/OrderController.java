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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
            @ModelAttribute Order order, @RequestParam("productNumber") String productNumberString,
                                    RedirectAttributes redirectAttributes) {

        try{
            customerRepository.save(customer);

            // Convert productNumberString to integer
            int productNumber = Integer.parseInt(productNumberString);
            product.setProductNumber(productNumber);

            Product existingProduct = productRepository.findById(product.getProductId()).get();
            BigDecimal totalAmount = existingProduct.getUnitPrice().multiply(BigDecimal.valueOf(order.getQuantity()));

            order.setProduct(existingProduct);
            order.setCustomer(customer);
            order.setTotalAmount(totalAmount);

            orderRepository.save(order);

            // Add attributes to be accessed in the redirected page
            redirectAttributes.addFlashAttribute("order", order);

            // Redirect
            return new RedirectView("show-order");

        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid product number: " + productNumberString);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

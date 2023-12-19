package com.example.Practice.Fruits.Controller;

//Map classes
import java.util.HashMap;
import java.util.Map;
//Required web classes
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Practice.Fruits.FruitNotFoundException;
import com.example.Practice.Fruits.Fruits;

@RestController
public class FruitServiceController {
 private static Map<String, Fruits> productRepo = new HashMap<>();
 static {
    Fruits apple = new Fruits("1","Apple");
    productRepo.put(apple.getId(), apple);
    Fruits banana = new Fruits("2","Banana");
    productRepo.put(banana.getId(), banana);
    Fruits chiku = new Fruits("3","Chiku");
    productRepo.put(chiku.getId(), chiku);
    Fruits dragon = new Fruits("4","Dragon Fruit");
    productRepo.put(dragon.getId(), dragon);
 }
 
 @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
 public ResponseEntity<Object> delete(@PathVariable("id") String id)
 {
    if (!productRepo.containsKey(id)) throw new FruitNotFoundException();
    productRepo.remove(id);
    return new ResponseEntity<>("Fruit is deleted!", HttpStatus.OK);
 }
 
 @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
 public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Fruits product)
 { 
    if (!productRepo.containsKey(id)) throw new FruitNotFoundException();
    productRepo.remove(id);
    product.setId(id);
    productRepo.put(id, product);
    return new ResponseEntity<>("Fruit is updated!", HttpStatus.OK);
 }
 
 @RequestMapping(value = "/products", method = RequestMethod.POST)
 public ResponseEntity<Object> createProduct(@RequestBody Fruits product) {
    productRepo.put(product.getId(), product);
    return new ResponseEntity<>("Fruit is created!", HttpStatus.CREATED);
 }
 
 @RequestMapping(value = "/products")
 public ResponseEntity<Object> getProduct() {
    return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
 }
}
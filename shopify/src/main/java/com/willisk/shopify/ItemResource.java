package com.willisk.shopify;

import com.willisk.shopify.model.Item;
import com.willisk.shopify.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RestController
@RequestMapping("/inventory")
public class ItemResource {
    private final InventoryService inventoryService;

    public ItemResource(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = inventoryService.findAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Item> getEmployeeById(@PathVariable("id") Long id) {
        Item item = inventoryService.findItemById(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        Item newItem = inventoryService.addItem(item);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        Item updateItem = inventoryService.addItem(item);
        return new ResponseEntity<>(updateItem, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable("id") Long id) {
        inventoryService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/csv")
    public void getAllItemsInCsv(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"employees.csv\"");
        inventoryService.writeEmployeesToCsv(servletResponse.getWriter());
    }

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }
}


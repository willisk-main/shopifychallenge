package com.willisk.shopify.service;

import com.willisk.shopify.exception.UserNotFoundException;
import com.willisk.shopify.model.Item;
import com.willisk.shopify.repo.InventoryRepo;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class InventoryService {
    private final InventoryRepo inventoryRepo;
    private static final Logger log = LoggerFactory.getLogger(InventoryService.class);

    @Autowired
    public InventoryService(InventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    public Item addItem(Item item) {
        item.setItemCode(UUID.randomUUID().toString());
        return inventoryRepo.save(item);
    }

    public List<Item> findAllItems() {
        return inventoryRepo.findAll();
    }

    public Item updateItem(Item item) {

        return inventoryRepo.save(item);
    }

    public Item findItemById(Long id) {
        return inventoryRepo.findItemById(id)
                .orElseThrow(() -> new UserNotFoundException("Item with id" + id + "was not found"));
    }

    public void deleteItem(Long id) {
        inventoryRepo.deleteItemById(id);
    }


    public void writeItemsToCsv(Writer writer) {

        List<Item> inventory = inventoryRepo.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (Item item : inventory) {
                csvPrinter.printRecord(
                        item.getId(),
                        item.getName(),
                        item.getDescription(),
                        item.getPrice(),
                        item.getQuantity());
            }
        } catch (IOException e) {
            log.error("Error While writing CSV ", e);
        }
    }
}

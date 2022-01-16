package com.willisk.shopify.repo;

import com.willisk.shopify.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.transaction.Transactional;
import java.util.Optional;

public interface InventoryRepo extends JpaRepository<Item, Long> {
    @Transactional void deleteItemById(Long id);
    Optional<Item> findItemById(Long id);
}

package edu.pos.repository;

import edu.pos.entity.ItemEntity;
import edu.pos.util.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemDao extends JpaRepository<ItemEntity, Integer> {
    List<ItemEntity> findAllByCategory(CategoryType category);
}
package co.istad.jdbc.dao;

import co.istad.jdbc.model.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface ProductDao {

    // Create
    int save (Product product) throws SQLException;

    // 1. Read all records
    // 2. Expected return value -> return type
    // 3. Parameters
    List<Product> findAll() throws SQLException;

    // Update by product code on existing record -> return as affected row
    int updatedByCode(String code, Product product) throws SQLException;

    // 1. Find a product by code
    Optional<Product> findByCode(String code) throws SQLException;

//     Delete
    int deleteByCode(String code) throws SQLException;

    boolean existByCode(String code) throws SQLException;

    Product getProductByCode(String code) throws SQLException;

}

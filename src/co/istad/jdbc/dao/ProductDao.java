package co.istad.jdbc.dao;

import co.istad.jdbc.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {

    // Create
    int save (Product product) throws SQLException;

    // 1. Read all records
    // 2. Expected return value -> return type
    // 3. Parameters
    List<Product> findAll() throws SQLException;

    // Update

    // Delete

}

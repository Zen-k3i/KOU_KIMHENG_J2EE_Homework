package co.istad.jdbc.service;

import co.istad.jdbc.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {

    List<Product> findAll();
    void save(Product product);
    void updateByCode(String code, Product product) throws SQLException;
    void deleteByCode(String code) throws SQLException;
    Product getProductByCode(String code) throws SQLException;
}

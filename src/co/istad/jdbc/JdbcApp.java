package co.istad.jdbc;

import co.istad.jdbc.config.DatabaseConfig;
import co.istad.jdbc.model.Product;
import co.istad.jdbc.service.ProductService;
import co.istad.jdbc.service.ProductServiceImpl;
import co.istad.jdbc.util.InputUtil;
import co.istad.jdbc.view.View;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class JdbcApp {
    public static void main(String[] args) {
        // Initialize connection with database
        DatabaseConfig.init();
        ProductService productService = new ProductServiceImpl();
        do {
            View.printMenu();
            int menu = InputUtil.getInteger("Enter menu option: ");
            switch (menu) {
                case 0 -> System.exit(0);
                case 1 -> {
                    try {
                        List<Product> productList = productService.findAll();
                        View.printProductList(productList);
                    } catch (RuntimeException e) {
                        View.printHeader(e.getMessage());
                    }
                }
                case 2 -> {
                    View.printHeader("Search product by code!");
                    String code = InputUtil.getText("Enter product code: ");
                    try {
                        productService.getProductByCode(code);

                    } catch (RuntimeException | SQLException e) {
                        View.printHeader(e.getMessage());
                    }
                }
                case 3 -> {
                    String code = InputUtil.getText("Enter product code: ");
                    String name = InputUtil.getText("Enter product name: ");
                    BigDecimal price = InputUtil.getMoney("Enter product price: ");
                    Integer qty = InputUtil.getInteger("Enter product qty: ");
                    Product product = new Product(code,name, price, qty, true);
                    try {
                        productService.save(product);
                        View.printHeader("Product saved successfully..!");
                    } catch (RuntimeException e) {
                        View.printHeader(e.getMessage());
                    }
                }
                case 4 -> {
                    View.printHeader("Update product by code!");
                    String code = InputUtil.getText("Enter product code: ");
                    String name = InputUtil.getText("Enter product name: ");
                    BigDecimal price = InputUtil.getMoney("Enter product price: ");
                    Integer qty = InputUtil.getInteger("Enter product qty: ");

                    Product product = new Product();
                    product.setName(name);
                    product.setPrice(price);
                    product.setQty(qty);

                    try {
                        productService.updateByCode(code,product);
                        View.printHeader("Product updated successfully..!");
                    } catch (RuntimeException | SQLException e) {
                        View.printHeader(e.getMessage());
                    }
                }
                case 5 -> {
                    View.printHeader("Delete product by code!");
                    String code = InputUtil.getText("Enter product code: ");
                    try {
                        productService.deleteByCode(code);
                        View.printHeader("Deleted successfully..!");
                    } catch (RuntimeException | SQLException e) {
                        View.printHeader(e.getMessage());
                    }
                }
                default -> System.out.println("Invalid menu..!");

            }
        }while (true);
        // Print all menu


        // Start operation

    }
}

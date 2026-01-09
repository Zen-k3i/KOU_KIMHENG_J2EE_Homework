package co.istad.jdbc.service;

import co.istad.jdbc.dao.ProductDao;
import co.istad.jdbc.dao.ProductDaoImpl;
import co.istad.jdbc.model.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao;

    public ProductServiceImpl() {
        productDao = new ProductDaoImpl();
    }

    @Override
    public List<Product> findAll() {
        try {
            return productDao.findAll();
        } catch (SQLException e) {
            System.out.println("SQL errored: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public void save(Product product) {
        try{
            productDao.save(product);
        }catch (SQLException e){
            System.out.println("SQL errored: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void updateByCode(String code, Product product) throws SQLException {
        //validation
        Product foundProduct = productDao.findByCode(code)
                .orElseThrow(()-> new RuntimeException("Product code doesn't exist..!"));
        //partially update
        if( !product.getName().isBlank())
            foundProduct.setName(product.getName());
        if ( product.getPrice() != null)
            foundProduct.setPrice(product.getPrice());
        if (product.getQty() != null)
            foundProduct.setQty(product.getQty());

        int affectedRow = productDao.updatedByCode(code, foundProduct);
        if (affectedRow < 1)
            throw new RuntimeException("Update operation failed..!");

    }

    @Override
    public void deleteByCode(String code) {
        try{
            if (!productDao.existByCode(code)) throw new RuntimeException("Product code doesn't exists");
            int affectedRow =  productDao.deleteByCode(code);
            if (affectedRow < 1)
                throw new RuntimeException("Deleted operation failed..!");

        }catch (SQLException e){
            System.out.println("SQL errored: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

    }


    @Override
    public Product getProductByCode(String code) throws SQLException {
        Product foundCode = productDao.getProductByCode(code);
        try{
            productDao.getProductByCode(code);
        }catch (SQLException e){
            System.out.println("SQL errored: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }

        return foundCode;
    }


}

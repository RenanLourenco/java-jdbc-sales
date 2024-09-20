package br.com.renan.main.repositories.product;

import br.com.renan.main.domain.Product;
import br.com.renan.main.repositories.generic.GenericRepo;

import java.sql.Connection;

public class ProductRepo extends GenericRepo<Product> {
    public ProductRepo(Connection c) {
        super(c, "products", Product.class);
    }
}

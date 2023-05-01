package ua.kiev.prog.case2;

import ua.kiev.prog.shared.Product;

import java.sql.Connection;

public class ProductDAOImpl2 extends AbstractDAO<Product> {
    public ProductDAOImpl2(Connection conn, String table) {
        super(conn, table);
    }
}

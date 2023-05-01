package ua.kiev.prog.case2;

import ua.kiev.prog.shared.Orders;

import java.sql.Connection;

public class OrdersDAOImpl2 extends AbstractDAO<Orders> {
    public OrdersDAOImpl2(Connection conn, String table) {
        super(conn, table);
    }
}

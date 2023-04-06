package org.example;

import org.example.entities.Customer;
import org.example.entities.Order;
import org.example.entities.Product;

import java.math.BigDecimal;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

       Connection connection = null;

        try {

            connection = JdbcConn.getConnection();
            System.out.println(connection.getCatalog());
            Statement s = connection.createStatement();



//            insertCustomer(s, 1,"jhon", "jhon@email");
  //          insertCustomer(s, 2,"jane", "jane@email");
//            insertProduct(s, 1, "Bread", new BigDecimal(50) );
//            insertProduct(s, 2, "Banana", new BigDecimal(10) );
  //          insertProduct(s, 3, "Milk", new BigDecimal(10) );
  //          insertProduct(s, 4, "Egg", new BigDecimal(10) );
//            insertOrder(s, 1, 1 , new java.sql.Date(new java.util.Date().getTime()));
//            insertOrderItems(s,1, 1);
//            insertOrderItems(s,1, 2);

            System.out.println("--------------------------------------------");

            String space = "    ";

            ResultSet customers = retreiveALl(s, "customers");
            System.out.println("customer list\n");
            while(customers.next()){
                System.out.println(customers.getInt("id") +
                         space + customers.getString("name") +
                         space + customers.getString("email"));
            }

            System.out.println("--------------------------------------------");

            ResultSet products = retreiveALl(s, "products");
            System.out.println("\nproducts list\n");
            while(products.next()){
                System.out.println(products.getInt("id") +
                        space + products.getString("name") +
                        space + products.getString("price"));
            }


            System.out.println("--------------------------------------------");

            ResultSet orders = retreiveALl(s, "orders");
            while(orders.next()){
                System.out.println("\n orders list\n");
                System.out.println(orders.getInt("id") +
                        space + orders.getString("customer_id") +
                        space  + orders.getDate(3));
            }
            System.out.println("--------------------------------------------");

            System.out.println( " 3, Retrieve by id ");

            System.out.println("================================================");

            ResultSet customer = retreivById(s, "customers", 1);
            while(customer.next()){
                System.out.println(customer.getInt("id") +
                        space + customer.getString("name") +
                        space + customer.getString("email"));
            }
            System.out.println("================================================");

            ResultSet product = retreivById(s, "products", 2);
            while(product.next()){
                System.out.println(product.getInt("id") +
                        space + product.getString("name") +
                        space + product.getString("price"));
            }

            // 4. deleting customer - forgot to cascade , fails to delete the item .

            //   delete(s, "products", 2);
//            System.out.println("product id = 2 is deleted");
//            System.out.println("\nproducts list\n");
//            while(products.next()){
//                System.out.println(products.getInt("id") +
//                        space + products.getString("name") +
//                        space + products.getString("price"));
//            }



        } finally {
            connection.close();
        }
    }

    public static void insertCustomer(Statement s, int id, String name, String email) throws SQLException {

        Customer customer = new Customer(id, name , email);
        s.executeUpdate("INSERT INTO customers values ( " + id + ",'" + name + "','" + email + "')" );

    }

    public static void insertProduct(Statement s, int id, String name, BigDecimal price) throws SQLException {

        Product product = new Product(id, name, price );

        s.executeUpdate("INSERT INTO products values ( " + id + ",'" + name + "'," + price + ")" );

    }

    public static void insertOrder(Statement s, int id, int customerId, Date date) throws SQLException {

        Order order = new Order(id, customerId, date);

        s.executeUpdate("INSERT INTO orders values ( " + id + ",'" + customerId + "','" + date + "')" );

    }

    public static void insertOrderItems(Statement s, int orderId, int productId) throws SQLException {

        s.executeUpdate("INSERT INTO order_items values ( " + orderId+ "," + productId + ")" );

    }

    public static  ResultSet  retreiveALl(Statement s,String table) throws SQLException {

        ResultSet result = s.executeQuery("SELECT * FROM " + table);

        return result;

    }

    public static  ResultSet  retreivById(Statement s,String table, int id) throws SQLException {

        ResultSet result = s.executeQuery("SELECT * FROM " + table + " where id = " + id);

        return result;

    }


    public static  void  delete(Statement s,String table, int id) throws SQLException {

        s.executeUpdate("delete  FROM " + table + " where id = " + id);

    }









}
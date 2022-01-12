package net.codejava.hibernate;

import java.util.HashSet;
import java.util.Set;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class StockManager {
 
    public static void main(String[] args) {
      //SessionFactory
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()

        .configure("hibernate.cfg.xml").build();

        Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();

        SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();

        // obtains the session
        Session session = sessionFactory.openSession();
        session.beginTransaction();
         
        Category category = new Category("Computer");
         
        Product pc = new Product("DELL PC", "Quad-core PC", 1200, category);
         
        Product laptop = new Product("MacBook", "Apple High-end laptop", 2100, category);
         
        Product phone = new Product("iPhone 5", "Apple Best-selling smartphone", 499, category);
         
        Product tablet = new Product("iPad 3", "Apple Best-selling tablet", 1099, category);
         
        Set<Product> products = new HashSet<Product>();
        products.add(pc);
        products.add(laptop);
        products.add(phone);
        products.add(tablet);
         
        category.setProducts(products);
         
        session.save(category);
         
        session.getTransaction().commit();
        session.close();       
    }
}
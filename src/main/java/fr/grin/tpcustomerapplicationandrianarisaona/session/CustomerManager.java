/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package fr.grin.tpcustomerapplicationandrianarisaona.session;

import fr.grin.tpcustomerapplicationandrianarisaona.entities.Customer;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Andrianarisaona
 */
@Stateless
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
   public List<Customer> getAllCustomers() {  
       Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList();
    }  
        
    public Customer update(Customer customer) {
      return em.merge(customer);  
    }   
    public Customer getCustomer(int idCustomer){
       return em.find(Customer.class, idCustomer);  
    }
    public void persist(Customer customer) {
        try {
            em.persist(customer);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
}

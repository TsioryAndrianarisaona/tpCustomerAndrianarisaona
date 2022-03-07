/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package fr.grin.tpcustomerapplicationandrianarisaona.managedbeans;

import fr.grin.tpcustomerapplicationandrianarisaona.entities.Customer;
import fr.grin.tpcustomerapplicationandrianarisaona.session.CustomerManager;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.ejb.EJB;

/**
 *
 * @author Andrianarisaona
 */
@Named(value = "customerDetailsMBean")
@ViewScoped
public class CustomerDetailsMBean implements Serializable {

    private int idCustomer;
    private Customer customer;

    @EJB
    private CustomerManager customerManager;
    
    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }
    
    public Customer getDetails() {
      return customer;
    }
    public String update() {
    // Modifie la base de données.
    // Il faut affecter à customer.
    customer = customerManager.update(customer);
    return "CustomerList";
  }
    /**
     * Creates a new instance of CustomerDetailsMBean
     */
    public CustomerDetailsMBean() {
    }
    public void loadCustomer(){
        this.customer = customerManager.getCustomer(idCustomer);
    }
}

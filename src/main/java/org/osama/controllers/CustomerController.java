package org.osama.controllers;


import org.osama.model.Customer;
import org.osama.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @RequestMapping("/customers")
    public ModelAndView getCustomer(@ModelAttribute("customer") Customer customer )
    {
        List<Customer> customers = customerService.getCustomers();
        ModelAndView modelAndView=new ModelAndView("customers","customers",customers);
        return modelAndView;
    }

    @RequestMapping(value = "/saveUpdateCustomer" ,method = RequestMethod.POST)
    public ModelAndView addDriver(@ModelAttribute("customer") Customer customer) {
        if(customer.getId()==null||customer.getId()==0){
            customerService.saveCustomer(customer);
        }else {
            customerService.updateCustomer(customer);
        }
        return new ModelAndView("redirect:/customers","customer",customer);
    }
    @RequestMapping(value = "customer/update/{id}" ,method = RequestMethod.GET)
    public ModelAndView updateCustomer(@PathVariable("id") int id) {
        ModelAndView modelAndView=new ModelAndView("updateCustomerForm");
        Customer customerById = customerService.findCustomerById(id);
        modelAndView.addObject("customer",customerById);
        return modelAndView;
    }
    @RequestMapping(value = "customer/delete/{id}" ,method = RequestMethod.GET)
    public String deleteCustomer(@PathVariable("id") int id, Principal principal) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";

    }

}

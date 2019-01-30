package org.osama.controllers;

import org.osama.model.Driver;
import org.osama.services.DriverSerivce;
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
public class DriverController {

    @Autowired
    DriverSerivce driverSerivce;
    @RequestMapping("/drivers")
    public ModelAndView getDriver(@ModelAttribute("driver")Driver driver){
        List<Driver> drivers = driverSerivce.getDrivers();
        ModelAndView modelAndView=new ModelAndView("drivers","drivers",drivers);
        return modelAndView;
    }
    @RequestMapping(value = "/saveUpdateDriver" ,method = RequestMethod.POST)
    public ModelAndView addDriver(@ModelAttribute("driver") Driver driver) {
        if(driver.getId()==null||driver.getId()==0){
            driverSerivce.saveDriver(driver);
        }else {
            driverSerivce.updateDriver(driver);
        }
        return new ModelAndView("redirect:/drivers","driver",driver);
    }
    @RequestMapping(value = "driver/update/{id}" ,method = RequestMethod.GET)
    public ModelAndView updateDriver(@PathVariable("id") int id) {
        ModelAndView modelAndView=new ModelAndView("updateDriverForm");
        Driver driverByid = driverSerivce.findDriverById(id);
        modelAndView.addObject("driver",driverByid);
        return modelAndView;
    }
    @RequestMapping(value = "driver/delete/{id}" ,method = RequestMethod.GET)
    public String deleteDriver(@PathVariable("id") int id, Principal principal) {
        driverSerivce.deleteDriver(id);
        return "redirect:/drivers";
    }
}

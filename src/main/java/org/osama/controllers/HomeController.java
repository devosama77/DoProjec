package org.osama.controllers;

import org.osama.model.Book;
import org.osama.model.Customer;
import org.osama.model.Driver;
import org.osama.model.tanker.NumberTanker;
import org.osama.model.tanker.Remark;
import org.osama.model.tanker.SizeTanker;
import org.osama.model.tanker.TypeLiquid;
import org.osama.reportview.ExcelBooking;
import org.osama.services.BookService;
import org.osama.services.CustomerService;
import org.osama.services.DriverSerivce;
import org.osama.services.tanker.NumberTankerService;
import org.osama.services.tanker.RemarkService;
import org.osama.services.tanker.SizeTankerService;
import org.osama.services.tanker.TypeLiquidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    public BookService bookService;
    @Autowired
    public DriverSerivce driverSerivce;
    @Autowired
    public CustomerService customerService;
    @Autowired
    public RemarkService remarkService;
    @Autowired
    public TypeLiquidService typeLiquidService;
    @Autowired
    public SizeTankerService sizeTankerService;
    @Autowired
    public NumberTankerService numberTankerService;

//    @RequestMapping("/")
//    public String getHome(@ModelAttribute("book") Book book,Model model) {
//    return "welcome";
//    }
    @RequestMapping("/")
    public String getBook(@ModelAttribute("book") @Valid Book book,BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "home";
        }
        List<Book> books = bookService.getBooks();
        List<Customer> customers = customerService.getCustomers();
        List<Driver> drivers=driverSerivce.getDrivers();
        List<Remark> listRemark=remarkService.getRemarks();
        List<SizeTanker> listSizeTanker=sizeTankerService.getSizeTankers();
        List<TypeLiquid> listTypeLiquid=typeLiquidService.getTypeLiquids();
        List<NumberTanker> listNumberTankers = numberTankerService.getNumberTankers();

        LinkedHashMap<String,String> linkedHashMapCustomersName=new LinkedHashMap<>();
        LinkedHashMap<String,String> linkedHashMapDriversName=new LinkedHashMap<>();
        LinkedHashMap<String,String> linkedHashMapAddress=new LinkedHashMap<>();

        for(Customer c:customers){
            linkedHashMapCustomersName.put(c.getCustomerName(),c.getCustomerName());
            linkedHashMapAddress.put(c.getAddress(),c.getAddress());
        }
        for(Driver d:drivers){
            linkedHashMapDriversName.put(d.getDriverName(),d.getDriverName());
        }

        model.addAttribute("remarks",listRemark);
        model.addAttribute("typeLiquids",listTypeLiquid);
        model.addAttribute("sizeTankers",listSizeTanker);
        model.addAttribute("numberTankers",listNumberTankers);
        model.addAttribute("customersName",linkedHashMapCustomersName);
        model.addAttribute("driversName",linkedHashMapDriversName);
        model.addAttribute("customerAddresses",linkedHashMapAddress);
        model.addAttribute("customers",customers);
        model.addAttribute("books",books);
        return "home";
    }
    @RequestMapping("/user")
    public String getUser(){
        return "redirect:/";
    }
    @RequestMapping("/admin")
    public String getAdmin(){
        return "redirect:/";
    }

    @RequestMapping(value = "/saveUpdateBook" ,method = RequestMethod.POST)
    public ModelAndView addDriver(@ModelAttribute("book") Book book) {
        if(book.getId()==null||book.getId()==0){
            bookService.saveBook(book);
        }else {
            bookService.updateBook(book);
        }
        return new ModelAndView("redirect:/","book",book);
    }

    @RequestMapping(value = "book/delete/{id}" ,method = RequestMethod.GET)
    public String deleteCustomer(@PathVariable("id") int id, Principal principal) {
        bookService.deleteBook(id);
        return "redirect:/";
    }
    @RequestMapping(value = "book/update/{id}" ,method = RequestMethod.GET)
    public String updateDriver(@PathVariable("id") int id,Model model) {
        List<Customer> customers = customerService.getCustomers();
        List<Driver> drivers=driverSerivce.getDrivers();
        LinkedHashMap<String,String> linkedHashMapCustomersName=new LinkedHashMap<>();
        LinkedHashMap<String,String> linkedHashMapDriversName=new LinkedHashMap<>();
        LinkedHashMap<String,String> linkedHashMapAddress=new LinkedHashMap<>();

        List<Remark> listRemark=remarkService.getRemarks();
        List<SizeTanker> listSizeTanker=sizeTankerService.getSizeTankers();
        List<TypeLiquid> listTypeLiquid=typeLiquidService.getTypeLiquids();
        List<NumberTanker> listNumberTankers = numberTankerService.getNumberTankers();


        for(Customer c:customers){
            linkedHashMapCustomersName.put(c.getCustomerName(),c.getCustomerName());
            linkedHashMapAddress.put(c.getAddress(),c.getAddress());
        }
        for(Driver d:drivers){
            linkedHashMapDriversName.put(d.getDriverName(),d.getDriverName());
        }
        Book book = bookService.findBookById(id);

        model.addAttribute("remarks",listRemark);
        model.addAttribute("typeLiquids",listTypeLiquid);
        model.addAttribute("sizeTankers",listSizeTanker);
        model.addAttribute("numberTankers",listNumberTankers);
        model.addAttribute("book",book);
        model.addAttribute("customersName",linkedHashMapCustomersName);
        model.addAttribute("driversName",linkedHashMapDriversName);
        model.addAttribute("customerAddresses",linkedHashMapAddress);

        return "updateBookForm";
    }

    @RequestMapping("/download")
      public ModelAndView printExcel(HttpServletRequest request){
        String type = request.getParameter("type");
        List<Book> books = bookService.getBooks();

        if(type!=null&&type.equals("xlsx")){

            return new ModelAndView(new ExcelBooking(),"books",books);
        }
//        else  if(type!=null&&type.equals("pdf")){
//
//            return new ModelAndView(new PdfReport(),"allCost",allCost);
//        }
        return new ModelAndView("redirect:/","books",books);
      }
}

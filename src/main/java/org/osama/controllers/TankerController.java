package org.osama.controllers;

import org.osama.model.tanker.NumberTanker;
import org.osama.model.tanker.Remark;
import org.osama.model.tanker.SizeTanker;
import org.osama.model.tanker.TypeLiquid;
import org.osama.services.tanker.NumberTankerService;
import org.osama.services.tanker.RemarkService;
import org.osama.services.tanker.SizeTankerService;
import org.osama.services.tanker.TypeLiquidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
public class TankerController {
    @Autowired
    public RemarkService remarkService;
    @Autowired
    public TypeLiquidService typeLiquidService;
    @Autowired
    public SizeTankerService sizeTankerService;
    @Autowired
    public NumberTankerService numberTankerService;

    @RequestMapping("/tankers")
    public String getTankers(Model model, @ModelAttribute("remark") Remark remark,@ModelAttribute("typeLiquid") TypeLiquid typeLiquid
                                        ,@ModelAttribute("sizeTanker") SizeTanker sizeTanker ,@ModelAttribute("numberTanker") NumberTanker numberTanker){
        List<Remark> remarks = remarkService.getRemarks();
        List<TypeLiquid> typeLiquids = typeLiquidService.getTypeLiquids();
        List<SizeTanker> sizeTankers = sizeTankerService.getSizeTankers();
        List<NumberTanker> numberTankers = numberTankerService.getNumberTankers();
        model.addAttribute("remarks",remarks);
        model.addAttribute("typeLiquids",typeLiquids);
        model.addAttribute("sizeTankers",sizeTankers);
        model.addAttribute("numberTankers",numberTankers);
        return "tankers";
    }
//    Add and delete Remark
    @RequestMapping(value = "/saveRemark" ,method = RequestMethod.POST)
    public ModelAndView addRemark(@ModelAttribute("remark") Remark remark) {
        if(remark.getId()==null||remark.getId()==0){
            remarkService.saveRemark(remark);
        }else {
            remarkService.updateRemark(remark);

        }
        return new ModelAndView("redirect:/tankers","remark",remark);
    }

    @RequestMapping(value = "remark/delete/{id}" ,method = RequestMethod.GET)
    public String deleteDriver(@PathVariable("id") int id) {
        remarkService.deleteRemark(id);
        return "redirect:/tankers";
    }
//    Add and Delete Liquid Type
@RequestMapping(value = "/saveLiquidType" ,method = RequestMethod.POST)
public ModelAndView addLiquid(@ModelAttribute("typeLiquid") TypeLiquid typeLiquid) {
    if(typeLiquid.getId()==null||typeLiquid.getId()==0){
        typeLiquidService.saveTypeLiquid(typeLiquid);

    }else {
        typeLiquidService.updateTypeLiquid(typeLiquid);

    }
    return new ModelAndView("redirect:/tankers","typeLiquid",typeLiquid);
}

    @RequestMapping(value = "typeLiquid/delete/{id}" ,method = RequestMethod.GET)
    public String deleteLiquid(@PathVariable("id") int id) {
        typeLiquidService.deleteTypeLiquid(id);
        return "redirect:/tankers";
    }

    //    Add and Delete Size Tankers
    @RequestMapping(value = "/saveSizeTanker" ,method = RequestMethod.POST)
    public ModelAndView addSizeTanker(@ModelAttribute("sizeTanker") SizeTanker sizeTanker) {
        if(sizeTanker.getId()==null||sizeTanker.getId()==0){
            sizeTankerService.saveSizeTanker(sizeTanker);
        }else {
            sizeTankerService.updateSizeTanker(sizeTanker);

        }
        return new ModelAndView("redirect:/tankers","sizeTanker",sizeTanker);
    }

    @RequestMapping(value = "sizeTanker/delete/{id}" ,method = RequestMethod.GET)
    public String deleteSizeTanker(@PathVariable("id") int id) {
        sizeTankerService.deleteSizeTanker(id);
        return "redirect:/tankers";
    }

    //    Add and Delete Size Tankers
    @RequestMapping(value = "/saveNumberTanker" ,method = RequestMethod.POST)
    public ModelAndView addNumberTanker(@ModelAttribute("numberTanker") NumberTanker numberTanker) {
        if(numberTanker.getId()==null||numberTanker.getId()==0){
            numberTankerService.saveNumberTanker(numberTanker);
        }else {
            numberTankerService.updateNumberTanker(numberTanker);

        }
        return new ModelAndView("redirect:/tankers","numberTanker",numberTanker);
    }

    @RequestMapping(value = "numberTanker/delete/{id}" ,method = RequestMethod.GET)
    public String deleteNumberTanker(@PathVariable("id") int id) {
        numberTankerService.deleteNumberTanker(id);
        return "redirect:/tankers";
    }
}

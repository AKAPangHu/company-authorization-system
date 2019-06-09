package com.ssm.cas.controller;

import com.ssm.cas.domain.Permission;
import com.ssm.cas.service.PermissionService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: 胖虎
 * @date: 2019/5/29 14:16
 **/
@Controller
@RequestMapping("/permission")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findAll(ModelAndView modelAndView){
        List<Permission> permissions = permissionService.findAll();
        modelAndView.addObject("permissionList", permissions);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView findById(@PathVariable String id){
        ModelAndView modelAndView = new ModelAndView();
        Permission permission = permissionService.findById(id);
        modelAndView.addObject(permission);
        modelAndView.setViewName("permission-show");
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePermission(@PathVariable String id){
        permissionService.deleteById(id);
        return "redirect:/permission";
    }
    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String jumpToSave(){
        return "permission-add";
    }
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String save(Permission permission){
        permissionService.save(permission);
        return "redirect:/permission";
    }


}

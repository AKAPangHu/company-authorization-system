package com.ssm.cas.controller;

import com.ssm.cas.domain.Permission;
import com.ssm.cas.domain.Role;
import com.ssm.cas.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: 胖虎
 * @date: 2019/5/28 21:46
 **/
@Controller
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roles = roleService.findAll();
        modelAndView.addObject("roleList", roles);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        ModelAndView modelAndView = new ModelAndView();
        Role role = roleService.findById(id);
        modelAndView.setViewName("role-show");
        modelAndView.addObject(role);
        return modelAndView;
    }

    @RequestMapping("/save.do")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/findAll.do";
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id") String roleId) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Role role = roleService.findById(roleId);
        List<Permission> permissions= roleService.findOthersPermissions(roleId);
        modelAndView.addObject("role", role);
        modelAndView.addObject("permissionList", permissions);
        modelAndView.setViewName("role-permission-add");
        return modelAndView;
    }

    @RequestMapping("/addPermissionToRole.do")
    public ModelAndView addPermissionToRole(@RequestParam(name = "roleId") String roleId, @RequestParam(name = "ids") String[] permissionIds){
        roleService.addPermissionToRole(roleId, permissionIds);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/role/findAll.do");
        return modelAndView;
    }

}

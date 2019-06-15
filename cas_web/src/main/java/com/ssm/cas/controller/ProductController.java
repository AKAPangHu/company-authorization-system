package com.ssm.cas.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.cas.domain.Product;
import com.ssm.cas.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: 胖虎
 * @date: 2019/5/24 8:25
 **/
@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product-list");
        List<Product> product = productService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(product);
        modelAndView.addObject("pageInfo", pageInfo);
        return modelAndView;
    }

    @RequestMapping(value = "/new" , method = RequestMethod.GET)
    public String jumpToSave(){
        return "product-add";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String save(Product product){
        productService.save(product);
        return "redirect:/product";
    }
}

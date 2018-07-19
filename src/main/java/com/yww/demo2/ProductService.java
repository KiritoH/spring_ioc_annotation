package com.yww.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class ProductService {

    @Resource(name = "categoryDao")
    private CategoryDao categoryDao;


    @Autowired
    @Qualifier("productDao")
    private  ProductDao productDao;
    public void save(){
        System.out.println("ProductService的save方法启动了...");
        categoryDao.save();
        productDao.save();
    }
}

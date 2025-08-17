package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/burger") // Test URL’ine uyumlu
public class BurgerController {

    private final BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao){
        this.burgerDao = burgerDao;
    }
    @GetMapping
    public List<Burger> getAllBurgers(){
        return burgerDao.findAll();
    }
    @GetMapping("/{id}")
    public Burger getIdBurgers(@PathVariable Long id){
        return burgerDao.findById(id);
    }
    @PostMapping
    public Burger addBurgers(@RequestBody Burger burger){
        return burgerDao.save(burger);
    }
    @PutMapping("/{id}")
    public Burger updateBurger(@PathVariable int id, @RequestBody Burger burger){
        burgerDao.update(burger);
        return burger;
    }
    @DeleteMapping("/{id}")
    public Burger deleteBurgers(@PathVariable Long id){
        return burgerDao.remove(id);
    }
    @GetMapping("/price/{price}")
    public List<Burger> findByPrice(@PathVariable double price){
        return burgerDao.findByPrice(price);
    }
    @GetMapping("/breadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable BreadType breadType){
        return burgerDao.findByBreadType(breadType);
    }
    @GetMapping("/content/{content}")
    public List<Burger> findByContent(@PathVariable String content){
        return burgerDao.findByContent(content);
    }
}
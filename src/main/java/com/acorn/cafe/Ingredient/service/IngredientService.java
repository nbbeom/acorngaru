package com.acorn.cafe.Ingredient.service;


import com.acorn.cafe.Ingredient.dao.IngredientDAO;
import com.acorn.cafe.Ingredient.dto.IngredientDTO;
import com.acorn.cafe.Ingredient.config.MySqlSessionFactory;

import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;


public class IngredientService {
    IngredientDAO dao;

    public IngredientService(){
        dao = new IngredientDAO();
    }

    public int IngredientDelete(int num) {
        SqlSession session = MySqlSessionFactory.getSession();
        int n = 0;
        try {
            IngredientDAO dao = new IngredientDAO();
            n = dao.IngredientDel(session, num);
            session.commit();
        } finally {
            session.close();
        }
        return n;
    }// end cartAdd

    public int IngredientCreate(IngredientDTO dto) {
        SqlSession session = MySqlSessionFactory.getSession();
        IngredientDAO dao = new IngredientDAO();
        int n=0;
        try {
            n = dao.IngredientCreate(session,dto);
            session.commit();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
        return n;
    }
    public int IngredientDelAll(List<String> list) {
        SqlSession session = MySqlSessionFactory.getSession();
        IngredientDAO dao = new IngredientDAO();
        int n = 0;
        try {
            n = dao.IngredientDelAll(session, list);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return n;
    }

    public int countIngredientByName(String name) {
        SqlSession s = MySqlSessionFactory.getSession();
        int amount;
        try{
            IngredientDAO dao = new IngredientDAO();
            System.out.println("service");
            amount = dao.countIngredientByName(s,name);
        } finally {
            s.close();
        }
        return amount;
    }

    public List<IngredientDTO> searchIngredient(HashMap<String, String> map) {
        SqlSession s = MySqlSessionFactory.getSession();
        List<IngredientDTO> searchIngredient = null;
        try{
            IngredientDAO dao =new IngredientDAO();
            searchIngredient =dao.searchIngredient(s,map);
        }finally {
            s.close();
        }
        return searchIngredient;
    }
    public List<IngredientDTO> allIngredient() {
        SqlSession s = MySqlSessionFactory.getSession();
        List<IngredientDTO> searchIngredient = null;
        try{
            IngredientDAO dao =new IngredientDAO();
            searchIngredient =dao.allIngredient(s);
        }finally {
            s.close();
        }
        return searchIngredient;
    }
}

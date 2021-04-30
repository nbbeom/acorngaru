package com.acorn.cafe.Ingredient.service;


import com.acorn.cafe.Ingredient.dao.IngredientDAO;
import com.acorn.cafe.Ingredient.dto.IngredientDTO;
import com.acorn.cafe.Ingredient.config.MySqlSessionFactory;

import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class IngredientService {
    IngredientDAO dao;

    public IngredientService(){
        dao = new IngredientDAO();
    }

    public List<IngredientDTO> selectAll(){
        SqlSession s = MySqlSessionFactory.getSession();
        List<IngredientDTO> list =null;

        try{
            list =dao.selectAll(s);
        }finally {
            s.close();
        }

        return list;

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
}

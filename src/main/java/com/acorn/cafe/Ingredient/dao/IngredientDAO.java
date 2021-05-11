package com.acorn.cafe.Ingredient.dao;


import com.acorn.cafe.Ingredient.dto.IngredientDTO;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class IngredientDAO {
    public int totalCount(SqlSession s, HashMap<String,String> search){
        return s.selectOne("com.acorn.cafe.Ingredient.config.IngredientMapper.selectAll",search);
    }
    public int IngredientDel(SqlSession session, int num) {
        int n = session.delete("com.acorn.cafe.Ingredient.config.IngredientMapper.ingredientDel", num);
        return n;
    }
    public int IngredientCreate(SqlSession session, IngredientDTO dto) {
        int n = session.insert("com.acorn.cafe.Ingredient.config.IngredientMapper.create",dto);
        return n;
    }
    public int IngredientDelAll(SqlSession session, List<String> list) {
        int n = session.delete("com.acorn.cafe.ingredient.config.IngredientMapper.ingredientDelAll",list);
        return n;
    }

    public int countIngredientByName(SqlSession s, String name) {
        System.out.println("start");
        int amount = s.selectOne("com.acorn.cafe.Ingredient.config.IngredientMapper.countIngredientByName","");
        System.out.println(amount);
        return amount;
    }

    public List<IngredientDTO> searchIngredient(SqlSession s, HashMap<String,String> map) {
        System.out.println("================");
        System.out.println(map);
        List<IngredientDTO> searchIngredient = s.selectList("com.acorn.cafe.Ingredient.config.IngredientMapper.searchIngredient",map);
        System.out.println(searchIngredient);
        return searchIngredient;
    }
    public List<IngredientDTO> allIngredient(SqlSession s) {
        List<IngredientDTO> searchIngredient = s.selectList("com.acorn.cafe.Ingredient.config.IngredientMapper.ingredientAllList");
        return searchIngredient;
    }
}

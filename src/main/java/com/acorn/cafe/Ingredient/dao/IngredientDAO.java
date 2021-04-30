package com.acorn.cafe.Ingredient.dao;


import com.acorn.cafe.Ingredient.dto.IngredientDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class IngredientDAO {
    public List<IngredientDTO> selectAll(SqlSession session){
        List<IngredientDTO> list =
                session.selectList("com.acorn.cafe.Ingredient.config.IngredientMapper.selectAll");
        return list;
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
}

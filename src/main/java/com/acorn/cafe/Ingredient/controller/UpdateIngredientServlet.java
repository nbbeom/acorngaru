package com.acorn.cafe.Ingredient.controller;

import com.acorn.cafe.Ingredient.dto.IngredientDTO;
import com.acorn.cafe.Ingredient.service.IngredientService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UpdateIngredientServlet")
public class UpdateIngredientServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String nextPage = null;
        IngredientDTO dto = new IngredientDTO();
        dto.setId(Integer.parseInt(request.getParameter("update_id")));
        dto.setName(request.getParameter("update_name"));
        dto.setPartner(request.getParameter("update_partner"));
        dto.setPrice(Integer.parseInt(request.getParameter("update_price")));
        dto.setQuantity(Integer.parseInt(request.getParameter("update_quantity")));
        dto.setUnit(request.getParameter("update_unit"));
        System.out.println(dto);// "10,20,21"

        String ingredientUrl= "/WEB-INF/ingredient/ingredient.jsp";
        RequestDispatcher dis = null;
        dis = request.getRequestDispatcher(ingredientUrl);
        dis.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

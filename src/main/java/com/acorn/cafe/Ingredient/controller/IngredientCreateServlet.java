package com.acorn.cafe.Ingredient.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acorn.cafe.Ingredient.service.IngredientService;
import com.acorn.cafe.Ingredient.dto.IngredientDTO;

/**
 * Servlet implementation class Ingedient_create
 */
@WebServlet("/Ingedient_create")
public class IngredientCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = 0;
        String name = request.getParameter("insert_name");
        int quantity = Integer.parseInt(request.getParameter("insert_quantity"));
        String partner = request.getParameter("insert_partner");
        int price = Integer.parseInt(request.getParameter("insert_price"));
        String unit = request.getParameter("insert_unit");
        System.out.println(name+"\t"+quantity+"\t"+partner+"\t"+unit);


        IngredientService service = new IngredientService();
        List<IngredientDTO>list = Arrays.asList();
        IngredientDTO dto = new IngredientDTO(id,name,quantity,price,unit,partner);
        int n = service.IngredientCreate(dto);
        System.out.println("실행된 레코드갯수: "+n);
        if (n !=0) {
            String ingredientUrl= "/WEB-INF/ingredient/ingredient.jsp";
            RequestDispatcher dis = null;
            dis = request.getRequestDispatcher(ingredientUrl);
            dis.forward(request,response);
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
package com.acorn.cafe.Ingredient.controller;

import com.acorn.cafe.Ingredient.service.IngredientService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DeleteAllIngredientServlet
 */
@WebServlet("/DeleteAllIngredientServlet")
public class DeleteAllIngredientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String data = request.getParameter("name");
        String[] x = data.split(",");
        List<String>list = Arrays.asList(x);//List.생성
        System.out.println(list);


        IngredientService service = new IngredientService();
        int n = service.IngredientDelAll(list);
        System.out.println("실행된 레코드갯수: "+n);

        response.sendRedirect("Ingredient.jsp");


    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
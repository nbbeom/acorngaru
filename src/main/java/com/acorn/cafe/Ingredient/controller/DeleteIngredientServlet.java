package com.acorn.cafe.Ingredient.controller;

import com.acorn.cafe.Ingredient.dto.IngredientDTO;
import com.acorn.cafe.Ingredient.service.IngredientService;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/DeleteIngredientServlet")
public class DeleteIngredientServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String nextPage = null;
        String data = request.getParameter("name");
        System.out.println(data);// "10,20,21"
        IngredientService service = new IngredientService();
        int n = service.IngredientDelete(Integer.parseInt(data));  //개별 데이삭제 완료
        System.out.println(n);


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

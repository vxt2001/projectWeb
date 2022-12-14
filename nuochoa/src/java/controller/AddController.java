/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dao.CategoryDAO;
import dao.ProductDAO;
import dao.ThuonghieuDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Category;
import model.Thuonghieu;

/**
 *
 * @author Admin
 */
public class AddController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
         request.getRequestDispatcher("add.jsp").forward(request, response);
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        List<Category> listCategories = new CategoryDAO().getAllCategories();
        request.setAttribute("listCategories", listCategories);
        List<Thuonghieu> thuonghieu = new ThuonghieuDAO().getAllTH();
        request.setAttribute("thuonghieu", thuonghieu);
        request.getRequestDispatcher("add.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
          String p_id = request.getParameter("id");
        String p_name = request.getParameter("name");
        String p_quantity = request.getParameter("quantity");
        String p_price = request.getParameter("price");
        String p_description = request.getParameter("description");
        String p_imageUrl = request.getParameter("imageUrl");
        String p_categoryIdl = request.getParameter("categoryId");
        String p_th_id = request.getParameter("th_id");
         List<Category> listCategories = new CategoryDAO().getAllCategories();
        request.setAttribute("listCategories", listCategories);
       List<Thuonghieu> thuonghieu = new ThuonghieuDAO().getAllTH();
        request.setAttribute("thuonghieu", thuonghieu);
         ProductDAO p= new ProductDAO();
        p.add(p_name, p_quantity, p_price, p_description, p_imageUrl, p_categoryIdl, p_th_id);
         request.getRequestDispatcher("add.jsp").forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

package com.liyan.controller;

import com.liyan.pojo.Invitations;
import com.liyan.service.InvitationsService;
import com.liyan.service.impl.InvitationsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * @Author: liyan
 */
@WebServlet("/invitation")
public class InvitationController extends HttpServlet {

    private Invitations invitations;

    //业务类对象
    private InvitationsService invitationsService = new InvitationsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求字符集和响应字符集
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");


        invitations = new Invitations();

        //接收action参数的值判断功能
        String action = req.getParameter("action");

        if("insert".equals(action)){
            //添加功能
            insertInvitation(req,resp);

        }else if("showAllInvitations".equals(action)){

            showAllInvitations(req,resp);


        }else if("deleteInvitations".equals(action)){

            delectInvitations(req,resp);

        }


    }


    //根据id删除

    private void  delectInvitations(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int id = Integer.valueOf(req.getParameter("id"));
        //传入删除业务
        boolean bl = invitationsService.deleteInvitations(id);

        //根据结果进行提示
        if(bl){
            req.setAttribute("mess","删除成功");
        }else{
            req.setAttribute("mess","该帖子无法删除");

        }
        req.getRequestDispatcher("invitation?action=showAllInvitations").forward(req,resp);


    }



    private void showAllInvitations(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //接收页码
        String pageNum = req.getParameter("pageNum");

        if(pageNum == null || "".equals(pageNum)){//无页码
            pageNum="1";
        }

        System.out.println(pageNum);


        Map<String,Object> Map= invitationsService.showAllInvitations(Integer.valueOf(pageNum));

        //设置共享属性
        req.setAttribute("Map",Map);

        //请求转发到index页面
        req.getRequestDispatcher("index.jsp").forward(req,resp);

    }


    private void  insertInvitation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        invitations.setTitle(req.getParameter("title"));
        invitations.setContent(req.getParameter("content"));

        invitations.setPostingTime(new Date());


        invitationsService.insertinvitation(invitations);

        //进行响应
        req.setAttribute("mess","添加成功");
        req.getRequestDispatcher("invitation?action=showAllInvitations").forward(req,resp);

    }

}

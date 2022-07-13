package com.liyan.service.impl;

import com.liyan.dao.InvitationsDao;
import com.liyan.dao.impl.InvitationsDaoImpl;
import com.liyan.pojo.Invitations;
import com.liyan.service.InvitationsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: liyan
 */
public class InvitationsServiceImpl implements InvitationsService {


    private InvitationsDao invitationsDao = new InvitationsDaoImpl();



    @Override
    public Map<String, Object> showAllInvitations(int pageNum) {

        //每页展示的数量
        int pageSize = 10;

        //获取表中书籍总数量
        long invitationCount = invitationsDao.findInvitationCount();

        //计算总页数
        int pageCount =(int) invitationCount/pageSize;

        if(pageCount==0){ //总页数不能为0
            pageCount=1;

        }else if(invitationCount%pageSize!=0){//取模不等于0，说明有剩余，则页数+1

            pageCount+=1;
        }

        //判断页码是否正确
        if(pageNum<1){
            pageNum=1;

        }else if(pageNum>pageCount){
            pageNum=pageCount;
        }

        //计算当前页的查询起始位置
        int beginIndex = (pageNum-1)*pageSize;

        //调用dao中的查询书籍方法
        List<Map<String,Object>> invitations = invitationsDao.findInvitations(beginIndex,pageSize);


        Map<String,Object> map = new HashMap<>();
        map.put("invitations",invitations);
        map.put("pageNum",pageNum);
        map.put("pageCount",pageCount);

        return map;
    }

    @Override
    public boolean deleteInvitations(int id) {

//调用数据操作
        int i = invitationsDao.deleteById(id);
        if(i>0){
            return true;
        }
        return false;

    }

    @Override
    public void insertinvitation(Invitations invitations) {

        invitationsDao.insertInvitation(invitations);
    }
}

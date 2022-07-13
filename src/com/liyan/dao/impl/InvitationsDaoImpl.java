package com.liyan.dao.impl;

import com.liyan.dao.InvitationsDao;
import com.liyan.pojo.Invitations;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @Author: liyan
 */
public class InvitationsDaoImpl implements InvitationsDao {

    //jdbc工具类对象
    private JdbcTemplate template = new JdbcTemplate(new ComboPooledDataSource());


    @Override
    public long findInvitationCount() {
        String sql = "select count(id) from invitation";
        long count = template.queryForObject(sql,Long.class);
        return count;
    }

    @Override
    public List<Map<String, Object>> findInvitations(int beginIndex, int pageSize) {
        String sql = "select * from invitation limit ?,?";
        Object[] objects = {beginIndex,pageSize};
        List<Map<String,Object>> invitations = template.queryForList(sql,objects);
        return invitations;
    }

    @Override
    public int deleteById(int id) {

        String sql = "delete from invitation where id=? ";
        return template.update(sql,id);

    }

    @Override
    public void insertInvitation(Invitations invitations) {

        String sql = "insert into invitation value(null,?,?,?)";
        Object[] objects = {invitations.getTitle(),invitations.getContent(),invitations.getPostingTime()};
        template.update(sql,objects);
    }
}

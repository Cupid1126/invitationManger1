package com.liyan.dao;

import com.liyan.pojo.Invitations;

import java.util.List;
import java.util.Map;

/**
 * @Author: liyan
 */
public interface InvitationsDao {
   public long findInvitationCount();

   public List<Map<String, Object>> findInvitations(int beginIndex, int pageSize);

   public int deleteById(int id);

   public void insertInvitation(Invitations invitations);
}

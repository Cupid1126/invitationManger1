package com.liyan.service;

import com.liyan.pojo.Invitations;

import java.util.Map;

/**
 * @Author: liyan
 */
public interface InvitationsService {
   public Map<String, Object> showAllInvitations(int pageNum);

   public boolean deleteInvitations(int id);

   public void insertinvitation(Invitations invitations);
}

package com.dong.sesrvice;

import java.util.List;

import com.dong.entity.User;

public interface UserService {
	public int insert(User user);
    
    public int update(User user);
   
    public int delete(String userName);
   
    public List<User> selectAll();
   
    public int countAll();
   
    public User findByUserName(String userName);
}

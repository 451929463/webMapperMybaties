package cn.tri.mapper;

import cn.tri.pojo.User;


public interface UserMapper {
	public User getId(int id);
	public void addUser(User user);
	public void deleteUser(int id);
	public void updateUser(User user);
}

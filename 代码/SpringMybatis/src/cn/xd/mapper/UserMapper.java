package cn.xd.mapper;

import java.util.List;

import cn.xd.po.User;

public interface UserMapper {
	
	//����id�����û�
	public User findUserById(String id)throws Exception;
	
	//�����û�����ѯ����ƥ����û�
	public List<User> findUserByName(String name)throws Exception;
	
	//����û���Ϣ
	public void insertUser(User user)throws Exception;
	
	//ɾ���û���Ϣ
	public void deleteUser(String id)throws Exception;
}

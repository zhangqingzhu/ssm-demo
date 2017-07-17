package cn.com.chnsys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.chnsys.pojo.User;

public interface UserMapper {
	List<User> login(User user);
	/**
	 * 锟斤拷询锟斤拷锟叫碉拷锟矫伙拷锟斤拷息
	 * @param user
	 * @return user锟斤拷锟斤拷
	 */
	List<User> findAllUser();
	/**
	 * 锟斤拷锟斤拷没锟斤拷锟较�
	 * @param user
	 */
	void save(User user);
	/**
	 * 删锟斤拷锟矫伙拷锟斤拷息
	 * @param id
	 * @return 锟斤拷锟截诧拷锟斤拷值锟斤拷true锟斤拷锟缴撅拷锟缴癸拷
	 */
	boolean delUser(int id);
	/**
	 * 锟斤拷锟絀D锟斤拷锟斤拷锟矫伙拷锟斤拷息
	 * @param id
	 * @return 锟斤拷锟斤拷一锟斤拷User锟斤拷锟斤拷
	 */
	User findById(int id);
	/**
	 * 锟斤拷锟斤拷锟矫伙拷锟斤拷息
	 * @param user
	 * @return 锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷值锟斤拷true锟斤拷锟斤拷锟铰成癸拷
	 */
	boolean updateUser(User user);
}

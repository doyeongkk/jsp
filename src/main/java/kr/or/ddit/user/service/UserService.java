package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.MemberVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.repository.UserDaoI;

public class UserService implements UserServiceI{
	private UserDaoI userDao = new UserDao();
	@Override
	public List<UserVo> selectAllUser() {
		return userDao.selectAllUser();
	}

	@Override
	public UserVo selectUser(String userid) {
		return userDao.selectUser(userid);
	}

	@Override
	public Map<String, Object> selectPagingUser(PageVo pageVo) {
		Map<String, Object> map = new HashMap<>();
		
		List<UserVo> userList = userDao.selectPagingUser(pageVo);
		int userCnt = userDao.selectAllCnt();
		
		map.put("userList", userList);
		map.put("userCnt", userCnt);
		
		return map;
		
	}

	@Override
	public List<MemberVo> selectAllMember() {
		return userDao.selectAllMember();
	}
	
}

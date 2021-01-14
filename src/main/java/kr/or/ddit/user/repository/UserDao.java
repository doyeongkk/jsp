package kr.or.ddit.user.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.user.model.MemberVo;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoI{

   @Override
   public List<UserVo> selectAllUser() {
      SqlSession sqlSession = MybatisUtil.getSqlSession();
      
      // select : 리턴되는 값의 복수 유무를 판단
      //         1. 단건 : 일반객체를 반환(UserVo) selectOne()
      //         2. 여러건 : List<UserVo> selectList()
      // insert, update, delete : insert, update, delete
      
      // 메소드 이름과 실행할 sql id를 동일하게 맞추자(유지보수-다른 개발자의 가독성)
      
      
      List<UserVo> userList = sqlSession.selectList("users.selectAllUser");
      
      // 사용한 자원 반환
      sqlSession.close();
      
      return userList;
   }

   @Override
   public UserVo selectUser(String userid) {
      SqlSession sqlSession = MybatisUtil.getSqlSession();
      
      UserVo user = sqlSession.selectOne("users.selectUser", userid);
      sqlSession.close();
      
      return user;
   }

   @Override
   public List<UserVo> selectPagingUser(PageVo pageVo) {
      SqlSession sqlSession = MybatisUtil.getSqlSession();
      
      List<UserVo> userList = sqlSession.selectList("users.selectPagingUser", pageVo);
      sqlSession.close();
      
      return userList;
   }

   @Override
   public List<MemberVo> selectAllMember() {
      SqlSession sqlSession = MybatisUtil.getSqlSession();

      List<MemberVo> memList = sqlSession.selectList("users.selectAllMember");
      
      // 사용한 자원 반환
      sqlSession.close();
      
      return memList;
   }

   @Override
   public int selectAllCnt() {
      SqlSession sqlSession = MybatisUtil.getSqlSession();
      
      int userCnt = sqlSession.selectOne("users.selectAllCnt");
      sqlSession.close();
      
      return userCnt;
   }

   @Override
   public int selectAllMemCnt() {
      SqlSession sqlSession = MybatisUtil.getSqlSession();
      
      int memberCnt = sqlSession.selectOne("users.selectAllMemCnt");
      sqlSession.close();
      
      return memberCnt;
   }

   @Override
   public List<MemberVo> selectPagingMember(PageVo pageVo) {
      SqlSession sqlSession = MybatisUtil.getSqlSession();
      
      List<MemberVo> memList = sqlSession.selectList("users.selectPagingMember", pageVo);
      sqlSession.close();
      
      return memList;
   }

   @Override
   public int modifyUser(UserVo userVo) {
      
      SqlSession sqlSession = MybatisUtil.getSqlSession();
      
      int updateCnt = sqlSession.update("users.modifyUser", userVo);
      
      if(updateCnt == 1) {
         sqlSession.commit();
      }else {
         sqlSession.rollback();
      }
      
      sqlSession.close();
      
      return updateCnt;
   }

   @Override
   public int insertUser(UserVo userVo) {
      
      SqlSession sqlSession = MybatisUtil.getSqlSession();
      
      int insertCnt = sqlSession.insert("users.insertUser", userVo);
      
      if(insertCnt == 1) {
         sqlSession.commit();
      }else {
         sqlSession.rollback();
      }
      
      sqlSession.close();
      
      return insertCnt;
   }

   @Override
   public int deleteUser(String userid) {
      
      SqlSession sqlSession = MybatisUtil.getSqlSession();
      
      int deleteCnt = sqlSession.delete("users.deleteUser", userid);
      
      if(deleteCnt == 1) {
         sqlSession.commit();
      }else {
         sqlSession.rollback();
      }
      
      sqlSession.close();
      
      return deleteCnt;
   }

   
   
}





















package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.repository.UserDao;
import kr.or.ddit.user.repository.UserDaoI;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

public class UserServiceTest {
 
private UserServiceI UserService;

	@Before
	public void setup() {
		UserService = new UserService();
		//테스트에서 사용할 신규 사용자 추가
		UserVo userVo = new UserVo("testUser", "테스트사용자", "testUserPass", 
				               new Date(), "대덕", "대전 중구 중앙로 76", "4층", "34940", "brown.png", "uuid-generated-filename.png");
		
		UserService.insertUser(userVo);
		
	     // 신규 입력 테스트를 위해 테스트 과정에서 입력된 데이터를 삭제 
		UserService.deleteUser("ddit_n");
	}
	
	@After
	public void tearDown() {
		UserService.deleteUser("testUser");
	}
	
	
	
	
	
	
	
	
	
   //전체 사용자 조회 테스트
      @Test
      public void selectAllUsertest() {
         /***Given***/
        

         /***When***/
         List<UserVo> userList = UserService.selectAllUser();
         
         /***Then***/
         assertEquals(16, userList.size());
      }
      
      //사용자 아이디를 이용하여 특정 사용자 정보 조회
      @Test
      public void selectUserTest() {
         /***Given***/
        
         String userid = "brown";

         /***When***/
         UserVo user = UserService.selectUser(userid);
         
         /***Then***/
         assertNotNull(user);
         assertEquals("브라운", user.getUsernm());
      }
      
      //사용자 아이디가 존재하지 않을 때, 특정 사용자 조회
      
      
      // 사용자 페이징 조회 테스트
      @Test
      public void selectPagingTest() {
         /***Given***/
        
         PageVo pageVo = new PageVo(2, 5);
         
         /***When***/
         Map<String, Object> map = UserService.selectPagingUser(pageVo);
         List<UserVo> userList = (List<UserVo>)map.get("userList");
         int userCnt = (int)map.get("userCnt");
         
         /***Then***/
         assertEquals(5, userList.size());
         assertEquals(16, userCnt);
      }
      
      @Test
      public void selectAllUserCntTest() {
         /***Given***/
         UserDaoI userDao = new UserDao();

         /***When***/
         int userCnt = userDao.selectAllCnt();

         /***Then***/
         assertEquals(16, userCnt);
      }
      

}
import static org.junit.Assert.*;

import org.junit.Test;

public class paginationTest {

	@Test
	public void pagination() {
		/***Given***/
		int userTotcnt = 32;
		int pageSize =5;

		/***When***/
      //  올림:Math.ceil(a)
        int pagination = (int)Math.ceil((double)userTotcnt/pageSize);
		
		/***Then***/
        assertEquals(7, pagination);
	}
	

}

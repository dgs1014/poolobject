/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.ReusablePool;

/**
 * @author alumno
 *
 */
public class ReusablePoolTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		
		ReusablePool pool1 = new ReusablePool(10);
		ReusablePool pool2 = null;
		
		ReusablePool i1 = pool1.getInstance();
		assertNotEquals(i1, null);
		
		ReusablePool i2 = pool2.getInstance();
		assertNotEquals(i2,null);
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() {
		int n = 20;
		boolean excepcion = false;
		ReusablePool pool = new ReusablePool(n);
		for(int i = 0; i < n;i++) {
			try {
				pool.acquireReusable();	
			}catch(NotFreeInstanceException e ) {
				fail("No adquiere todos los disponibles");
			}
			
		}
		try {
			pool.acquireReusable();	
		}catch(NotFreeInstanceException e ) {
			excepcion = true;
		}
		if(excepcion = false) {
			fail("Adquiere minimo un reusable mas");
		}
		
		
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		fail("Not yet implemented");
	}

}

package java7;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MultiCatch {

	public static void main(String[] args) throws Exception {
		//new MultiCatch().useReflection();
		new MultiCatch().useReflectionTryCatch();
		
		//new MultiCatch().someFunction();
	}
	
	void useReflection() throws NoSuchMethodException, SecurityException {
			//Method method = Object.class.getMethod("test");
		Method method = MultiCatch.class.getMethod("test");
			try {
				method.invoke(this);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	void useReflectionTryCatch() throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException, IOException {
		//Method method = Object.class.getMethod("test");
		Method method = MultiCatch.class.getMethod("test");
		try {
			method.invoke(this);
			throw new IOException();
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException Exception caught");
			e.printStackTrace();
			throw e;
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException Exception caught");
			e.printStackTrace();
			throw e;
		} catch (InvocationTargetException e) {
			 System.out.println("InvocationTargetException Exception caught");
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			 System.out.println("IOException caught");
			e.printStackTrace();
			//System.exit(1);
			throw e;
		} finally {
			System.out.println("finally called");
		}
	}	
	
	public void someFunction() throws Exception {
	    try {
	        throw new Exception();
	    } catch (Exception e) {
	        System.out.println("Exception caught");
	        throw new Exception(e);
	    } finally {
	       System.out.println("finally called");
	    }
	}
	 public void test() {
		System.out.println("Test method called Using Reflection");
	}
}

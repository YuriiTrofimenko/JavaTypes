package org.ellie.types.model;

public class MyInt {

	//public int x;
	private int x;
	private static int count;
	
	static {
		
		count = 0;
	}
	
	public MyInt() {
		count++;
	}
	
	public MyInt(int _x) throws Exception {
		
		if(_x < 0) {
			throw new Exception("x < 0");
		}
		this.x = _x;
		count++;
	}
	
	public static int getCount() {
		return count;
	}

	public int getX() {
		return x;
	}

	@Override
	public String toString() {
		return String.valueOf(x);
	}
}

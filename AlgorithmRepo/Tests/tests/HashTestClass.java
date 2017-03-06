package tests;

public class HashTestClass {
	private String name;
	private int value;
	private Double[] valueArray;
	private HashTestInnerClass box;
	private int hash = 0;
	
	public HashTestClass(String name, int value, int boxVal, boolean boxBoolean, Double[] valueArray){
		this.name = name;
		this.value = value;
		this.box = new HashTestInnerClass(boxVal, boxBoolean);
		this.valueArray = valueArray;
	}
	
	public int hashCode()
	{
		int h = hash;
		if(h != 0){ return h;}
		
		h = 17;
		h = 31*h + name.hashCode();
		h = 31*h + ((Integer) value).hashCode();
		h = 31*h + box.hashCode();
		for(int i = 0; i < valueArray.length; i++){
			h = 31*h + valueArray[i].hashCode();
		}
		
		hash = h;
		return h;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	@Override
	public boolean equals(Object x)
	{
		if(this == x) return true;
		if(x == null) return false;
		if(x.getClass() != this.getClass()) return false;
		
		HashTestClass that = (HashTestClass) x;
		if(this.name != that.name) return false;
		if(this.value != that.value) return false;
		if(this.valueArray != that.valueArray) return false;
		if(this.box != that.box) return false;
		return true;
	}
	
	private static class HashTestInnerClass{
		int boxVal;
		boolean boxBoolean;
		int hash = 0;
		
		public HashTestInnerClass(int boxVal, boolean boxBoolean){
			this.boxVal = boxVal;
			this.boxBoolean = boxBoolean;
		}
		
		public int hashCode()
		{
			int h = hash;
			if(h != 0) return h;
			
			h = 17;
			h = 31*h + ((Integer) boxVal).hashCode();
			h = 31*h + ((Boolean) boxBoolean).hashCode();
			
			hash = h;
			return h;
		}
		
		@Override
		public boolean equals(Object x){
			if(this == x) return true;
			if(x == null) return false;
			if(this.getClass() != x.getClass()) return false;
			
			HashTestInnerClass that = (HashTestInnerClass) x;
			if(this.boxVal != that.boxVal) return false;
			if(this.boxBoolean != that.boxBoolean) return false;
			return true;
		}
	}
}

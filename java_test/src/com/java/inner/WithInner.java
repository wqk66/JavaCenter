package com.java.inner;

public class WithInner {

	class Inner{
		
	}
}

class InnerC extends WithInner.Inner{
	InnerC(WithInner wi){
		wi.super();
	}
}

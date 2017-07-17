package com.javaweb.struts;

import com.opensymphony.xwork2.ActionSupport;

public class InputAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private boolean booleanVal;
	private char charVal;
	private int intVal;
	private long longVal;
	private float floatVal;
	private double doubleVal;
	public boolean isBooleanVal() {
		return booleanVal;
	}
	public void setBooleanVal(boolean booleanVal) {
		this.booleanVal = booleanVal;
	}
	public char getCharVal() {
		return charVal;
	}
	public void setCharVal(char charVal) {
		this.charVal = charVal;
	}
	public int getIntVal() {
		return intVal;
	}
	public void setIntVal(int intVal) {
		this.intVal = intVal;
	}
	public long getLongVal() {
		return longVal;
	}
	public void setLongVal(long longVal) {
		this.longVal = longVal;
	}
	public float getFloatVal() {
		return floatVal;
	}
	public void setFloatVal(float floatVal) {
		this.floatVal = floatVal;
	}
	public double getDoubleVal() {
		return doubleVal;
	}
	public void setDoubleVal(double doubleVal) {
		this.doubleVal = doubleVal;
	}
	//execute·½·¨
	public String execute() throws Exception{
		return SUCCESS;
	}
	
}

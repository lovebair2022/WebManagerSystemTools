package com.mxsm.commontool;

/**
 * 
 * @author mxsm
 *
 */

public class ParseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5524428450426225495L;

	
	public ParseException(){
		
		super();
	}
	
	public ParseException(String message)
	{
		super(message);
	}
	
	public ParseException(String message, Throwable cause)
	{
		super(message, cause);
	} 
	
	public ParseException(Throwable cause)
	{
		super(cause);
	} 
}

/**
 * 
 */
package com.alti.local.admin.exception;

/**
 * @author syandagudita
 *
 */
public class ViewNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6724443720766585077L;

	public ViewNotFoundException() {
		super();
	}
	
	public ViewNotFoundException(String message) {
		super(message);
	}
	
	public ViewNotFoundException(Throwable throwable) {
		super(throwable);
	}
	
	
}

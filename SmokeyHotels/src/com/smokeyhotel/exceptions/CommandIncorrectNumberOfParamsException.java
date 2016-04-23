/**
 * 
 */
package com.smokeyhotel.exceptions;

/**
 * @author InsaneAboutTNT
 *
 */
public class CommandIncorrectNumberOfParamsException extends RuntimeException {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param message
	 */
	public CommandIncorrectNumberOfParamsException(int number, int expectedNumber) {
		super("Incorrect number of parameters entered in the command"
				+ ", expected number: " + expectedNumber
				+ " input number: " + number);
		// TODO Auto-generated constructor stub
	}
}

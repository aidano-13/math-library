package com.github.aidano7.mathLibrary.errors;

public class InadequateAmountOfNumbers extends Exception {

	private static final long serialVersionUID = 8681051505725216774L;

	public InadequateAmountOfNumbers(String errorMessage) {
		super(errorMessage);
	}
}

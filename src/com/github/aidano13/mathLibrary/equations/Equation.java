package com.github.aidano13.mathLibrary.equations;

import com.github.aidano13.mathLibrary.errors.InadequateAmountOfNumbers;

public interface Equation {

	public float get(float x);

	public Equation pointsToLine(float[][] points) throws InadequateAmountOfNumbers;

	public String toString();
}

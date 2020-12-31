package com.github.aidano13.mathLibrary.equations;

import com.github.aidano13.mathLibrary.errors.InadequateAmountOfNumbers;
import com.github.aidano13.mathLibrary.geometry.Point;

public class LinearEquation implements Equation {

	public static Equation pointsToLine(float[][] points) throws InadequateAmountOfNumbers {
		if (points.length >= 2) {
			float x1 = points[0][0];
			float y1 = points[0][1];
			float x2 = points[1][0];
			float y2 = points[1][1];

			float m = (y2 - y1) / (x2 - x1);

			float b = y1 - m * x1;

			return new LinearEquation(m, b);
		} else {
			throw new InadequateAmountOfNumbers(
					String.format("Expected two or more points, instead found %o", points.length));
		}
	}

	public static Equation pointsToLine(Point[] points) throws InadequateAmountOfNumbers {
		if (points.length >= 2) {
			float x1 = points[0].x;
			float y1 = points[0].y;
			float x2 = points[1].x;
			float y2 = points[1].y;

			float m = (y2 - y1) / (x2 - x1);

			float b = y1 - m * x1;

			return new LinearEquation(m, b);
		} else {
			throw new InadequateAmountOfNumbers(
					String.format("Expected two or more points, instead found %o", points.length));
		}
	}

	public float m;
	public float b;

	public LinearEquation(float m, float b) {
		this.m = m;
		this.b = b;
	}

	public LinearEquation(float m) {
		this.m = m;
		this.b = 0;
	}

	public LinearEquation() {
		this.m = 0;
		this.b = 0;
	}

	@Override
	public float get(float x) {
		return m * x + b;
	}

	@Override
	public String toString() {
		return String.format("y = %fx + %f", m, b);
	}
}

package com.github.aidano13.mathLibrary.equations;

import com.github.aidano13.mathLibrary.errors.ImaginaryAnswerException;
import com.github.aidano13.mathLibrary.errors.InadequateAmountOfNumbers;
import com.github.aidano13.mathLibrary.geometry.Point;

public class QuadraticEquation implements Equation {

	public static Equation pointsToLine(float[][] points) throws InadequateAmountOfNumbers {
		if (points.length >= 3) {
			float x1 = points[0][0];
			float y1 = points[0][1];
			float x2 = points[1][0];
			float y2 = points[1][1];
			float x3 = points[2][0];
			float y3 = points[2][1];

			float A1 = -(x1 * x1) + (x2 * x2);
			float B1 = -x1 + x2;
			float D1 = -y1 + y2;

			float A2 = -(x2 * x2) + (x3 * x3);
			float B2 = -x2 + x3;
			float D2 = -y2 + y3;

			float B_MULTIPLIER = -(B2 / B1);

			float A3 = B_MULTIPLIER * A1 + A2;
			float D3 = B_MULTIPLIER * D1 + D2;

			float a = D3 / A3;
			float b = (D1 - A1 * a) / B1;
			float c = y1 - (a * x1 * a * x1) - b * x1;

			return new QuadraticEquation(a, b, c);
		} else {
			throw new InadequateAmountOfNumbers(
					String.format("Expected three or more points, instead found %o", points.length));
		}
	}

	public static Equation pointsToLine(Point[] points) throws InadequateAmountOfNumbers {
		if (points.length >= 3) {
			float x1 = points[0].x;
			float y1 = points[0].y;
			float x2 = points[1].x;
			float y2 = points[1].y;
			float x3 = points[2].x;
			float y3 = points[2].y;

			float A1 = -(x1 * x1) + (x2 * x2);
			float B1 = -x1 + x2;
			float D1 = -y1 + y2;

			float A2 = -(x2 * x2) + (x3 * x3);
			float B2 = -x2 + x3;
			float D2 = -y2 + y3;

			float B_MULTIPLIER = -(B2 / B1);

			float A3 = B_MULTIPLIER * A1 + A2;
			float D3 = B_MULTIPLIER * D1 + D2;

			float a = D3 / A3;
			float b = (D1 - A1 * a) / B1;
			float c = y1 - (a * x1 * a * x1) - b * x1;

			return new QuadraticEquation(a, b, c);
		} else {
			throw new InadequateAmountOfNumbers(
					String.format("Expected three or more points, instead found %o", points.length));
		}
	}

	public static Equation pointsToLine(Point a, Point b, Point c) {
		float x1 = a.x;
		float y1 = a.y;
		float x2 = b.x;
		float y2 = b.y;
		float x3 = c.x;
		float y3 = c.y;

		float A1 = -(x1 * x1) + (x2 * x2);
		float B1 = -x1 + x2;
		float D1 = -y1 + y2;

		float A2 = -(x2 * x2) + (x3 * x3);
		float B2 = -x2 + x3;
		float D2 = -y2 + y3;

		float B_MULTIPLIER = -(B2 / B1);

		float A3 = B_MULTIPLIER * A1 + A2;
		float D3 = B_MULTIPLIER * D1 + D2;

		float a = D3 / A3;
		float b = (D1 - A1 * a) / B1;
		float c = y1 - (a * x1 * a * x1) - b * x1;

		return new QuadraticEquation(a, b, c);
	}

	public float a;
	public float b;
	public float c;

	public QuadraticEquation(float a, float b, float c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public QuadraticEquation() {
		this.a = 0;
		this.b = 0;
		this.c = 0;
	}

	public float get(float x) {
		return (a * x) * (a * x) + b * x + c;
	}

	@Override
	public String toString() {
		return String.format("%fx^2 + %fx + %f = 0", a, b, c);
	}

	public float[] getZeros() throws ImaginaryAnswerException {
		boolean isImaginary = b * b - (4 * a * c) < 0;

		if (isImaginary) {
			throw new ImaginaryAnswerException("");
		}

		float x1 = (b + (float) Math.sqrt((float) b * b - (4 * a * c))) / (2 * a);
		float x2 = (b - (float) Math.sqrt((float) b * b - (4 * a * c))) / (2 * a);

		return new float[] { x1, x2 };
	}
}

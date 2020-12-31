package com.github.aidano13.mathLibrary.geometry;

import com.github.aidano13.mathLibrary.equations.LinearEquation;

public class Line {

    public Point a;
    public Point b;
    public float slope;

    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
        this.slope = LinearEquation.pointsToLine(a, b).m;
    }

    public Point midpoint() {
        float midpointX = (a.x + b.x) / 2;
        float midpointY = (a.y + b.y) / 2;
        return new Point(midpointX, midpointY);
    }
}

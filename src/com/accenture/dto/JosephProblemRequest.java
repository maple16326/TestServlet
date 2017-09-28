package com.accenture.dto;

import com.accenture.JasonAnnotation.JsonAnnotation;

public class JosephProblemRequest extends DataTransferObject {
@JsonAnnotation(name = "circle")
	private Circle circle;

public Circle getCircle() {
	return circle;
}

public void setCircle(Circle circle) {
	this.circle = circle;
}

}

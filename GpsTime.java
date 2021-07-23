package homework; // 1 point penalty for not restoring the package before turning this in

// CSC 403 W20  HW6
// Fix the toDo items

/*  Ashay Kargaonkar */

import java.time.LocalDate;

import stdlib.StdIn;

public class GpsTime {
	private double longitude;
	private double latitude;
	private LocalDate when;

	// ToDo 1 implement the required constructor (see other file)
	public GpsTime(double longitude, double latitude, LocalDate date) {

		this.longitude = longitude;
		this.latitude = latitude;
		this.when = date;
	}

	// ToDo 2 update the hashcode function below
	// You can try your answer from hw5, or make up a new one
	public int hashCode() {

		int hash = 50;

		hash = hash * 31 + Double.hashCode(longitude);
		hash = hash * 31 + when.hashCode();
		hash = hash * 31 + Double.hashCode(latitude);
		hash = hash & (0x7fffffff);

		return hash;
	}

	// ToDo 3 use the textbook 'recipe' to implement the equals function for this
	// class
	public boolean equals(Object x) {

		if (this.hashCode() == x.hashCode())
			return true;
		else {
			return false;
		}
	}

	public String toString() {
		return Double.toString(longitude) + " " + Double.toString(latitude) + " " + when.toString();
	}
}

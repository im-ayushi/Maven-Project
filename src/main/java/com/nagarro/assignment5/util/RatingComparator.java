package com.nagarro.assignment5.util;

import java.util.Comparator;

import com.nagarro.assignment5.domain.Tshirt;

public class RatingComparator implements Comparator<Tshirt> {

	public int compare(Tshirt tshirt1, Tshirt tshirt2) {
		return (int) (tshirt2.getRating() - tshirt1.getRating());
	}
}

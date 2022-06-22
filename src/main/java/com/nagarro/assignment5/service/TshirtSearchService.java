package com.nagarro.assignment5.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.nagarro.assignment5.dao.TshirtDao;
import com.nagarro.assignment5.domain.*;
import com.nagarro.assignment5.dto.TshirtSearchDto;
import com.nagarro.assignment5.util.*;

public class TshirtSearchService {
	Scanner sc;

	public ArrayList<Tshirt> getMatchingTshirts(TshirtSearchDto tshirtSearchDto) throws FileNotFoundException {

		ArrayList<Tshirt> tshirt = new ArrayList<Tshirt>();
		ArrayList<Tshirt> allTshirtData = TshirtDao.getAllTshirts();

		String inputFormat = String.format("%s,%s,%s", tshirtSearchDto.getColor(), tshirtSearchDto.getSize(),
				tshirtSearchDto.getGender());
		String outputFormat;
		String output = tshirtSearchDto.getOutputPreference().name();

		System.out.println("Your choice of Output Preference is : ");

		for (Tshirt allTshirtDataiterator : allTshirtData) {
			outputFormat = String.format("%s,%s,%s", allTshirtDataiterator.getColor(), allTshirtDataiterator.getSize(),
					allTshirtDataiterator.getGender());
			if (inputFormat.equalsIgnoreCase(outputFormat))
				tshirt.add(allTshirtDataiterator);
		}

		if (output.equalsIgnoreCase("PRICE")) {
			Collections.sort(tshirt, new PriceComparator());
			System.out.println(output);
		} else if (output.equalsIgnoreCase("RATING")) {
			Collections.sort(tshirt, new RatingComparator());
			System.out.println(output);
		} else {
			Collections.sort(tshirt, new PriceComparator());
			Collections.sort(tshirt, new RatingComparator());
			System.out.println(output);
		}
		System.out.println("\n\n");

		return tshirt;
	}
}

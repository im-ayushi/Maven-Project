package com.nagarro.assignment5.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import com.nagarro.assignment5.domain.Tshirt;
import com.nagarro.assignment5.dto.TshirtSearchDto;
import com.nagarro.assignment5.service.TshirtSearchService;
import com.nagarro.assignment5.view.Input;
import com.nagarro.assignment5.view.Output;

public class Application {

	public static void main(String[] args) throws FileNotFoundException {

		Input input = new Input();
		TshirtSearchDto tshirtSearchDto = input.getInput();

		TshirtSearchService tshirtsearchservice = new TshirtSearchService();
		ArrayList<Tshirt> matchedTShirts = tshirtsearchservice.getMatchingTshirts(tshirtSearchDto);

		Output output = new Output();
		output.displayOutput(matchedTShirts);
	}

}

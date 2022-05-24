package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Lotto;
import com.example.demo.model.Winner;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MyController {

	@GetMapping(value = "/lotto")
	public @ResponseBody void lotto(HttpServletRequest request, HttpServletResponse response) {
		Winner win1 = new Winner();
		win1.setWinnerId(23);
		int[] temp = { 2, 45, 34, 23, 3, 5 };
		win1.setNums(temp);

		Winner win2 = new Winner();
		win2.setWinnerId(54);
		int[] temp2 = { 52, 3, 12, 11, 18, 22 };
		win2.setNums(temp2);

		Lotto lotto = new Lotto();
		lotto.setLottoId(5);
		int[] winningNumbers = { 2, 45, 34, 23, 7, 5, 3 };
		Winner[] wins = { win1, win2 };

		lotto.setWinningNumbers(winningNumbers);
		lotto.setWinnerList(wins);

		ObjectMapper obj = new ObjectMapper();
		String res = "No value provided by server";
		try {
			res = obj.writeValueAsString(lotto);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.setContentType("application/json");
		try {
			response.getWriter().write(res);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

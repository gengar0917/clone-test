package com.example.hanghaegg.search.controller;

import com.example.hanghaegg.search.dto.SummonerDTO;
import com.example.hanghaegg.search.service.SummonerService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class SummonerController {

	private final SummonerService summonerService;

	@PostMapping(value = "/summonerByName")
	@ResponseBody
	public SummonerDTO callSummonerByName(@RequestParam String summonerName){

		summonerName = summonerName.replaceAll(" ","%20");

		SummonerDTO apiResult = summonerService.callRiotAPISummonerByName(summonerName);

		return apiResult;
	}
}
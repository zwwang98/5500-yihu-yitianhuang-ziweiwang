package com.example.fitness.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import com.example.fitness.service.RankingService;

import java.util.Map;


@RestController
public class RankingController {
	private RankingService rankingService;

	@Autowired
	public RankingController(RankingService rankingService) {
		this.rankingService = rankingService;
	}

	@GetMapping(value="/ranking/calories/{userId}")
	public Integer getUserCaloriesRank(@PathVariable String userId) {
		return rankingService.getUserCaloriesRanking(userId);
	}


	@GetMapping(value="/ranking/calories/{userId}/{activity}")
	public Integer getUserActivityTimeRanking(@PathVariable String userId, @PathVariable String activity) {
		return rankingService.getUserActivityTimeRanking(userId, activity);
	}

	@GetMapping(value="/ranking/calories/{userId}}")
	public Map<String, Integer> getUserLocationRanking(@PathVariable String userId) {
		return rankingService.getUserLocationRanking(userId);
	}





}

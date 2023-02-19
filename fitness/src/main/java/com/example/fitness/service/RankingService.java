package com.example.fitness.service;

import com.example.fitness.model.Place;
import com.example.fitness.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RankingService {
	List<User> userList;
	Map<String, Integer> locationList;

	public Integer getUserCaloriesRanking(String userId) {

		return 0;
	}

	public Integer getUserActivityTimeRanking(String userId, String activity) {

		return 0;
	}

	/*
		return: Map<String, Integer> : place, frequency
	 */
	public Map<String, Integer> getUserLocationRanking(String userId) {
		locationList = new HashMap<>();

		return locationList;
	}

}

package com.cs5500.fitness.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.cs5500.fitness.model.Place;
import com.cs5500.fitness.model.Segment;
import com.cs5500.fitness.repository.PlaceRepository;
import com.cs5500.fitness.repository.SegmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import static org.mockito.Mockito.when;

class RecommendationControllerTest {
    @Mock
    private PlaceRepository placeRepository;

    @Mock
    private SegmentRepository segmentRepository;

    @InjectMocks
    private RecommendationController recommendationController;

    static private final Place place1 = new Place();
    static private final Place place2 = new Place();
    static private final Place place3 = new Place();
    static private final Place place4 = new Place();
    static private final Segment segment1 = new Segment();
    static private final Segment segment2 = new Segment();
    static private final Segment segment3 = new Segment();
    static private final Segment segment4 = new Segment();
    static private final Segment segment5 = new Segment();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @BeforeAll
    static void beforeAll() {
        place1.setLat("42.3554");
        place1.setLon("-71.0624");
        place1.setId(1);
        place2.setLat("42.3662");
        place2.setLon( "-71.0621");
        place2.setId(2);
        place3.setLat("42.3589");
        place3.setLon( "-71.0568");
        place3.setId(3);
        place4.setLat("42.3591");
        place4.setLon("-71.0597");
        place4.setId(4);

        segment1.setPlace(1);
        segment1.setActivity("Running");
        segment2.setPlace(2);
        segment2.setActivity("Swimming");
        segment3.setPlace(3);
        segment3.setActivity("Cycling");
        segment4.setPlace(3);
        segment4.setActivity("Cycling");
        segment5.setPlace(4);
        segment5.setActivity("Tennis");
    }

    @Test
    public void recommendActivityForCaloriesTest() {
        Double height = 6.0;
        Integer weight = 180;
        String gender = "male";
        Integer age = 30;
        Map<String, Integer> expectedActivityTime = new HashMap<>();
        expectedActivityTime.put("Jogging", 50);
        expectedActivityTime.put("Running", 32);
        expectedActivityTime.put("Swimming", 44);
        expectedActivityTime.put("Jumping rope", 32);
        expectedActivityTime.put("Cycling", 39);
        expectedActivityTime.put("Yoga", 101);
        expectedActivityTime.put("Tennis", 50);
        Map<String, Integer> actualActivityTime = recommendationController.recommendActivityForCalories(height, weight, gender, age);
        assertEquals(expectedActivityTime, actualActivityTime);
    }

    @Test
    public void recommendActivityOnLocationTest() {
        Double latitude = 42.3601;
        Double longitude = -71.0589;
        int k = 10000000;
        List<Place> places = List.of(place1,place2,place3,place4);
        when(placeRepository.findAll()).thenReturn(places);

        List<Segment> segments = List.of(segment1, segment2, segment3, segment4, segment5);
        when(segmentRepository.findAll()).thenReturn(segments);

        Map<String, Integer> expectedActivityToFreq = new HashMap<>();
        expectedActivityToFreq.put("Running", 1);
        expectedActivityToFreq.put("Swimming", 1);
        expectedActivityToFreq.put("Cycling", 2);
        expectedActivityToFreq.put("Tennis", 1);
        Map<String, Integer> actualActivityToFreq = recommendationController.recommendActivityOnLocation(latitude, longitude);

        assertEquals(expectedActivityToFreq, actualActivityToFreq);
    }
}
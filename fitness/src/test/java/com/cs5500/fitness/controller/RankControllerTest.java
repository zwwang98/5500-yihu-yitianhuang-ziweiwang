package com.cs5500.fitness.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import com.cs5500.fitness.model.Place;
import com.cs5500.fitness.model.Segment;
import com.cs5500.fitness.repository.PlaceRepository;
import com.cs5500.fitness.repository.SegmentRepository;

import java.util.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.stream.Collectors;

class RankControllerTest {
    @Mock
    private SegmentRepository segmentRepository;

    @Mock
    private PlaceRepository placeRepository;

    @InjectMocks
    private RankController rankController;

    private static Segment segment1 = new Segment();
    private static Segment segment2 = new Segment();
    private static Segment segment3 = new Segment();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @BeforeAll
    static void beforeAll() {
        segment1.setActivity("activity1");
        segment1.setManual("manual1");
        segment1.setStartTimeX("2023-04-11 12:00:00");
        segment1.setEndTimeX("2023-04-11 12:30:00");
        segment1.setDuration(30.0);
        segment1.setDistance(2.5);
        segment1.setType("type1");
        segment1.setStartTimeY("2023-04-11 12:00:00");
        segment1.setEndTimeY("2023-04-11 12:30:00");
        segment1.setLastUpdate("2023-04-11 12:30:00");
        segment1.setRecordId(1);
        segment1.setSegmentId(1);
        segment1.setCalories(Double.valueOf(100));
        segment1.setPlace(1);

        segment2.setActivity("activity2");
        segment2.setManual("manual1");
        segment2.setStartTimeX("2023-04-11 12:00:00");
        segment2.setEndTimeX("2023-04-11 12:30:00");
        segment2.setDuration(30.0);
        segment2.setDistance(2.5);
        segment2.setType("type1");
        segment2.setStartTimeY("2023-04-11 12:00:00");
        segment2.setEndTimeY("2023-04-11 12:30:00");
        segment2.setLastUpdate("2023-04-11 12:30:00");
        segment2.setRecordId(2);
        segment2.setSegmentId(2);
        segment2.setCalories(Double.valueOf(50));
        segment2.setPlace(2);

        segment3.setActivity("activity1");
        segment3.setManual("manual1");
        segment3.setStartTimeX("2023-04-11 12:00:00");
        segment3.setEndTimeX("2023-04-11 12:30:00");
        segment3.setDuration(30.0);
        segment3.setDistance(2.5);
        segment3.setType("type1");
        segment3.setStartTimeY("2023-04-11 12:00:00");
        segment3.setEndTimeY("2023-04-11 12:30:00");
        segment3.setLastUpdate("2023-04-11 12:30:00");
        segment3.setRecordId(3);
        segment3.setSegmentId(3);
        segment3.setCalories(Double.valueOf(200));
        segment3.setPlace(1);
    }

    @Test
    void topFreqActivities() {
        List<Segment> segments = new ArrayList<>();
        segments.add(segment1);
        segments.add(segment2);
        segments.add(segment3);

        when(segmentRepository.findAll()).thenReturn(segments);

        Set<Map.Entry<String, Double>> result = rankController.topFreqActivities().stream().collect(Collectors.toSet());

        Map<String, Double> expected = new HashMap<>();
        expected.put("activity1", 2.0);
        expected.put("activity2", 1.0);

        assertEquals(expected.entrySet(), result);
    }

    @Test
    void topCaloriesActivities() {
        List<Segment> segments = new ArrayList<>();
        segments.add(segment1);
        segments.add(segment2);
        segments.add(segment3);

        when(segmentRepository.findAll()).thenReturn(segments);

        Set<Map.Entry<String, Double>> result = rankController.topCaloriesActivities().stream().collect(Collectors.toSet());

        Map<String, Double> expected = new HashMap<>();
        expected.put("activity1", 150.0);
        expected.put("activity2", 50.0);

        assertEquals(expected.entrySet(), result);
    }

    @Test
    void topLocations() {
        List<Segment> segments = new ArrayList<>();
        segments.add(segment1);
        segments.add(segment2);
        segments.add(segment3);

        when(segmentRepository.findAll()).thenReturn(segments);

        Place place1 = new Place();
        place1.setId(1);
        place1.setName("place1");
        Place place2 = new Place();
        place2.setId(2);
        place2.setName("place2");

        when(placeRepository.findById(1)).thenReturn(Optional.of(place1));
        when(placeRepository.findById(2)).thenReturn(Optional.of(place2));

        List<String> result = rankController.topLocations();

        List<String> expected = new ArrayList<>();
        expected.add("place1");
        expected.add("place2");

        assertEquals(expected, result);
    }
}
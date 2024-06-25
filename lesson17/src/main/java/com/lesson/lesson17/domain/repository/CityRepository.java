package com.lesson.lesson17.domain.repository;

import com.lesson.lesson17.domain.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer>
{
    List<City> findByPeopleCount(int peopleCount);
    List<City> findByNameContainingIgnoreCase(String name);
    List<City> findByBriefHistoryContainingIgnoreCase(String keyword);
}


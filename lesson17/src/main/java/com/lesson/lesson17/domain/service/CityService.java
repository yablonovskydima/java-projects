package com.lesson.lesson17.domain.service;

import com.lesson.lesson17.domain.entity.City;
import com.lesson.lesson17.domain.repository.CityRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityService
{
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository)
    {
        this.cityRepository = cityRepository;
    }

    public City updateCity(int id, City updatedCity)
    {
        City isexist = cityRepository.findById(id).orElse(null);

        if(isexist != null)
        {
            isexist.setName(updatedCity.getName());
            isexist.setBriefHistory(updatedCity.getBriefHistory());
            isexist.setCoordinates(updatedCity.getCoordinates());
            isexist.setPeopleCount(updatedCity.getPeopleCount());
            return cityRepository.save(isexist);
        }
        else
        {
            return null;
        }
    }

    public List<City> getCitiesByPeopleCount(int peopleCount)
    {
        return cityRepository.findByPeopleCount(peopleCount);
    }

    public List<City> findByNameContainingIgnoreCase(String name)
    {
        return cityRepository.findByNameContainingIgnoreCase(name);
    }

    public List<City> getByHistoryKeyword(String keyword) {
        return cityRepository.findByBriefHistoryContainingIgnoreCase(keyword);
    }
}

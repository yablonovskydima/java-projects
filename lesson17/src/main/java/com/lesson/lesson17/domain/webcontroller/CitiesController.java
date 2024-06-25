package com.lesson.lesson17.domain.webcontroller;

import com.lesson.lesson17.domain.entity.City;
import com.lesson.lesson17.domain.repository.CityRepository;
import com.lesson.lesson17.domain.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CitiesController
{
    private final CityRepository cityRepository;
    private final CityService cityService;

    @Autowired
    public CitiesController(CityRepository cityRepository, CityService cityService)
    {
        this.cityRepository = cityRepository;
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> getCities()
    {
        return cityRepository.findAll();
    }

    @PostMapping
    public City addCity(@RequestBody City city)
    {
        return  cityRepository.save(city);
    }

    @DeleteMapping("/{id}")
    public String deleteCity(@PathVariable int id)
    {
        cityRepository.deleteById(id);
        return "City with id " + id + " was deleted.";
    }

    @PutMapping("/{id}")
    public String editCity(@PathVariable int id, @RequestBody City city)
    {
        cityService.updateCity(id, city);
        return "City with id " + id + " was edited.";
    }

    @GetMapping("/get-by-people-count/{count}")
    public List<City> getByPeopleCount(@PathVariable int count)
    {
        return cityService.getCitiesByPeopleCount(count);
    }

    @GetMapping("/get-containing/{name}")
    public List<City> getByName(@PathVariable String name)
    {
        return cityService.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/history-keyword/{keyword}")
    public List<City> getByHistoryKey(@PathVariable String keyword)
    {
        return cityService.getByHistoryKeyword(keyword);
    }
}

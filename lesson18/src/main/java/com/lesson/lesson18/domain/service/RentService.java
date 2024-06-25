package com.lesson.lesson18.domain.service;

import com.lesson.lesson18.domain.entity.Flat;
import com.lesson.lesson18.domain.entity.Rent;
import com.lesson.lesson18.domain.repository.FlatRepository;
import com.lesson.lesson18.domain.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentService
{
    private final RentRepository rentRepository;

    @Autowired
    public RentService(RentRepository rentRepository)
    {
        this.rentRepository = rentRepository;
    }

    public Rent updateRent(int id, Rent updatedRent)
    {
        Rent isexist = rentRepository.findById(id).orElse(null);

        if(isexist != null)
        {
            if(isexist.getStartDate().after(isexist.getEndDate()))
            {
                return null;
            }

            isexist.setEndDate(updatedRent.getEndDate());
            isexist.setStartDate(updatedRent.getStartDate());
            isexist.setPrice(updatedRent.getPrice());
            isexist.setClient(updatedRent.getClient());
            isexist.setSeller(updatedRent.getSeller());
            return rentRepository.save(isexist);
        }
        else
        {
            return null;
        }
    }
}

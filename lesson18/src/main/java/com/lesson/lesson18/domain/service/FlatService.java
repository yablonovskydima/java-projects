package com.lesson.lesson18.domain.service;

import com.lesson.lesson18.domain.entity.Client;
import com.lesson.lesson18.domain.entity.Flat;
import com.lesson.lesson18.domain.repository.ClientRepository;
import com.lesson.lesson18.domain.repository.FlatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlatService
{
    private final FlatRepository flatRepository;

    @Autowired
    public FlatService(FlatRepository flatRepository)
    {
        this.flatRepository = flatRepository;
    }

    public Flat updateFlat(int id, Flat updatedFlat)
    {
        Flat isexist = flatRepository.findById(id).orElse(null);

        if(isexist != null)
        {
            isexist.setAddress(updatedFlat.getAddress());
            isexist.setSeller(updatedFlat.getSeller());
            return flatRepository.save(isexist);
        }
        else
        {
            return null;
        }
    }
}

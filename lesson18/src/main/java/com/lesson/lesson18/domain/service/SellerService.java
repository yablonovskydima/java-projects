package com.lesson.lesson18.domain.service;

import com.lesson.lesson18.domain.entity.Client;
import com.lesson.lesson18.domain.entity.Seller;
import com.lesson.lesson18.domain.repository.ClientRepository;
import com.lesson.lesson18.domain.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService
{
    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository)
    {
        this.sellerRepository = sellerRepository;
    }

    public Seller updateSeller(int id, Seller updatedSeller)
    {
        Seller isexist = sellerRepository.findById(id).orElse(null);

        if(isexist != null)
        {
            isexist.setName(updatedSeller.getName());
            isexist.setPhoneNumber(updatedSeller.getPhoneNumber());
            isexist.setRents(updatedSeller.getRents());
            isexist.setFlats(updatedSeller.getFlats());
            return sellerRepository.save(isexist);
        }
        else
        {
            return null;
        }
    }
}

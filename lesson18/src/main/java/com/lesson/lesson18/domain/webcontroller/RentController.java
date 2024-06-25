package com.lesson.lesson18.domain.webcontroller;

import com.lesson.lesson18.domain.entity.Client;
import com.lesson.lesson18.domain.entity.Flat;
import com.lesson.lesson18.domain.entity.Rent;
import com.lesson.lesson18.domain.entity.Seller;
import com.lesson.lesson18.domain.repository.ClientRepository;
import com.lesson.lesson18.domain.repository.FlatRepository;
import com.lesson.lesson18.domain.repository.RentRepository;
import com.lesson.lesson18.domain.repository.SellerRepository;
import com.lesson.lesson18.domain.service.ClientService;
import com.lesson.lesson18.domain.service.FlatService;
import com.lesson.lesson18.domain.service.RentService;
import com.lesson.lesson18.domain.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rent")
public class RentController
{
    private SellerRepository sellerRepository;
    private ClientRepository clientRepository;
    private ClientService clientService;
    private SellerService sellerService;
    private RentRepository rentRepository;
    private FlatRepository flatRepository;

    private FlatService flatService;
    private RentService rentService;

    @Autowired
    public RentController(SellerRepository sellerRepository,
                          ClientRepository clientRepository,
                          RentRepository repository,
                          FlatRepository flatRepository,
                          ClientService clientService,
                          SellerService sellerService,
                          FlatService flatService,
                          RentService rentService) {

        this.sellerRepository = sellerRepository;
        this.clientRepository = clientRepository;
        this.rentRepository = repository;
        this.flatRepository = flatRepository;
        this.clientService = clientService;
        this.sellerService = sellerService;
        this.flatService = flatService;
        this.rentService = rentService;
    }

    @GetMapping("/sellers")
    public List<Seller> showSellers()
    {
        return sellerRepository.findAll();
    }

    @GetMapping("/clients")
    public List<Client> showClients()
    {
        return clientRepository.findAll();
    }

    @GetMapping("/rents")
    public List<Rent> showRents()
    {
        return rentRepository.findAll();
    }

    @PostMapping("/rents/{sellerId}/{clientId}")
    public Rent addRent(@RequestBody Rent rent, @PathVariable int sellerId, @PathVariable int clientId)
    {
        rent.setSeller(sellerRepository.findById(sellerId).get());
        rent.setClient(clientRepository.findById(clientId).get());
        rentRepository.save(rent);
        return rent;
    }

    @DeleteMapping("/rents/{id}")
    public String deleteRent(@PathVariable int id)
    {
        Rent rent = rentRepository.findById(id).get();
        rentRepository.delete(rent);
        return "Rent with id " + id + " was deleted.";
    }

    @PutMapping("/rents/{id}/{sellerId}/{clientId}")
    public Rent editRent(@RequestBody Rent rent, @PathVariable int id,  @PathVariable int sellerId, @PathVariable int clientId)
    {
        rent.setSeller(sellerRepository.findById(sellerId).get());
        rent.setClient(clientRepository.findById(clientId).get());
        rentService.updateRent(id, rent);
        return rent;
    }

    @GetMapping("/flats")
    public List<Flat> showFlats()
    {
        return flatRepository.findAll();
    }

    @PostMapping("/flats/{sellerId}")
    public Flat addFlat(@RequestBody Flat flat, @PathVariable int sellerId)
    {
        flat.setSeller(sellerRepository.findById(sellerId).get());
        flatRepository.save(flat);
        return flat;
    }

    @DeleteMapping("/flats/{id}")
    public String deleteFlat(@PathVariable int id)
    {
        Flat flat = flatRepository.findById(id).get();
        flatRepository.delete(flat);
        return "Flat with id " + id + " was deleted.";
    }

    @PutMapping("/flats/{id}/{sellerId}")
    public Flat editFlat(@RequestBody Flat flat, @PathVariable int id, @PathVariable int sellerId)
    {
        flat.setSeller(sellerRepository.findById(sellerId).get());
        flatService.updateFlat(id, flat);
        return flat;
    }

    @PostMapping("/clients")
    public Client addClient(@RequestBody Client client)
    {
        clientRepository.save(client);
        return client;
    }

    @PostMapping("/sellers")
    public Seller addSeller(@RequestBody Seller seller)
    {
        sellerRepository.save(seller);
        return seller;
    }

    @DeleteMapping("/sellers/{id}")
    public String deleteSeller(@PathVariable int id)
    {
        Seller seller = sellerRepository.findById(id).get();
        sellerRepository.delete(seller);
        return "Seller with id " + id + " was deleted.";
    }

    @PutMapping("/sellers/{id}")
    public Seller editSeller(@RequestBody Seller seller, @PathVariable int id)
    {
        sellerService.updateSeller(id, seller);
        return seller;
    }

    @DeleteMapping("/clients/{id}")
    public String deleteClient(@PathVariable int id)
    {
        Client client = clientRepository.findById(id).get();
        clientRepository.delete(client);
        return "Client with id " + id + " was deleted.";
    }

    @PutMapping("/clients/{id}")
    public Client editClient(@RequestBody Client client, @PathVariable int id)
    {
        clientService.updateClient(id, client);
        return client;
    }

    @GetMapping("/find/client-by-name/{name}")
    public List<Client> clientByName(@PathVariable String name)
    {
        return clientRepository.findByName(name);
    }

    @GetMapping("/find/client-by-phone/{phone}")
    public List<Client> clientByPhone(@PathVariable String phone)
    {
        return clientRepository.findByPhoneNumber(phone);
    }

    @GetMapping("/find/client-by-rent-price/{price}")
    public List<Client> clientByRentPrice(@PathVariable int price)
    {
        return rentRepository.findClientsByRentPrice(price);
    }

    @GetMapping("/find/client-by-current-month")
    public List<Client> clientByCurrentMonth()
    {
        return rentRepository.findClientsByRentThisMonth();
    }

    @GetMapping("/find/client-by-end-month")
    public List<Client> clientByEndMonth()
    {
        return rentRepository.findClientsByEndingThisMonth();
    }

    @GetMapping("/find/client-by-avg-time")
    public List<Client> clientByAvgTime()
    {
        return rentRepository.findClientsWithAvgTime();
    }

    @GetMapping("/find/client-by-avg-year")
    public List<Client> clientByAvgYear()
    {
        return rentRepository.findClientsWithAvgYear();
    }


    @GetMapping("/rents/avg-price")
    public double averagePrice()
    {
        return rentRepository.findAveragePrice();
    }

    @GetMapping("/rents/max-price")
    public double maxPrice()
    {
        return rentRepository.findMaxPrice();
    }

    @GetMapping("/rents/min-price")
    public double minPrice()
    {
        return rentRepository.findMinPrice();
    }
}

package com.lesson.lesson18.domain.repository;

import com.lesson.lesson18.domain.entity.Client;
import com.lesson.lesson18.domain.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentRepository extends JpaRepository<Rent, Integer>
{
    @Query("SELECT r.client FROM Rent r WHERE r.price = :price")
    List<Client> findClientsByRentPrice(@Param("price") int price);

    @Query("SELECT r.client FROM Rent r " +
            "WHERE YEAR(r.startDate) = YEAR(CURRENT_DATE) " +
            "AND MONTH(r.startDate) = MONTH(CURRENT_DATE)")
    List<Client> findClientsByRentThisMonth();

    @Query("SELECT r.client FROM Rent r " +
            "WHERE YEAR(r.endDate) = YEAR(CURRENT_DATE) " +
            "AND MONTH(r.endDate) = MONTH(CURRENT_DATE)")
    List<Client> findClientsByEndingThisMonth();

    @Query("SELECT r.client FROM Rent r " +
            "GROUP BY r.client " +
            "HAVING AVG(r.endDate - r.startDate) < 30")
    List<Client> findClientsWithAvgTime();

    @Query("SELECT r.client FROM Rent r " +
            "GROUP BY r.client " +
            "HAVING AVG(r.endDate - r.startDate) > 365")
    List<Client> findClientsWithAvgYear();

    List<Rent> findByPrice(int price);

    @Query("SELECT AVG(r.price) FROM Rent r")
    double findAveragePrice();

    @Query("SELECT MAX(r.price) FROM Rent r")
    int findMaxPrice();

    @Query("SELECT MIN(r.price) FROM Rent r")
    int findMinPrice();
}

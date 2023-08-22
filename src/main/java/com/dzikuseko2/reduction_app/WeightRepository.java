package com.dzikuseko2.reduction_app;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WeightRepository extends JpaRepository<Weight, Integer> {

    List<Weight> findAll();
    Page<Weight> findAll(Pageable page);

    Optional<Weight> findAById(Integer id);

    Weight save(Weight entity);



}

package com.skillswap.skillswap_core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillswap.skillswap_core.entity.Imagen;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Integer>{

}

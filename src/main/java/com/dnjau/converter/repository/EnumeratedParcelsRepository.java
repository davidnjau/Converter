package com.dnjau.converter.repository;

import com.dnjau.converter.model.EnumeratedParcels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnumeratedParcelsRepository extends JpaRepository<EnumeratedParcels, String> {
}
package com.konex.drogueria.domain.port;

import com.konex.drogueria.domain.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
}

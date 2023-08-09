package com.konex.drogueria.service;

import com.konex.drogueria.entity.Medicine;
import com.konex.drogueria.repository.MedicineRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MedicineServiceImpl implements MedicineService{
  private MedicineRepository medicineRepository;
  @Override
  public ResponseEntity<?> listMedication() {
    List<Medicine> medicines;
    try{
      medicines = medicineRepository.findAll();
      return new ResponseEntity<>(medicines, HttpStatus.OK);
    } catch (Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public ResponseEntity<?> saveMedication(Medicine medicine) {
    try{
      Medicine medicineSaved = medicineRepository.save(medicine);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

  @Override
  public ResponseEntity<?> updateMedication(Medicine medicine, Integer id) {
    try {
      Optional<Medicine> medicineSearched = medicineRepository.findById(id);
      if (medicineSearched.isPresent()) {
        medicineSearched.get().setName(medicine.getName());
        medicineSearched.get().setLaboratory(medicine.getLaboratory());
        medicineSearched.get().setManufacturingDate(medicine.getManufacturingDate());
        medicineSearched.get().setDueDate(medicine.getDueDate());
        medicineSearched.get().setStock(medicine.getStock());
        medicineSearched.get().setValueUnit(medicine.getValueUnit());
        Medicine medicineUpdate = medicineRepository.save(medicineSearched.get());
      }
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @Override
  public ResponseEntity<?> deleteMedication(Integer id) {
    try {
      Optional<Medicine> medicineSearched = medicineRepository.findById(id);
      if (medicineSearched.isPresent()){
        medicineRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
      }else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

    }catch (Exception e){
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }
}

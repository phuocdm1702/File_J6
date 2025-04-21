package com.example.java6_sof306_ot_de_mau_1.repository;

import com.example.java6_sof306_ot_de_mau_1.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, Integer> {
}

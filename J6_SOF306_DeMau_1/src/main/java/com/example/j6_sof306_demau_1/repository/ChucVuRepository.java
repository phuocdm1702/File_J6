package com.example.j6_sof306_demau_1.repository;

import com.example.j6_sof306_demau_1.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu,Integer> {
}

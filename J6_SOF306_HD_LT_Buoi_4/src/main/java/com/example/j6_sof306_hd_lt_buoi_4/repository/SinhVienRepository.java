package com.example.j6_sof306_hd_lt_buoi_4.repository;

import com.example.j6_sof306_hd_lt_buoi_4.entity.SinhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Integer> {
}

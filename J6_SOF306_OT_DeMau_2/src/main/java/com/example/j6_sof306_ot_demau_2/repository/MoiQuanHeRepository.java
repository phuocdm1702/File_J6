package com.example.j6_sof306_ot_demau_2.repository;

import com.example.j6_sof306_ot_demau_2.entity.MoiQuanHe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoiQuanHeRepository extends JpaRepository<MoiQuanHe, Integer> {
}

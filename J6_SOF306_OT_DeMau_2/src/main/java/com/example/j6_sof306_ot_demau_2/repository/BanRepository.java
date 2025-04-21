package com.example.j6_sof306_ot_demau_2.repository;

import com.example.j6_sof306_ot_demau_2.dto.BanDTOGET;
import com.example.j6_sof306_ot_demau_2.entity.Ban;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BanRepository extends JpaRepository<Ban, Integer> {
    @Query("""
            SELECT new com.example.j6_sof306_ot_demau_2.dto.BanDTOGET
            (
            b.id,
            b.ma,
            b.hoTen,
            b.ngaySinh,
            b.moiQuanHe.ma,
            b.moiQuanHe.loaiQuanHe
            ) FROM Ban b
            """)
    List<BanDTOGET> getAll();

    @Query("""
            SELECT new com.example.j6_sof306_ot_demau_2.dto.BanDTOGET
            (
            b.id,
            b.ma,
            b.hoTen,
            b.ngaySinh,
            b.moiQuanHe.ma,
            b.moiQuanHe.loaiQuanHe
            ) FROM Ban b
            """)
    Page<BanDTOGET> getAllPage(Pageable pageable);

    @Query("""
            SELECT new com.example.j6_sof306_ot_demau_2.dto.BanDTOGET
            (
            b.id,
            b.ma,
            b.hoTen,
            b.ngaySinh,
            b.moiQuanHe.ma,
            b.moiQuanHe.loaiQuanHe
            ) FROM Ban b WHERE b.id = ?1
            """)
    BanDTOGET detailBan(int id);

    @Transactional
    @Modifying
    @Modifying
    @Query("DELETE FROM Ban b WHERE b.ma= ?1")
    void deleteBan(String ma);

    @Query("""
        SELECT new com.example.j6_sof306_ot_demau_2.dto.BanDTOGET
        (
        b.id,
        b.ma,
        b.hoTen,
        b.ngaySinh,
        b.moiQuanHe.ma,
        b.moiQuanHe.loaiQuanHe
        ) FROM Ban b ORDER BY b.ngaySinh ASC
        """)
    List<BanDTOGET> getAllFemaleSortedByBirthDate();
}

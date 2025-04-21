package com.example.j6_sof306_demau_1.repository;

import com.example.j6_sof306_demau_1.dto.NhanVienDTOGet;
import com.example.j6_sof306_demau_1.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
    @Query("""
            SELECT new com.example.j6_sof306_demau_1.dto.NhanVienDTOGet
            (
            nv.id,
            nv.maNhanVien,
            nv.hoTen,
            nv.ngaySinh,
            nv.gioiTinh,
            nv.chucVu.maChucVu,
            nv.chucVu.tenChucVu
            )  FROM NhanVien nv
            """)
    Page<NhanVienDTOGet> getAll(Pageable pageable);


    @Query("""
            SELECT new com.example.j6_sof306_demau_1.dto.NhanVienDTOGet
            (
            nv.id,
            nv.maNhanVien,
            nv.hoTen,
            nv.ngaySinh,
            nv.gioiTinh,
            nv.chucVu.maChucVu,
            nv.chucVu.tenChucVu
            )  FROM NhanVien nv
            WHERE nv.maNhanVien = ?1
            """)
    NhanVienDTOGet detail(String ma);



}

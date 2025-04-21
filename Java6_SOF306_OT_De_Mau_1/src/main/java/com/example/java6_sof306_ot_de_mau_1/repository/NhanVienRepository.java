package com.example.java6_sof306_ot_de_mau_1.repository;

import com.example.java6_sof306_ot_de_mau_1.dto.NhanVienDTOGET;
import com.example.java6_sof306_ot_de_mau_1.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
    @Query("""
            SELECT new com.example.java6_sof306_ot_de_mau_1.dto.NhanVienDTOGET(
            nv.id,
            nv.maNhanVien,
            nv.hoTen,
            nv.gioiTinh,
            nv.ngaySinh,
            nv.idChucVu.maChucVu,
            nv.idChucVu.tenChucVu
            )FROM NhanVien nv
            """)
    List<NhanVienDTOGET> getAll();

    @Query("""
            SELECT new com.example.java6_sof306_ot_de_mau_1.dto.NhanVienDTOGET(
            nv.id,
            nv.maNhanVien,
            nv.hoTen,
            nv.gioiTinh,
            nv.ngaySinh,
            nv.idChucVu.maChucVu,
            nv.idChucVu.tenChucVu
            )FROM NhanVien nv
            """)
    Page<NhanVienDTOGET> getAllPage(Pageable pageable);

    @Query("""
            SELECT new com.example.java6_sof306_ot_de_mau_1.dto.NhanVienDTOGET(
            nv.id,
            nv.maNhanVien,
            nv.hoTen,
            nv.gioiTinh,
            nv.ngaySinh,
            nv.idChucVu.maChucVu,
            nv.idChucVu.tenChucVu
            )FROM NhanVien nv WHERE nv.maNhanVien = ?1
            """)
    NhanVienDTOGET detailNV(String maNV);

    @Query("""
                SELECT new com.example.java6_sof306_ot_de_mau_1.dto.NhanVienDTOGET(
                    nv.id,
                    nv.maNhanVien,
                    nv.hoTen,
                    nv.gioiTinh,
                    nv.ngaySinh,
                    nv.idChucVu.maChucVu,
                    nv.idChucVu.tenChucVu
                )
                FROM NhanVien nv
                WHERE LOWER(nv.hoTen) LIKE LOWER('%a%')
            """)
    List<NhanVienDTOGET> danhSachTheoTen();
}

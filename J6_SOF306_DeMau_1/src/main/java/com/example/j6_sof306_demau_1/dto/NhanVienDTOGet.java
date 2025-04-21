package com.example.j6_sof306_demau_1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
@Getter
@Setter
public class NhanVienDTOGet {
    private Integer id;
    private String maNhanVien;
    private String hoTen;
    private LocalDate ngaySinh;
    private Boolean gioiTinh;
    private String maChucVu;
    private String tenChucVu;

    public NhanVienDTOGet() {
    }

    public NhanVienDTOGet(Integer id, String maNhanVien, String hoTen, LocalDate ngaySinh, Boolean gioiTinh, String maChucVu, String tenChucVu) {
        this.id = id;
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.maChucVu = maChucVu;
        this.tenChucVu = tenChucVu;
    }
}

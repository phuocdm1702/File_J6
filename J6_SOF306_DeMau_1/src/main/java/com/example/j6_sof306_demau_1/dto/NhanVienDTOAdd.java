package com.example.j6_sof306_demau_1.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class NhanVienDTOAdd {
    private String maNhanVien;
    private String hoTen;
    private LocalDate ngaySinh;
    private Boolean gioiTinh;
    private Integer chucVuID;

    public NhanVienDTOAdd() {
    }

    public NhanVienDTOAdd(String maNhanVien, String hoTen, LocalDate ngaySinh, Boolean gioiTinh, Integer chucVuID) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.chucVuID = chucVuID;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Integer getChucVuID() {
        return chucVuID;
    }

    public void setChucVuID(Integer chucVuID) {
        this.chucVuID = chucVuID;
    }
}

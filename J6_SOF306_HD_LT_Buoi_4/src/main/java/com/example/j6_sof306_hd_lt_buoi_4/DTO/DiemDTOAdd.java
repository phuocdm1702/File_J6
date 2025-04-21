package com.example.j6_sof306_hd_lt_buoi_4.DTO;

import com.example.j6_sof306_hd_lt_buoi_4.entity.SinhVien;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class DiemDTOAdd {
    private String maDiem;
    private String monHoc;
    private BigDecimal diemSo;
    private Integer sinhVienID;

    public DiemDTOAdd() {
    }

    public DiemDTOAdd(String maDiem, String monHoc, BigDecimal diemSo, Integer sinhVienID) {
        this.maDiem = maDiem;
        this.monHoc = monHoc;
        this.diemSo = diemSo;
        this.sinhVienID = sinhVienID;
    }

    public String getMaDiem() {
        return maDiem;
    }

    public void setMaDiem(String maDiem) {
        this.maDiem = maDiem;
    }

    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

    public BigDecimal getDiemSo() {
        return diemSo;
    }

    public void setDiemSo(BigDecimal diemSo) {
        this.diemSo = diemSo;
    }

    public Integer getSinhVienID() {
        return sinhVienID;
    }

    public void setSinhVienID(Integer sinhVienID) {
        this.sinhVienID = sinhVienID;
    }
}

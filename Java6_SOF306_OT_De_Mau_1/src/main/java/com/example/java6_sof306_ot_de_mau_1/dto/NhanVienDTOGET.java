package com.example.java6_sof306_ot_de_mau_1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NhanVienDTOGET {
    private Integer id;
    private String maNhanVien;
    private String hoTen;
    private Boolean gioiTinh;
    private LocalDate ngaySinh;
    private String maChucVu;
    private String tenChucVu;

}

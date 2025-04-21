package com.example.j6_sof306_demau_1.controller;

import com.example.j6_sof306_demau_1.dto.NhanVienDTOAdd;
import com.example.j6_sof306_demau_1.dto.NhanVienDTOGet;
import com.example.j6_sof306_demau_1.entity.ChucVu;
import com.example.j6_sof306_demau_1.entity.NhanVien;
import com.example.j6_sof306_demau_1.repository.ChucVuRepository;
import com.example.j6_sof306_demau_1.repository.NhanVienRepository;
import lombok.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienRepository NVrepository;
    @Autowired
    private ChucVuRepository CVRepository;

    @GetMapping("/hien-thi")
    public List<NhanVienDTOGet> hienThi(@RequestParam(value = "page") Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return NVrepository.getAll(pageable).getContent();
    }

    @PostMapping("/add")
    public String addNhanVien(@RequestBody NhanVienDTOAdd nhanVienDTOAdd) {
        NhanVien nhanVien = new NhanVien();
        BeanUtils.copyProperties(nhanVienDTOAdd, nhanVien);
        ChucVu chucVu = CVRepository.findById(nhanVienDTOAdd.getChucVuID()).get();
        nhanVien.setChucVu(chucVu);
        NVrepository.save(nhanVien);
        return "Thêm thành công!";
    }

    @GetMapping("/detail/{ma}")
    public NhanVienDTOGet detail(@PathVariable("ma") String ma) {
        return NVrepository.detail(ma);
    }
}

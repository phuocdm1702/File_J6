package com.example.java6_sof306_ot_de_mau_1.controller;

import com.example.java6_sof306_ot_de_mau_1.dto.NhanVienDTOGET;
import com.example.java6_sof306_ot_de_mau_1.dto.NhanVienRequest;
import com.example.java6_sof306_ot_de_mau_1.entity.ChucVu;
import com.example.java6_sof306_ot_de_mau_1.entity.NhanVien;
import com.example.java6_sof306_ot_de_mau_1.repository.ChucVuRepository;
import com.example.java6_sof306_ot_de_mau_1.repository.NhanVienRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
public class NhanVienConTroller {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private ChucVuRepository chucVuRepository;

    @GetMapping("/hien-thi")
    public List<NhanVienDTOGET> getAll() {
        return nhanVienRepository.getAll();
    }

    @GetMapping("/hien-thi-page")
    public Page<NhanVienDTOGET> getAllPage(@RequestParam(value = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return nhanVienRepository.getAllPage(pageable);
    }

    @PostMapping("/add")
    public String addNhanVien(@RequestBody NhanVienRequest nhanVienRequest) {
        NhanVien nv = new NhanVien();

        BeanUtils.copyProperties(nhanVienRequest, nv);
        ChucVu cv = chucVuRepository.findById(nhanVienRequest.getNhanVienID()).get();

        nv.setIdChucVu(cv);
        nhanVienRepository.save(nv);
        return "Them thanh cong!";
    }

    @GetMapping("/detail/{ma}")
    public NhanVienDTOGET detailNV(@PathVariable("ma") String ma){
        return nhanVienRepository.detailNV(ma);
    }

    @GetMapping("/loc-nv")
    public List<NhanVienDTOGET> locNV(){
        return nhanVienRepository.danhSachTheoTen();
    }
}

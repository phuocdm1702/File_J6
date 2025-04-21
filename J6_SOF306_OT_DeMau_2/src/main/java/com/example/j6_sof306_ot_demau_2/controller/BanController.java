package com.example.j6_sof306_ot_demau_2.controller;

import com.example.j6_sof306_ot_demau_2.dto.BanDTOGET;
import com.example.j6_sof306_ot_demau_2.dto.BanDTORequest;
import com.example.j6_sof306_ot_demau_2.entity.Ban;
import com.example.j6_sof306_ot_demau_2.entity.MoiQuanHe;
import com.example.j6_sof306_ot_demau_2.repository.BanRepository;
import com.example.j6_sof306_ot_demau_2.repository.MoiQuanHeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/api/ban")
public class BanController {
    @Autowired
    private BanRepository banRepository;
    @Autowired
    private MoiQuanHeRepository moiQuanHeRepository;

    @GetMapping("/hien-thi")
    public List<BanDTOGET> getAll(){
        return banRepository.getAll();
    }

    @GetMapping("/phan-trang")
    public Page<BanDTOGET> getAllPage(@RequestParam(value = "page" , defaultValue = "1") int page){
        Pageable pageable = PageRequest.of(page, 5);
        return banRepository.getAllPage(pageable);
    }

    @PostMapping("/add-ban")
    public String addBan(@RequestBody BanDTORequest banDTORequest){
        Ban ban = new Ban();
        BeanUtils.copyProperties(banDTORequest, ban);
        MoiQuanHe moiQuanHe = moiQuanHeRepository.findById(banDTORequest.getMoiQuanHeID()).get();
        ban.setMoiQuanHe(moiQuanHe);
        banRepository.save(ban);
        return "Them thanh cong";
    }

    @PutMapping("/update-ban/{id}")
    public String updateBan(@PathVariable("id") int id, @RequestBody BanDTORequest banDTORequest){
        Ban ban = new Ban();
        BeanUtils.copyProperties(banDTORequest,ban);
        MoiQuanHe moiQuanHe = moiQuanHeRepository.findById(banDTORequest.getMoiQuanHeID()).get();
        ban.setMoiQuanHe(moiQuanHe);
        ban.setId(id);
        banRepository.save(ban);
        return ("Update thanh cong!");
    }


    @DeleteMapping("/delete-ban/{ma}")
    public String deleteBan(@PathVariable("ma") String ma){
        banRepository.deleteBan(ma);
        return "Xoa thanh cong!";
    }

    @GetMapping("/detail-ban/{id}")
    public BanDTOGET detailBan(@PathVariable("id") int id){
        return banRepository.detailBan(id);
    }
    @GetMapping("/sap-xep")
    public List<BanDTOGET> sapXep(){
        return banRepository.getAllFemaleSortedByBirthDate();
    }

}

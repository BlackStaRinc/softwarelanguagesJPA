package codespring.softwarelanguages.webApi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import codespring.softwarelanguages.business.abstracts.ProgrammingTechService;
import codespring.softwarelanguages.business.requests.CreateProgTechnologyRequest;
import codespring.softwarelanguages.business.responses.GetAllProgTechnologiesResponse;

import io.swagger.v3.oas.annotations.*;

@RestController
@RequestMapping("/api/PTech")
public class ProgrammingTechnologyController {

    private ProgrammingTechService pTechnologyService;

    @Autowired
    public ProgrammingTechnologyController(ProgrammingTechService pTechService) {
        this.pTechnologyService = pTechService;
    }

    @Operation(summary = "{Kayıtlı Tüm Programlama Teknolojilerini Getirir}", tags = "Software Technologies Services")
    @GetMapping("/getAllTech")
    public List<GetAllProgTechnologiesResponse> getAllTech(){
        return pTechnologyService.getAllTech();
    }
    @Operation(summary = "{Listeye Yeni Kayıt Ekler}", tags = "Software Technologies Services")
    @PostMapping("/setTechName")
    public void pTechAdd(@RequestBody CreateProgTechnologyRequest createProgTechnologyRequest)throws Exception{
        this.pTechnologyService.pTechnologyAdd(createProgTechnologyRequest);
    }
 
}

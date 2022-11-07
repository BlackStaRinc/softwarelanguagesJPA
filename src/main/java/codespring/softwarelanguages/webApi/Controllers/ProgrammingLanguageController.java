package codespring.softwarelanguages.webApi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import codespring.softwarelanguages.business.abstracts.ProgrammingLanguageService;
import codespring.softwarelanguages.business.requests.CreatePLanguageRequest;
import codespring.softwarelanguages.business.responses.GetAllPLanguagesResponse;
import io.swagger.v3.oas.annotations.*;

@RestController
@RequestMapping("/api/PLanguages")
public class ProgrammingLanguageController {

   
    private ProgrammingLanguageService pLanguageService;

    @Autowired
    public ProgrammingLanguageController(ProgrammingLanguageService pLanguageService) {
        this.pLanguageService = pLanguageService;
    }
    
    @Operation(summary = "{Kayıtlı Tüm Programlama Dillerini Getirir}", tags = "Software Languages Services")
    @GetMapping("/getAll")
    public List<GetAllPLanguagesResponse> getAll(){
        return pLanguageService.getAll();
    }

    @Operation(summary = "{Listeye Yeni Kayıt Ekler}", tags = "Software Languages Services")
    @PostMapping("/add")
    public void add(@RequestBody CreatePLanguageRequest createPLanguageRequest)throws Exception{
        this.pLanguageService.add(createPLanguageRequest);
    }
}

package codespring.softwarelanguages.webApi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import codespring.softwarelanguages.business.abstracts.ProgrammingLanguageService;
import codespring.softwarelanguages.entities.concretes.ProgrammingLanguage;


@RestController
@RequestMapping("/api/PLanguages")
public class ProgrammingLanguageController {
    private ProgrammingLanguageService pLanguageService;

    @Autowired
    public ProgrammingLanguageController(ProgrammingLanguageService pLanguageService) {
        this.pLanguageService = pLanguageService;
    }

    @GetMapping("/getAll")
    public List<ProgrammingLanguage> getAll(){
        return pLanguageService.getAll();
    }
    @GetMapping("/getId")
    public ProgrammingLanguage getId(@RequestParam int id)throws Exception{
        return this.pLanguageService.getId(id);
    }
    @PostMapping("/setName")
    public void pLanguageAdd(@RequestBody ProgrammingLanguage pLanguage)throws Exception{
        this.pLanguageService.pLanguageAdd(pLanguage);
    }
    @PutMapping("/updateName")
        public void pLanguageUpdate(@RequestBody ProgrammingLanguage pLanguage) {
            this.pLanguageService.pLanguageUpdate(pLanguage);
    }
    @DeleteMapping("/delete")
        public void pLanguageDelete(@RequestParam int id){
            this.pLanguageService.pLanguageDelete(id);
    }
    
}

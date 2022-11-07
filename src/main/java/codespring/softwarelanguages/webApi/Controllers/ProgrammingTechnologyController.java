package codespring.softwarelanguages.webApi.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import codespring.softwarelanguages.business.abstracts.ProgrammingTechService;
import codespring.softwarelanguages.business.requests.CreatePTechnologyRequest;
import codespring.softwarelanguages.business.requests.DeletePTechnologyRequest;
import codespring.softwarelanguages.business.requests.UpdatePTechnologyRequest;
import codespring.softwarelanguages.business.responses.GetAllPTechnologiesResponse;
import codespring.softwarelanguages.business.responses.GetIdPTechnologiesResponse;
import io.swagger.v3.oas.annotations.*;

@RestController
@RequestMapping("/api/PTechnologies")
public class ProgrammingTechnologyController {

    private ProgrammingTechService pTechnologyService;

    @Autowired
    public ProgrammingTechnologyController(ProgrammingTechService pTechService) {
        this.pTechnologyService = pTechService;
    }

    @Operation(summary = "{Kayıtlı Tüm Programlama Teknolojilerini Getirir}", tags = "Software Technologies Services")
    @GetMapping("/getAll")
    public List<GetAllPTechnologiesResponse> getAll(){
        return pTechnologyService.getAll();
    }
    
    @Operation(summary = "{Listeden Id ye Göre Kayıt Listeler}", tags = "Software Technologies Services")
    @GetMapping("/getId")
	public GetIdPTechnologiesResponse getId(int id){
		return pTechnologyService.getId(id);
	}

    @Operation(summary = "{Listeye Yeni Kayıt Ekler}", tags = "Software Technologies Services")
    @PostMapping("/add")
    public void add(@RequestBody CreatePTechnologyRequest createPTechnologyRequest)throws Exception{
        this.pTechnologyService.add(createPTechnologyRequest);
    }

    @Operation(summary = "{Listedeki Kaydı Günceller", tags = "Software Technologies Services")
    @PutMapping("/update")
	public void update(UpdatePTechnologyRequest updatePTechnologyRequest) throws Exception{
		pTechnologyService.update(updatePTechnologyRequest);
	}

    @Operation(summary = "{Listeden Kayıt Siler}", tags = "Software Technologies Services")
    @DeleteMapping("/delete")
	public void delete(DeletePTechnologyRequest deletePTechnologyRequest) {
		pTechnologyService.delete(deletePTechnologyRequest);
	}
 
}

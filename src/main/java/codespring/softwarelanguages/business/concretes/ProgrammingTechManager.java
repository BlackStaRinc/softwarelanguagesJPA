package codespring.softwarelanguages.business.concretes;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codespring.softwarelanguages.business.abstracts.ProgrammingTechService;
import codespring.softwarelanguages.business.requests.CreatePTechnologyRequest;
import codespring.softwarelanguages.business.requests.DeletePTechnologyRequest;
import codespring.softwarelanguages.business.requests.UpdatePTechnologyRequest;
import codespring.softwarelanguages.business.responses.GetAllPTechnologiesResponse;
import codespring.softwarelanguages.business.responses.GetIdPTechnologiesResponse;
import codespring.softwarelanguages.dataAccess.abstracts.ProgrammingLanguagesRepository;
import codespring.softwarelanguages.dataAccess.abstracts.ProgrammingTechnologiesRepository;
import codespring.softwarelanguages.entities.concretes.ProgrammingLanguages;
import codespring.softwarelanguages.entities.concretes.ProgrammingTechnologies;

@Service
public class ProgrammingTechManager implements ProgrammingTechService{
    private ProgrammingTechnologiesRepository pTechnologiesRepository;
    private ProgrammingLanguagesRepository pLanguagesRepository;

    @Autowired
    public ProgrammingTechManager(ProgrammingTechnologiesRepository pTechnologiesRepository, ProgrammingLanguagesRepository pLanguagesRepository) {
        this.pTechnologiesRepository = pTechnologiesRepository;
        this.pLanguagesRepository = pLanguagesRepository;
    }

    @Override
    public List<GetAllPTechnologiesResponse> getAll() {
        List<ProgrammingTechnologies> rProggramingTechnologies = pTechnologiesRepository.findAll();
        List<GetAllPTechnologiesResponse> pTechnologiesResponses = new ArrayList<>();
        for (ProgrammingTechnologies pTechnology : rProggramingTechnologies) {
            GetAllPTechnologiesResponse rTechnologies = new GetAllPTechnologiesResponse();
            ProgrammingLanguages pLanguages = pLanguagesRepository.getReferenceById(pTechnology.getProgrammingLanguages().getId());
            rTechnologies.setId(pTechnology.getId());
            rTechnologies.setName(pTechnology.getName());
            rTechnologies.setProgrammingLanguage(pLanguages.getName());
            pTechnologiesResponses.add(rTechnologies);            
        }
        return pTechnologiesResponses;
    }
    
    @Override
    public void add(CreatePTechnologyRequest createPTechnologyRequest) throws Exception {
        ProgrammingTechnologies pTechnology = new ProgrammingTechnologies();
        ProgrammingLanguages pLanguages = pLanguagesRepository.getReferenceById(createPTechnologyRequest.getProgrammingLanguageId());
        pTechnology.setName(createPTechnologyRequest.getName());
        pTechnology.setProgrammingLanguages(pLanguages);

         if (pTechControl(createPTechnologyRequest)) {
            throw new Exception("Programlama Dili Aynı veya Boş Olamaz");
        }
        this.pTechnologiesRepository.save(pTechnology);
    }

    public boolean pTechControl(CreatePTechnologyRequest createPTechnologyRequest){
        List<ProgrammingTechnologies> pTechnologies = pTechnologiesRepository.findAll();
        for (ProgrammingTechnologies pTechnology : pTechnologies) {
            if (pTechnology.getName().equalsIgnoreCase(createPTechnologyRequest.getName()) 
            || createPTechnologyRequest.getName().equals("")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public GetIdPTechnologiesResponse getId(int id){
        ProgrammingTechnologies pTechnologies = pTechnologiesRepository.getReferenceById(id);
        GetIdPTechnologiesResponse getIdPTechnologiesResponse = new GetIdPTechnologiesResponse();
        getIdPTechnologiesResponse.setId(pTechnologies.getId());
        getIdPTechnologiesResponse.setName(pTechnologies.getName());

        return getIdPTechnologiesResponse;
    }

    @Override
    public void update(UpdatePTechnologyRequest updatePTechnologyRequest) throws Exception {

        ProgrammingLanguages pLanguages = pLanguagesRepository.getReferenceById(updatePTechnologyRequest.getProgrammingLanguageId());

        ProgrammingTechnologies pTechnologies = new ProgrammingTechnologies();
        pTechnologies.setId(updatePTechnologyRequest.getId());
        pTechnologies.setName(updatePTechnologyRequest.getName());
        pTechnologies.setProgrammingLanguages(pLanguages);

         if (pLangControl(updatePTechnologyRequest)) {
            throw new Exception("Programlama Dili Aynı veya Boş Olamaz");
        }

        ProgrammingTechnologies upTechnologies = pTechnologiesRepository.getReferenceById(pTechnologies.getId());
		upTechnologies.setName(pTechnologies.getName());
		upTechnologies.setProgrammingLanguages(pLanguages);
		pTechnologiesRepository.save(upTechnologies);
    }

    private boolean pLangControl(UpdatePTechnologyRequest updatePTechnologyRequest) {
        List<ProgrammingTechnologies> pTechnologies = pTechnologiesRepository.findAll();
        for (ProgrammingTechnologies pTechnology : pTechnologies) {
            if (pTechnology.getName().equalsIgnoreCase(updatePTechnologyRequest.getName()) 
            || updatePTechnologyRequest.getName().equals("")) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void delete(DeletePTechnologyRequest deletePTechnologyRequest) {
        ProgrammingTechnologies pTechnologies = new ProgrammingTechnologies();
        pTechnologies.setId(deletePTechnologyRequest.getId());
        pTechnologiesRepository.delete(pTechnologies);
    }

}

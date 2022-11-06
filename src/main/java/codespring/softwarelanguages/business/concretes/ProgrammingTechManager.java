package codespring.softwarelanguages.business.concretes;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codespring.softwarelanguages.business.abstracts.ProgrammingTechService;
import codespring.softwarelanguages.business.requests.CreateProgTechnologyRequest;
import codespring.softwarelanguages.business.responses.GetAllProgTechnologiesResponse;
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
    public List<GetAllProgTechnologiesResponse> getAllTech() {
        List<ProgrammingTechnologies> resultProggramingTechnologies = pTechnologiesRepository.findAll();
        List<GetAllProgTechnologiesResponse> progTechnologiesResponses = new ArrayList<>();
        for (ProgrammingTechnologies pTechnology : resultProggramingTechnologies) {
            GetAllProgTechnologiesResponse responseTechnologies = new GetAllProgTechnologiesResponse();
            responseTechnologies.setId(pTechnology.getId());
            responseTechnologies.setName(pTechnology.getName());
            progTechnologiesResponses.add(responseTechnologies);            
        }
        return progTechnologiesResponses;
    }
    
    @Override
    public void pTechnologyAdd(CreateProgTechnologyRequest createProgTechnologyRequest) throws Exception {
        ProgrammingTechnologies programmingTechnology = new ProgrammingTechnologies();
        ProgrammingLanguages programmingLanguages = pLanguagesRepository.getReferenceById(createProgTechnologyRequest.getP_lang_id());
        programmingTechnology.setName(createProgTechnologyRequest.getName());

         if (pTechControl(createProgTechnologyRequest)) {
            throw new Exception("Programlama Dili Aynı veya Boş Olamaz");
        }
        this.pTechnologiesRepository.save(programmingTechnology);
    }

    public boolean pTechControl(CreateProgTechnologyRequest createProgTechnologyRequest){
        List<ProgrammingTechnologies> pTechnologies = pTechnologiesRepository.findAll();
        for (ProgrammingTechnologies programmingTechnology : pTechnologies) {
            if (programmingTechnology.getName().equalsIgnoreCase(createProgTechnologyRequest.getName()) 
            || createProgTechnologyRequest.getName().equals("")) {
                return true;
            }
        }
        return false;
    }

}

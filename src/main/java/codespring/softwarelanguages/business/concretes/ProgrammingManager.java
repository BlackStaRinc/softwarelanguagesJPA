package codespring.softwarelanguages.business.concretes;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codespring.softwarelanguages.business.abstracts.ProgrammingLanguageService;
import codespring.softwarelanguages.business.requests.CreateProgLanguageRequest;
import codespring.softwarelanguages.business.responses.GetAllProgLanguagesResponse;
import codespring.softwarelanguages.dataAccess.abstracts.ProgrammingLanguagesRepository;
import codespring.softwarelanguages.entities.concretes.ProgrammingLanguages;

@Service
public class ProgrammingManager implements ProgrammingLanguageService{
    private ProgrammingLanguagesRepository pLanguagesRepository;

    @Autowired
    public ProgrammingManager(ProgrammingLanguagesRepository pLanguagesRepository) {
        this.pLanguagesRepository = pLanguagesRepository;
    }

    @Override
    public List<GetAllProgLanguagesResponse> getAll() {
        List<ProgrammingLanguages> resultProggramingLanguages = pLanguagesRepository.findAll();
        List<GetAllProgLanguagesResponse> progLanguagesResponses = new ArrayList<>();
        for (ProgrammingLanguages pLanguage : resultProggramingLanguages) {
            GetAllProgLanguagesResponse responseLanguages = new GetAllProgLanguagesResponse();
            responseLanguages.setId(pLanguage.getId());
            responseLanguages.setName(pLanguage.getName());
            progLanguagesResponses.add(responseLanguages);            
        }
        return progLanguagesResponses;
    }
    
    @Override
    public void pLanguageAdd(CreateProgLanguageRequest createProgLanguageRequest) throws Exception {
        ProgrammingLanguages programmingLanguage = new ProgrammingLanguages();
        programmingLanguage.setName(createProgLanguageRequest.getName());
         if (pLangControl(createProgLanguageRequest)) {
            throw new Exception("Programlama Dili Aynı veya Boş Olamaz");
        }
        this.pLanguagesRepository.save(programmingLanguage);
    }

    public boolean pLangControl(CreateProgLanguageRequest createProgLanguageRequest){
        List<ProgrammingLanguages> pLanguages = pLanguagesRepository.findAll();
        for (ProgrammingLanguages programmingLanguage : pLanguages) {
            if (programmingLanguage.getName().equalsIgnoreCase(createProgLanguageRequest.getName()) 
            || createProgLanguageRequest.getName().equals("")) {
                return true;
            }
        }
        return false;
    }
    /* 
    @Override
    public ProgrammingLanguage getId(int id) throws Exception {
        return this.pLanguagesRepository.getId(id);
    }

    @Override
    public void pLanguageUpdate(ProgrammingLanguage pLanguage) {
       this.pLanguagesRepository.pLanguageUpdate(pLanguage);
    }

    @Override
    public void pLanguageDelete(int id){
       this.pLanguagesRepository.pLanguageDelete(id);
    }
    */

}

package codespring.softwarelanguages.business.concretes;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codespring.softwarelanguages.business.abstracts.ProgrammingLanguageService;
import codespring.softwarelanguages.business.requests.CreatePLanguageRequest;
import codespring.softwarelanguages.business.responses.GetAllPLanguagesResponse;
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
    public List<GetAllPLanguagesResponse> getAll() {
        List<ProgrammingLanguages> rProggramingLanguages = pLanguagesRepository.findAll();
        List<GetAllPLanguagesResponse> pLanguagesResponses = new ArrayList<>();
        for (ProgrammingLanguages pLanguage : rProggramingLanguages) {
            GetAllPLanguagesResponse rLanguages = new GetAllPLanguagesResponse();
            rLanguages.setId(pLanguage.getId());
            rLanguages.setName(pLanguage.getName());
            pLanguagesResponses.add(rLanguages);            
        }
        return pLanguagesResponses;
    }
    
    @Override
    public void add(CreatePLanguageRequest createPLanguageRequest) throws Exception {
        ProgrammingLanguages pLanguage = new ProgrammingLanguages();
        pLanguage.setName(createPLanguageRequest.getName());
         if (pLangControl(createPLanguageRequest)) {
            throw new Exception("Programlama Dili Aynı veya Boş Olamaz");
        }
        this.pLanguagesRepository.save(pLanguage);
    }

    public boolean pLangControl(CreatePLanguageRequest createPLanguageRequest){
        List<ProgrammingLanguages> pLanguages = pLanguagesRepository.findAll();
        for (ProgrammingLanguages pLanguage : pLanguages) {
            if (pLanguage.getName().equalsIgnoreCase(createPLanguageRequest.getName()) 
            || createPLanguageRequest.getName().equals("")) {
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

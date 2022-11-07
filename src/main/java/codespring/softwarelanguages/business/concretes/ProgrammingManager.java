package codespring.softwarelanguages.business.concretes;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codespring.softwarelanguages.business.abstracts.ProgrammingLanguageService;
import codespring.softwarelanguages.business.requests.CreatePLanguageRequest;
import codespring.softwarelanguages.business.requests.DeletePLanguageRequest;
import codespring.softwarelanguages.business.requests.UpdatePLanguageRequest;
import codespring.softwarelanguages.business.responses.GetAllPLanguagesResponse;
import codespring.softwarelanguages.business.responses.GetIdPLanguagesResponse;
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

    @Override
    public GetIdPLanguagesResponse getId(int id){
        ProgrammingLanguages pLanguages = pLanguagesRepository.getReferenceById(id);
        GetIdPLanguagesResponse gIdPLanguagesResponse = new GetIdPLanguagesResponse();
        gIdPLanguagesResponse.setId(pLanguages.getId());
        gIdPLanguagesResponse.setName(pLanguages.getName());

        return gIdPLanguagesResponse;
    }

    @Override
    public void update(UpdatePLanguageRequest updatePLanguageRequest) throws Exception {
        ProgrammingLanguages pLanguage = new ProgrammingLanguages();
        pLanguage.setName(updatePLanguageRequest.getName());
        pLanguage.setId(updatePLanguageRequest.getId());
         if (pLangControl(updatePLanguageRequest)) {
            throw new Exception("Programlama Dili Aynı veya Boş Olamaz");
        }
        this.pLanguagesRepository.save(pLanguage);
    }

    private boolean pLangControl(UpdatePLanguageRequest updatePLanguageRequest) {
        List<ProgrammingLanguages> pLanguages = pLanguagesRepository.findAll();
        for (ProgrammingLanguages pLanguage : pLanguages) {
            if (pLanguage.getName().equalsIgnoreCase(updatePLanguageRequest.getName()) 
            || updatePLanguageRequest.getName().equals("")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete(DeletePLanguageRequest deletePLanguageRequest) {
        ProgrammingLanguages pLanguages = new ProgrammingLanguages();
        pLanguages.setId(deletePLanguageRequest.getId());
        pLanguagesRepository.delete(pLanguages);
    }

}

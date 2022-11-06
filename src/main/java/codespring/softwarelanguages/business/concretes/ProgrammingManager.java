package codespring.softwarelanguages.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codespring.softwarelanguages.business.abstracts.ProgrammingLanguageService;
import codespring.softwarelanguages.dataAccess.abstracts.ProgrammingLanguagesRepository;
import codespring.softwarelanguages.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingManager implements ProgrammingLanguageService{
    private ProgrammingLanguagesRepository pLanguagesRepository;

    @Autowired
    public ProgrammingManager(ProgrammingLanguagesRepository pLanguagesRepository) {
        this.pLanguagesRepository = pLanguagesRepository;
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return pLanguagesRepository.getAll();
        //deneme branch repo jpa
    }

    @Override
    public ProgrammingLanguage getId(int id) throws Exception {
        return this.pLanguagesRepository.getId(id);
    }

    @Override
    public void pLanguageAdd(ProgrammingLanguage pLanguage) throws Exception {
         if (pLangControl(pLanguage)) {
            throw new Exception("Programlama Dili Aynı veya Boş Olamaz");
        }
        this.pLanguagesRepository.pLanguageAdd(pLanguage);
    }
    public boolean pLangControl(ProgrammingLanguage pLanguage){
        List<ProgrammingLanguage> pLanguages = pLanguagesRepository.getAll();
        for (ProgrammingLanguage programmingLanguage : pLanguages) {
            if (programmingLanguage.getName().equalsIgnoreCase(pLanguage.getName()) 
            || pLanguage.getName().equals("")
            || programmingLanguage.getId()==(pLanguage.getId())) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void pLanguageUpdate(ProgrammingLanguage pLanguage) {
       this.pLanguagesRepository.pLanguageUpdate(pLanguage);
    }
    @Override
    public void pLanguageDelete(int id){
       this.pLanguagesRepository.pLanguageDelete(id);
    }
    

   
}

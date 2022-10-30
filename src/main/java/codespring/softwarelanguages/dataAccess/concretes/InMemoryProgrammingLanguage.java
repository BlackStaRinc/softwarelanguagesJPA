package codespring.softwarelanguages.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import codespring.softwarelanguages.dataAccess.abstracts.ProgrammingLanguagesRepository;
import codespring.softwarelanguages.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguage implements ProgrammingLanguagesRepository{
    List<ProgrammingLanguage> programmingLanguages;

    public InMemoryProgrammingLanguage(){
        programmingLanguages = new ArrayList<>();

        programmingLanguages.add(new ProgrammingLanguage(0,"C#"));
        programmingLanguages.add(new ProgrammingLanguage(1,"Java"));
        programmingLanguages.add(new ProgrammingLanguage(2,"Python"));
    }

    @Override
    public List<ProgrammingLanguage> getAll() {
        return programmingLanguages;
    }
    @Override
    public ProgrammingLanguage getId(int id){
        for (ProgrammingLanguage language : programmingLanguages){
            if (language.getId() == id){
                return language;
            }
        }
        return null;
    }

    @Override
    public void pLanguageAdd(ProgrammingLanguage pLanguage){
        this.programmingLanguages.add(pLanguage);
    }

    @Override
    public void pLanguageUpdate(ProgrammingLanguage pLanguage) {
        for (ProgrammingLanguage pLang : programmingLanguages) {
            if (pLanguage.getId()==pLang.getId()) {
                pLang.setName(pLanguage.getName());
            }
        }
    }

    @Override
    public void pLanguageDelete(int id){
       this.programmingLanguages.remove(id);
    }
    
}

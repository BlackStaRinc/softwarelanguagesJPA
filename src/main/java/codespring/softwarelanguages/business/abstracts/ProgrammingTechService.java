package codespring.softwarelanguages.business.abstracts;

import java.util.List;

import codespring.softwarelanguages.business.requests.CreatePTechnologyRequest;
import codespring.softwarelanguages.business.responses.GetAllPTechnologiesResponse;


public interface ProgrammingTechService {

    List<GetAllPTechnologiesResponse> getAll();
    void add(CreatePTechnologyRequest createPTechnologyRequest)throws Exception;
    /*ProgrammingLanguage getId(int id) throws Exception;
    void pLanguageUpdate(ProgrammingLanguage pLanguage);
    void pLanguageDelete(int id);
    */
}


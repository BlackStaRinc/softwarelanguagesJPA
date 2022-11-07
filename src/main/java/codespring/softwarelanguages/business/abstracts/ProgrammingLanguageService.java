package codespring.softwarelanguages.business.abstracts;

import java.util.List;

import codespring.softwarelanguages.business.requests.CreatePLanguageRequest;
import codespring.softwarelanguages.business.requests.DeletePLanguageRequest;
import codespring.softwarelanguages.business.requests.UpdatePLanguageRequest;
import codespring.softwarelanguages.business.responses.GetAllPLanguagesResponse;
import codespring.softwarelanguages.business.responses.GetIdPLanguagesResponse;


public interface ProgrammingLanguageService {

    List<GetAllPLanguagesResponse> getAll();
    GetIdPLanguagesResponse getId(int id);
    void add(CreatePLanguageRequest createPLanguageRequest)throws Exception;
    void update(UpdatePLanguageRequest updatePLanguageRequest)throws Exception;
    void delete(DeletePLanguageRequest deletePLanguageRequest);
}


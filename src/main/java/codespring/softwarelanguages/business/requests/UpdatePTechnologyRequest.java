package codespring.softwarelanguages.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePTechnologyRequest {
    private int id;
    private String name;
    private int programmingLanguageId;
}

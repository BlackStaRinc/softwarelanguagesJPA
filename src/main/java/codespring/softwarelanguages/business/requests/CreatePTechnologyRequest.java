package codespring.softwarelanguages.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePTechnologyRequest {
    private String name;
    private int programming_language_id;
}

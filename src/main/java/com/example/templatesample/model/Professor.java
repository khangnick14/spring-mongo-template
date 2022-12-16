package com.example.templatesample.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(collection = "professor")
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Professor {
    @Id
    private String professorID;
    private Profile profile;

    public void updateProfessor(Professor newProfessor) {
        this.professorID = newProfessor.getProfessorID();
        this.profile = newProfessor.getProfile();
    }
}

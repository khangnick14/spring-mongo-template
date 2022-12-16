package com.example.templatesample.model;

import com.example.templatesample.model.enums.Major;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


@Data
@Builder
@Document(collection = "student")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {
        @Id
        private String studentID;
        private Profile profile;
        private Major major;
        private Payment payment;

        public void updateStudent(Student newStudent) {
                this.studentID = newStudent.getStudentID();
                this.profile = newStudent.getProfile();
                this.major = newStudent.getMajor();
                this.payment = newStudent.getPayment();
        }
}

package com.binarytree.binarytreestudents.controller.dto;

import com.binarytree.binarytreestudents.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentGradeDTO{
    private Student student;
    private int grade;
}

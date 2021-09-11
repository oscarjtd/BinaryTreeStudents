package com.binarytree.binarytreestudents.service;

import com.binarytree.binarytreestudents.applicationdto.ResponseBinaryTreeDto;
import com.binarytree.binarytreestudents.exception.BinaryTreeException;
import com.binarytree.binarytreestudents.exception.DataNotFoundException;
import com.binarytree.binarytreestudents.model.BinaryTree;
import com.binarytree.binarytreestudents.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BinaryTreeService {
    private BinaryTree binaryTree = new BinaryTree();

    public ResponseEntity<ResponseBinaryTreeDto> addStudent(Student student) throws BinaryTreeException {
        binaryTree.addStudent(student);
        return new ResponseEntity<>(new ResponseBinaryTreeDto(student, "Student addded succesfully", null), HttpStatus.OK);


    }
    public ResponseEntity<ResponseBinaryTreeDto> listStudents(int which) throws DataNotFoundException
    {
        return new ResponseEntity<>(new ResponseBinaryTreeDto(binaryTree.listStudents(which),"Successful!",
                null),HttpStatus.OK);

    }
    public ResponseEntity<ResponseBinaryTreeDto> listStudentsByGrade(float grade, int condition) throws BinaryTreeException
    {
        if (binaryTree.listStudentsByGrade(grade, condition).isEmpty())
        {
            return new ResponseEntity<>(new ResponseBinaryTreeDto(binaryTree.listStudentsByGrade(grade, condition), "Esta vacia", null), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(new ResponseBinaryTreeDto(binaryTree.listStudentsByGrade(grade, condition), "Success!", null), HttpStatus.OK);
    }
    public ResponseEntity<ResponseBinaryTreeDto> count() throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.count(),"Successful!",
                        null),HttpStatus.OK);

    }

    // ResponseEntity to list Boys who end in a certain number given by the user
    public ResponseEntity<ResponseBinaryTreeDto> listEndEqualNum(char number) throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.listEndEqualNum(number),"Successful List",
                        null),HttpStatus.OK);

    }

    // ResponseEntity to show how many ID's end in a certain number given by the user
    public ResponseEntity<ResponseBinaryTreeDto> countEndEqualNum(char number) throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.countEndEqualNum(number),"Successful Counter",
                        null),HttpStatus.OK);

    }

    public ResponseEntity<ResponseBinaryTreeDto> getLeaves() throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.getLeaves(),"List Success",
                        null),HttpStatus.OK);

    }

    // ResponseEntity to prune the existing Leaves in the Tree
    public ResponseEntity<ResponseBinaryTreeDto> prune() throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.prune(),"successful pruning",
                        null),HttpStatus.OK);

    }

    // ResponseEntity to calculate the Tree Grade
    public ResponseEntity<ResponseBinaryTreeDto> calculateTreeGrade() throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.calculateTreeGrade(),"successful",
                        null),HttpStatus.OK);

    }

    // ResponseEntity to get All Boys Grade
    public ResponseEntity<ResponseBinaryTreeDto> getStudentsGrade() throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.getStudentsGrade(),"successful",
                        null),HttpStatus.OK);

    }

    // ResponseEntity to get All Boys of a certain Level given by user
    public ResponseEntity<ResponseBinaryTreeDto> getStudentsByLevel(int wantedLevel) throws DataNotFoundException,
            BinaryTreeException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.getStudentsByLevel(wantedLevel),"successful",
                        null),HttpStatus.OK);

    }

    // ResponseEntity to get Boys that end in a certain number and are Leaves
    public ResponseEntity<ResponseBinaryTreeDto> isEqualAndLeaf(int number) throws DataNotFoundException
    {
        return new ResponseEntity<>(
                new ResponseBinaryTreeDto(binaryTree.isEqualAndLeaf(number),"successful List",
                        null),HttpStatus.OK);

    }
}

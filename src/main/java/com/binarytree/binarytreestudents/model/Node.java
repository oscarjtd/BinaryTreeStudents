package com.binarytree.binarytreestudents.model;

import com.binarytree.binarytreestudents.controller.dto.StudentGradeDTO;
import com.binarytree.binarytreestudents.exception.BinaryTreeException;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@ToString
public class Node {
    private Student data;
    private Node left;
    private Node right;
    private int grade;

    public Node(Student data) {
        this.data = data;
        this.grade = 1;
    }

    public void addStudent(Student data) throws BinaryTreeException {
        if (data.getCode() < this.getData().getCode()) {
            if (this.getLeft() == null) {
                this.setLeft(new Node(data));

            } else {
                this.left.addStudent(data);
            }
        } else if (data.getCode() > this.getData().getCode()) {
            if (this.getRight() == null) {
                this.setRight(new Node(data));

            } else {
                this.right.addStudent(data);
            }

        } else {
            throw new BinaryTreeException("A student with that code already exists");
        }

    }

    public List<Student> listStudentsByGrade(double grade, int condition) {

        List<Student> listStudentsByGrade = new ArrayList<>();

        if (condition == 1) {
            if (this.getData().getGrade() <= grade) {
                listStudentsByGrade.add(this.getData());
            }
            if (this.getLeft() != null) {
                    listStudentsByGrade.addAll(this.getLeft().listStudentsByGrade(grade, condition));
            }
            if (this.getRight() != null) {
                    listStudentsByGrade.addAll(this.getRight().listStudentsByGrade(grade, condition));
            }
        } else if (condition == 2) {
            if (this.getData().getGrade() < grade) {
                listStudentsByGrade.add(this.getData());
            }
            if (this.getLeft() != null) {
                    listStudentsByGrade.addAll(this.getLeft().listStudentsByGrade(grade, condition));
            }
            if (this.getRight() != null) {
                    listStudentsByGrade.addAll(this.getRight().listStudentsByGrade(grade, condition));
            }
        } else if (condition == 3) {
            if (this.getData().getGrade() > grade) {
                listStudentsByGrade.add(this.getData());
            }
            if (this.getLeft() != null) {
                    listStudentsByGrade.addAll(this.getLeft().listStudentsByGrade(grade, condition));
            }
            if (this.getRight() != null) {
                    listStudentsByGrade.addAll(this.getRight().listStudentsByGrade(grade, condition));
            }
        } else if (condition == 4) {
            if (this.getData().getGrade() >= grade) {
                listStudentsByGrade.add(this.getData());
            }
            if (this.getLeft() != null) {
                    listStudentsByGrade.addAll(this.getLeft().listStudentsByGrade(grade, condition));
            }
            if (this.getRight() != null) {
                    listStudentsByGrade.addAll(this.getRight().listStudentsByGrade(grade, condition));
            }
        }

        return listStudentsByGrade;
    }


    public List<Student> listStudentsPreOrder() {
        List<Student> listStudentsPreOrder = new ArrayList<>();
        listStudentsPreOrder.add(this.getData());
        if (this.getLeft() != null) {
            listStudentsPreOrder.addAll(this.getLeft().listStudentsPreOrder());
        }
        if (this.getRight() != null) {
            listStudentsPreOrder.addAll(this.getRight().listStudentsPreOrder());
        }
        // Once finished return the List
        return listStudentsPreOrder;
    }
    public List<Student> listStudentsInOrder(){
        // Generate a new List
        List<Student> listStudentsInOrder = new ArrayList<>();
        // if root Left has something...
        if(this.getLeft() != null){
            // move to the Left and call the method AGAIN! and add ALL
            listStudentsInOrder.addAll(this.getLeft().listStudentsInOrder());
        }
        // add root to the List
        listStudentsInOrder.add(this.getData());

        // if the root Right has something...
        if(this.getRight() != null){
            // move to the Right and call the method AGAIN! and add ALL
            listStudentsInOrder.addAll(this.getRight().listStudentsInOrder());
        }
        // Once finished return the List
        return listStudentsInOrder;
    }

    public List<Student> listStudentsPostOrder(){
        // Generate a new List
        List<Student> listStudentsPostOrder = new ArrayList<>();
        // if root Left has something...
        if(this.getLeft() != null){
            // move to the Left and call the method AGAIN! and add ALL
            listStudentsPostOrder.addAll(this.getLeft().listStudentsPostOrder());
        }
        // if the root Right has something...
        if(this.getRight() != null){
            // move to the Right and call the method AGAIN! and add ALL
            listStudentsPostOrder.addAll(this.getRight().listStudentsPostOrder());
        }
        // add the root to the List
        listStudentsPostOrder.add(this.getData());
        // Once finished return the List
        return listStudentsPostOrder;
    }
    public List<Student> listEndEqualNum(char number) //throws DataNotFoundException
    {
        // Creating a new List...
        List<Student> listEndEqualNum = new ArrayList<>();
        // Validate if root ends in number
        if(this.getData().getCode() %10 == number)
        {
            listEndEqualNum.add(this.getData());
        }
        // if root Left has something...
        if (this.getLeft() != null)
        {
            // if root Left ends in number...
            if (this.getData().getCode() % 10 == number)
            {
                // add to the List and move to the Left and call the method AGAIN!
                listEndEqualNum.addAll(this.getLeft().listEndEqualNum(number));
            }
        }
        // if root Right has something...
        if (this.getRight() != null)
        {
            // if root Right ends in number...
            if (this.getData().getCode() % 10 == number)
            {
                // add to the List and move to the Right and call the method AGAIN!
                listEndEqualNum.addAll(this.getRight().listEndEqualNum(number));
            }
        }

        // HELP WITH THIS VALIDATION!!
        /*
        if(listEqualNum.isEmpty()){
            throw new DataNotFoundException("no hay niños terminados en ese numero");
        }
         */

        // Once finished return the List
        return listEndEqualNum;
    }

    // Method to count how many Boys' ID end in a certain number given by the user
    public int countEndEqualNum(char number)
    {
        // set a new variable with the list that the method above returns...
        List<Student> listStudentsEndEqualNum = listEndEqualNum(number);
        // return the list Size (int)...
        return listStudentsEndEqualNum.size();
    }

    // validate if the Node is a Leaf
    public boolean isLeaf()
    {
        // return TRUE if the Node has Left & Right == null
        return left ==null && right==null;
    }

    // Method to get All existing Leaves
    public List<Student> getLeaves() {
        // Generate a new List
        List<Student> getLeaves = new ArrayList<>();
        // if root is a Leaf...
        if (this.isLeaf()) {
            getLeaves.add(this.getData());
        }
        else
        {
            // if root Left has something...
            if (this.getLeft() != null)
            {
                // add to the List and move to the Left and call the method AGAIN!
                getLeaves.addAll(this.getLeft().getLeaves());
            }
            // if root Right has something...
            if (this.getRight() != null)
            {
                // add to the List and move to the Right and call the method AGAIN!
                getLeaves.addAll(this.getRight().getLeaves());
            }
        }
        // Once finished return the List
        return getLeaves;
    }

    // Method to prune all existing Leaves in the Tree
    public void prune()
    {
        // if root Left has something...
        if (this.getLeft() != null)
        {
            // ir root Left is a Leaf...
            if (this.getLeft().isLeaf())
            {
                // set root Left as null
                this.setLeft(null);
            }
            else
            {
                // move to the Left and call the Method AGAIN!
                this.getLeft().prune();
            }
        }
        // if root Right has something...
        if (this.getRight() != null)
        {
            // is root Right is a Leaf...
            if (this.getRight().isLeaf())
            {
                // set root Right as null
                this.setRight(null);
            }
            else
            {
                // move to the Right and call the Method AGAIN!
                this.getRight().prune();
            }
        }
    }

    // Method to calculate Tree Grade
    public int calculateTreeGrade()
    {
        int gradeLeft = 0, gradeRight = 0;
        // if the current Node is a Leaf...
        if(this.isLeaf())
        {
            return 1;
        }
        // if the current Node has kids...
        else
        {
            // if current on the Left has something...
            if(this.getLeft() != null)
            {
                // calculate grade on the Left and save the number in gradeLeft
                gradeLeft = this.getLeft().calculateTreeGrade();
            }
            // if current on the Right has something...
            if(this.getRight() != null)
            {
                // calculate grade on the Right and save the number in gradeRight
                gradeRight = this.getRight().calculateTreeGrade();
            }
        }
        // ---- RETURN 1 + MY LARGEST CHILD ----
        // if current on the Left is >= current on the Right...
        if(gradeLeft >= gradeRight)
        {
            // return current (1) + current Left Grade
            return 1 + gradeLeft;
        }
        // if current on the Left < current on the Right...
        else
        {
            // return current (1) + current Right Grade
            return 1 + gradeRight;
        }
    }

    // Method to get Boys Grade using a DataTransferObject
    public List<StudentGradeDTO> getStudentsGrade()
    {
        // Generating a List of BoyGradeDTO
        List<StudentGradeDTO> listStudents = new ArrayList<>();
        int gradeLeft = 0, gradeRight = 0;
        // if the current Node is a Leaf...
        if(this.isLeaf())
        {
            // create a DTO with currentNodeData and current grade (int)
            listStudents.add(new StudentGradeDTO(this.data,this.grade));
        }
        // if the current Node has kids...
        else
        {
            // if current on the Left has something...
            if(this.getLeft() != null)
            {
                // calculate grade on the Left and save the number in gradeLeft
                gradeLeft = this.getLeft().calculateTreeGrade();
                // call the Method again and add All Boys on the Left
                listStudents.addAll(this.getLeft().getStudentsGrade());
            }
            // if current on the Right has something...
            if(this.getRight() != null)
            {
                // calculate grade on the Right and save the number in gradeRight
                gradeRight = this.getRight().calculateTreeGrade();
                // call the Method again and add All Boys on the Right
                listStudents.addAll(this.getRight().getStudentsGrade());
            }

            // ---- RETURN 1 + MY LARGEST CHILD ----
            // if current on the Left is >= current on the Right...
            if(gradeLeft >= gradeRight)
            {
                // return current (1) + current Left Grade
                listStudents.add(new StudentGradeDTO(this.data,1 + gradeLeft));
            }
            // if current on the Left < current on the Right...
            else
            {
                // return current (1) + current Right Grade
                listStudents.add(new StudentGradeDTO(this.data,1 + gradeRight));
            }
        }
        return listStudents;
    }

    // Method to get All Boys of a certain Level given by user
    public List<Student> getStudentsByLevel(int currentLevel, int wantedLevel)
    {
        // Generating a List...
        List<Student> listStudentsLevel= new ArrayList<>();
        // if current level is equal to wanted level...
        if(currentLevel == wantedLevel)
        {
            // add current to the List
            listStudentsLevel.add(this.data);
        }
        else
        {
            // if current on the Left has something...
            if(this.getLeft() != null)
            {
                // call the Method again and add all on the Left (go down 1 level)
                listStudentsLevel.addAll(this.getLeft().getStudentsByLevel(currentLevel+1, wantedLevel));
            }
            // if current on the Right has something...
            if(this.getRight() != null)
            {
                // call the Method again and add all on the Right (go down 1 level)
                listStudentsLevel.addAll(this.getRight().getStudentsByLevel(currentLevel+1, wantedLevel));
            }
        }
        return listStudentsLevel;
    }

    // Method to get Boys that end in a certain number and are Leaves
    public List<Student> isEqualAndLeaf(int number)
    {
        // Generating the List...
        List<Student> listEqualAndLeaf = new ArrayList<>();
        // if current ends in the number and is a Leaf
        if(this.getData().getCode() %10 == number && this.isLeaf())
        {
            // add current to the List
            listEqualAndLeaf.add(this.data);
        }
        // if current on the Left has something...
        if(this.getLeft() != null)
        {
            // call the Method again and add All on the Left
            listEqualAndLeaf.addAll(this.getLeft().isEqualAndLeaf(number));
        }
        // if current on the Right has something...
        if(this.getRight() != null)
        {
            // call the Method again and add All on the Right
            listEqualAndLeaf.addAll(this.getRight().isEqualAndLeaf(number));
        }
        return listEqualAndLeaf;
    }

}

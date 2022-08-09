package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/Student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> GetStudents(){
        return studentService.GetStudents();
    }

    @PostMapping
    public void RegisterNewStudent(
            @RequestBody Student student){
        studentService.AddNewStudent(student);
    }

    @DeleteMapping(path = "{StudentId}")
    public  void DeleteStudent(
            @PathVariable("StudentId") Long StudentId){
        studentService.DeleteStudent(StudentId);
    }
    @PutMapping(path = "{StudentId}")
    public  void UpdateStudent(@PathVariable("StudentId") Long StudentId,
                               @RequestParam(required = false) String FirstName,
                               @RequestParam(required = false) String LastName){
        studentService.UpdateStudent(StudentId,FirstName,LastName);
    }



}

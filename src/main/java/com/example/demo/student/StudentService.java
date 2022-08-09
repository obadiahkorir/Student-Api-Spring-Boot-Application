package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class StudentService {
    private final  StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository =studentRepository;
    }
    public List<Student> GetStudents(){
       return studentRepository.findAll();
    }
    public void AddNewStudent(Student student){
        Optional<Student> studentptional = studentRepository.findByFirstName(student.getFirstName());
        if(studentptional.isPresent()){
            throw new IllegalStateException("Name Already Taken");
        }
        studentRepository.save(student);
    }
    public void DeleteStudent(Long StudentId){
     boolean exists = studentRepository.existsById(StudentId);
     if(!exists){
         throw  new IllegalStateException("Student with the given id does not exist");
     }
     studentRepository.deleteById(StudentId);
    }
    @Transactional
    public void UpdateStudent(Long StudentId,String FirstName,String LastName){
        Student student = studentRepository.findById(StudentId).orElseThrow(()-> new IllegalStateException(
                "Student with the Id"+ StudentId +"does not exist"
        ));
        if(FirstName !=null && FirstName.length()>0 && !Objects.equals(student.getFirstName(),FirstName)){
            student.setFirstName(FirstName);
        }
        if(LastName !=null && LastName.length()>0 && !Objects.equals(student.getLastName(),LastName)){
            student.setLastName(LastName);
        }
    }
}

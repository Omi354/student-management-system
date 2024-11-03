package org.example;

import java.util.List;

public class StudentInfoManager {

  List<Student> studentList;

  public StudentInfoManager(List<Student> studentList) {
    this.studentList = studentList;
  }

  public void addStudent(String fullName, double testScore) {
    studentList.add(new Student(fullName, testScore));
  }

  public void removeStudent(String fullName) {
    studentList.removeIf(v -> v.getFullName().equals(fullName));
  }

  public void updateTestScore(String fullName, double testScore) {
    Student updatedStudent = studentList.stream()
        .filter(v -> v.getFullName().equals(fullName))
        .toList().getFirst();
    updatedStudent.setTestScore(testScore);
  }

  public void calculateAveragePoint(List<Student> studentList) {
    double averageTestScore = studentList.stream()
        .map(v -> v.getTestScore())
        .mapToDouble(Double::doubleValue)
        .average()
        .orElse(Double.NaN);
    System.out.println("平均点: " + averageTestScore + "点");
  }

  public void showAllStudentInfo(List<Student> studentList) {
    System.out.println("学生一覧：");
    for (Student student : studentList) {
      System.out.println(student);
    }
  }


}

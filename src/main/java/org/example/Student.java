package org.example;

public class Student {

  String fullName;
  double testScore;

  public Student(String fullName, double testScore) {
    this.fullName = fullName;
    this.testScore = testScore;
  }

  public String getFullName() {
    return fullName;
  }

  public double getTestScore() {
    return testScore;
  }

  public void setTestScore(double testScore) {
    this.testScore = testScore;
  }

  @Override
  public String toString() {
    return fullName + ": " + testScore + "点";
  }
}
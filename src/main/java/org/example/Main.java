package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    // 学生のインスタンスを配列で作成
    Student[] students = {
        new Student("山田 太郎", 85),
        new Student("佐藤 花子", 92),
        new Student("鈴木 次郎", 78),
        new Student("田中 美咲", 66),
        new Student("高橋 健太", 89),
        new Student("伊藤 あかり", 74),
        new Student("渡辺 修", 95),
        new Student("中村 優", 58),
        new Student("小林 彩香", 81),
        new Student("加藤 真一", 69)
    };

    // イニシャルのstudentListを作成
    List<Student> studentList = new ArrayList<>();
    for (Student student : students) {
      studentList.add(student);
    }

    // StudentInfoManagerのインスタンス生成
    StudentInfoManager studentInfoManager = new StudentInfoManager(studentList);

    // add処理の確認
    String addedStudentName = "ニギハヤミコハクヌシ";
    double addedTestScore = 32;
    studentInfoManager.addStudent(addedStudentName, addedTestScore);
    System.out.println(studentList);

    // remove処理の確認
    String removedStudentName = "ニギハヤミコハクヌシ";
    studentInfoManager.removeStudent(removedStudentName);
    System.out.println(studentList);

    // 点数の更新
    String updatedStudentName = "山田 太郎";
    double testScoreAfterUpdate = 50;

    studentInfoManager.updateTestScore(updatedStudentName, testScoreAfterUpdate);
    System.out.println(studentList);

    // 平均点の計算
    studentInfoManager.calculateAveragePoint(studentList);

    // 全学生の情報を表示
    studentInfoManager.showAllStudentInfo(studentList);


  }
}
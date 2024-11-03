package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // Scannerのインスタンスを生成
    Scanner scanner = new Scanner(System.in);

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

    // studentListをイニシャライズ
    List<Student> studentList = new ArrayList<>();
    for (Student student : students) {
      studentList.add(student);
    }

    // StudentInfoManagerのインスタンス生成
    StudentInfoManager studentInfoManager = new StudentInfoManager(studentList);

    while (true) {
      // メニュー画面の表示
      System.out.println("1. 学生を追加");
      System.out.println("2. 学生を削除");
      System.out.println("3. 点数を更新");
      System.out.println("4. 平均点を計算");
      System.out.println("5. 全学生の情報を表示");
      System.out.println("6. 終了");

      int userInputNumber = scanner.nextInt();
      // コンソールの改行を削除
      scanner.nextLine();

      switch (userInputNumber) {
        case 1 -> {
          // 学生の追加処理
          System.out.println("学生の名前を入力してください: ");
          String addedStudentName = scanner.nextLine();
          System.out.println(addedStudentName + "の点数を入力してください: ");
          double addedTestScore = scanner.nextDouble();
          // コンソールの改行を削除
          scanner.nextLine();
          studentInfoManager.addStudent(addedStudentName, addedTestScore);
          System.out.println(
              "学生名; " + addedStudentName + ", 点数: " + addedTestScore + "点 を登録しました");
        }
        case 2 -> {
          // 学生の削除処理
          System.out.println("学生の名前を入力してください: ");
          String removedStudentName = scanner.nextLine();
          studentInfoManager.removeStudent(removedStudentName);
          System.out.println("学生名: " + removedStudentName + " の情報を削除しました");
        }
        case 3 -> {
          // 点数の更新
          System.out.println("学生の名前を入力してください: ");
          String updatedStudentName = scanner.nextLine();
          System.out.println(updatedStudentName + "の更新後の点数を入力してください: ");
          double testScoreAfterUpdate = scanner.nextDouble();
          // コンソールの改行を削除
          scanner.nextLine();
          studentInfoManager.updateTestScore(updatedStudentName, testScoreAfterUpdate);
          System.out.println("学生名; " + updatedStudentName + "の点数を" + testScoreAfterUpdate
              + "点に変更しました");
        }
        case 4 -> {
          // 平均点の計算
          studentInfoManager.calculateAveragePoint(studentList);
        }
        case 5 -> {
          // 全学生の情報を表示
          studentInfoManager.showAllStudentInfo(studentList);
        }
        case 6 -> {
          scanner.close();
          System.out.println("プログラムを終了します。");
        }
        default -> System.out.println("無効な入力です。再度入力してください。");
      }
      if (userInputNumber == 6) {
        break;
      }
    }
  }
}
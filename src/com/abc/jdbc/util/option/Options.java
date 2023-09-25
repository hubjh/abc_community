package com.abc.jdbc.util.option;

import com.abc.jdbc.util.print.Print;

import java.util.Scanner;

public class Options {
    public static int number(int option) {
        Print print = new Print();
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int selectNumber = sc.nextInt();
            if (selectNumber >= 1 && selectNumber < (option + 1)) {
                return selectNumber;
            } else {
                print.optionError();
                return -1;
            }
        } else {
            // 정수가 아닌 입력이 들어올 경우 오류 메시지 출력
        sc.nextLine(); // 입력 버퍼 비우기
        print.optionError();
        return -1;
        }
    }
}







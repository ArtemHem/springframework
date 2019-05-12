package lesson3_hw;

import java.util.Scanner;

public class MainHibernate {

    private static ConnectBDHibernate connectBD;
    private static Scanner in;
    private static boolean isWorkingTableName = true;
    private static boolean isWorkingTable = true;

    public static void main(String[] args) {
        connectBD = new ConnectBDHibernate();
        in = new Scanner(System.in);

        while (isWorkingTableName) {
            System.out.println("Input table number: ");
            int searchTableNum = in.nextInt();
            System.out.println("Print(1)/Delete(2)");
            int printDelete = in.nextInt();
            String nameTable = getNameTable(searchTableNum);
            isWorkingTableName = checkIsWorking(searchTableNum);
            if (!isWorkingTableName) {
                return;
            }

            workingWithTable(nameTable,printDelete);
            isWorkingTable = true;
        }
        in.close();
    }

    private static void workingWithTable(String nameTable, int printDelete) {
        while (isWorkingTable) {
            System.out.println("Input a number " + nameTable + ": ");
            int num = in.nextInt();
            isWorkingTable = checkIsWorking(num);
            if (!isWorkingTable) {
                return;
            }

            if (printDelete == 2) {
                deleteSearchPosition(nameTable, num);
            } else {
                printSearchPosition(nameTable,num);
            }
        }
    }

    private static String getNameTable(int searchTableNum) {
        String nameTable = "student";
        if (searchTableNum == 2) {
            nameTable = "course";
        }
        return nameTable;
    }

    private static void printSearchPosition(String tableName, int num) {
        if (tableName.equals("student")) {
            connectBD.getStudent(num);
        }
        if (tableName.equals("course")) {
            connectBD.getCourse(num);
        }
    }

    private static void deleteSearchPosition(String tableName, int num) {
        if (tableName.equals("student")) {
            connectBD.deleteStudentInTable(num);
        }
        if (tableName.equals("course")) {
            connectBD.deleteCourseInTable(num);
        }
    }

    private static boolean checkIsWorking(int num) {
        if (num == 10) {
            System.out.println("cancel");
            return false;
        }
        return true;
    }

}

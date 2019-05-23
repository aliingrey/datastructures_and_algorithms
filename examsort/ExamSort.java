import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExamSort
{
    private static void mergeSortRecursive(Student data[],Student temp[], int low, int high)
    { 
        int n = high-low+1; //getting size of the array 
        int middle = low + n/2; 
        int i; 
        if (n < 2) return;
        for (i = low; i < middle; i++) { 
            temp[i] = data[i]; 
        }
        mergeSortRecursive(temp,data,low,middle-1); 
        mergeSortRecursive(data,temp,middle,high); 
        merge(data,temp,low,middle,high);
    }
    private static void merge(Student data[], Student temp[],int low, int middle, int high) {
        int result_index = low;
        int temp_index = low; 
        int dest_index = middle; 
        while (temp_index < middle && dest_index <= high) { 
            if (data[dest_index].getId() < temp[temp_index].getId()) {
                data[result_index++] = data[dest_index++];
            }  else { 
                data[result_index++] = temp[temp_index++];
            } 
        }
        while (temp_index < middle) {
            data[result_index++] = temp[temp_index++]; 
        } 
    }
    private static void InsertionSort(Student[] students) {
        int n = students.length;
        Student temp;
        for (int i=1; i< n; i++) {
            for(int j = i ; j > 0 ; j--){
                if(students[j].getId() < students[j-1].getId()){
                    temp = students[j];
                    students[j] = students[j-1];
                    students[j-1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        ExamSort sort = new ExamSort();
        int n = 50;
        Student[] students = new Student[n];
        Random random = new Random();
        ArrayList studentArrayList = new ArrayList();
        int count = 0;
        while (count < n) {
             int uniYear = random.nextInt(3) + 1;
             int studentID = random.nextInt(100) + 1;
             String[] fnames = {"Bob", "Ali", "Tom", "Joy", "Ari", "Bridget", "Ethan", "Hayley", "Meaghan", "Josh"};
             String first = fnames[(int)(Math.random()*fnames.length)];
             
             String[] lnames = {"Jones", "Walker", "Smith", "Thomas", "Donnovan", "Dillon", "Hart", "Wagner"};
             String last = lnames[(int)(Math.random()*lnames.length)];
             
             String[] programs = {"Computer Science", "Business", "Engineering", "Law", "English", "Art"};
             String program = programs[(int)(Math.random()*programs.length)]; 

             if (!studentArrayList.contains(studentID)) {
                 studentArrayList.add(studentID);
                 students[count] = new Student(studentID,first, last, uniYear, program);
                 count++;
             }
        }
        System.out.println("\nunsorted list of students:\n");
        for (int i = 0; i < n; i ++) {
             System.out.println(students[i]);
        }
        
        Scanner input = new Scanner(System.in);      
        int choice;
        do {
               System.out.println("\npress the number for the case you'd like to execute\n -- 1 for case 1, 2 for case 2, 0 to exit --");        
               choice = input.nextInt();
               System.out.println();
               switch (choice) {
                   case 1: {
                       System.out.println("\nCase-1");
                       Student[] temp = new Student[n];
                       mergeSortRecursive(students, temp, 0, n-1);
                       System.out.println("\nsorted using merge sort:");
                       for (int i = 0; i < n; i = i + 10) {
                            for (int j = 0; j < i; j ++) {
                                System.out.println(students[j]);
                            }
                            System.out.println("\n");
                        }
                       break;
                    }
                    case 2: {
                        System.out.println("\nCase-2");
                        InsertionSort(students);
                        System.out.println("\nsorted using insertion sort:");
                        for (int i = 0; i < n; i ++) {
                            System.out.println(students[i]);
                        }
                        break;
           
                
                    }
                    case 0: {
                        System.out.println("\n\n");
                        break;
                    }

                } 
        } while (choice != 0);
    }
}

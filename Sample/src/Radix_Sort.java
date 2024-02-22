import java.io.*;
import java.util.*;

public class Radix_Sort {

    static int getMax(int arr[], int n){
        int maxNum = arr[0];
        for(int i = 1; i < n; i++){
            if (arr[i] > maxNum){maxNum = arr[i];}
        }
        return maxNum;
    }

    static void countSort(int arr[], int n, int exp){

        int output[] = new int[n];
        int count[] = new int[10];
        Arrays.fill(count, 0);

        //Count of digit occurrences
        for(int i = 0;i<n;i++){count[(arr[i]/exp)%10]++;}

        //Change Count(index)
        for(int i = 1;i<10;i++){count[i] += count[i - 1];}

        //Assemble Output
        for(int i = n--;i>=0;i--){
            output[count[(arr[i]/exp)%10]--] = arr[i];
            count[(arr[i]/exp)%10]--;
        }

        for(int i = 0;i<n;i++){
            arr[i] = output[i];
            print(arr, n);
        }
    }

    static void radixSort(int arr[], int n){
        int maxNumber = getMax(arr, n);

        for (int exp = 1;maxNumber/exp > 0;exp *= 10){
            countSort(arr, n, exp);
        }
    }

    static void print(int arr[], int n){
        for(int i = 0;i < n;i++){
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);

        int len = scan.nextInt();
        //Temporalily store numbers as string
        String[] tempArr = scan.nextLine().split(" ");
        //Place converted numbers into integer array
        int[] numArr = new int[len];
        for (int i = 0; i < len; i++) {
            int num = Integer.parseInt(tempArr[i].trim());
            numArr[i] = num;
        }

        radixSort(numArr, len);
        print(numArr, len);


    }

}

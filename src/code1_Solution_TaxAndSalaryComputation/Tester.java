package code1_Solution_TaxAndSalaryComputation;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

class Utility {

    public static float computeNetSalary(Integer basicSalary,Integer transportAllowance,Integer houseAllowance){
        int grossSalary = basicSalary + transportAllowance + houseAllowance;
        float taxPercentage = 0;
        if (grossSalary > 2000) {
            taxPercentage = 0.2f;
        }else{
            taxPercentage = 0.05f;
        }
        float netSalary = grossSalary - (grossSalary * taxPercentage);
        return(netSalary);
    }

}

class Tester {

    private static Scanner in;

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        String inputData = "101,102,50";
        List<Integer> inputValues = Arrays.stream(inputData.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(Utility.computeNetSalary(inputValues.get(0), inputValues.get(1), inputValues.get(2)));
//        in.close();
    }

}
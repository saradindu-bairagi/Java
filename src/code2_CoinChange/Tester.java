//Given the number of available $5 coins, X, the number of available $1 coins, Y and the amount Z,
// write a java program to print the minimum number of $5 and $1 coins needed to provide exact change.
// Print “NP” if exact change cannot be made.

//Constraints:
//-1 < X <= 100

//-1 < Y <= 100
//-1 < Z <= 600
//Input Format:
//First line contains X,Y,Z
//Output Format:
//number of $1 coins and number of $5 coins separated by ‘and’
//Sample Input & Output:
//Input: 4,12,21
//Output: 1 and 4
//Input X = 3,3,19
//Output: NP

package code2_CoinChange;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Utility {
    public static String findCoinsNeeded(int onesAvailable, int fivesAvailable, int amountNeeded) {
        //set the initial value of return as NP
        String returnValue = "NP";
        // Find out the maximum number of $5 coins that is needed
        int fivesNeeded = amountNeeded / 5;
        // if required number of $5 coins are not available, use the available $coins
        if (fivesNeeded >= fivesAvailable) {
            fivesNeeded = fivesAvailable;
        }
        //Find out the remaining number of $1 coin needed
        int onesNeeded = amountNeeded - (fivesNeeded * 5);
        // if required number of $1 coins are not available , use the available number
        // and construct the return string
        if (onesNeeded <= onesAvailable) {
            returnValue = onesNeeded+" and "+ fivesNeeded;
        }
        return returnValue;
    }
}

class Tester {

    public static void main(String[] args) {
        //Multi-line input
// 		Scanner in = new Scanner(System.in);
// 		int fivesAvailable = in.nextInt();
// 		int onesAvailable = in.nextInt();
// 		int amountNeeded = in.nextInt();
// 		String returnValue = CoinUtility.findCoinsNeeded(onesAvailable, fivesAvailable, amountNeeded);
// 		System.out.println(returnValue);

        //Single line input
        Scanner in = new Scanner(System.in);
        String inputString = in.nextLine();
        List<String> inputData = Arrays.stream(inputString.split(",")).collect(Collectors.toList());
        int fivesAvailable = Integer.parseInt(inputData.get(0));
        int onesAvailable =Integer.parseInt(inputData.get(1));
        int amountNeeded = Integer.parseInt(inputData.get(2));
        String returnValue = Utility.findCoinsNeeded(onesAvailable, fivesAvailable, amountNeeded);
        System.out.println(returnValue);
    }
}

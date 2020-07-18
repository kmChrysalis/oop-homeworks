package tasks;

import java.util.HashMap;

public class Tasks {
    private final int[][] dependenciesArray;

    public Tasks(int num) { //tasks constructor
        dependenciesArray = new int[num][num]; //create new 2d array
    }

    public boolean dependsOn(int task1, int task2) {
        if (task1 < dependenciesArray.length && task1 > -1 && //check if task1 is legal
                task2 < dependenciesArray.length && task2 > -1 && //check if task2 is legal
                task1 != task2 && //but not equals
         dependenciesArray[task1][task2] != 1) //check if not already filled and task2 not dependsOn task1
        {
            dependenciesArray[task1][task2] = 1;
        }
        return false; //return false in any other way
    }

    public int[] order() {
        int[] out = new int [dependenciesArray.length]; //array for output
        int k = 0, flag; //k index for out

        for (int i = 0; i < dependenciesArray.length; i++) {
            for (int j = 0; j < dependenciesArray[i].length; j++) {
                if (dependenciesArray[i][j] == 1 && checkCycle(i , i, j, false)) {
                    return out;
                }
            }
        }

        for (int i = 0; i < dependenciesArray.length; i++) { //filling first tasks without depends
            flag = 0; //set flag to 0
            for (int j = 0; j < dependenciesArray[i].length; j++) {
                if (dependenciesArray[i][j] == 0) {
                    flag++; //count flags
                }
            }
            if (flag == dependenciesArray.length) {
                out[k++] = i; //fill output with any task that have no depends
            }
        }

        for (int i = 0; i < dependenciesArray.length; i++) { //fill with all tasks that have depends
            if (k < out.length && out[i] != 0) { //fill for each task that already in out array
                for (int j = 0; j < dependenciesArray[i].length; j++) {
                    if (dependenciesArray[j][out[i]] == 1) {
                        out[k++] = j; //search for tasks that depends on out[j] task
                    }
                }
            }
        }
       
        return out; //return output array
    }

    private boolean checkCycle(int cycleVariable, int task1, int task2, boolean isCycle) {
        if (dependenciesArray[task1][cycleVariable] == 1) {
            isCycle = true;
        }
        else if (dependenciesArray[task1][task2] == 1) {
            for (int i = 0; i < dependenciesArray[task2].length; i++) {
                isCycle |= checkCycle(cycleVariable, task2, i, isCycle);
            }
        }
        return isCycle;
    }

}
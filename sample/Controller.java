package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.abs;

/*
            Brief guide:
            To create an array, first type a number into the 'size of your array' text box, then select one of the four
            available types. Once you click the 'Create' button, an array of the specified size and type will be created
            and assigned to MainArray.

            Then, go to the 'Test' section. clicking the 'Run Tests' button will run MainArray through all 4 sorting
            algorithms, recording the amount of changes (ie any use of '=') and comparisons (any use of a comparison operator).
            A swap will be recorded as three changes, since you need to change 3 variables to swap 2 numbers.

            Once the labels are filled with values, you can press the 'Record Results' button to save your results to a
            ListView in the 'Recent Results' tab.

            From there you can preview your results by clicking on any element of the list, and the appropriate labels
            will fill up to show the full results of your test.

            If you wish to save those results, type a file name in the text box below the 'Save to file' button, which will
            print your results into that file. There is no need to add ".txt" to the end. It will not empty your ListView.
            Load From File works intuitively, and does not clear the file.

            Neither Save nor load will append to the file/list
 */

public class Controller {
    public Label LearningTag;
    public int[] MainArray; //This will serve as the array being tested, and will not be altered after each algorithm is finished
    public int Arraytype = 0;
    public int Currenttype; //Currenttype should accurately reflect the contents of MainArray at any given moment
    public Label PreviewTag;
    public TextField SizeField;
    public Label ChangesLabelBubble;
    public Label ComparesLabelBubble;
    public Label ChangesLabelInsertion;
    public Label ComparisionsLabelInsertion;
    public Label ChangesLabelQuick;
    public Label ComparisionsLabelQuick;
    public Label ChangesLabelMerge;
    public Label ComparisionsLabelMerge;
    public ListView List;
    public Label BCh; //B = bubble, I = insert, M = merge, Q = quicksort, Ch = changes, Co = compares
    public Label ICh;
    public Label QCh;
    public Label MCh;
    public Label BCo;
    public Label ICo;
    public Label QCo;
    public Label MCo;
    public TextField FileNameField;
    public TextField FileNameFieldRead;


    public void LearnSortingAlgorithms(ActionEvent actionEvent) {
        LearningTag.setText("A sorting algorithm is an algorithm that puts an unordered array, usually of numbers, into an order, " +
                "\n usually ascending. for example, a sorting algorithm would turn the array\n 3, 2, 4, 1, 5 \n into \n1, 2, 3, 4, 5");

    }

    public void LearnBubble(ActionEvent actionEvent) {
        LearningTag.setText("Bubble sort is a simple yet inefficient algorithm, in which you go through the array, " +
                "\n comparing pairs. If the pairs are out of order, swap them." +
                "\n After you have gone through the entire array, check if it is sorted. If it is not, rinse and repeat." +
                "\n For example, to solve \n3, 2, 1\n bubble sort would first compare 3 and 2, swapping them to make " +
                "\n2, 3, 1\n then it would compare 3 and 1, swapping them to make \n2, 1, 3\n It would then check if the array is sorted, which it isn't, and start over.\n it would compare 2 and 1, which would be out of order, swapping them to make \n1, 2, 3\n It would then check 2 and 3, which are in order, so it would not switch them. The array is now sorted.");
    }

    public void LearnInsertion(ActionEvent actionEvent) {
        LearningTag.setText("Insertion sort is an algorithm that builds a sorted array by inserting one element at a time, starting from the left.\n" +
                "2, 8, 4, 3, 9\n" +
                "we will start with the very first element, 2. Obviously, an array of size one is guaranteed to be sorted.\n" +
                "2,] 8, 4, 3, 9\n" +
                "we will then integrate 8. Since it is higher than 2, it is already in order. Assume that everything to the left of the\n" +
                " ']' is sorted.\n" +
                "2, 8,] 4, 3, 9\n" +
                "we will then have to integrate the 4, which goes in between the 2 and the 8.\n" +
                "2, 4, 8,] 3, 9\n" +
                "and then the three.\n" +
                "2, 3, 4, 8,] 9\n" +
                "2, 3, 4, 8, 9]\n" +
                "The array is now sorted.\n");
    }

    public void LearnMerge(ActionEvent actionEvent) {
        LearningTag.setText("Merge Sort is a recursive algorithm, meaning that a Merge sort function will usually call itself inside the function.\n" +
                "Merge sort splits the array up into subarray and gradually merges them so they are in order.\n" +
                "5, 8, 2, 3, 4, 1, 7, 6\n" +
                "5, 8, 2, 3,| 4, 1, 7, 6\n" +
                "5, 8,| 2, 3,| 4, 1,| 7, 6\n" +
                "5,| 8,| 2,| 3,| 4,| 1,| 7,| 6\n" +
                "5, 8,| 2, 3,| 1, 4,| 6, 7\n" +
                "2, 3, 5, 8,| 1, 4, 6, 7\n" +
                "1, 2, 3, 4, 5, 6, 7, 8\n" +
                "The process of merging 2 subarrays is quite simple. Create a new array, put a counter at the beginning of each\n" +
                "subarray, and repeatedly take the smaller element, moving up each counter, and put it into the new array.\n" +
                "Note that both subarrays must be sorted for the merge to work"
                );

    }

    public void LearnBogo(ActionEvent actionEvent) {
        LearningTag.setText("Bogo sort is an impractical algorithm in which the elements are repeatedly randomized\n " +
                "and checked until they are in order.\n" +
                "On average, this algorithm takes n! time to complete. However, since it can theoretically sort\n" +
                "any array on its first try, it is technically speaking the fastest sorting algorithm in the best case.");
    }

    public void LearnQuicksort(ActionEvent actionEvent) {
        LearningTag.setText("Quicksort is another recursive algorithm, similar to Merge sort.\n" +
                "To do Quicksort, first select an element to be the 'Pivot'. It can be any element you wish, but I prefer to \n" +
                "use the first element. Then, restructure the array so that all the elements that are less than the pivot are to the\n" +
                "left of the pivot, and all elements greater are to the right. Repeat for the arrays on either side of the pivot.\n" +
                "[5], 8, 4, 7, 3, 1, 2, 6\n" +
                "use 5 as the pivot\n" +
                "[2, 4, 3, 1] [5] [7, 8, 6]\n" +
                "notice now that the left and right subarrays are of numbers less than five and of numbers greater than five\n" +
                "[1, [2] 3, 4] [5] [6, [7] 8])\n" +
                "This is commonly believed to be the most efficient sorting algorithm.");
    }

    public void Random(ActionEvent actionEvent) {

        PreviewTag.setText("6, 4, 3, 1, 7, 5, 2, 10, 8, 9");
        Arraytype = 1;
    }

    public void Descending(ActionEvent actionEvent) {
        PreviewTag.setText("10, 9, 8, 7, 6, 5, 4, 3, 2, 1");
        Arraytype = 2;
    }

    public void Narrowing(ActionEvent actionEvent) {
        PreviewTag.setText("10, 1, 9, 2, 8, 3, 7, 4, 6, 5");
        Arraytype = 3;

    }

    public void Expanding(ActionEvent actionEvent) {
        PreviewTag.setText("5, 6, 4, 7, 3, 8, 2, 9, 1");
        Arraytype = 4;
    }

    public void Create(ActionEvent actionEvent) {
        int size = Integer.parseInt(SizeField.getText());
        MainArray = new int[size];
        //Array.clear();
        switch (Arraytype) {
            case 0:
                break;
            case 1:
                Random rand = new Random(System.currentTimeMillis());
                for (int i = 0; i < size; i++) {
                    MainArray[i] = (abs(rand.nextInt() % size));
                }
                Currenttype = 1;
                break;
            case 2:
                for (int i = 0; i < size; i++) {
                    MainArray[i] = (size - i);
                }
                Currenttype = 2;
                break;
            case 3:

                for (int i = 0; i < size; i++) {
                    if (i % 2 == 0) {
                        MainArray[i] = (size - (i / 2));
                    } else {
                        MainArray[i] = ((i - 1) / 2 + 1);
                    }
                }
                Currenttype = 3;

                break;
            case 4:
                for (int i = 0; i < size; i++) {
                    if (i % 2 == 0) {
                        MainArray[i] = ((size - i) / 2);
                    } else {
                        if (size % 2 == 0) {
                            MainArray[i] = (((size + i) / 2 + 1));
                        } else {
                            MainArray[i] = ((size + i) / 2);
                        }
                    }
                }
                Currenttype = 4;
                break;
        }
        for (int i = 0; i < MainArray.length; i++) {
            System.out.println(MainArray[i]);
        }
    }

    public void BubbleSort() {
        int changes = 0;
        int compares = 0;
        int[] newArray = new int[MainArray.length];
        System.arraycopy(MainArray, 0, newArray, 0, MainArray.length);

        boolean sorted = false;
        int temp;
        while (!sorted) { //needs to repeat this process until the array has been found to be sorted
            sorted = true;
            for (int i = 0; i < (newArray.length) - 1; i++) {
                compares++;
                if (newArray[i] > newArray[i + 1]) { //checks if the 2 elements are out of order and swaps them if they are
                    temp = newArray[i];
                    newArray[i] = newArray[i + 1];
                    newArray[i + 1] = temp;
                    changes += 3;
                    sorted = false;
                }
            }
//            sorted = true;
//            for (int i = 0; i < newArray.length - 1 && sorted; i++) { //checking if the array is in order
//                compares++;
//                if (newArray[i] > newArray[i + 1]) {
//                    sorted = false;
//                }
//            }
        }

        ChangesLabelBubble.setText(String.valueOf(changes));
        ComparesLabelBubble.setText(String.valueOf(compares));
    }


    public void InsertionSort() {
        int changes = 0;
        int compares = 0;
        int location = 0;
        int temp;
        int[] newArray = new int[MainArray.length];
        System.arraycopy(MainArray, 0, newArray, 0, MainArray.length);

        for (int i = 1; i < newArray.length; i++) {
            compares++;
            for (int ii = 0; newArray[ii] < newArray[i]; ii++) { //find the position where the next element is to be inserted
                compares++;
                location++;
            }
            changes++;
            temp = newArray[i];

            for (int ii = i; ii > location; ii--) {//inserts that number into the slot
                newArray[ii] = newArray[ii - 1];
                changes++;
            }
            newArray[location] = temp;
            changes++;
            location = 0;
        }
        ChangesLabelInsertion.setText(String.valueOf(changes));
        ComparisionsLabelInsertion.setText(String.valueOf(compares));

/*        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }*/ //use this to print the array after the algorithm is complete



    } //incomplete recording of comparisions and checks

    public void Quicksort()  {//this is a main function that exists only to call the recursive function and change the labels
        int[] Backup = new int[MainArray.length];
        System.arraycopy(MainArray, 0, Backup, 0, MainArray.length);
        int[] results;
        results = Quicksorta(0, MainArray.length - 1);
        System.out.println("\n\n\nCompleted Array:\n");

        ChangesLabelQuick.setText(String.valueOf(results[1]));
        ComparisionsLabelQuick.setText(String.valueOf(results[0]));


        /*for (int ii = 0; ii < MainArray.length; ii++) {
            System.out.println(MainArray[ii]);
        }*/
        System.arraycopy(Backup, 0, MainArray, 0, MainArray.length);
    }

    public int[] Quicksorta(int start, int end) //the array will have its first elements be compares and second be changes
    {
        int compares = 0;
        int changes = 0;
        int i = start;
        for (int j = start + 1; j <= end; j++) { //iterates through array
            compares++;
            if (MainArray[j] < MainArray[start])//checks if j is less than the pivot
            {
                i++;
                int a = MainArray[i];
                MainArray[i] = MainArray[j]; //moves i up and swaps it with j
                MainArray[j] = a;
                changes += 3;
            }
        }

        int a = MainArray[start];
        MainArray[start] = MainArray[i]; //switches i and pivot
        MainArray[i] = a;
        changes += 3;


        int[] x = new int[2];
        int[] y = new int[2];
        int[] z = new int[2];
        if (i - start > 1) { //to ensure that the first half is larger than 1, otherwise it won't work

            x = Quicksorta(start, i - 1);
        }

        if (end - i > 1) {
            y = Quicksorta(i + 1, end);
        }

        z[0] = compares + x[0] + y[0];
        z[1] = changes + x[1] + y[1];


        return z;
    }


    public int[] Merge(int s1, int e1, int s2, int e2)//s1>e1>s2>e2 , s1 e1 are start and end of first section by index, s2 e2 for second section
    {
        //e1 and e2 are exclusive, if e1 is n, then the section goes from s1 to n-1
        int[] z = {0, 0}; //first element is changes, second is comparisons

        int i1 = 0; //iterators for the first and second sections respectively, relative to the start (s1 and s2)
        int i2 = 0;
        int[] temparray = new int[e2-s1]; //Merge sort isn't in place
        while((i1 != e1-s1) && (i2 != e2 - s2))//keep iterating until end of either section is reached
        {
            z[1]++; //a comparision and change are both guaranteed to happen
            z[0]++;
            if(MainArray[i1+s1] < MainArray[i2+s2])
            {
                temparray[i1+i2] = MainArray[i1+s1];
                i1++;
            }
            else
            {
                temparray[i1+i2] = MainArray[i2+s2];
                i2++;
            }
        }
        z[1]++;
        if(i1 == e1-s1) //if the first iterator reached the end of its section, print the rest of the section into the temparray
        {
            for(int i = s2+i2; i < e2; i++)
            {
                temparray[i1+i2] = MainArray[s2+i2];
                i2++;
                z[0]++;
            }
        }
        else
        {
            for(int i = s1+i1; i < e1; i ++)
            {
                temparray[i1+i2] = MainArray[s1+i1];
                i1++;
                z[0]++;
            }
        }
        for(int i = 0; i < temparray.length; i++)
        {
            MainArray[s1+i] = temparray[i];
            z[0]++;
        }
        return z;
    }
    public int[] MergeSort(int start, int end) //both start and end should be inclusive. 4, 7, would be 4, 5, 6, 7
    {
        int[] x = {0, 0};
        int[] y = {0, 0};
        int[] z = {0, 0};
        if(end==start) { //cannot merge a segment of length 1
            return z;
        }
        int half = (end - start) / 2 + start;

        x = MergeSort(start, half);
        y = MergeSort(half + 1, end);
        z = Merge(start, half+1, half+1, end+1);
        int[] a = {0, 0};
        a[0] = x[0] + y[0] + z[0];
        a[1] = x[1] + y[1] + z[1]; //accumulates previous changes and comparisons alongside those of subarrays
        return a;
    }

    public void MergeSortMain() {

        int[] Backup = new int[MainArray.length];
        System.arraycopy(MainArray, 0, Backup, 0, MainArray.length);
        int[] x = MergeSort(0, MainArray.length-1);
        ChangesLabelMerge.setText(String.valueOf(x[0]));
        ComparisionsLabelMerge.setText(String.valueOf(x[1]));
        System.out.println();
        for (int ii = 0; ii < MainArray.length; ii++) {
            System.out.println(MainArray[ii]);
        }
        System.arraycopy(Backup, 0, MainArray, 0, MainArray.length);
    }

    public void RunTests(ActionEvent actionEvent) {
        BubbleSort();
        InsertionSort();
        Quicksort();
        MergeSortMain();
    }

    public void Record(ActionEvent actionEvent) throws IOException {

        List.getItems().add(new Result(Currenttype, MainArray.length,Integer.parseInt(ChangesLabelBubble.getText()), Integer.parseInt(ComparesLabelBubble.getText()), Integer.parseInt(ChangesLabelInsertion.getText()), Integer.parseInt(ComparisionsLabelInsertion.getText()), Integer.parseInt(ChangesLabelQuick.getText()), Integer.parseInt(ComparisionsLabelQuick.getText()), Integer.parseInt(ChangesLabelMerge.getText()), Integer.parseInt(ComparisionsLabelMerge.getText())));
        ChangesLabelBubble.setText("--");
        ComparesLabelBubble.setText("--");
        ChangesLabelInsertion.setText("--");
        ComparisionsLabelInsertion.setText("--");
        ChangesLabelQuick.setText("--");
        ComparisionsLabelQuick.setText("--");
        ChangesLabelMerge.setText("--");
        ComparisionsLabelMerge.setText("--");
    }

    public void ViewResult(MouseEvent mouseEvent) {
//        System.out.println(List.getItems().get((List.getSelectionModel().getSelectedIndex())));
        Result r = (Result) List.getItems().get((List.getSelectionModel().getSelectedIndex()));
        BCh.setText(String.valueOf(r.getChangesBubble()));
        BCo.setText(String.valueOf(r.getComparesBubble()));
        ICh.setText(String.valueOf(r.getChangesInsertion()));
        ICo.setText(String.valueOf(r.getComparesInsertion()));
        QCh.setText(String.valueOf(r.getChangesQuick()));
        QCo.setText(String.valueOf(r.getComparesQuick()));
        MCh.setText(String.valueOf(r.getChangesMerge()));
        MCo.setText(String.valueOf(r.getComparesMerge()));
    }

    public void SaveToFile(ActionEvent actionEvent)throws IOException {
        FileWriter fw = new FileWriter(FileNameField.getText() + ".txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for(int i = 0; i < List.getItems().size(); i++)
        {
            System.out.println("entered");
            Result r = (Result)List.getItems().get(i);
            bw.write(String.valueOf(r.getType()) + "\r"); //curiously, Java says the String.valueOf call wasn't necessary, yet it didn't function until I used it.
            bw.write(String.valueOf(r.getSize())+"\r"); //also, my most sincere apologies if there was a better way of printing the data from r.
            bw.write(String.valueOf(r.getChangesBubble())+"\r");
            bw.write(String.valueOf(r.getComparesBubble())+"\r");
            bw.write(String.valueOf(r.getChangesInsertion())+"\r");
            bw.write(String.valueOf(r.getComparesInsertion())+"\r");
            bw.write(String.valueOf(r.getChangesQuick())+"\r");
            bw.write(String.valueOf(r.getComparesQuick())+"\r");
            bw.write(String.valueOf(r.getChangesMerge())+"\r");
            bw.write(String.valueOf(r.getComparesMerge())+"\r");
        }

        bw.close();
    }

    public void ReadFromFile(ActionEvent actionEvent) throws IOException {
        List.getItems().clear();
        FileReader fr = new FileReader(FileNameFieldRead.getText() + ".txt");
        BufferedReader br = new BufferedReader(fr);
        String[] strarray = new String[10];
        while((strarray[0] = br.readLine()) != null)
        {
            for(int i = 0; i < 9 ; i++)
            {
                if((strarray[i+1] = br.readLine()) == null)
                {
                    break;
                }
            }
            //sorry about the 10 argument constructor
            List.getItems().add(new Result(Integer.parseInt(strarray[0]),Integer.parseInt(strarray[1]), Integer.parseInt(strarray[2]), Integer.parseInt(strarray[3]), Integer.parseInt(strarray[4]), Integer.parseInt(strarray[5]), Integer.parseInt(strarray[6]), Integer.parseInt(strarray[7]),Integer.parseInt(strarray[8]), Integer.parseInt(strarray[9])));
        }

    }

}
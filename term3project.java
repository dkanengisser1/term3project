import java.io.*;

public class term3project {
    private Account[] arrayOfAccounts = new Account[100];
    private String[][] friendList = new String[100][];
    private int length;
    private int found = 0;

    public term3project() {
        this.length = 0;
    }

    public void addToArray(String name) {
        Account temp = new Account(name);
        this.arrayOfAccounts[this.length] = temp;
        this.length++;
    }

    public void addFollowingToAccount() {
        int i = 0;
        Account temp = this.arrayOfAccounts[i];
        while (temp != null) {
            int j = 0;
            while (this.friendList[i][j] != null) {
                Account placeholder = this.getAccount(this.friendList[i][j]);
                temp.addFollowing(placeholder);
                placeholder.addFollower(temp);
                j++;

            }
            i++;
            temp = this.arrayOfAccounts[i];
        }
    }

    public void addFollowerstoAccount(Account follower, Account mainAccount) {
        mainAccount.addFollower(follower);
    }

    public Account getAccount(String name) {
        int i = 0;
        this.found = 0;
        Account temp = this.arrayOfAccounts[i];
        while (temp != null) {
            String temporary = temp.getName().trim();
            String temporary2 = name.trim();
            if (temporary.equalsIgnoreCase(temporary2)) {
                this.found = 1;
                return temp;
            }
            i++;
            temp = this.arrayOfAccounts[i];
        }
        return null;
    }

    public void printAccount() {
        int i = 0;
        Account temp = this.arrayOfAccounts[i];
        while (temp != null) {
            System.out.println(temp.getName());
            System.out.println(temp.getNumberOfFollowing());
            System.out.println(temp.getNumberOfFollowers());
            i++;
            temp = this.arrayOfAccounts[i];
        }
    }

    public void addToFriendList(String[] list) {
        int i = 0;
        while (this.friendList[i] != null) {
            i++;
        }
        this.friendList[i] = list;
    }

    public float task1() {
        /* return value = all followers divdied by number of accounts */

        float totalNumberOfFollowers = 0;
        int i = 0;
        Account temp = this.arrayOfAccounts[i];
        while (temp != null) {
            totalNumberOfFollowers += temp.getNumberOfFollowers();
            i++;
            temp = this.arrayOfAccounts[i];
        }
        float divider = this.length * (this.length - 1);
        float returnValue = totalNumberOfFollowers / divider;
        return returnValue;
    }

    public String task2() {
        Account highestNumberOfFollowers = this.arrayOfAccounts[0];
        int highestNumber = 0;
        int i = 0;
        Account temp = this.arrayOfAccounts[i];
        while (temp != null) {
            if (temp.getNumberOfFollowers() > highestNumber) {
                highestNumberOfFollowers = temp;
                highestNumber = temp.getNumberOfFollowers();
            } else if (temp.getNumberOfFollowers() == highestNumber) {
            if (highestNumberOfFollowers.getName().trim().compareToIgnoreCase(temp.getName().trim()) >= 1) {
                highestNumberOfFollowers = temp;
                highestNumber = temp.getNumberOfFollowers();
            }
        }
            i++;
            temp = this.arrayOfAccounts[i];
        }
        return highestNumberOfFollowers.getName();
    }

    public String task3() {
        Account highestNumberOfFollowing = this.arrayOfAccounts[0];
        int highestNumber = 0;
        int i = 0;
        Account temp = this.arrayOfAccounts[i];
        while (temp != null) {
            if (temp.getNumberOfFollowing() > highestNumber) {
                highestNumberOfFollowing = temp;
                highestNumber = temp.getNumberOfFollowing();
            } else if (temp.getNumberOfFollowing() == highestNumber) {
                if (highestNumberOfFollowing.getName().trim().compareToIgnoreCase(temp.getName().trim()) >= 1) {
                    highestNumberOfFollowing = temp;
                    highestNumber = temp.getNumberOfFollowing();
                }
            }
            i++;
            temp = this.arrayOfAccounts[i];
        }
        return highestNumberOfFollowing.getName();
    }

    public int task4() {
        String[] listOfFofF = new String[this.length];
        Account shorter = this.arrayOfAccounts[0];
        for (int i = 0; i < shorter.getNumberOfFollowers(); i++) {
            for (int j = 0; j < shorter.getFollower(i).getNumberOfFollowers(); j++) {
                if (this.checkInList(listOfFofF, shorter.getFollower(i).getFollower(j)) == false
                        && this.checkinfollower(shorter.getFollower(i).getFollower(j)) == false) {
                    int k = 0;
                    while (listOfFofF[k] != null) {
                        k++;
                    }
                    listOfFofF[k] = shorter.getFollower(i).getFollower(j).getName();
                }
            }
        }
        int x = 0;
        int returnValue = 0;
        while (listOfFofF[x] != null) {
            returnValue++;
            x++;
        }
        return returnValue;
    }

    public boolean checkinfollower(Account check) {
        for (int i = 0; i < this.arrayOfAccounts[0].getNumberOfFollowers(); i++) {
            if (check == this.arrayOfAccounts[0].getFollower(i)) {
                return true;
            } else if (check == this.arrayOfAccounts[0]) {
                return true;
            }
        }
        return false;
    }

    public boolean checkInList(String[] list, Account check) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == check.getName()) {
                return true;
            }
        }
        return false;
    }

    public int task5() {
        int i = 0;
        int[] listOfFollowers = new int[this.length];
        Account temp = this.arrayOfAccounts[i];
        while (temp != null) {
            listOfFollowers[i] = temp.getNumberOfFollowers();
            i++;
            temp = this.arrayOfAccounts[i];
        }

        int[] sortedArray = insertSort(listOfFollowers);
        int average = 0;
        if (sortedArray.length % 2 == 0) {
            average = (sortedArray[sortedArray.length / 2] + sortedArray[(sortedArray.length / 2) - 1]) / 2;
        } else {
            average = sortedArray[length / 2];
        }
        return average;

    }

    public int[] insertSort(int[] sortArray) {
        for (int i = 1; i < sortArray.length; i++) {

            int compare = sortArray[i];
            int j = i - 1;
            while (j >= 0 && sortArray[j] > compare) {
                sortArray[j + 1] = sortArray[j];
                j = j - 1;
            }
            sortArray[j + 1] = compare;
        }
        ;
        return sortArray;
    }
    public String task6(){
        int highestNumber=0;
        String highestAccount="";
        int i=0;
        Account temp=this.arrayOfAccounts[i];
        while(temp!=null){
            Account [] listOfProp=new Account[100];
            for (int j=0;j<temp.getNumberOfFollowers();j++){
                Account newTemp=temp.getFollower(j);
                if (this.checkForRepeat(listOfProp,this.getLengthOfArrayAccount(listOfProp),newTemp)==false && this.checkForRepeat(listOfProp, this.getLengthOfArrayAccount(listOfProp), temp)==false){
                    listOfProp[this.getLengthOfArrayAccount(listOfProp)]=newTemp;
                }
                for (int k=0;k<newTemp.getNumberOfFollowers();k++){
                    if (this.checkForRepeat(listOfProp,this.getLengthOfArrayAccount(listOfProp),newTemp.getFollower(k))==false&& this.checkForRepeat(listOfProp, this.getLengthOfArrayAccount(listOfProp), temp)==false){
                        listOfProp[this.getLengthOfArrayAccount(listOfProp)]=newTemp.getFollower(k);
                    }
            }
        }


            if (this.getLengthOfArrayAccount(listOfProp)>highestNumber){
                highestNumber=this.getLengthOfArrayAccount(listOfProp);
                highestAccount=temp.getName().trim();
            }
            else if(this.getLengthOfArrayAccount(listOfProp)==highestNumber){
                if (highestAccount.compareTo(temp.getName().trim())>=1){
                    highestNumber=this.getLengthOfArrayAccount(listOfProp);
                    highestAccount=temp.getName().trim();
                }
            }
            i++;
            temp=this.arrayOfAccounts[i];
        }
        return highestAccount;
    }
    public int getLengthOfArrayAccount(Account[] list){
        int i=0;
        int count=0;
        while(list[i]!=null){
            count++;
            i++;
        }
        return count;
    }
    public Account[] addToList(Account[] list,Account input,int position){
        for(int i=0;i<input.getNumberOfFollowers();i++){
            if (this.checkForRepeat(list,position,input.getFollower(i))==false){}
            list[position]=input.getFollower(i);
            list=this.addToList(list,input.getFollower(i),position+1);
            position=0;
            while(list[position]!=null){
                position++;
            }
        }
        return list;
    }
    public boolean checkForRepeat(Account[] list,int length,Account check){
        for(int i=0;i<length;i++){
            if(check==list[i]){
                return true;
            }
        }
        return false;
    } 

    public static void main(String[] args) {
        try {
            term3project main = new term3project();

            FileInputStream inputFile = new FileInputStream(args[0]);
            InputStreamReader file = new InputStreamReader(inputFile);
            int i;
            int x = 0;
            int checkline = -1;
            char[] placeholder = new char[10000];
            String[] list = new String[10000];
            while ((i = file.read()) != -1) {
                char r = (char) i;
                if (i == 32) {
                    String text = String.valueOf(placeholder);
                    if (checkline == -1) {

                        main.addToArray(text);
                    } else {
                        list[checkline] = text;
                    }
                    checkline++;
                    placeholder = new char[10000];
                } else if (i == 10) {

                    String text = String.valueOf(placeholder);
                    if (checkline == -1) {
                        main.addToArray(text);
                    }

                    else if (checkline != -1) {
                        list[checkline] = text;

                    }
                    main.addToFriendList(list);
                    checkline = -1;
                    placeholder = new char[10000];
                    list = new String[10000];
                } else {
                    placeholder[x] = r;
                    x++;
                }

            }
            ;

            file.close();
            inputFile.close();
            main.addFollowingToAccount();
            System.out.println("Task 1: " + main.task1());
            System.out.println("Task 2: " + main.task2());
            System.out.println("Task 3: " + main.task3());
            System.out.println("Task 4: " + main.task4());
            System.out.println("Task 5: " + main.task5());
            System.out.println("Task 6: " + main.task6());
        } catch (FileNotFoundException fnfe) {
            System.out.println("NO Such File Exists");
        } catch (IOException except) {
            System.out.println("IOException occurred");
        }

    }
}
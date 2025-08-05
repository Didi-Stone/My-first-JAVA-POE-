
package com.mycompany.finalpoe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author ST10231469 
 */

public class Methods{
   

  public static boolean correctIntValue(String input){ 
    //This to ensure that only numeric value can pass through the loop
    String requirements  = "[0-9]";
    Pattern pt = Pattern.compile(requirements);
    Matcher mt = pt.matcher(input);
    if (input == null){
        JOptionPane.showMessageDialog(null,"Please enter a numeric value", "Incorrect",0);        
      return false;}
return mt.matches();
}   
    public static boolean checkIntValue(JTextField input){ 
    //This to ensure that only numeric value can pass through the loop
    String requirements  = "[0-9]";
    Pattern pt = Pattern.compile(requirements);
    Matcher mt = pt.matcher(input.getText());
    if (input.getText() == null){
        JOptionPane.showMessageDialog(null,"Please enter a numeric value", "Incorrect",0);        
    return false;
    }
return mt.matches();
}
   public static boolean checkDescription(JTextField input){
    //This method makes sure that the description task is no more than 50 characters
    int testLength;
    testLength = input.getText().length();
    boolean lengthTrueOrFalse ;
 
    if (testLength > 50){
        JOptionPane.showMessageDialog(null,"Please enter a task description with less than 50 characters", "Incorrect",0);        
        lengthTrueOrFalse = false;
    }else {
        lengthTrueOrFalse = true;
    }
return lengthTrueOrFalse;
}   
   public static String taskId(String taskName, int tasknumber, String devName){
    //This method is for Task ID this will take the first two letters of the task Name and task number and the last last three letters of the developer in the following way
    String taskID;
    String theFirstTwo = taskName.substring(0,2);
    String theLastThree = devName.substring(devName.length()- 3);
    taskID = theFirstTwo.toUpperCase()+":"+tasknumber+":"+theLastThree.toUpperCase();
    JOptionPane.showMessageDialog(null,"This is the taskID: "+taskID,"TaskID",1);    
return taskID;
}
   public static String printTaskDetails(String status,int taskNumber,String TaskName, String taskDescription, String ID, int estimateDuration,int count,int addnumofTasks){
    //This method will display to the user the details of the task they entered
    String printTaskDetails ="";
    String numTaskNumber = String.valueOf(taskNumber);
    String estimate = String.valueOf(estimateDuration);
    JOptionPane.showMessageDialog(null,"Task Status: "+status+"\n"+"Task number: "+numTaskNumber+"\n"+"Task name: "+TaskName+"\n"+"Task Description: "+taskDescription+"\n"+"Task ID: "+ID+"\n"+"Duration: "+estimate+"hrs"+"\n","Task Details "+count+"/"+addnumofTasks,1);
return printTaskDetails;
}
   public static int returnTotalHours(int hour){
    JOptionPane.showMessageDialog(null,"This is the total hours for all your tasks "+hour,"Total Hours",1);    
return hour;
}
   public static void longestTaskDuration(){

    if(null == FinalPOE.hoursForTasks){//This checks the public array in the FinalPOE class for the longest task and if the array is empty it will display the following JOptionPane
        JOptionPane.showMessageDialog(null, "There are no avaliable tasks", "Empty Tasks", 1);
    }else{ 
   int longest = FinalPOE.hoursForTasks[0];
   int subScript = 0;        
    for(int i = 0; i < FinalPOE.hoursForTasks.length; i++){//The purpose of the this loop is to check if what the user input is actually in the array
         if(longest< FinalPOE.hoursForTasks[i]){
            longest=FinalPOE.hoursForTasks[i];
            subScript=i;    
            }
         
    } JOptionPane.showMessageDialog(null, "Developer Details: "+FinalPOE.developerDetails[subScript]
        + "\nTask Duration: "+longest+"hrs"
        ,"Task Longest Duration",1);    
  } 
}
   public static void displayTaskDone(){
    boolean foundStatus = false;
    if(null == FinalPOE.taskStatus){
        JOptionPane.showMessageDialog(null, "There are no avaliable tasks", "Empty Tasks", 1);
    }
    else{  
        for (String taskStatu : FinalPOE.taskStatus) {
            //The purpose of the this loop is to check if what the user input is actually in the array
            if (taskStatu.equals("Done")) {
                foundStatus = true;
                break; 
            }
        }
    if(foundStatus == true){
        for(int i = 0; i < FinalPOE.taskStatus.length; i++){
            if(FinalPOE.taskStatus[i].equals("Done")){
            JOptionPane.showMessageDialog(null,"Developer Details: "+FinalPOE.developerDetails[i]+
                "\nTask Name : "+FinalPOE.taskNames[i]+
                "\nTask Duration : "+FinalPOE.hoursForTasks[i]+"hrs"+
                "\nTask Status: "+FinalPOE.taskStatus[i],"Task Status",1);
            }
        }
    }
 if(foundStatus == false){
        JOptionPane.showMessageDialog(null, "There are no Tasks that are Done.","Task Status", 1);
    }    
   }           
}   
   public static void searchForTask(){
    String nameTask;
    boolean foundTask = false;
    if(null == FinalPOE.taskNames){
        JOptionPane.showMessageDialog(null, "There are no avaliable tasks", "Empty Tasks", 1);
    }
    else{  
    nameTask = JOptionPane.showInputDialog(null, "Please enter the name of Task you are searching for: ", "Task assigned to developer", 1);
        for (String taskName : FinalPOE.taskNames) {
            //The purpose of the this loop is to check if what the user input is actually in the array
            if (taskName.equalsIgnoreCase(nameTask)) {
                foundTask = true;
                break; 
            }
        }
    if(foundTask == true){
        for(int i = 0; i < FinalPOE.taskNames.length; i++){
            if(FinalPOE.taskNames[i].equalsIgnoreCase(nameTask)){
            JOptionPane.showMessageDialog(null,"Task Name : "+FinalPOE.taskNames[i]+
                "\nDeveloper Details : "+FinalPOE.developerDetails[i]+
                "\nTask Status: "+FinalPOE.taskStatus[i],"Developer Task",1);
            }
        }
    }
 if(foundTask == false){
        JOptionPane.showMessageDialog(null, "The task cannot be found, please try again","Task not found", 0);
    }    
   }           
}
   public static void developerTasks(){
    String devTask;
    boolean foundDev = false;
    if(null == FinalPOE.taskNames){//Checking to see if the array is empty
        JOptionPane.showMessageDialog(null, "There are no tasks avaliable.", "Empty Tasks", 1);
    }
    else{  
    devTask = JOptionPane.showInputDialog(null, "Please enter the full name of the developer: ", "Task assigned to developer", 1);
        for (String developerDetail : FinalPOE.developerDetails) {
            //The purpose of the this loop is to check if what the user input is actually in the array
            if (developerDetail.equalsIgnoreCase(devTask)) {
                foundDev = true;//it will then make the found variable true if it is in the array
                break; 
            }
        }
    if(foundDev == true){
        for(int i = 0; i < FinalPOE.developerDetails.length; i++){
           if(FinalPOE.developerDetails[i].equalsIgnoreCase(devTask)){
            JOptionPane.showMessageDialog(null,"Developer Details : "+FinalPOE.developerDetails[i]+
                "\nTask Name: "+FinalPOE.taskNames[i]+
                "\nTask Status: "+FinalPOE.taskStatus[i],"Developer Task",1);
           }
        }
    }  
    if(foundDev == false){
      JOptionPane.showMessageDialog(null, "The developer cannot be found, please try again","Developer not found", 0);
    } 
  }          
}
   public static void deleteTask(){
    if(null == FinalPOE.taskNames){//The purpose of this is to check if the arrays are empty to avoid errors
        JOptionPane.showMessageDialog(null, "There are no avaliable tasks", "Empty Tasks", 1);
    }else{
        String nameOfTask;
        //Make a new array that is one smaller
        boolean found = false;
        int indexLess = 0;
        String[]newTaskName;
        int[]newTaskNumber;
        String[]newTaskdescription;
        String[]newDeveloper;
        int[]newDuration;
        String[]newID;
        String[]newStatus;
        newID = new String[FinalPOE.taskIDs.length-1];//the arrays that will store all the elements of the array from the FinalPOE class will be subtract by one because the element will be removed
        newStatus = new String[FinalPOE.taskStatus.length-1];
        newDuration= new int[FinalPOE.hoursForTasks.length-1];
        newTaskName = new String[FinalPOE.taskNames.length-1];
        newTaskNumber = new int[FinalPOE.taskNumbers.length-1];
        newDeveloper= new String[FinalPOE.developerDetails.length-1];       
        newTaskdescription = new String[FinalPOE.taskDescriptions.length-1];
        nameOfTask = JOptionPane.showInputDialog(null, "Please write the name of the Task you want to delete.", "Delete a Task", 2);
        
        for (String taskName : FinalPOE.taskNames) {
            //The purpose of the this loop is to check if what the user input is actually in the array
            if (taskName.equalsIgnoreCase(nameOfTask)) {
                found = true;//it will then make the found variable true if it is in the array
                break; 
            }
        }
        if(found == true){//if found is true it will execute the code within
            for(int i = 0; i < FinalPOE.taskNames.length; i++){
                
                if(!FinalPOE.taskNames[i].equalsIgnoreCase(nameOfTask)){
                    newTaskName[indexLess] =FinalPOE.taskNames[i];//This array is being directly called from the FinalPOE method where the elements have been stored
                    newTaskNumber[indexLess] =FinalPOE.taskNumbers[i];
                    newTaskdescription[indexLess] =FinalPOE.taskDescriptions[i];
                    newDeveloper[indexLess] =FinalPOE.developerDetails[i];
                    newDuration[indexLess] =FinalPOE.hoursForTasks[i];
                    newID[indexLess] =FinalPOE.taskIDs[i];
                    newStatus[indexLess] =FinalPOE.taskStatus[i];
                    indexLess++;
                }
            }
        }
        if(found == false){//if what the user input isn't in the array then the found variable will remain false
            JOptionPane.showMessageDialog(null, "The Task name you have written can not be found, please try again", "Task not found", 0);
        }else{//otherwise if found is not false then the elements in the array except the ones that the user wants deleted will be stored back to the original array that was called
            JOptionPane.showMessageDialog(null, "The Task has been deleted", "Successfully Deleted", 1);
            FinalPOE.taskNames=newTaskName;//the new array will the store elements right back into the array that has been called from the FinalPOE class
            FinalPOE.taskNumbers=newTaskNumber;
            FinalPOE.taskDescriptions=newTaskdescription;
            FinalPOE.developerDetails=newDeveloper;
            FinalPOE.hoursForTasks=newDuration;
            FinalPOE.taskIDs=newID;
            FinalPOE.taskStatus=newStatus;
        }
    }
}  
   public static void displayTaskReport(){
    if(null == FinalPOE.taskNames){
        JOptionPane.showMessageDialog(null, "There are no avaliable Tasks", "Empty Tasks", 1);
    }
    else{    
       for(int i = 0; i < FinalPOE.taskNames.length; i++){      
        JOptionPane.showMessageDialog(null,"Task Name: "+FinalPOE.taskNames[i]+
            "\nTask number: "+FinalPOE.taskNumbers[i]+
            "\nTask Description: "+FinalPOE.taskDescriptions[i]+
            "\nDeveloper Details: "+FinalPOE.developerDetails[i]+
            "\nTask Duration: "+FinalPOE.hoursForTasks[i]+"hrs"+
            "\nTask ID: "+FinalPOE.taskIDs[i]+
            "\nTask Status: "+FinalPOE.taskStatus[i],"Task Report",1);
        }
    }
}
}

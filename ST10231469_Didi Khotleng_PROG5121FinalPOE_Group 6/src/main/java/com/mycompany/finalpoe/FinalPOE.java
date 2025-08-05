
package com.mycompany.finalpoe;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author ST10231469
 */

public class FinalPOE{
    public static String[]taskIDs;
    public static String[]taskNames;
    public static int[]taskNumbers;
    public static String[]developerDetails;
    public static String[]taskDescriptions;
    public static String[]taskStatus;
    public static int[]hoursForTasks;
    public static void main(String[] args) {
    

        JTextField taskNAME = new JTextField();
        JTextField developerDetailFirstName = new JTextField();
        JTextField developerDetailLastName = new JTextField();
        JTextField TaskDescription = new JTextField();
        JTextField hoursForTask = new JTextField();
        String[] choose = {"To Do","Doing","Done"};
        JComboBox statusSelect = new JComboBox(choose);
        int count = 1;
        int addNumOfTasks;
        int TaskNumber = 0;
        int TotalHours = 0;
        int estimateDuration;
        String ID;
        String select;
        String status;
        String options;
        String devName;
        String devFirstName;
        String devLastName;
        String TaskName;
        String estimate;
        String numOfTask;
        String taskDescription;
 
do{       
options = JOptionPane.showInputDialog(null,"Please select the following options: "
        +"\nOption 1. Add tasks"
        +"\nOption 2. Show report"
        +"\nOption 3. Quit"
        +"\nPlease enter the option of your choice: "
        ,"Welcome to EasyKanban",JOptionPane.PLAIN_MESSAGE);
  
        Object[] Tasks = {
            "Please enter the task name:",taskNAME,
            "Please enter the task Description, should not exceed 50 characters:",TaskDescription,
            "Please enter your first name:",developerDetailFirstName,
            "Please enter your last name:",developerDetailLastName,
            "Please enter your estimated duration for the task in hours:",hoursForTask,
            "Please select the status of the task",statusSelect,
        };    
switch(options){    
        case "1":   
           
            numOfTask = JOptionPane.showInputDialog(null,"Please enter the number of tasks you wish to set: ","Add tasks",3);
            addNumOfTasks = Integer.parseInt(numOfTask);
            
            
            taskNumbers = new int[addNumOfTasks];
            taskNames = new String[addNumOfTasks];           
            taskDescriptions = new String[addNumOfTasks];
            developerDetails = new String[addNumOfTasks];
            hoursForTasks = new int[addNumOfTasks];
            taskStatus = new String[addNumOfTasks]; 
            taskIDs = new String[addNumOfTasks];
            
    for(int i = 0; i < addNumOfTasks;i++){
        do{
        JOptionPane.showMessageDialog(null, "1. Please ensure that you fill in all the text fields"
                + "\n2. Your task description is less than 50 character"
                + "\n3. You enter a numerical value for the duration","Message", 2);
        JOptionPane.showMessageDialog(null, Tasks, "Add Tasks", 3);
        }while(hoursForTask.getText().isEmpty()&& !Methods.checkIntValue(hoursForTask)||!Methods.checkDescription(TaskDescription)||TaskDescription.getText().isEmpty() || taskNAME.getText().isEmpty() ||developerDetailFirstName.getText().isEmpty()||developerDetailLastName.getText().isEmpty());
        //only when the users inputs are correct and suitable, will the do-while loop break and store variables in the array.
        
            TaskName = taskNAME.getText();//.getText() ensure that the JTextField gets converted into a string so that it much more easier to read and work with when using arrays.
            taskNames[i] = TaskName; 
            taskNAME.setText(null);//The purpose of the .setText(null) is clear the textfields, so that when the JOptionPane loops back the user doesn't have to clear the textfields.
               
            TaskNumber++;
            taskNumbers[i] = TaskNumber;
                   
            taskDescription = TaskDescription.getText();
            taskDescriptions[i] = taskDescription;
            TaskDescription.setText(null);
            
            
            devFirstName = developerDetailFirstName.getText();
            devLastName = developerDetailLastName.getText();
            devName = devFirstName+" "+devLastName;
            developerDetails[i] = devName;
            developerDetailFirstName.setText(null);
            developerDetailLastName.setText(null);
            
            estimate = hoursForTask.getText();
            estimateDuration= Integer.parseInt(estimate);            
            hoursForTasks[i] = estimateDuration;
            hoursForTask.setText(null);
               
            ID= Methods.taskId(TaskName, TaskNumber, devFirstName);
            taskIDs[i] = ID;
                
            status = statusSelect.getSelectedItem().toString();
            taskStatus[i] = status; 
            count++;//this will increment within the for loop
            
           Methods.printTaskDetails(status, TaskNumber, TaskName, taskDescription, ID, estimateDuration,count,addNumOfTasks);  
           TotalHours = TotalHours + estimateDuration;//All the hous the user input will incremented into Total hours and displayed when ever needed
        }
    Methods.returnTotalHours(TotalHours);
            break;
        case "2":  
 do{
    select = JOptionPane.showInputDialog(null,"Please select the following options:"
                + "\n1. Display all the tasks with the status of Done."
                + "\n2. Display the longest task duration."
                + "\n3. Search for a Task."
                + "\n4. Search for Tasks assigned to a developer"
                + "\n5. Delete a Task"
                + "\n6. Display a report of all captured Tasks."
                + "\n7. Go back to the Main Menu","Show Report", 1);
        
    switch(select){
//There is no need for parameters in these methods because the methods in the Methods. class already have direct access to the arrays
//All these methods collaborate with the array in this method
            case "1":
                Methods.displayTaskDone();
                    break;
            case "2":
                Methods.longestTaskDuration();
                    break;
            case "3":
                Methods.searchForTask();
                    break;
            case "4":
                Methods.developerTasks();
                    break;
            case "5":
                Methods.deleteTask(); 
                    break;
            case "6":
                Methods.displayTaskReport();
                    break;
            case "7": 
                //this will break out of the case and also out of the loop because the user input 7
                    break;
            default:
                JOptionPane.showMessageDialog(null,"Please enter either: "
                    + "\n1. Display all tasks with status of done."
                    + "\n2. Display the Task with the longest duration."
                    + "\n3. Search for a task."
                    + "\n4. Search for task assigned to a Developer."
                    + "\n5. Delete Task."
                    + "\n6. Display report of all captured tasks."
                    + "\n7. Back to Main menu", "Incorrect User Input",0);
                    break;
        }
    }while(!select.equals("7"));//the loop will only break until the user inputs 7
            break;
                
        case "3":                
            JOptionPane.showMessageDialog(null, "Thank you for using this Application, Goodbye!","Exit",1);
            System.exit(0);//This exits the program and the 0 means that it is exiting the program normally as expected
            break;
            
        default:      
            JOptionPane.showMessageDialog(null,"Please enter either: \n 1. To add tasks\n 2. To show the report \n 3. To exit the application","Incorrect input",0);    
            break;          
        }
    }while(!options.equals("3"));//if the user enters a value that isn't 3, the loop execute
 }       
}
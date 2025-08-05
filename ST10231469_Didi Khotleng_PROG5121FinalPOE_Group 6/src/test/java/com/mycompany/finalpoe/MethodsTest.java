
package com.mycompany.finalpoe;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * @author ST10347155 Zipho Mbewana
 */
public class MethodsTest {
    
    public MethodsTest() {
    }
    
    @Test
    public void testCheckDescription() {
    JTextField TaskDescription = new JTextField("Task successfully captured");
    assertEquals(true,Methods.checkDescription(TaskDescription));{
    JOptionPane.showMessageDialog(null, "Task successfully captured","Successful", 1);
    }
    }
    @Test
    public void testCheckDescriptionfalse() {
    JTextField TaskDescription = new JTextField("Please enter a task description of less than 50 characters");
    assertEquals(false,Methods.checkDescription(TaskDescription));
    }
    @Test
    public void testTaskId() {
    String taskName = "Login Feature"; 
    int taskNumber = 1; 
    String devFirstName = "Robyn";
    assertEquals("LO:"+taskNumber+":BYN",Methods.taskId(taskName, taskNumber, devFirstName));    
    }    
    @Test
    public void testReturnTotalHours() {
    int totalHours = 0;
    int durationA = 10;
    int durationB = 12;
    int durationC = 55;
    int durationD = 11;
    int durationE = 1;
    for(int i = 0; i < 5;i++){
  if(i == 0){
       totalHours = durationA + totalHours;
       }
  if(i == 1){
       totalHours = durationB + totalHours;
       }
  if(i == 2){
       totalHours = durationC + totalHours;   
       }
  if(i == 3){
       totalHours = durationD + totalHours;    
       }
  if(i == 4){
       totalHours = durationE + totalHours;    
       }
    }
    assertEquals(89,Methods.returnTotalHours(totalHours));    
    }
    @Test
    public void testReturnTotalHours2() {
    int totalHours = 0;
    int taskOne = 8;
    int taskTwo = 10;
    for(int i = 0; i < 2;i++){
       if(i == 0){
       totalHours = taskOne + totalHours;
       }
       if(i == 1){
       totalHours = taskTwo + totalHours;
       }
    }
    assertEquals(18,Methods.returnTotalHours(totalHours));      
    }
    @Test
    public void populateDeveloperArray() {
    String[]Developer={"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};
    FinalPOE.developerDetails =Developer;
    for(String developerDetail : FinalPOE.developerDetails){
            JOptionPane.showMessageDialog(null, "The Developers are: " + developerDetail, "Display Developers", 1);
        }
    }
    @Test
    public void testLongestTaskDuration() {
    String[]Developer={"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};
    int[]duration ={5,8,2,11};
    FinalPOE.developerDetails =Developer;
    FinalPOE.hoursForTasks=duration;
    Methods.longestTaskDuration();
    }
    @Test
    public void testDisplayTaskDone() {
    String[]Developer={"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};   
    String[]TaskName ={"Create Login","Create Add Features","Create Reports","Add Arrays"};
    String[]Status ={"To Do","Doing","Done","Todo"};
    int[]duration ={5,8,2,11};
    FinalPOE.developerDetails=Developer;
    FinalPOE.hoursForTasks=duration;
    FinalPOE.taskNames=TaskName;
    FinalPOE.taskStatus=Status;
    Methods.displayTaskDone();
    }
    @Test
    public void testSearchForTask() {
    String[]Developer={"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};   
    String[]TaskName ={"Create Login","Create Add Features","Create Reports","Add Arrays"};
    String[]Status ={"To Do","Doing","Done","Todo"};
    int[]duration ={5,8,2,11};
    FinalPOE.developerDetails=Developer;
    FinalPOE.hoursForTasks=duration;
    FinalPOE.taskNames=TaskName;
    FinalPOE.taskStatus=Status;
    Methods.searchForTask();
    }
    @Test
    public void testDisplayDeveloperTasks() {
    String[]Developer={"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};   
    String[]TaskName ={"Create Login","Create Add Features","Create Reports","Add Arrays"};
    String[]Status ={"To Do","Doing","Done","Todo"};
    int[]duration ={5,8,2,11};
    FinalPOE.developerDetails=Developer;
    FinalPOE.hoursForTasks=duration;
    FinalPOE.taskNames=TaskName;
    FinalPOE.taskStatus=Status;
    Methods.developerTasks();
    }
    @Test
    public void testDeleteTask() {
    String[]Developer={"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};   
    String[]TaskName ={"Create Login","Create Add Features","Create Reports","Add Arrays"};
    String[]Status ={"To Do","Doing","Done","Todo"};
    int[]duration ={5,8,2,11};
    int[] taskNumber={1,2,3,4};
    String[] descriptions={"Create a login.","Create a add feature.","Create reports.","Add elements to the array"};
    String[]taskID={"CR:"+1+":IKE","CR:"+2+":ARD","CR:"+3+":SON","AD:"+4+":NDA"};
    FinalPOE.taskNumbers=taskNumber;
    FinalPOE.taskIDs=taskID;
    FinalPOE.developerDetails=Developer;
    FinalPOE.hoursForTasks=duration;
    FinalPOE.taskNames=TaskName;
    FinalPOE.taskStatus=Status;
    FinalPOE.taskDescriptions=descriptions;
    Methods.deleteTask();
    Methods.displayTaskReport();
    }
    @Test
    public void testDisplayTaskReport() {
    String[]Developer={"Mike Smith","Edward Harrison","Samantha Paulson","Glenda Oberholzer"};   
    String[]TaskName ={"Create Login","Create Add Features","Create Reports","Add Arrays"};
    String[]Status ={"To Do","Doing","Done","To do"};
    int[]duration ={5,8,2,11};
    int[] taskNumber={1,2,3,4};
    String[] descriptions={"Create a login.","Create a add feature.","Create reports.","Add elements to the array"};
    String[]taskID={"CR:"+1+":IKE","CR:"+2+":ARD","CR:"+3+":SON","AD:"+4+":NDA"};
    FinalPOE.taskNumbers=taskNumber;
    FinalPOE.taskIDs=taskID;
    FinalPOE.developerDetails=Developer;
    FinalPOE.hoursForTasks=duration;
    FinalPOE.taskNames=TaskName;
    FinalPOE.taskStatus=Status;
    FinalPOE.taskDescriptions=descriptions;
    Methods.displayTaskReport();  
    }
   
}

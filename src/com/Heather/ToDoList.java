package com.Heather;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ToDoList extends JFrame{
    private JPanel rootPanel;
    private JTextField newToDotextField;
    private JButton addToDoButton;
    private JList<String> toDoList;
    private JButton deleteButton;
    private DefaultListModel<String> listModel; //a JList needs a model to provide data

    protected ToDoList(){
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(500,500));
        listModel=new DefaultListModel<String>();//create a listModel.  the list starts empty, so no data to add yet.
        // when you add data to the list, you actually need to add it to the lists's *Model*

        //configure the JList to use this model as its data source.
        toDoList.setModel(listModel);

        addListeners();//move event listener configuration into a separate method, keep things neater

        pack();
        setVisible(true);
    }

    private void addListeners(){
        //Need to listen for button clicked.  Also, read text in the text box and add to list.

        addToDoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newToDo=newToDotextField.getText();
                newToDo=newToDo.trim();//remove whitespace

                //check to see if the JTextField is empty, if empty ignore.
                if (newToDo.length()==0){
                    return;
                }

                listModel.addElement(newToDo);//add new item to the JList's Model.
                newToDotextField.setText("");//clear the JTextField
            }
        });
        //and, listen for the list being clicked on, which should remove the selected item.
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex=toDoList.getSelectedIndex();
                if (selectedIndex!= -1){
                    listModel.remove(selectedIndex);//remove from model.
                }
            }
        });
        /*toDoList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //what was selected?
                int selectedIndex=toDoList.getSelectedIndex();
                if(selectedIndex != -1){
                    listModel.remove(selectedIndex); //remove from the model.
                }
            }
        });*/
    }



}

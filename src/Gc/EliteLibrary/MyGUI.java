lpackage Gc.EliteLibrary;

import java.awt.*;  // import all of the classes for doing graphics 
import java.awt.event.*;
// Import require JFrams
import javax.swing.*;
 

public class MyGUI extends JFrame {
	  
	private JLabel label;  //Text that sits on the screen
	private JButton button;  // 
	private JTextField textfield; //
	private JTextField textfield1; //
	private ImageIcon image1; // create an image Icon
	private JLabel labelimage; // Create label for image
	
	
	
	
	public MyGUI() {
		//Manipulate variables and add them to the screen
		setLayout(new FlowLayout());  //Flow left to right and top to bottom
		
		image1 = new  ImageIcon(getClass().getResource("library.jpg"));  // get and set image to display
		labelimage = new JLabel(image1); //Create label for screen display
		add(labelimage); // add label to screen
		
		label = new JLabel(" ");
		add(label);// add label to the screen
		
		textfield = new JTextField("Enter A Catalog Number 1-4:");
		add(textfield);// add text field  to the screen
		
		textfield1 = new JTextField(15);
		add(textfield1);// add text field  to the screen
		
		button = new JButton("Click For Text");
		add(button);// add button to the screen
		
		// create subclass   to contain events for action
		 event event1 = new event();   // create events object  call new GUI class
	     button.addActionListener(event1);		
	}
	public class events implements Actionlistener{
	public void action Performs(ActionEvent e){
	label.setText("Action Item");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Make a GUI Object
		MyGUI aGui = new MyGUI();

		// Three thing that must be done to create a GUI window
		aGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //Exit the App when window is closed
		
		//aGui.setSize(200, 300);    // Set window size to 200 pixels by 300 pixels
		aGui.pack();   //Set window size around image to pack 
		aGui.setVisible(true);    //Show the window, do not hide it
		
		aGui.setTitle("Team eLITE Library Program");
		
		
		
	}

}

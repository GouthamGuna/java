package in.gmsk.example;

import javax.swing.JOptionPane;

public class ClassNameHere {
	
	public void infoBox(String infoMessage, String titleBar){
		JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
	}
}

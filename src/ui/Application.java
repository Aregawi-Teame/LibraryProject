package ui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;



public class Application {

	public static void main(String[] args) {
	      EventQueue.invokeLater(() -> 
	         {
	            LoginUi.INSTANCE.setTitle("Library Application");
	            LoginUi.INSTANCE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            
	            LoginUi.INSTANCE.init();
	            centerFrameOnDesktop(LoginUi.INSTANCE);
	            LoginUi.INSTANCE.setVisible(true);
	         });
	   }
	   
	   public static void centerFrameOnDesktop(Component f) {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			int height = toolkit.getScreenSize().height;
			int width = toolkit.getScreenSize().width;
			int frameHeight = f.getSize().height;
			int frameWidth = f.getSize().width;
			f.setLocation(((width - frameWidth) / 2), (height - frameHeight) / 3);
		}
}

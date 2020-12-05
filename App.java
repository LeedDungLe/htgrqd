
import java.awt.EventQueue;
import java.util.HashSet;
import java.util.Set;
import view.mainGUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
		try {
                    mainGUI frame = new mainGUI();
                    frame.setVisible(true);
		} catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});

    }
    
}

import java.awt.EventQueue;

public class main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {    
            public void run() {
                try {
                    Registration frame = new Registration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
	}

}

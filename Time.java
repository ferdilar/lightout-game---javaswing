import javax.swing.*;
public class Time extends Thread {
	private String sDet;
	public int det;
	private JLabel lblT;
	public boolean lanjut=false;
	public Time(JLabel lblTime) {
		lblT=lblTime;
		det=1;
	}
	public void run(){
		while (true){
			sDet=sDet.valueOf(det);
			try {
				if(lanjut==true){
					lblT.setText(sDet + " S");
					det++;//asumsikan dalam detik
				}
				Thread.sleep(1000);
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.util.*;
import java.applet.Applet;
import java.applet.AudioClip;
public class LightOut implements ActionListener{//Class LightOut inheritance dari kelas Actionlistener java
	//Attribut
	/*semua Button*/
	private JButton gambar1;
	private JButton gambar2;
	private JButton gambar3;
	private JButton gambar4;
	private JButton gambar5;
	private JButton gambar6;
	private JButton gambar7;
	private JButton gambar8;
	private JButton gambar9;
	private JFrame frame;
	/*semua ImageIcon get dari resource*/
	private ImageIcon on;
	private ImageIcon off;
	private ImageIcon gTime;
	private ImageIcon gWon;
	/*Keterangan permainan beberapa atribut yang akan tampil sbg keterangan saat permainan*/
	private JLabel lblTime;
	private JLabel gbrTime;
	private JLabel lblLangkah;
	private JLabel jdlLangkah;
	private JButton cmdNew;
	private JButton cmdExit;
	/*Atribut lain*/
	private AudioClip sClick;
	private AudioClip sWon;
	private int langkah;//counter byk langkah yang dilakukan
	private int det;//timer yang akan menghitung lama permainan hingga berhasil
	private boolean lanjut;//status agar waktu berjalan
	Random r = new Random();
	private Time t;
	/*Constructor*/
	public LightOut(){//panggil user interface
		System.out.println("Loading ... \nPrepare Ur Self ^_^");
		frame=new JFrame("LIGHT OUT LOUD");
		frame.setResizable(false);
		frame.setSize(345,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
	}
	
	public void addComponent(){//masukkkan componen dalan interface yang akan tampil
		// memasukkan gambar ke Image Icon
		sClick = Applet.newAudioClip(getClass().getResource("aset/click.wav"));
		sWon = Applet.newAudioClip(getClass().getResource("aset/charge.wav"));
		on=new ImageIcon(getClass().getResource("aset/on.jpg"));
		off=new ImageIcon(getClass().getResource("aset/off.jpg"));
		gWon=new ImageIcon(getClass().getResource("aset/won.jpg"));
		//------------------------gambar 1
		gambar1=new JButton("1");
		gambar1.setIcon(on);
		frame.add(gambar1);
		gambar1.setBounds(20,50,100,100);//x,y,width,height
		//------------------------gambar 2
		gambar2=new JButton("2");
		gambar2.setIcon(on);
		frame.add(gambar2);
		gambar2.setBounds(120,50,100,100);
		//------------------------gambar 3
		gambar3=new JButton("3");
		gambar3.setIcon(on);
		frame.add(gambar3);
		gambar3.setBounds(220,50,100,100);
		//------------------------gambar 4
		gambar4=new JButton("4");
		gambar4.setIcon(on);
		frame.add(gambar4);
		gambar4.setBounds(20,150,100,100);
		//------------------------gambar 5
		gambar5=new JButton("5");
		gambar5.setIcon(on);
		frame.add(gambar5);
		gambar5.setBounds(120,150,100,100);
		//------------------------gambar 6
		gambar6=new JButton("6");
		gambar6.setIcon(on);
		frame.add(gambar6);
		gambar6.setBounds(220,150,100,100);
		//------------------------gambar 7
		gambar7=new JButton("7");
		gambar7.setIcon(on);
		frame.add(gambar7);
		gambar7.setBounds(20,250,100,100);
		//------------------------gambar 8
		gambar8=new JButton("8");
		gambar8.setIcon(on);
		frame.add(gambar8);
		gambar8.setBounds(120,250,100,100);
		//------------------------gambar 9
		gambar9=new JButton("9");
		gambar9.setIcon(on);
		frame.add(gambar9);
		gambar9.setBounds(220,250,100,100);
		//keterangan permainan
		gbrTime=new JLabel("T");
		gTime=new ImageIcon(getClass().getResource("aset/time.jpg"));
		gbrTime.setIcon(gTime);
		frame.add(gbrTime);
		gbrTime.setBounds(30,370,40,40);
		//counter waktu
		lblTime=new JLabel("0 S");
		frame.add(lblTime);
		lblTime.setBounds(100,370,40,40);
		//penambahan langkah
		jdlLangkah=new JLabel("Langkah :");
		frame.add(jdlLangkah);
		jdlLangkah.setBounds(200,370,70,40);
		lblLangkah=new JLabel("0");
		frame.add(lblLangkah);
		lblLangkah.setBounds(300,370,30,40);
		//tombol aksi untuk new game dan keluar
		cmdNew=new JButton("New Game");
		frame.add(cmdNew);
		cmdNew.setBounds(20,15,300,30);
		cmdExit=new JButton("Exit");
		frame.add(cmdExit);
		cmdExit.setBounds(20,420,300,30);
		setButton(false);
	}
	public void addListener(){//inisialisasi
		gambar1.addActionListener(this);
		gambar2.addActionListener(this);
		gambar3.addActionListener(this);
		gambar4.addActionListener(this);
		gambar5.addActionListener(this);
		gambar6.addActionListener(this);
		gambar7.addActionListener(this);
		gambar8.addActionListener(this);
		gambar9.addActionListener(this);
		cmdNew.addActionListener(this);
		cmdExit.addActionListener(this);
		t=new Time(lblTime);
		t.start();
	}

	public void actionPerformed(ActionEvent e){//aksi hidup/mati
		int x;
		int y;
		sClick.play();
		if(e.getSource()==gambar1){//jika gambar satu di klik, maka yang akan terpengaruhi adalah gambar 1,2,4
			if(gambar1.getIcon()==on){//jika sebelumnya hidup
				gambar1.setIcon(off);//maka matikan
			}else{
				gambar1.setIcon(on);//jika tidak, tetap hidup berarti sebelumnya mati.
			}
			if(gambar2.getIcon()==on){
				gambar2.setIcon(off);
			}else{
				gambar2.setIcon(on);
			}
			if(gambar4.getIcon()==on){
				gambar4.setIcon(off);
			}else{
				gambar4.setIcon(on);
			}
			langkah++;
			cekMenang();
			lblLangkah.setText(String.valueOf(langkah));
		}else if(e.getSource()==gambar2){
			if(gambar1.getIcon()==on){
				gambar1.setIcon(off);
			}else{
				gambar1.setIcon(on);
			}
			if(gambar2.getIcon()==on){
				gambar2.setIcon(off);
			}else{
				gambar2.setIcon(on);
			}
			if(gambar3.getIcon()==on){
				gambar3.setIcon(off);
			}else{
				gambar3.setIcon(on);
			}
			if(gambar5.getIcon()==on){
				gambar5.setIcon(off);
			}else{
				gambar5.setIcon(on);
			}
			langkah++;
			cekMenang();
			lblLangkah.setText(String.valueOf(langkah));
		}else if(e.getSource()==gambar3){
			if(gambar2.getIcon()==on){
				gambar2.setIcon(off);
			}else{
				gambar2.setIcon(on);
			}
			if(gambar3.getIcon()==on){
				gambar3.setIcon(off);
			}else{
				gambar3.setIcon(on);
			}
			if(gambar6.getIcon()==on){
				gambar6.setIcon(off);
			}else{
				gambar6.setIcon(on);
			}
			langkah++;
			cekMenang();
			lblLangkah.setText(String.valueOf(langkah));
		}else if(e.getSource()==gambar4){
			if(gambar1.getIcon()==on){
				gambar1.setIcon(off);
			}else{
				gambar1.setIcon(on);
			}
			if(gambar4.getIcon()==on){
				gambar4.setIcon(off);
			}else{
				gambar4.setIcon(on);
			}
			if(gambar5.getIcon()==on){
				gambar5.setIcon(off);
			}else{
				gambar5.setIcon(on);
			}
			if(gambar7.getIcon()==on){
				gambar7.setIcon(off);
			}else{
				gambar7.setIcon(on);
			}
			langkah++;
			cekMenang();
			lblLangkah.setText(String.valueOf(langkah));
		}else if(e.getSource()==gambar5){
			if(gambar2.getIcon()==on){
				gambar2.setIcon(off);
			}else{
				gambar2.setIcon(on);
			}
			if(gambar4.getIcon()==on){
				gambar4.setIcon(off);
			}else{
				gambar4.setIcon(on);
			}
			if(gambar5.getIcon()==on){
				gambar5.setIcon(off);
			}else{
				gambar5.setIcon(on);
			}
			if(gambar6.getIcon()==on){
				gambar6.setIcon(off);
			}else{
				gambar6.setIcon(on);
			}
			if(gambar8.getIcon()==on){
				gambar8.setIcon(off);
			}else{
				gambar8.setIcon(on);
			}
			langkah++;
			cekMenang();
			lblLangkah.setText(String.valueOf(langkah));
		}else if(e.getSource()==gambar6){
			if(gambar3.getIcon()==on){
				gambar3.setIcon(off);
			}else{
				gambar3.setIcon(on);
			}
			if(gambar5.getIcon()==on){
				gambar5.setIcon(off);
			}else{
				gambar5.setIcon(on);
			}
			if(gambar6.getIcon()==on){
				gambar6.setIcon(off);
			}else{
				gambar6.setIcon(on);
			}
			if(gambar9.getIcon()==on){
				gambar9.setIcon(off);
			}else{
				gambar9.setIcon(on);
			}
			langkah++;
			cekMenang();
			lblLangkah.setText(String.valueOf(langkah));
		}else if(e.getSource()==gambar7){
			if(gambar4.getIcon()==on){
				gambar4.setIcon(off);
			}else{
				gambar4.setIcon(on);
			}
			if(gambar7.getIcon()==on){
				gambar7.setIcon(off);
			}else{
				gambar7.setIcon(on);
			}
			if(gambar8.getIcon()==on){
				gambar8.setIcon(off);
			}else{
				gambar8.setIcon(on);
			}
			langkah++;
			cekMenang();
			lblLangkah.setText(String.valueOf(langkah));
		}else if(e.getSource()==gambar8){
			if(gambar5.getIcon()==on){
				gambar5.setIcon(off);
			}else{
				gambar5.setIcon(on);
			}
			if(gambar7.getIcon()==on){
				gambar7.setIcon(off);
			}else{
				gambar7.setIcon(on);
			}
			if(gambar8.getIcon()==on){
				gambar8.setIcon(off);
			}else{
				gambar8.setIcon(on);
			}
			if(gambar9.getIcon()==on){
				gambar9.setIcon(off);
			}else{
				gambar9.setIcon(on);
			}
			langkah++;
			cekMenang();
			lblLangkah.setText(String.valueOf(langkah));
		}else if(e.getSource()==gambar9){
			if(gambar6.getIcon()==on){
				gambar6.setIcon(off);
			}else{
				gambar6.setIcon(on);
			}
			if(gambar8.getIcon()==on){
				gambar8.setIcon(off);
			}else{
				gambar8.setIcon(on);
			}
			if(gambar9.getIcon()==on){
				gambar9.setIcon(off);
			}else{
				gambar9.setIcon(on);
			}
			langkah++;
			cekMenang();
			lblLangkah.setText(String.valueOf(langkah));
		}else if(e.getSource()==cmdNew){//jika button new game di klik
			lanjut=true;
			det=0;
			langkah=0;
			lblLangkah.setText(String.valueOf(langkah));//inisialisasi
			setTempat();
			setButton(true);//aktifkan papan permainan
			t.det=1;
			t.lanjut=true;
		}else if(e.getSource()==cmdExit){//jika button exit untuk keluar
			System.exit(0);
		}
	}

	public void setButton(boolean masuk){//status gambar true berarti standby untuk dimainkan/dapat menerima aksi user
		gambar1.setEnabled(masuk);
		gambar2.setEnabled(masuk);
		gambar3.setEnabled(masuk);
		gambar4.setEnabled(masuk);
		gambar5.setEnabled(masuk);
		gambar6.setEnabled(masuk);
		gambar7.setEnabled(masuk);
		gambar8.setEnabled(masuk);
		gambar9.setEnabled(masuk);
	}
	public void setTempat(){//inisialisasi tempat awal yang random dari 3 posisi yg ditentukan soal
		int ran=r.nextInt(3) +1;
		if(ran==1){
			gambar1.setIcon(on);
			gambar2.setIcon(off);
			gambar3.setIcon(on);
			gambar4.setIcon(on);
			gambar5.setIcon(off);
			gambar6.setIcon(on);
			gambar7.setIcon(on);
			gambar8.setIcon(off);
			gambar9.setIcon(on);
		}else if(ran==2){
			gambar1.setIcon(off);
			gambar2.setIcon(on);
			gambar3.setIcon(on);
			gambar4.setIcon(on);
			gambar5.setIcon(off);
			gambar6.setIcon(off);
			gambar7.setIcon(on);
			gambar8.setIcon(off);
			gambar9.setIcon(off);
		}else{
			gambar1.setIcon(on);
			gambar2.setIcon(off);
			gambar3.setIcon(off);
			gambar4.setIcon(off);
			gambar5.setIcon(on);
			gambar6.setIcon(off);
			gambar7.setIcon(off);
			gambar8.setIcon(off);
			gambar9.setIcon(on);
		}
		
	}
//Jika menang
	public void cekMenang(){
		if(gambar1.getIcon()==off && gambar2.getIcon()==off && gambar3.getIcon()==off && gambar4.getIcon()==off && gambar5.getIcon()==off && gambar6.getIcon()==off && gambar7.getIcon()==off && gambar8.getIcon()==off && gambar9.getIcon()==off){
			sWon.play();
			JOptionPane.showMessageDialog(null,"\n\nAnda Menang dengan Waktu : "
			+ t.det +" detik,  Langkah : " + (langkah) + " Kali", "Permainan Selesai",
			JOptionPane.INFORMATION_MESSAGE, gWon); t.lanjut=false;
		setButton(false);
		}
	}
}


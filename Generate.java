package com.gmail.s.birchyboy.FreeRider2LevelGenerator;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Generate {
	private Random r = new Random();
	private int length =r.nextInt(19)+1;
	private int chunkLength = r.nextInt(49)+1;
	private String alph1 = "- 123456789abcdefghijklmnopqrstuvwxyz";
	private String alph2 = "1234567890abcdefghijklmnopqrstuvwxyz";
	private String output = "";
	public void start(){
		if(length%2!=0){
			length =r.nextInt(19)+1;
		}else if(chunkLength%2!=0){
			chunkLength = r.nextInt(49)+1;
		}
		for(int q = 0; q<length; q++){
			for(int w = 0; w<chunkLength; w++){
				output+=gen();
				if((w+1)==chunkLength && (q+1)!=length){
					output+=",";
				}else if((w+1)==chunkLength && (q+1)==length){
					continue;
				}else{
					output+=" ";
				}
			}
		}
		JTextArea msg = new JTextArea(output);
		msg.setLineWrap(true);
		msg.setWrapStyleWord(true);
		JScrollPane scrollPane = new JScrollPane(msg);
		msg.setPreferredSize(new Dimension(800,420));
		JOptionPane.showMessageDialog(null,scrollPane);
	}
	public String gen(){
		String temp = ""+alph1.charAt(r.nextInt(alph1.length())) + alph2.charAt(r.nextInt(alph2.length())) + alph2.charAt(r.nextInt(alph2.length()));
		return temp.trim();
	}
}

package posist;
import java.security.MessageDigest;
import java.sql.Time;
import java.util.*;
import java.util.Date;
import java.util.Scanner;

import javax.swing.text.DateFormatter;
import javax.xml.bind.DatatypeConverter;

import java.text.*;


import java.text.SimpleDateFormat;  
import java.util.Date;  


public class posist_Tree {
	
	public static int sum =0;
	public static int genesisVal =0;
	public static String genesisAdress="";
	public static int nodecount=0;
	
	static HashMap<String, Boolean> ownerMap = new HashMap<>();
	
	
	public String getDate()
	{
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    
		return formatter.format(date);
	}

	
	public class node 
	{
		String time;
		String data;
		int nodeNumber;
		String nodeId;
		String referenceNodeId;
		String[] childReferenceNodeId;
		String genesisReferenceNodeId;
		String HashValue;
		ArrayList<node> children;
		
		// extra fields
		int ownerId;
		int value;
		String ownerName;
		
		// Calculating the SHA encrypted hash 
		String hashOfSet ;
		
		public node(int ownerId,int value,int ownerName,String parent)
		{
			// initialising the children array
			this.children= new ArrayList();
			this.hashOfSet = getSHA256Hash(ownerId+""+value+""+ownerName);
			this.genesisReferenceNodeId=genesisAdress;
			this.data = ownerId+""+value+""+ownerName;
			this.time = getDate();
			this.HashValue = getDate()+""+(nodecount+1)+""+this.toString()+""
			            +genesisReferenceNodeId+""+this.childReferenceNodeId+
			            ""+referenceNodeId+""+ownerId+""+value+""+ownerName;
			
			
			
			this.referenceNodeId=parent;
			// Incrementing the node ID each time 
			nodecount++;
			this.nodeId = this.toString();
			this.nodeNumber = nodecount;
			
		}
		
		
		
		

	}
	
	
	private String getSHA256Hash(String data) {

        String result = null;

        try {

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(data.getBytes("UTF-8"));

            return bytesToHex(hash); // make it printable

        }catch(Exception ex) {

            ex.printStackTrace();

        }

        return result;

    }
	
	 private String  bytesToHex(byte[] hash) {

	        return DatatypeConverter.printHexBinary(hash);

	    }
	 
	 public static void main(String[] args) {
			// TODO Auto-generated method stub

			Scanner scn = new Scanner(System.in);
			System.out.println("Enter your name if you want to make the node");
			String ownername = scn.nextLine();
			
			
			node genesisNode = new node(null);
			
		}

}


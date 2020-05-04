package components;

import java.util.Arrays;

public class VonNeumannMemory {
	/*
	 * this means one memory space for both the data and instructions.
	 * THIS ALSO MEANS ONE ACCESS, EITHER DATA OR INSTRUCTIONS, AT A TIME!! (accessing data & instruction at the same TIME
	 * => STRUCTURAL HAZARDa! eyy itsa me mario
	 * since we're allowed to structure it however we want... I'll do the first half as instructions and the second half as data.
	 * it is BYTE ADDRESSABLE.
	 * go to cash class
	 */
	
	private static String[] memory= zeros(2048);
	//private static int lastoccDataByte=-1;
	private static int firstnonoccInstructionByte=-1;
	

//	private static void init()
//	{
//		for(int i=0;i<2048;i++)
//		{
//			memory[i]="x";
//		}
//	}
	public static void addinstructions(String[] instructions)
	{
		//init();
		firstnonoccInstructionByte+=1;
		for (int i=0;i<instructions.length;i++)
		{
			String x=instructions[i];
			String temp1=(String) x.subSequence(0,8);
			String temp2=(String) x.subSequence(8,16);
			String temp3=(String) x.subSequence(16,24 );
			String temp4=(String) x.subSequence(24, 32);
			memory[firstnonoccInstructionByte]=(temp1);
			memory[firstnonoccInstructionByte+1]=(temp2);
			memory[firstnonoccInstructionByte+2]=(temp3);
			memory[firstnonoccInstructionByte+3]=(temp4);
			firstnonoccInstructionByte+=4;
			
		
		}
	}
	
	public static String fetchinstruction(int pc)
	{
		//init();
		if(pc<=1023)
		{
			String result=memory[pc];
			result=result+memory[pc+1];
			result=result+memory[pc+2];
			result=result+memory[pc+3];
			return result;
		}
		System.out.println("this is the data memory territory");
		return null;
	}

	
	//data
	//load 
	public static String load(String address)
	{
		//init();
		int add=Integer.parseInt(address, 2);
		if(add<1021)
		{
			String result=memory[add];
			result=result+memory[add+1];
			result=result+memory[add+2];
			result=result+memory[add+3];
//			System.out.println(result);
			return result;
		}
		System.out.println("load in vonneuma: check your address");
		return null;
		
		
	}
	//store
	public static void store(String address,String data)
	{
		//init();
		int add=Integer.parseInt(address, 2);
		//System.out.println(add);
		if(add>1023)
		{
		String temp1=(String) data.subSequence(0,8);
		String temp2=(String) data.subSequence(8,16);
		String temp3=(String) data.subSequence(16,24 );
		String temp4=(String) data.subSequence(24, 32);
		//System.out.println(memory.length);
		memory[add]=temp1;
		memory[add+1]=temp2;
		memory[add+2]=temp3;
		memory[add+3]=temp4;
		}
		else
		{
			System.out.println("store in vonneuma: check your address");
		}
	}
//	public static void main(String[]args)
//	{
//		String[] instructions=new String[3];
//		System.out.println(instructions[0]);
//		instructions[0]="s";
//		System.out.println(instructions[0]);
		//String[] instructions= {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb","cccccccccccccccccccccccccccccccccccccccccccc","dddddddddddddddddddddddddddddddddddddddd"};
//		
//				addinstructions(instructions);
//		System.out.println(firstnonoccInstructionByte);
//		System.out.println(memory[firstnonoccInstructionByte-1]);
//		System.out.println(memory[firstnonoccInstructionByte]);
		//System.out.println(fetchinstruction(12));
//		store("0","00010000111000100111111111111111");
//		load("0");
//	}

	public static String[] zeros(int size){
		String[] ret  = new String[size];
		Arrays.fill(ret,"00000000");
		return ret;
	}
	
}
package com.receptive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Searcher {
	private String erl;
	private String txtIn;
	
	public Searcher(String sq) {
		//erl = sq;
		txtIn = sq;
	}
	
	public Searcher() {
		txtIn = "";
	}
	
	public String getSequence() {
		String code = "";
		//String searchWord = "SV=2";
		int loc = 0;
		int caps10 = 0;
		String sequence = "";
		// get code from url,erl
		try {
			
			URL page = new URL(erl);
			BufferedReader in = new BufferedReader(
			new InputStreamReader(page.openStream()));

			String inputLine;
			while ((inputLine = in.readLine()) != null)
				code += inputLine;
			in.close();
		} catch(Exception e) { System.out.println("Error happened"); }
		
        // code is now all page code now do searching
        // through code
		System.out.println(code);
        boolean found = false;
		String retWord = "";
		char ch;
		int indexx = 0;
		String curWord = "";
		int iter = -1;
		// look for location of beginning of sequence , loc
		do
		{
			iter++;
			curWord = "";
			if (iter < (code.length() - 11))
			{	
				// curWord will be 10 chars at a time cycling through code
				for (int i = iter; i < (iter + 10); i++)
				{
					curWord += code.charAt(i); 
				}
				System.out.println(curWord);
				// check if curWord is all caps and no spaces
				// then we have begun the AA sequence
				for (int i = 0; i < 10; i++)
				{
					ch = curWord.charAt(i);
					if (Character.isLetter(ch) && Character.isUpperCase(ch))
					{
						caps10 += 1;
						//System.out.println("caps10: " + caps10);
						//System.out.println("ch: " + ch);
					}
				}
				if (caps10 == 10)
				{
					loc = iter;
					found = true;
				}
				else
				{
					caps10 = 0;
				}
			} // end if (iter < (code.lenght() - 11)
		} while (found == false);
		/*
		if (found == true)
		{
			do
			{
				indexx += 1;
				ch = code.charAt(indexx);
				retWord += String.valueOf(ch);
			} while (indexx < (code.length() - 1));
		}
		System.out.print("word: ");
		System.out.println(searchWord);
		if (found == true)
			System.out.println("Found");
		else
			System.out.println("Not Found");
		return retWord;      */
		System.out.println("location: " + loc);
		for (int i = loc; i < code.length(); i++)
		{
			sequence += code.charAt(i);
		}
		return sequence;
	}
	
	public void convertForUrl(){
		String start = this.txtIn;
		String finish = "";
		char ch;
		for (int i = 0; i < start.length(); i++)
		{
			ch = start.charAt(i);
			if (ch == ' ')
			{
				finish += '+';
			}
			else
			{
				finish += String.valueOf(ch);
			}
		} // end for i
		erl = "http://www.uniprot.org/uniprot/?query=" + finish + "&sort=score";
	} // end converForUrl()
	
	public void getUPcode() {
		int loc = 0;
		String curWord = "";
		String section = "";
		String UPcode = "";
		boolean found = false;
		int proLength = txtIn.length();
		String code = "";
		String searchWord = txtIn;
		
		// get code from url,erl
		try {
			
			URL page = new URL(erl);
			BufferedReader in = new BufferedReader(
			new InputStreamReader(page.openStream()));

			String inputLine;
			while ((inputLine = in.readLine()) != null)
				code += inputLine;
			in.close();
		} catch(Exception e) { System.out.println("Error happened"); }
		
		// search
		int iter = -1;
		//System.out.println(searchWord);
		do
		{
			do
			{
				section = "";
				iter++;
				found = false;
				curWord = "";
				for (int j = iter; j < (searchWord.length() + iter); j++)
				{
					curWord += code.charAt(j);
					if (curWord.equals(searchWord))
					{
						found = true;
					//	System.out.println("Found it");
						loc = j;
					}
				} // end for j
			} while (found == false);
			
			// go back in code to look for UniProt number
			loc -= 500;
			for (int i = loc; i < (loc + 500); i++)
			{
				section += code.charAt(i);
			}
			System.out.println(section + "\ncontains human: " + section.contains("HUMAN"));
		} while (section.contains("HUMAN") == false);
		// in this section of code look for code and HUMAN
		// UP code is after <a href="/uniprot/  its 6 chars
		searchWord = "<a href=\"/uniprot/";
		found = false;
		curWord = "";
		iter = -1;
		do
		{
			curWord = "";
			iter++;
			for (int i = iter; i < (section.length() - 20); i++)
			{
				curWord += section.charAt(i);
				if (curWord.equals(searchWord))
				{
					found = true;
					loc = i;
				}
			} // end for i
		} while (found == false);
		
		// got location (loc) of UP code now get next 6 chars
		loc += 1;
		for (int i = loc; i < (loc + 6); i++)
		{
			UPcode += section.charAt(i);
		}
		
		// got UP code now set erl
		erl = "http://www.uniprot.org/uniprot/" + UPcode + ".fasta";
		System.out.println(erl);
	} // end getUPcode()
	
	public String getErl(){
		return this.erl;
	}
	
	public void setTxtIn(String t) {
		txtIn = t;
	}

}

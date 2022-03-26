package com.receptive;

public class Receptor {
	private String sequence;
	private String drugClass;
	private String specific;
	private int seqLength;
	
	public Receptor() {
		sequence = "";
		drugClass = "";
		specific = "";
		seqLength = 0;
	}
	
	public void setFiveHt(int i) {
	
		System.out.println("i: " + i);
		drugClass = "serotonin";
		switch (i) {
		case 0:
		{
			specific = "5-hydroxytryptamine receptor 1A";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			seqLength = sequence.length();
			break;
		}
		case 1:
		{
			specific = "5-hydroxytryptamine receptor 1B";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}          
		case 2:
		{
			specific = "5-hydroxytryptamine receptor 1D";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 3:
		{
			specific = "5-hydroxytryptamine receptor 2A";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 4:
		{
			specific = "5-hydroxytryptamine receptor 2B";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 5:
		{
			specific = "5-hydroxytryptamine receptor 2C";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 6:
		{
			specific = "5-hydroxytryptamine receptor 3A";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 7:
		{
			specific = "5-hydroxytryptamine receptor 3B";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 8:
		{
			specific = "5-hydroxytryptamine receptor 4";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 9:
		{
			specific = "5-hydroxytryptamine receptor 5A";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 10:
		{
			specific = "5-hydroxytryptamine receptor 7";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}        
		
		} // end switch
		seqLength = sequence.length();
	} // end setFiveHt()
	
	public void setGaba(int i) {
		System.out.println("i: " + i);
		drugClass = "gaba";
		switch (i) {
		case 0:
		{
			specific = "Gamma-aminobutyric acid receptor subunit alpha-1";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 1:
		{
			specific = "Gamma-aminobutyric acid receptor subunit alpha-2";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}          
		case 2:
		{
			specific = "Gamma-aminobutyric acid receptor subunit alpha-3";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 3:
		{
			specific = "Gamma-aminobutyric acid receptor subunit alpha-4";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 4:
		{
			specific = "Gamma-aminobutyric acid receptor subunit alpha-5";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 5:
		{
			specific = "Gamma-aminobutyric acid receptor subunit alpha-6";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 6:
		{
			specific = "Gamma-aminobutyric acid receptor subunit beta-1";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 7:
		{
			specific = "Gamma-aminobutyric acid receptor subunit beta-2";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 8:
		{
			specific = "Gamma-aminobutyric acid receptor subunit gamma-2";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 9:
		{
			specific = "Gamma-aminobutyric acid receptor subunit delta";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}

		} // end switch
		seqLength = sequence.length();
	} // end setGaba()
	
	
	public void setDopa(int i) {
		System.out.println("i: " + i);
		drugClass = "dopamine";
		switch (i) {
		case 0:
		{
			specific = "D(1A) dopamine receptor";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 1:
		{
			specific = "D(1B) dopamine receptor";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}          
		case 2:
		{
			specific = "D(2) dopamine receptor";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 3:
		{
			specific = "D(3) dopamine receptor";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}
		case 4:
		{
			specific = "D(4) dopamine receptor";
			Searcher seq = new Searcher(specific);
			seq.convertForUrl();
			seq.getUPcode();
			sequence = seq.getSequence();
			break;
		}

		} // end switch
		seqLength = sequence.length();
	} // end setGaba()
	
	public String getSpecific() {
		return specific;
	}
	
	public String getSequence() {
		return this.sequence;
	}
	
	public int getSeqLength() {
		return seqLength;
	}
}

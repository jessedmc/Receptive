package com.receptive;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;

public class WinMain {

	protected Shell shell;
	private Text txtPro;
	private Button btnSet;
	private Button btnSeqList;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WinMain window = new WinMain();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(915, 603);
		shell.setText("SWT Application");
		
		Button btnShowSequence = new Button(shell, SWT.NONE);
		btnShowSequence.setBounds(48, 37, 148, 48);
		btnShowSequence.setText("Show Sequence");
		
		Label lblSequence = new Label(shell, SWT.WRAP);
		lblSequence.setText("Sequence");
		lblSequence.setBounds(216, 74, 587, 209);
		
		List lstRec = new List(shell, SWT.BORDER | SWT.V_SCROLL);
		lstRec.setBounds(48, 356, 314, 175);
		
		txtPro = new Text(shell, SWT.BORDER);
		txtPro.setBounds(216, 37, 206, 21);
		
		btnSet = new Button(shell, SWT.NONE);
		
		// create receptor objects
		// 5-HT
		Receptor[] fiveHt = new Receptor[11];
		for (int i = 0; i < 11; i++)
		{
			fiveHt[i] = new Receptor();
		}
		
		// GABA
		Receptor[] gaba = new Receptor[10];
		for (int i = 0; i < 10; i++)
		{
			gaba[i] = new Receptor();
		}
		
		// Dopa
		Receptor[] dopa = new Receptor[5];
		for (int i = 0; i < 5; i++)
		{
			dopa[i] = new Receptor();
		}
		
		// Set all receptors
		btnSet.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				// 5-HT
				
				for (int i = 0; i < 11; i++)
				{
					fiveHt[i].setFiveHt(i);
				}     
				System.out.println("5ht lengths: ");
				for (int loopIndex = 0; loopIndex < 11; loopIndex++) 
				{
					lstRec.add(fiveHt[loopIndex].getSpecific());
					System.out.print(fiveHt[loopIndex].getSeqLength() + " ");
				} 
				
				// GABA
				
				for (int i = 0; i < 10; i++)
				{
					gaba[i].setGaba(i);
				}
				System.out.println("gaba lengths: ");
				for (int loopIndex = 0; loopIndex < 10; loopIndex++) 
				{
					lstRec.add(gaba[loopIndex].getSpecific());
					System.out.print(gaba[loopIndex].getSeqLength() + " ");
				}
				
				// Dopa
				for (int i = 0; i < 5; i++)
				{
					dopa[i].setDopa(i);
				}
				System.out.println("dopa lengths: ");
				for (int loopIndex = 0; loopIndex < 5; loopIndex++)
				{
					lstRec.add(dopa[loopIndex].getSpecific());
					System.out.print(dopa[loopIndex].getSeqLength() + " ");
				}
			}
		});
		btnSet.setBounds(48, 114, 148, 38);
		btnSet.setText("Set");
		
		btnSeqList = new Button(shell, SWT.NONE);
		btnSeqList.setBounds(48, 325, 129, 25);
		btnSeqList.setText("Show Sequence");
		
		// show sequence from the list
		btnSeqList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String selected[] = lstRec.getSelection();
				int indicey[] = lstRec.getSelectionIndices();
				
				if (indicey[0] < 11)
				{
					lblSequence.setText(fiveHt[indicey[0]].getSequence());
				}
				
				// list indices 0 to 10 will match 5ht indices
				// list indices > 10 and < 21 for gaba 
				// list indices > 20 are dopa
				// will be offset
				if ((indicey[0] > 10) && (indicey[0] < 21))
				{
					indicey[0] -= 11;
					lblSequence.setText(gaba[indicey[0]].getSequence());
				}
				
				if (indicey[0] > 20)
				{
					indicey[0] -= 21;
					lblSequence.setText(dopa[indicey[0]].getSequence());
				}
					
		
			}
		});
		
		
		btnShowSequence.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// seq data of textbox is protein to search for
				Searcher seq = new Searcher(txtPro.getText());
				seq.convertForUrl();
				seq.getUPcode();
				lblSequence.setText(seq.getSequence());
				seq = null;
				//lblSequence.setText(seq.getErl());
			}
		});

	}
}

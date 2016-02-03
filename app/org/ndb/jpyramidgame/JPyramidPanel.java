/*
 * Created on Oct 30, 2005
 *
 */
package org.ndb.jpyramidgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.ndb.jpyramidgame.pyramidsolver.IPyramid;
import org.ndb.jpyramidgame.pyramidsolver.PyramidDifference;
import org.ndb.jpyramidgame.pyramidsolver.PyramidFactory;
import org.ndb.jpyramidgame.pyramidsolver.PyramidHelper;
import org.ndb.jpyramidgame.pyramidsolver.PyramidSolver;

public class JPyramidPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7946141099216808063L;

	private CheckPyramidPanel checkPyramidPanel = null;

	private JScrollPane jScrollPane = null;

	private JTextArea jTextArea = null;

	private JPanel solvePanel = null;

	private JButton jSolve = null;

	private JButton jNext = null;

	private JButton jPrev = null;
	
	private JButton jReset = null;

	/**
	 * This is the default constructor
	 */
	public JPyramidPanel() {
		super();
		initialize();

	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {

		this.setLayout(new BorderLayout());
		this.setSize(300, 205);
		this.add(getCheckPyramidPanel(), java.awt.BorderLayout.WEST);
		this.add(getJScrollPane(), java.awt.BorderLayout.EAST);

		solvePanel = new JPanel();
		solvePanel.setLayout(new FlowLayout());
		solvePanel.add(getJPrev(), null);
		solvePanel.add(getJSolve(), null);
		solvePanel.add(getJNext(), null);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));

		bottomPanel.add(solvePanel, null);

		JPanel tempJPanel = new JPanel();
		tempJPanel.setLayout(new FlowLayout());
		
		tempJPanel.add(getJRandom(), null);
		tempJPanel.add(getJReset(), null);
		
		bottomPanel.add(tempJPanel);

		this.add(bottomPanel, BorderLayout.SOUTH);
	}

	/**
	 * This method initializes checkPyramidPanel
	 * 
	 * @return org.ndb.jpyramidgame.CheckPyramidPanel
	 */
	private CheckPyramidPanel getCheckPyramidPanel() {
		if (checkPyramidPanel == null) {
			checkPyramidPanel = new CheckPyramidPanel();
		}
		return checkPyramidPanel;
	}

	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane
					.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			jScrollPane
					.setHorizontalScrollBarPolicy(javax.swing.JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			jScrollPane.setViewportView(getJTextArea());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTextArea
	 * 
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea(" ", 20, 13);
			jTextArea.setFont(new java.awt.Font("Lucida Console",
					java.awt.Font.BOLD, 12));
			jTextArea.setRows(10);
			jTextArea.setEditable(false);
		}
		return jTextArea;
	}

	/**
	 * This method initializes jSolve
	 * 
	 * @return javax.swing.JButton
	 */

	List<IPyramid> pyrs = new ArrayList<IPyramid>();
	int index = 0;

	private JButton jRandom = null;

	private JButton getJSolve() {
		if (jSolve == null) {
			jSolve = new JButton();
			jSolve.setText("Solve");
			jSolve.setMnemonic(java.awt.event.KeyEvent.VK_S);
			jSolve.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					onSolve();
				}
			});
		}
		return jSolve;
	}

	/**
	 * This method initializes jNext
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJNext() {
		if (jNext == null) {
			jNext = new JButton();
			jNext.setText("-->");
			jNext.setToolTipText("Step forward...");
			jNext.setEnabled(false);
			jNext.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					onNext();
				}

			});
		}
		return jNext;
	}

	/**
	 * This method initializes jPrev
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJPrev() {
		if (jPrev == null) {
			jPrev = new JButton();
			jPrev.setText("<--");
			jPrev.setToolTipText("Step backward...");
			jPrev.setEnabled(false);
			jPrev.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					onPrevious();
				}
			});
		}
		return jPrev;
	}

	/**
	 * 
	 */
	private void onNext() {
		index++;
		if (index >= pyrs.size() - 1)
			jNext.setEnabled(false);

		if (index > 0)
			jPrev.setEnabled(true);

		checkPyramidPanel.setPyramid(pyrs.get(index));
		checkPyramidPanel.resetAllColor();
		getDifferences();
	}

	/**
	 * 
	 */
	private void onPrevious() {
		index--;
		if (index <= 0)
			jPrev.setEnabled(false);

		if (index < pyrs.size() - 1)
			jNext.setEnabled(true);

		checkPyramidPanel.setPyramid(pyrs.get(index));
		checkPyramidPanel.resetAllColor();
		getDifferences();
	}

	/**
	 * 
	 */
	private void onSolve() {
		jNext.setEnabled(false);
		jPrev.setEnabled(false);
		index = 0;

		boolean[] bools = checkPyramidPanel.getBooleans();
		boolean[] tempbools = new boolean[bools.length];

		// System.arraycopy(bools,0,tempbools,0,bools.length);
		// we are going to iterate through them anyway, we might as well just
		// copy them
		// them in the for loop
		int count = 0;
		for (int i = 0; i < bools.length; ++i) {
			boolean b = tempbools[i] = bools[i];
			if (b) {
				count++;
			}
		}

		if (count <= 0) {
			JOptionPane.showMessageDialog(JPyramidPanel.this,
					"At least one box must be checked!");
		} else if (count >= 15) {
			JOptionPane.showMessageDialog(JPyramidPanel.this,
					"At least one box must be left unchecked!");
		} else {

			IPyramid p = PyramidFactory.newPyramid(tempbools, null);
			PyramidSolver ps = new PyramidSolver(p);
			long start = System.currentTimeMillis();
			pyrs = ps.solve();
			long end = System.currentTimeMillis();

			System.out.println("Start: " + start);
			System.out.println("End: " + end);
			System.out.println("Time: " + (end - start) / 1000.0 + " seconds");

			if (pyrs != null && pyrs.size() > 0) {
				jTextArea.setText(PyramidHelper.textSolution(pyrs));
				jTextArea.setCaretPosition(0);

				getDifferences();

				if (pyrs.size() > 1) {
					jNext.setEnabled(true);
					return;
				}
			} else {
				checkPyramidPanel.resetAllColor();
				JOptionPane.showMessageDialog(JPyramidPanel.this,
						"This pyramid is unsolvable!");
			}
		}

		jNext.setEnabled(false);
		jPrev.setEnabled(false);
	}

	void getDifferences() {

		PyramidDifference pd = PyramidHelper.getDifferences(pyrs, index);

		checkPyramidPanel.setColor(pd.getRed(), Color.RED);
		checkPyramidPanel.setColor(pd.getGreen(), Color.GREEN);
		checkPyramidPanel.setColor(pd.getYellow(), Color.YELLOW);

	}

	public void generateRandom() {
		IPyramid p = PyramidFactory.generateRandom();
		checkPyramidPanel.setPyramid(p);
	}
	
	public void reset() {
		checkPyramidPanel.reset();
		jNext.setEnabled(false);
		jPrev.setEnabled(false);
		jTextArea.setText("");
	}

	/**
	 * This method initializes jRandom
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJRandom() {
		if (jRandom == null) {
			jRandom = new JButton();
			jRandom.setText("Random");
			jRandom
					.setComponentOrientation(java.awt.ComponentOrientation.UNKNOWN);
			jRandom.setToolTipText("Generates a random pyramid...");
			jRandom.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					checkPyramidPanel.resetAllColor();
					JPyramidPanel.this.generateRandom();
				}
			});
		}
		return jRandom;
	}
	
	/**
	 * This method initializes jReset
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJReset() {
		if (jReset == null) {
			jReset = new JButton();
			jReset.setText("Reset");
			jReset
					.setComponentOrientation(java.awt.ComponentOrientation.UNKNOWN);
			jReset.setToolTipText("Resets the pyramid...");
			jReset.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JPyramidPanel.this.reset();
				}
			});
		}
		return jReset;
	}

} // @jve:decl-index=0:visual-constraint="11,9"

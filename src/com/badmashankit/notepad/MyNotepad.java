/**
 * Copyright (C) 2017 Ankit Shukla, http://badmashankit.com
 * 
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.badmashankit.notepad;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyNotepad extends JFrame {
	private static final long serialVersionUID = 1L;

	public MyNotepad() {
		super("MyNotepad");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(500, 500));
		setupView();
		setVisible(true);
	}
	
	public void setupView() {
		JPanel mainPanel = new JPanel();
		mainPanel.add(new JScrollPane(new JTextArea(20, 100)));
		getContentPane().add(mainPanel);
		pack();
	}
}

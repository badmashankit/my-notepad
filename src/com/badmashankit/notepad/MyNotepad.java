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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyNotepad extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private JMenuBar menuBar;
	private JMenu file;
	private JMenu edit;
	private JMenu format;
	private JMenu help;
	private JMenuItem newFile;
	private JMenuItem openFile;
	private JMenuItem saveFile;
	private JMenuItem exitFile;
	private JFileChooser fileChooser;
	private static String DEFAULT_TITLE = "MyNotepad";

	public MyNotepad() {
		super("Untitled - " + DEFAULT_TITLE);
		textArea = new JTextArea();
		menuBar = new JMenuBar();
		fileChooser = new JFileChooser();
		file = new JMenu("File");
		edit = new JMenu("Edit");
		format = new JMenu("Format");
		help = new JMenu("Help");
		newFile = new JMenuItem("New             Ctrl+N");
		openFile = new JMenuItem("Open            Ctrl+O");
		saveFile = new JMenuItem("Save            Ctrl+S");
		exitFile = new JMenuItem("Exit");
		setupView();
		addActionListeners();
		setVisible(true);
	}

	private void setupView() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(500, 500));
		setLayout(new BorderLayout());
		setJMenuBar(menuBar);
		add(new JScrollPane(textArea));
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(format);
		menuBar.add(help);
		file.add(newFile);
		file.add(openFile);
		file.add(saveFile);
		file.add(exitFile);
	}

	private void addActionListeners() {
		saveFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showSaveDialog(rootPane) == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					PrintWriter pw = null;
					try {
						pw = new PrintWriter(file);
						pw.print(textArea.getText());
					} catch (FileNotFoundException ex) {
						ex.printStackTrace();
					} finally {
						pw.flush();
						pw.close();
						setTitle(file.getName() + " - " + DEFAULT_TITLE);
					}
				}
			}
		});
		
		exitFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}

package gui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;

import net.atlanticbb.tantlinger.shef.HTMLEditorPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HTMLEditor extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;
	HTMLEditorPane editor = null;

	/**
	 * Auto-generated main method to display this JDialog
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				HTMLEditor inst = new HTMLEditor(frame);
				inst.setVisible(true);
			}
		});
	}

	private HTMLEditor() {
		setHTMLEditor();
	}

	public HTMLEditor(String s) {
		this();
		editor.setText(s);
		initGUI();
	}

	public HTMLEditor(JFrame frame) {
		super(frame);
		initGUI();
		setHTMLEditor();
	}

	private void setHTMLEditor() {
		editor = new HTMLEditorPane();
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(editor.getEditMenu());
		menuBar.add(editor.getFormatMenu());
		menuBar.add(editor.getInsertMenu());
		setJMenuBar(menuBar);
		getContentPane().add(editor, BorderLayout.CENTER);

	}

	private void initGUI() {
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);

		JButton btOK = new JButton("OK");
		btOK.setMnemonic('o');
		btOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = editor.getText();
				System.out.println(s);
				dispose();
			}
		});
		panel.add(btOK);

		JButton btCancel = new JButton("Cancel");
		btCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btCancel.setMnemonic('c');
		panel.add(btCancel);

		try {
			setSize(527, 452);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

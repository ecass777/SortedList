// SortedListGUI.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SortedListGUI extends JFrame {

    private SortedList sortedList;
    private JTextField addTextField;
    private JButton addButton;
    private JTextField searchTextField;
    private JButton searchButton;
    private JTextArea textArea;

    public SortedListGUI() {
        super("SortedList GUI");

        sortedList = new SortedList();

        // Create components
        addTextField = new JTextField(20);
        addButton = new JButton("Add");
        searchTextField = new JTextField(20);
        searchButton = new JButton("Search");
        textArea = new JTextArea(15, 30);
        textArea.setEditable(false);

        // Layout components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Add String:"));
        inputPanel.add(addTextField);
        inputPanel.add(addButton);

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        searchPanel.add(new JLabel("Search String:"));
        searchPanel.add(searchTextField);
        searchPanel.add(searchButton);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(inputPanel, BorderLayout.NORTH);
        controlPanel.add(searchPanel, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(textArea);

        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Add listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = addTextField.getText();
                if (!s.isEmpty()) {
                    sortedList.add(s);
                    textArea.append("Added: " + s + "\n");
                    displayList();
                    addTextField.setText("");
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = searchTextField.getText();
                if (!s.isEmpty()) {
                    int index = sortedList.binarySearch(s);
                    if (index >= 0) {
                        textArea.append("Found '" + s + "' at index " + index + "\n");
                    } else {
                        int insertionPoint = -index - 1;
                        textArea.append("'" + s + "' not found. It would be at index " + insertionPoint + "\n");
                    }
                    searchTextField.setText("");
                }
            }
        });

        // Finalize frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void displayList() {
        ArrayList<String> list = sortedList.getList();
        textArea.append("Current List:\n");
        for (int i = 0; i < list.size(); i++) {
            textArea.append(i + ": " + list.get(i) + "\n");
        }
        textArea.append("\n");
    }

    public static void main(String[] args) {
        new SortedListGUI();
    }
}

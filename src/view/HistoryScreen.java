package view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HistoryScreen extends JPanel {
    private JTextField titleTxtField;
    private JTable historyTable;
    private JScrollPane scrollPane;
    private JButton menuBtn;
    private ActionListener actionListener;
    private Color orange = new Color(255, 138, 0);
    private Color white = new Color(255, 255, 255);

    public HistoryScreen(ActionListener actionListener, ArrayList<String> history) {
        this.actionListener = actionListener;

        setLayout(null);
        setBounds(0, 0, 400, 400);
        setBackground(white);
        setBorder(BorderFactory.createLineBorder(orange, 10));

        titleTxtField = new JTextField();
        titleTxtField.setBounds(25, 28, 350, 74);
        titleTxtField.setText("Game History");
        titleTxtField.setHorizontalAlignment(JTextField.CENTER);
        titleTxtField.setFont(new Font("Inter", Font.BOLD, 36));
        titleTxtField.setBackground(white);
        titleTxtField.setForeground(Color.BLACK);
        titleTxtField.setBorder(BorderFactory.createLineBorder(orange, 5));
        titleTxtField.setEditable(false);

        add(titleTxtField);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NICKNAME");
        model.addColumn("FIGURE");
        model.addColumn("RESULT");
        model.addColumn("DATE");

        for (int i = 0; i < history.size(); i++) {
            String rowData = history.get(i);
            if (rowData != null && !rowData.isEmpty()) {
                String[] data = rowData.split(";");
                model.addRow(data);
            }
        }

        historyTable = new JTable(model);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        historyTable.setDefaultRenderer(Object.class, centerRenderer);

        historyTable.setDefaultEditor(Object.class, null);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.LEFT);
        historyTable.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);

        historyTable.getTableHeader().setFont(new Font("Inter", Font.BOLD, 12));
        historyTable.getTableHeader().setBackground(orange);
        historyTable.getTableHeader().setForeground(white);

        historyTable.getColumnModel().getColumn(0).setPreferredWidth(45);
        historyTable.getColumnModel().getColumn(1).setPreferredWidth(1);
        historyTable.getColumnModel().getColumn(2).setPreferredWidth(1);

        historyTable.setFont(new Font("Inter", Font.PLAIN, 12));
        historyTable.setBackground(white);
        historyTable.setForeground(Color.BLACK);

        scrollPane = new JScrollPane(historyTable);
        scrollPane.setBounds(25, 124, 350, 185);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setWheelScrollingEnabled(true);
        scrollPane.getViewport().setPreferredSize(new Dimension(343, 185));

        add(scrollPane);

        menuBtn = new JButton("Menu");
        menuBtn.setBounds(160, 331, 80, 35);
        menuBtn.setFont(new Font("Inter", Font.BOLD, 18));
        menuBtn.setForeground(Color.BLACK);
        menuBtn.setBackground(white);
        menuBtn.setBorder(BorderFactory.createLineBorder(orange, 4));
        menuBtn.setFocusable(false);

        menuBtn.addActionListener(actionListener);
        menuBtn.setActionCommand("histMenuBtn");

        menuBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuBtn.setBackground(orange);
                menuBtn.setForeground(white);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuBtn.setBackground(white);
                menuBtn.setForeground(Color.BLACK);
            }
        });

        add(menuBtn);

    }


}

package com.trash.view;

import com.trash.controller.HistoryController;
import com.trash.model.HistoryModel;
import com.trash.controller.WasteController;
import com.trash.model.WasteModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class MainView extends JFrame {

    public MainView() {
        setTitle("e-Waste");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
    }

    private void initUI() {
        // Panel utama dengan layout GridBagLayout
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(0, 51, 0)); // Warna hijau tua sebagai latar belakang panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Jarak antar elemen
        gbc.fill = GridBagConstraints.HORIZONTAL; // Tombol memenuhi lebar panel

        // Menambahkan label di atas dengan GridBagConstraints
        JLabel lblTitle = new JLabel("E-Waste", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24)); // Mengubah font dan ukuran
        lblTitle.setForeground(Color.WHITE); // Warna teks putih
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Membuat label lebih lebar
        panel.add(lblTitle, gbc);

        // Spasi di bawah label
        gbc.gridy = 1;
        panel.add(new JLabel(" "), gbc);

        // Tombol dengan GridBagConstraints teratur
        gbc.gridwidth = 1; // Tombol menggunakan satu kolom

        // Tombol dengan desain khusus
        JButton btnAddWaste = createButton("Add Waste", e -> openAddWasteDialog());
        styleButton(btnAddWaste); // Menata tombol
        gbc.gridy = 2;
        panel.add(btnAddWaste, gbc);

        JButton btnViewWaste = createButton("View Waste", e -> openViewWasteDialog());
        styleButton(btnViewWaste);
        gbc.gridy = 3;
        panel.add(btnViewWaste, gbc);

        JButton btnSearchWaste = createButton("Search Waste", e -> openSearchWasteDialog());
        styleButton(btnSearchWaste);
        gbc.gridy = 4;
        panel.add(btnSearchWaste, gbc);

        JButton btnReports = createButton("Generate Report", e -> generatePdfReport());
        styleButton(btnReports);
        gbc.gridy = 5;
        panel.add(btnReports, gbc);

        JButton btnSummary = createButton("View Summary", e -> openSummaryDialog());
        styleButton(btnSummary);
        gbc.gridy = 6;
        panel.add(btnSummary, gbc);

        JButton btnRefresh = createButton("Refresh", e -> refreshView());
        styleButton(btnRefresh);
        gbc.gridy = 7;
        panel.add(btnRefresh, gbc);

        JButton btnHistory = createButton("View History", e -> openHistoryDialog());
        styleButton(btnHistory);
        gbc.gridy = 8;
        panel.add(btnHistory, gbc);

        JButton btnRequestPickup = createButton("Request Pickup", e -> openRequestPickupDialog());
        styleButton(btnRequestPickup);
        gbc.gridy = 9;
        panel.add(btnRequestPickup, gbc);

        // Menambahkan panel ke dalam frame
        add(panel, BorderLayout.CENTER);
    }

    // Fungsi untuk menata tombol dengan warna dan desain yang konsisten
    private void styleButton(JButton button) {
        button.setPreferredSize(new Dimension(200, 50)); // Ukuran tombol
        button.setBackground(new Color(102, 204, 0)); // Warna hijau muda
        button.setForeground(Color.WHITE); // Warna teks putih
        button.setFont(new Font("Arial", Font.PLAIN, 18)); // Ukuran dan font teks tombol
        button.setFocusPainted(false); // Menghilangkan border saat tombol dipilih
        button.setBorder(BorderFactory.createEmptyBorder()); // Menghilangkan border tombol
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Menambahkan cursor tangan
    }



    private JButton createButton(String text, java.awt.event.ActionListener actionListener) {
        JButton button = new JButton(text);
        button.addActionListener(actionListener);
        button.setPreferredSize(new Dimension(200, 40)); // Same size for all buttons
        return button;
    }

    private void refreshView() {
        WasteController controller = new WasteController();
        List<WasteModel> wasteList = controller.getAllWaste();
        JOptionPane.showMessageDialog(this, "Data refreshed!", "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void generatePdfReport() {
        WasteController controller = new WasteController();
        String filePath = "e_waste_report.pdf";
        controller.generatePdfReport(filePath);
        JOptionPane.showMessageDialog(this, "PDF Report generated at " + filePath, "Report Generated", JOptionPane.INFORMATION_MESSAGE);
    }

    private void openSearchWasteDialog() {
        JDialog dialog = new JDialog(this, "Search Waste", true);
        dialog.setSize(600, 400);
        dialog.setLayout(new BorderLayout());

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        JLabel lblKeyword = new JLabel("Keyword:");
        JTextField txtKeyword = new JTextField(20);
        JButton btnSearch = new JButton("Search");

        searchPanel.add(lblKeyword);
        searchPanel.add(txtKeyword);
        searchPanel.add(btnSearch);

        String[] columnNames = {"ID", "Category", "Description"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        btnSearch.addActionListener(e -> {
            String keyword = txtKeyword.getText();
            if (!keyword.isEmpty()) {
                WasteController controller = new WasteController();
                List<WasteModel> searchResults = controller.searchWaste(keyword);
                tableModel.setRowCount(0); // Clear previous results
                for (WasteModel waste : searchResults) {
                    Object[] row = {waste.getId(), waste.getCategory(), waste.getDescription()};
                    tableModel.addRow(row);
                }
            } else {
                JOptionPane.showMessageDialog(dialog, "Please enter a keyword to search.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        dialog.add(searchPanel, BorderLayout.NORTH);
        dialog.add(scrollPane, BorderLayout.CENTER);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void openAddWasteDialog() {
        JDialog dialog = new JDialog(this, "Add Waste", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(3, 2));

        JLabel lblCategory = new JLabel("Category:");
        JTextField txtCategory = new JTextField();
        JLabel lblDescription = new JLabel("Description:");
        JTextField txtDescription = new JTextField();
        JButton btnSave = new JButton("Save");

        btnSave.addActionListener(e -> {
            String categoryName = txtCategory.getText();
            String description = txtDescription.getText();

            if (categoryName.isEmpty() || description.isEmpty()) {
                JOptionPane.showMessageDialog(dialog, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                WasteController controller = new WasteController();
                int categoryId = controller.getCategoryIdByName(categoryName);

                if (categoryId == -1) {
                    JOptionPane.showMessageDialog(dialog, "Category not found!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                WasteModel waste = new WasteModel(categoryId, description, description);
                if (controller.addWaste(waste)) {
                    JOptionPane.showMessageDialog(dialog, "Waste added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "Failed to add waste.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        dialog.add(lblCategory);
        dialog.add(txtCategory);
        dialog.add(lblDescription);
        dialog.add(txtDescription);
        dialog.add(new JLabel());
        dialog.add(btnSave);

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void openViewWasteDialog() {
        JDialog dialog = new JDialog(this, "View Waste", true);
        dialog.setSize(600, 400);

        String[] columnNames = {"ID", "Category", "Description"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        WasteController controller = new WasteController();
        List<WasteModel> wasteList = controller.getAllWaste();
        for (WasteModel waste : wasteList) {
            Object[] row = {waste.getId(), waste.getCategory(), waste.getDescription()};
            tableModel.addRow(row);
        }

        JScrollPane scrollPane = new JScrollPane(table);

        JButton btnEdit = new JButton("Edit");
        JButton btnDelete = new JButton("Delete");

        btnEdit.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                String categoryName = (String) tableModel.getValueAt(selectedRow, 1);
                String description = (String) tableModel.getValueAt(selectedRow, 2);

                String newCategoryName = JOptionPane.showInputDialog(dialog, "Update Category:", categoryName);
                String newDescription = JOptionPane.showInputDialog(dialog, "Update Description:", description);

                if (newCategoryName != null && newDescription != null) {
                    int categoryId = controller.getCategoryIdByName(newCategoryName);

                    if (categoryId == -1) {
                        JOptionPane.showMessageDialog(dialog, "Category not found!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (controller.updateWaste(id, categoryId, newDescription)) {
                        JOptionPane.showMessageDialog(dialog, "Waste updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        tableModel.setValueAt(newCategoryName, selectedRow, 1);
                        tableModel.setValueAt(newDescription, selectedRow, 2);
                    } else {
                        JOptionPane.showMessageDialog(dialog, "Failed to update waste.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(dialog, "Please select a row to edit.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        btnDelete.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int id = (int) tableModel.getValueAt(selectedRow, 0);
                WasteController controller1 = new WasteController();
                if (controller1.deleteWaste(id)) {
                    JOptionPane.showMessageDialog(dialog, "Waste deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    tableModel.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(dialog, "Failed to delete waste.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(dialog, "Please select a row to delete.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDelete);

        dialog.setLayout(new BorderLayout());
        dialog.add(scrollPane, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    private void openRequestPickupDialog() {
        JDialog dialog = new JDialog(this, "Request Pickup", true);
        dialog.setSize(400, 300);
        dialog.setLayout(new GridLayout(6, 2)); // Perubahan pada jumlah baris

        JLabel lblWasteId = new JLabel("Waste ID:");
        JTextField txtWasteId = new JTextField();
        JLabel lblRequestDate = new JLabel("Request Date:");
        JTextField txtRequestDate = new JTextField();
        JLabel lblWeight = new JLabel("Weight:");
        JTextField txtWeight = new JTextField();  // Input untuk weight
        JLabel lblAddress = new JLabel("Address:");
        JTextField txtAddress = new JTextField();  // Input untuk address
        JButton btnRequest = new JButton("Request Pickup");

        btnRequest.addActionListener(e -> {
            try {
                int wasteId = Integer.parseInt(txtWasteId.getText());
                String requestDate = txtRequestDate.getText();
                double weight = Double.parseDouble(txtWeight.getText());  // Ambil input weight
                String address = txtAddress.getText();  // Ambil input address

                if (requestDate.isEmpty() || address.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Fields cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                HistoryController controller = new HistoryController();
                if (controller.addHistory(wasteId, "Pending", requestDate, null, weight, address)) {
                    JOptionPane.showMessageDialog(dialog, "Pickup request added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    dialog.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialog, "Failed to request pickup.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "Please enter valid data!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        dialog.add(lblWasteId);
        dialog.add(txtWasteId);
        dialog.add(lblRequestDate);
        dialog.add(txtRequestDate);
        dialog.add(lblWeight);
        dialog.add(txtWeight);  // Tambahkan input weight
        dialog.add(lblAddress);
        dialog.add(txtAddress);  // Tambahkan input address
        dialog.add(new JLabel());
        dialog.add(btnRequest);

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }


    private void openHistoryDialog() {
        JDialog dialog = new JDialog(this, "View History", true);
        dialog.setSize(600, 400);

        String[] columnNames = {"ID", "Waste ID", "Status", "Request Date", "Pickup Date", "Weight", "Address"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        HistoryController controller = new HistoryController();
        List<HistoryModel> historyList = controller.getHistory();
        for (HistoryModel history : historyList) {
            Object[] row = {history.getId(), history.getWasteId(), history.getStatus(),
                    history.getRequestDate(), history.getPickupDate(),
                    history.getWeight(), history.getAddress()};  // Tambahkan weight dan address
            tableModel.addRow(row);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        dialog.add(scrollPane);

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }


    private void openSummaryDialog() {
        WasteController controller = new WasteController();
        int totalWaste = controller.getTotalWasteCount();
        List<String> categories = controller.getUniqueCategories();

        StringBuilder summary = new StringBuilder();
        summary.append("Total Waste Entries: ").append(totalWaste).append("\n\n");
        summary.append("Categories: \n");
        for (String category : categories) {
            summary.append("- ").append(category).append("\n");
        }

        JOptionPane.showMessageDialog(this, summary.toString(), "Waste Summary", JOptionPane.INFORMATION_MESSAGE);
    }
}

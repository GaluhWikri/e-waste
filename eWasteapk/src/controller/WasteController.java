
package controller;

import db.DatabaseConnector;
import model.WasteModel;
import model.RequestPickupModel;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;




public class WasteController {


    // Menambah data waste
    public boolean addWaste(WasteModel waste) {
        String query = "INSERT INTO waste (category_id, description) VALUES (?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, waste.getCategoryId());
            stmt.setString(2, waste.getDescription());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Mengambil semua data waste
    public List<WasteModel> getAllWaste() {
        List<WasteModel> wasteList = new ArrayList<>();
        String query = "SELECT w.id, c.name AS category, w.description FROM waste w JOIN category c ON w.category_id = c.id";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String category = rs.getString("category");
                String description = rs.getString("description");
                wasteList.add(new WasteModel(id, category, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wasteList;
    }

    // Menghapus data waste
    public boolean deleteWaste(int id) {
        String query = "DELETE FROM waste WHERE id = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Memperbarui data waste dengan kategori baru
    public boolean updateWaste(int wasteId, int categoryId, String description) {
        String query = "UPDATE waste SET category_id = ?, description = ? WHERE id = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, categoryId);
            stmt.setString(2, description);
            stmt.setInt(3, wasteId);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Mencari data waste berdasarkan keyword
    public List<WasteModel> searchWaste(String keyword) {
        List<WasteModel> wasteList = new ArrayList<>();
        String query = "SELECT w.id, c.name AS category, w.description FROM waste w JOIN category c ON w.category_id = c.id WHERE c.name LIKE ? OR w.description LIKE ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String category = rs.getString("category");
                    String description = rs.getString("description");
                    wasteList.add(new WasteModel(id, category, description));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wasteList;
    }

    // Mengekspor laporan PDF
    public void generatePdfReport(String filePath) {
        List<WasteModel> wasteList = getAllWaste();
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            document.add(new Paragraph("Waste Report"));
            document.add(new Paragraph("Generated on: " + new java.util.Date().toString()));
            document.add(new Paragraph("\n"));

            PdfPTable table = new PdfPTable(3);
            table.addCell("ID");
            table.addCell("Category");
            table.addCell("Description");

            for (WasteModel waste : wasteList) {
                table.addCell(String.valueOf(waste.getId()));
                table.addCell(waste.getCategory());
                table.addCell(waste.getDescription());
            }

            document.add(table);
            document.close();
            System.out.println("PDF Report Generated: " + filePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Mendapatkan jumlah total waste
    public int getTotalWasteCount() {
        String query = "SELECT COUNT(*) AS total FROM waste";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e)            {
            e.printStackTrace();
        }
        return 0;
    }

    // Mendapatkan daftar kategori unik
    public List<String> getUniqueCategories() {
        List<String> categories = new ArrayList<>();
        String query = "SELECT DISTINCT name FROM category";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                categories.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    // Mendapatkan id kategori berdasarkan nama kategori
    public int getCategoryIdByName(String categoryName) {
        String query = "SELECT id FROM category WHERE name = ?";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, categoryName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Kategori tidak ditemukan
    }


    // Request pickup dengan berat dan alamat
    public boolean addRequestPickup(RequestPickupModel request) {
        String query = "INSERT INTO requestpickup (waste_id, pickup_date, status, weight, address) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, request.getWasteId());
            stmt.setDate(2, new java.sql.Date(request.getPickupDate().getTime()));
            stmt.setString(3, request.getStatus());
            stmt.setBigDecimal(4, BigDecimal.valueOf(request.getWeight()));
            stmt.setString(5, request.getAddress());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Fungsi untuk mendapatkan riwayat request pickup
    public List<RequestPickupModel> getRequestHistory() {
        List<RequestPickupModel> pickupList = new ArrayList<>();
        String query = "SELECT rp.id, w.description AS waste_description, rp.pickup_date, rp.status, rp.weight, rp.address " +
                "FROM requestpickup rp JOIN waste w ON rp.waste_id = w.id";
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String wasteDescription = rs.getString("waste_description");
                Date pickupDate = rs.getDate("pickup_date");
                String status = rs.getString("status");
                double weight = rs.getDouble("weight");
                String address = rs.getString("address");

                pickupList.add(new RequestPickupModel(id, wasteDescription, pickupDate, status, weight, address));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pickupList;
    }

}

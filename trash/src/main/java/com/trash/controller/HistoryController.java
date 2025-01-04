package com.trash.controller;

import com.trash.model.HistoryModel;

import java.util.ArrayList;
import java.util.List;

public class HistoryController {

    private List<HistoryModel> historyList = new ArrayList<>();

    public boolean addHistory(int wasteId, String status, String requestDate, String pickupDate, double weight, String address) {
        String query = "INSERT INTO history (waste_id, status, request_date, pickup_date, weight, address) VALUES (?, ?, ?, ?, ?, ?)";
        HistoryModel history = new HistoryModel(wasteId, status, requestDate, pickupDate);
        return historyList.add(history);

    }

    public List<HistoryModel> getHistory() {
        return historyList;
    }

    public boolean updateHistory(int historyId, String status, String pickupDate) {
        String query = "UPDATE history SET status = ?, pickup_date = ? WHERE id = ?";
        for (HistoryModel history : historyList) {
            if (history.getId() == historyId) {
                history.setStatus(status);
                history.setPickupDate(pickupDate);
                return true;
            }
        }
        return false;
    }
}

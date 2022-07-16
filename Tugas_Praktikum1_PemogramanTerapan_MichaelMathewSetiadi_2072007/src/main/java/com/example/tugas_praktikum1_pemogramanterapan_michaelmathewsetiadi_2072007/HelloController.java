package com.example.tugas_praktikum1_pemogramanterapan_michaelmathewsetiadi_2072007;

import com.example.tugas_praktikum1_pemogramanterapan_michaelmathewsetiadi_2072007.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class HelloController {
    public TextField nrp;
    public TextField nama;
    public TextField ipa;
    public TextField ips;
    public TableView<Student> table1;
    public TableColumn<Integer,Student> cNRP;
    public TableColumn<String,Student> cNama;
    public TableColumn<Float,Student> cIPA;
    public TableColumn<Float,Student> cIPS;
    public Button btnAdd;
    public Button btnUpdate;
    public Button btnRemove;
    private int index;

    private ObservableList<Student> oList;


    public void initialize() {
        oList = FXCollections.observableArrayList(
        );
        table1.setItems(oList);
        cNRP.setCellValueFactory(new PropertyValueFactory<>("nrp"));
        cNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        cIPA.setCellValueFactory(new PropertyValueFactory<>("ipa"));
        cIPS.setCellValueFactory(new PropertyValueFactory<>("ips"));
    }
    public void reset(){
        nama.clear();
        nrp.clear();
        ipa.clear();
        ips.clear();
    }
    public void Add(ActionEvent actionEvent) {
        int NRP = Integer.parseInt(nrp.getText());
        String Nama = nama.getText();
        float IPA = Float.parseFloat(ipa.getText());
        float IPS = Float.parseFloat(ips.getText());
        reset();
        oList.add(new Student(NRP,Nama,IPA,IPS));
    }

    public void Update(ActionEvent actionEvent) {
        int NRP = Integer.parseInt(nrp.getText());
        String Nama = nama.getText();
        float IPA = Float.parseFloat(ipa.getText());
        float IPS = Float.parseFloat(ips.getText());
        reset();
        oList.set(index,new Student(NRP,Nama,IPA,IPS));
    }

    public void Delete(ActionEvent actionEvent) {
        int NRP = Integer.parseInt(nrp.getText());
        for (Student std: oList) {
            if (NRP == std.getNrp()) {
                reset();
                oList.remove(std);
                break;
            }
        }
    }

    public void Selected(MouseEvent mouseEvent) {
        if (!table1.getSelectionModel().getSelectedCells().isEmpty()){
            btnAdd.setDisable(true);
            btnUpdate.setDisable(false);
            btnRemove.setDisable(false);
            index = table1.getSelectionModel().getSelectedIndex();
        }

        nrp.setText(String.valueOf(table1.getSelectionModel().getSelectedItem().getNrp()));
        nama.setText(table1.getSelectionModel().getSelectedItem().getNama());
        ipa.setText(String.valueOf(table1.getSelectionModel().getSelectedItem().getIpa()));
        ips.setText(String.valueOf(table1.getSelectionModel().getSelectedItem().getIps()));
    }
}
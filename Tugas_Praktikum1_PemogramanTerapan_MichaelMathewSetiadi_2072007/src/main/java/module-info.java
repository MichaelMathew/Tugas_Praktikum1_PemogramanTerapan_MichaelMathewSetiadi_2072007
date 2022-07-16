module com.example.tugas_praktikum1_pemogramanterapan_michaelmathewsetiadi_2072007 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tugas_praktikum1_pemogramanterapan_michaelmathewsetiadi_2072007 to javafx.fxml;
    exports com.example.tugas_praktikum1_pemogramanterapan_michaelmathewsetiadi_2072007;
    exports com.example.tugas_praktikum1_pemogramanterapan_michaelmathewsetiadi_2072007.model;
}
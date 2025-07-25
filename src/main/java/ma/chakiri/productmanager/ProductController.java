package ma.chakiri.productmanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class ProductController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private ListView<Product> productListView;

    private ObservableList<Product> productList;

    @FXML
    public void initialize() {
        productList = FXCollections.observableArrayList();
        productListView.setItems(productList);
    }

    @FXML
    protected void onAddButtonClick() {
        String name = nameField.getText();
        String priceText = priceField.getText();

        if (name.isEmpty() || priceText.isEmpty()) {
            showAlert("Error", "Name and price fields cannot be empty.");
            return;
        }

        try {
            double price = Double.parseDouble(priceText);
            Product newProduct = new Product(name, price);
            productList.add(newProduct);

            nameField.clear();
            priceField.clear();
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid price format. Please enter a valid number.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
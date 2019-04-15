package com.geekzila.books;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.geekzila.books.model.Hotel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HotelController implements Initializable {

	@FXML
	private TextField idField;

	@FXML
	private TextField nameField;

	@FXML
	private TextField numberOfRoomsField;

	@FXML
	private TextField addressField;

	@FXML
	private TextField priceField;

	@FXML
	private Button insertButton;

	@FXML
	private Button updateButton;

	@FXML
	private Button deleteButton;

	@FXML
	private TableView<Hotel> TableView;

	@FXML
	private TableColumn<Hotel, Integer> idColumn;

	@FXML
	private TableColumn<Hotel, String> nameColumn;

	@FXML
	private TableColumn<Hotel, String> numberOfRoomsColumn;

	@FXML
	private TableColumn<Hotel, String> addressColumn;

	@FXML
	private TableColumn<Hotel, Double> priceColumn;

	Stage dialogStage = new Stage();
	Scene scene;
	
	ObservableList<Hotel> hotelList = FXCollections.observableArrayList();
	
	public HotelController() {
		// TODO Auto-generated constructor stub
		Hotel hotel = new Hotel("Sri Guptha Bhavan", "123", "Chennai", 2000.0);
		hotel.setId(1);
		hotelList.add(hotel);
	}
	/**
	 * Insert new record in the database
	 */
	@FXML
	private void insertButton() {
		Hotel newHotel = new Hotel(nameField.getText(), numberOfRoomsField.getText(), addressField.getText(), Double.valueOf(priceField.getText()));
		newHotel.setId(Integer.valueOf(idField.getText()));
		hotelList.add(newHotel);
		showHotels();
	}
	
	/**
	 * Update the record in the database
	 */
	@FXML
	private void updateButton() {
//		String query = "UPDATE books SET title='" + titleField.getText() + "',author='" + authorField.getText()
//				+ "',year=" + yearField.getText() + ",pages=" + pagesField.getText() + " WHERE id=" + idField.getText()
//				+ "";
		showHotels();
	}

	/**
	 * Delete a book from the database.
	 * 
	 * @throws IOException
	 */
	@FXML
	private void deleteButton() throws IOException {
		hotelList.remove(getHotel(Integer.valueOf(idField.getText())));
		showHotels();
	}
	
	private Hotel getHotel(Integer id) {
		for (Hotel hotel : hotelList) {
			if(hotel.getId() == id) {
				return hotel;
			}
		}
		return null;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		showHotels();
	}

	/**
	 * Get list of books from the database.
	 * 
	 * @return
	 */
	public ObservableList<Hotel> getHotelList() {
		return hotelList;
	}

	// I had to change ArrayList to ObservableList I didn't find another option to
	// do this but this works :)
	public void showHotels() {
		ObservableList<Hotel> list = getHotelList();

		idColumn.setCellValueFactory(new PropertyValueFactory<Hotel, Integer>("id"));
		nameColumn.setCellValueFactory(new PropertyValueFactory<Hotel, String>("name"));
		numberOfRoomsColumn.setCellValueFactory(new PropertyValueFactory<Hotel, String>("numberOfRooms"));
		addressColumn.setCellValueFactory(new PropertyValueFactory<Hotel, String>("address"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<Hotel, Double>("price"));

		TableView.setItems(list);
	}

}
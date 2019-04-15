package com.geekzila.books;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.geekzila.books.model.Books;

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

public class BooksController implements Initializable {

	@FXML
	private TextField idField;

	@FXML
	private TextField titleField;

	@FXML
	private TextField authorField;

	@FXML
	private TextField yearField;

	@FXML
	private TextField pagesField;

	@FXML
	private Button insertButton;

	@FXML
	private Button updateButton;

	@FXML
	private Button deleteButton;

	@FXML
	private TableView<Books> TableView;

	@FXML
	private TableColumn<Books, Integer> idColumn;

	@FXML
	private TableColumn<Books, String> titleColumn;

	@FXML
	private TableColumn<Books, String> authorColumn;

	@FXML
	private TableColumn<Books, Integer> yearColumn;

	@FXML
	private TableColumn<Books, Integer> pagesColumn;

	Stage dialogStage = new Stage();
	Scene scene;
	
	ObservableList<Books> booksList = FXCollections.observableArrayList();
	
	public BooksController() {
		// TODO Auto-generated constructor stub
		booksList.add(new Books(1, "Famous Book", "Dharshnu", 1998, 122));
		booksList.add(new Books(2, "Another Book", "Vela", 1998, 1256));
	}
	/**
	 * Insert new record in the database
	 */
	@FXML
	private void insertButton() {
//		String query = "insert into books values(" + idField.getText() + ",'" + titleField.getText() + "','"
//				+ authorField.getText() + "'," + yearField.getText() + "," + pagesField.getText() + ")";
//		executeQuery(query);
		Books newBook = new Books(Integer.valueOf(idField.getText()), titleField.getText(), authorField.getText(), Integer.valueOf(yearField.getText()), Integer.valueOf(pagesField.getText()));
		booksList.add(newBook);
		showBooks();
	}
	
	/**
	 * Update the record in the database
	 */
	@FXML
	private void updateButton() {
		String query = "UPDATE books SET title='" + titleField.getText() + "',author='" + authorField.getText()
				+ "',year=" + yearField.getText() + ",pages=" + pagesField.getText() + " WHERE id=" + idField.getText()
				+ "";
		showBooks();
	}

	/**
	 * Delete a book from the database.
	 * 
	 * @throws IOException
	 */
	@FXML
	private void deleteButton() throws IOException {
		booksList.remove(getBook(Integer.valueOf(idField.getText())));
		showBooks();
	}
	
	private Books getBook(Integer id) {
		for (Books books : booksList) {
			if(books.getId() == id) {
				return books;
			}
		}
		return null;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		showBooks();
	}

	/**
	 * Get list of books from the database.
	 * 
	 * @return
	 */
	public ObservableList<Books> getBooksList() {
		return booksList;
	}

	// I had to change ArrayList to ObservableList I didn't find another option to
	// do this but this works :)
	public void showBooks() {
		ObservableList<Books> list = getBooksList();

		idColumn.setCellValueFactory(new PropertyValueFactory<Books, Integer>("id"));
		titleColumn.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));
		authorColumn.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));
		yearColumn.setCellValueFactory(new PropertyValueFactory<Books, Integer>("year"));
		pagesColumn.setCellValueFactory(new PropertyValueFactory<Books, Integer>("pages"));

		TableView.setItems(list);
	}

}
package com.geekzila.books;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.geekzila.books.db.ConnectionUtil;
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
	
	/**
	 * Insert new record in the database
	 */
	@FXML
	private void insertButton() {
		String query = "insert into books values(" + idField.getText() + ",'" + titleField.getText() + "','"
				+ authorField.getText() + "'," + yearField.getText() + "," + pagesField.getText() + ")";
		executeQuery(query);
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
		executeQuery(query);
		showBooks();
	}

	/**
	 * Delete a book from the database.
	 * 
	 * @throws IOException
	 */
	@FXML
	private void deleteButton() throws IOException {
		String query = "DELETE FROM books WHERE id=" + idField.getText() + "";
		executeQuery(query);
		showBooks();
	}

	public void executeQuery(String query) {
		Connection conn = ConnectionUtil.connectdb();
		Statement st;
		try {
			st = conn.createStatement();
			st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		ObservableList<Books> booksList = FXCollections.observableArrayList();
		Connection connection = connection = ConnectionUtil.connectdb();
		String query = "SELECT * FROM books";
		Statement st;
		ResultSet rs;

		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Books books;
			while (rs.next()) {
				books = new Books(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getInt("year"),
						rs.getInt("pages"));
				booksList.add(books);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
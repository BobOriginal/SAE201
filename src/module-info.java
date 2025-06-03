/**
 * 
 */
/**
 * 
 */
module SAE201 {
	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;

	opens controleur to javafx.base , javafx.graphics, javafx.fxml;
	opens modele to javafx.base , javafx.graphics, javafx.fxml;
	opens vue to javafx.base , javafx.graphics, javafx.fxml;

}
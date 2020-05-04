package App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author csr13
 */
public class HelpController {

    @FXML
    private Button event_menu_button;

    @FXML
    private Button book_button;

    @FXML
    private Button account_button;

    @FXML
    private Button help_button;
    
    @FXML
    private Button goback;

    @FXML
    private AnchorPane scrollAbout;

    @FXML
    public void gotoAccount(ActionEvent event) {

    }

    @FXML
    public void gotoEvent(ActionEvent event) throws IOException {
         App.setRoot("/fxml/admin_Landing");
    }

    @FXML
    public void gotoGuestBook(ActionEvent event) throws IOException {
          App.setRoot("/fxml/GuestList_Book");
    }

    @FXML
    public void gotoHelp(ActionEvent event) {

    }
    
    

}

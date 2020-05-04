package IndiefyLogin;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MusicListController {
    
   @FXML
   TableView<Music> musicList;
   
   @FXML
   TableColumn<Music, String> albumColumn;
   
   @FXML
   TableColumn<Music, String> artistColumn;
   
   @FXML
   TableColumn<Music, String> genreColumn;
   
   @FXML
   TableColumn<Music, Integer> yearColumn;
   
private App App;
    
public MusicListController() {
}

@FXML
    public void initialize() {
       /* 
        Initialise the TableView by setting the cell value factory
        Read this page for help: https://code.makery.ch/library/javafx-tutorial/part2/
        */
       musicList.setItems(getMusicListData());
       musicList.setEditable(true);
       albumColumn.setCellValueFactory(cellData -> cellData.getValue().getAlbum());
       artistColumn.setCellValueFactory(cellData -> cellData.getValue().getArtist());
       genreColumn.setCellValueFactory(cellData -> cellData.getValue().getGenre());
       yearColumn.setCellValueFactory(cellData -> cellData.getValue().getYear().asObject());
       
        // Set the items that should be contained in the TableView
    }

    private ObservableList<Music> getMusicListData() {
        List<Music> musicListToReturn = new ArrayList<>();
        musicListToReturn.add(new Music("COVID19", "Bat", "Virus", 2019));
  //              try {
            
            // Get the music list from the database
            
//            while(rs.next()) {
//                musicListToReturn.add(
                  // create a new music object
  //              );
 //           }
//        } catch (SQLException ex) {
 //           ex.printStackTrace();
 //       }
        
       
       return FXCollections.observableArrayList(musicListToReturn);
    }
    
}

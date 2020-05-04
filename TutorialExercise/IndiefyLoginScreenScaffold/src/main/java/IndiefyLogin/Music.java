package IndiefyLogin;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

public class Music {
    
    private StringProperty album;
    private StringProperty artist;
    private StringProperty genre;
    private IntegerProperty year;
    
    
    public Music() {
        this("gthafjksd","dalsjkfha","aldsfhladk",9999);
    }

    public Music(String album, String artist, String genre, Integer year) {
        this.album = new SimpleStringProperty(album);
        this.artist = new SimpleStringProperty(artist);
        this.genre = new SimpleStringProperty(genre);
        this.year = new SimpleIntegerProperty(year);
    }

    public StringProperty getAlbum() {
        return album;
    }

    public void setAlbum(StringProperty album) {
        this.album = album;
    }

    public StringProperty getArtist() {
        return artist;
    }

    public void setArtist(StringProperty artist) {
        this.artist = artist;
    }

    public StringProperty getGenre() {
        return genre;
    }

    public void setGenre(StringProperty genre) {
        this.genre = genre;
    }

    public IntegerProperty getYear() {
        return year;
    }

    public void setYear(IntegerProperty year) {
        this.year = year;
    }
    

}

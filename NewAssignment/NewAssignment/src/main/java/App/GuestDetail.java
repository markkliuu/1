
package App;

public class GuestDetail {
    public String guestCode;
    public String guestEmail;

    public GuestDetail(String guestCode, String guestEmail) {
        this.guestCode = guestCode;
        this.guestEmail = guestEmail;
    }

    public String getGuestCode() {
        return guestCode;
    }

    public void setGuestCode(String guestCode) {
        this.guestCode = guestCode;
    }

    public String getGuestEmail() {
        return guestEmail;
    }

    public void setGuestEmail(String guestEmail) {
        this.guestEmail = guestEmail;
    }
    
    

}

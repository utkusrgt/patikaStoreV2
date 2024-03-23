package PatikaStore;

public class MobilePhone extends Urun {

    private int battery;
    private String color;
    private int kamera;

    public MobilePhone(double birimFiyat, double indirimOrani, int stokMiktari, String urunAdi, Marka marka, int depolama, double ekranBoyutu, int ram, int battery, String color, int kamera) {
        super(birimFiyat, indirimOrani, stokMiktari, urunAdi, marka, depolama, ekranBoyutu, ram);
        this.battery = battery;
        this.color = color;
        this.kamera = kamera;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getKamera() {
        return kamera;
    }

    public void setKamera(int kamera) {
        this.kamera = kamera;
    }
}

package PatikaStore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class Magaza {

    private List<Marka> markalar;
    private List<MobilePhone> mobilePhones;
    private List<NoteBook> noteBooks;

    public Magaza() {



        this.markalar = new ArrayList<>();
        this.mobilePhones = new ArrayList<>();
        this.noteBooks = new ArrayList<>();
        //PatikaStore.Marka Ekleme
        markalar.add(new Marka(1, "Apple"));
        markalar.add(new Marka(2, "Asus"));
        markalar.add(new Marka(3, "Casper"));
        markalar.add(new Marka(4, "HP"));
        markalar.add(new Marka(5, "Huawei"));
        markalar.add(new Marka(6, "Lenovo"));
        markalar.add(new Marka(7, "Monster"));
        markalar.add(new Marka(8, "Samsung"));
        markalar.add(new Marka(9, "Xiaomi"));
        markalar.sort(Comparator.comparing(Marka:: getName));//Alfabatik sıralama
    }

//    public void urunEkle(PatikaStore.Urun urun,int techSecim){
//        if (urun instanceof PatikaStore.Urun){
//            for (PatikaStore.Marka marka : markalar){
//                if (urun.getMarka().getName().equals(marka.getName())){
//                    if(techSecim == 1){
//                        mobilePhones.add(PatikaStore.MobilePhone);
//                    }else {
//                        noteBooks.add(PatikaStore.NoteBook);
//                    }
//                    break;
//                }
//            }
//        }
//    }

    public void addMobilePhone(MobilePhone mobilePhone){
        if(mobilePhone instanceof MobilePhone){
            for(Marka marka : markalar){
                if(mobilePhone.getMarka().getName().equals(marka.getName())){
                    mobilePhones.add(mobilePhone);
                }
            }
        }
    }

    public void addingMobile() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the brand you wish to add by ID: ");
        markaListele();
        int markaId = scanner.nextInt();
        scanner.nextLine();
        Marka marka = getMarkaById(markaId);
        if (marka != null) {
            System.out.print("Ürün Adı: ");
            String urunAdi = scanner.nextLine();
            System.out.print("Birim Fiyat: ");
            double birimFiyat = scanner.nextDouble();
            System.out.print("Stok Miktarı: ");
            int stokMiktari = scanner.nextInt();
            int depolama, kamera, ram, battery;
            double ekranBoyutu, indirimOrani;
            String color;
            System.out.print("İndirim Oranı ");
            indirimOrani = scanner.nextInt();
            System.out.print("Depolama (GB): ");
            depolama = scanner.nextInt();
            System.out.print("Ekran Boyutu (inç): ");
            ekranBoyutu = scanner.nextDouble();
            System.out.print("Kamera (MP): ");
            kamera = scanner.nextInt();
            System.out.print("Pil Gücü (mAh): ");
            battery = scanner.nextInt();
            System.out.print("Ram: ");
            ram = scanner.nextInt();
            System.out.print("Color: ");
            color = scanner.nextLine();
            scanner.nextLine();
            MobilePhone mobilePhone = new MobilePhone(birimFiyat, indirimOrani, stokMiktari, urunAdi, marka, depolama, ekranBoyutu, ram, battery, color, kamera);
            addMobilePhone(mobilePhone);

            System.out.println("PatikaStore.Urun Eklendi");
        } else{
            System.out.println("Geçersiz marka ID");
        }



    }




    public void addNoteBook(NoteBook noteBook){
        if(noteBook instanceof NoteBook){
            for(Marka marka : markalar){
                if(noteBook.getMarka().getName().equals(marka.getName())){
                    noteBooks.add(noteBook);
                }
            }
        }
    }

    public void addingNoteBook() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the brand you wish to add by ID: ");
        markaListele();
        int markaId = scanner.nextInt();
        scanner.nextLine();
        Marka marka = getMarkaById(markaId);
        if (marka != null) {
            System.out.print("Ürün Adı: ");
            String urunAdi = scanner.nextLine();
            System.out.print("Birim Fiyat: ");
            double birimFiyat = scanner.nextDouble();
            System.out.print("Stok Miktarı: ");
            int stokMiktari = scanner.nextInt();
            int depolama, ram;
            double ekranBoyutu, indirimOrani;
            System.out.print("İndirim Oranı ");
            indirimOrani = scanner.nextInt();
            System.out.print("Depolama (GB): ");
            depolama = scanner.nextInt();
            System.out.print("Ekran Boyutu (inç): ");
            ekranBoyutu = scanner.nextDouble();
            System.out.print("Ram: ");
            ram = scanner.nextInt();
            NoteBook noteBook = new NoteBook(birimFiyat, indirimOrani, stokMiktari, urunAdi, marka, depolama, ekranBoyutu, ram );
            addNoteBook(noteBook);

            System.out.println("PatikaStore' a Urun Eklendi");
        } else{
            System.out.println("Geçersiz marka ID");
        }



    }



    public void  urunSil(int urunId){

        mobilePhones.removeIf(urun -> urun.getId() == urunId );
        noteBooks.removeIf(urun -> urun.getId() == urunId );
     /*   Iterator<PatikaStore.Urun> iterator = cepTelefonlari.iterator();
        while (iterator.hasNext()){
            PatikaStore.Urun urun = iterator.next();
            if (urun.getId() == urunId){
                iterator.remove();;
            }

        }*/


    }
    public  void urunListele(){

        System.out.println("Notebook Listesi");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | PatikaStore.Marka     | Depolama  | Ekran     | RAM         |");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (Urun urun : noteBooks) {
            System.out.format("| %-2d | %-30s | %-9.1f TL | %-9s | %-10d | %-6.1f | %-11d |\n", urun.getId(), urun.getUrunAdi(), urun.getBirimFiyat(), urun.getMarka().getName(), urun.getDepolama(), urun.getEkranBoyutu(), urun.getRam());
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("\nCep Telefonu Listesi");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | PatikaStore.Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      |");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        for (MobilePhone mobilePhone : mobilePhones) {
            System.out.format("| %-2d | %-30s | %-9.1f TL | %-9s | %-10d | %-6.1f | %-9d | %-9.1f | %-9d | %-9s |\n", mobilePhone.getId(), mobilePhone.getUrunAdi(), mobilePhone.getBirimFiyat(), mobilePhone.getMarka().getName(), mobilePhone.getDepolama(), mobilePhone.getEkranBoyutu(), mobilePhone.getRam());
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

    }

    public void urunGor(){
        System.out.println("Notebook Listesi");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | PatikaStore.Marka     | Depolama  | Ekran     | RAM         |");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for(Urun urun : noteBooks){
            System.out.println(urun.getId() +  " " + urun.getUrunAdi() + "                      | " + urun.getBirimFiyat() + "      " + urun.getMarka() + "     " + urun.getDepolama() + "      " + urun.getEkranBoyutu() + "       " + urun.getRam());
        }
        System.out.println("Telefon Listesi");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | PatikaStore.Marka     | Depolama  | Ekran     | RAM         | Kamera    | Pil        | Renk      |");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for(MobilePhone mobilePhone : mobilePhones){
            System.out.println(mobilePhone.getId() +  " " + mobilePhone.getUrunAdi() + "                      | " + mobilePhone.getBirimFiyat()
                    + "      " + mobilePhone.getMarka()
                    + "     " + mobilePhone.getDepolama()
                    + "      " + mobilePhone.getEkranBoyutu()
                    + "       " + mobilePhone.getRam()
                    + "      " + mobilePhone.getKamera()
                    + "      " + mobilePhone.getBattery()
                    + "      " + mobilePhone.getColor());
        }
    }

    public  void markaListele(){
        System.out.println("| ID | PatikaStore.Marka Adı  |");
        for (Marka marka : markalar) {
            System.out.format("| %-1d  | %-1s    |\n",marka.getId(),marka.getName());
        }
    }

    public Marka getMarkaById(int id) {
        for (Marka marka : markalar) {
            if (marka.getId() == id) {
                return marka;
            }
        }
        return null;
    }

}

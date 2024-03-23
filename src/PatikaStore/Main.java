package PatikaStore;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Magaza magaza = new Magaza();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Telefon Ekle");
            System.out.println("2. Notebook Ekle");
            System.out.println("3. Ürünleri Listele");
            System.out.println("4. Ürün Sil");
            System.out.println("5. PatikaStore.Marka Listele");
            System.out.println("6. Çıkış");
            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();
            scanner.nextLine();
            switch (secim) {
            case 1:
                magaza.addingMobile();
                break;

            case 2:
                magaza.addingNoteBook();
                
            case 3:
                magaza.urunGor();
                break;
            case 4:
                System.out.println("Silmek istediğiniz ürünü seçin");
                int silinecekId = scanner.nextInt();
                magaza.urunSil(silinecekId);
                System.out.println("PatikaStore.Urun Silindi");
                break;
            case 5:
                magaza.markaListele();
                break;
            case 6:
                System.out.println("Programdan çıkılıyor...");
                System.exit(0);
            default:
                System.out.println("Geçersiz Seçim...");
            }


        }
    }
}

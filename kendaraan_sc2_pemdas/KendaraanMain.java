package kendaraan_sc2_pemdas;
import java.util.ArrayList;
import java.util.Scanner;

public class KendaraanMain {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Kendaraan> inventaris = new ArrayList<>();
        int countAdded = 0;
        while(countAdded < 5) {
            System.out.println("1. Mobil");
            System.out.println("2. Motor");
            System.out.println("3. Truk");
            System.out.print("Pilih kendaraan: ");
            int pilih = in.nextInt();
            in.nextLine();
            if(pilih < 1 || pilih > 3) {
                System.out.println("Pilihan tidak valid\n");
                continue;
            }
            System.out.print("Masukkan ID: ");
            String id = in.nextLine();
            System.out.print("Masukkan nama: ");
            String nama = in.nextLine();
            System.out.print("Masukkan biaya harian: ");
            double biayaHarian = in.nextDouble();
            System.out.print("Apakah tersedia? (true/false): ");
            boolean tersedia = in.nextBoolean();
            in.nextLine();
            switch(pilih) {
                case 1:
                    System.out.print("Apakah mobil memiliki bensin? (true/false): ");
                    boolean bensin = in.nextBoolean();
                    in.nextLine();
                    inventaris.add(new Mobil(id, nama, biayaHarian, tersedia, bensin));
                    break;
                case 2:
                    inventaris.add(new Motor(id, nama, biayaHarian, tersedia));
                    break;
                case 3:
                    System.out.print("Masukkan muatan maksimal truk: ");
                    double muatanMaks = in.nextDouble();
                    in.nextLine();
                    inventaris.add(new Truk(id, nama, biayaHarian, tersedia, muatanMaks));
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
            countAdded++;
            System.out.println();
        }
        
        int pil = 0;
        
        do {
            System.out.println("1. Tampilkan semua kendaraan");
            System.out.println("2. Hitung biaya kendaraan");
            System.out.println("3. Cari kendaraan tersedia");
            System.out.println("0. Keluar");
            System.out.print("Pilih operasi:");
            pil = in.nextInt();
            System.out.println();
            
            if(pil == 1) tampilkanSemuaKendaraan(inventaris);
            if(pil == 2) hitungBiayaKendaraan(inventaris);
            if(pil == 4) cariKendaraanTersedia(inventaris);

            System.out.println();
            in.nextLine();
        } while(pil != 0);
        
        in.close();
    }

    public static void tampilkanSemuaKendaraan(ArrayList<Kendaraan> inventaris) {
        for(Kendaraan k : inventaris) {
            k.tampilkanDetail();
        }
    }
        
    public static void hitungBiayaKendaraan(ArrayList<Kendaraan> inventaris) {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan ID kendaraan: ");
        String id = in.nextLine();
        System.out.print("Masukkan jumlah hari sewa: ");
        int hari = in.nextInt();
        in.nextLine();
        for(Kendaraan k : inventaris) {
            if(k.getId().equals(id)) {
                System.out.printf("Biaya total sewa kendaraan %s selama %d hari adalah Rp %.2f\n", k.getNama(), hari, k.hitungBiayaTotal(hari));
                return;
            }
        }
        System.out.println("Kendaraan dengan ID tersebut tidak ditemukan");
    }

    public static void cariKendaraanTersedia(ArrayList<Kendaraan> inventaris) {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan tipe kendaraan (Mobil/Motor/Truk): ");
        String type = in.nextLine();
        
        for(Kendaraan k : inventaris) {
            if(
                k.isTersedia() 
                && (type.equals("Mobil") && k instanceof Mobil)
                && (type.equals("Motor") && k instanceof Motor)
                && (type.equals("Truk") && k instanceof Truk)
            ) {
                k.tampilkanDetail();
            }
        }
    }
}
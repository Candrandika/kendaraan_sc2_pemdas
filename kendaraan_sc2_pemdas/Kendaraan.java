package kendaraan_sc2_pemdas;

abstract class Kendaraan {
    private String id;
    private String nama;
    private double biayaHarian;
    private boolean tersedia;

    public Kendaraan(String id, String nama, double biayaHarian, boolean tersedia) {
        this.id = id;
        this.nama = nama;
        this.biayaHarian = biayaHarian;
        this.tersedia = tersedia;
    }

    public String getId()  {return id;}
    public String getNama() {return nama;}
    public double getBiayaHarian() {return biayaHarian;}
    public boolean isTersedia() {return tersedia;}
    public double hitungBiayaTotal(int hari) {
        if(hari <= 0) throw new IllegalArgumentException("Hari sewa harus positif");
        return biayaHarian * hari + this.hitungBiayaTambahan();
    }
    public void tampilkanDetail() {
        System.out.printf("ID: %s, Nama: %s, Biaya Harian: Rp %.0f, Status: %s\n", this.id, this.nama, this.biayaHarian, this.tersedia ? "Tersedia" : "Tidak Tersedia");
    }

    protected abstract double hitungBiayaTambahan();
}

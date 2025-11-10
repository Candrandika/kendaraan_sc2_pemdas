package kendaraan_sc2_pemdas;

class Truk extends Kendaraan {
    private double muatanMaks;

    public Truk(String id, String nama, double biayaHarian, boolean tersedia, double muatanMaks) {
        super(id, nama, biayaHarian, tersedia);
        this.muatanMaks = muatanMaks;
    }

    @Override
    protected double hitungBiayaTambahan() { return this.muatanMaks * 50000; }
}
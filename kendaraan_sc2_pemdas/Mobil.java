package kendaraan_sc2_pemdas;
class Mobil extends Kendaraan {
    private boolean bensin;

    public Mobil(String id, String nama, double biayaHarian, boolean tersedia, boolean bensin) {
        super(id, nama, biayaHarian, tersedia);
        this.bensin = bensin;
    }

    @Override
    protected double hitungBiayaTambahan() {
        return this.bensin ? this.getBiayaHarian() * 0.1 : 0;
    }
}


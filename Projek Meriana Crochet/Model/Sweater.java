package Model;
import Interface.DapatKustom;

public class Sweater extends ProdukRajutan implements DapatKustom{
    private String ukuran;
    private String detailCustom;
    private double getBiayaTambahan;

    public Sweater(String kode, String nama, String bahan, double hargaDasar, int stok, String ukuran){
        super(kode, nama, bahan, hargaDasar, stok);
        this.ukuran = ukuran;
        this.getBiayaTambahan = 0;
    }
    @Override
    public double hitungHargaAkhir(){
        return getHargaDasar() + getBiayaTambahan;
    }
    @Override
    public String tampilkanInfo(){
        String infoCustom = "";
        if (detailCustom != null){
            infoCustom = " | Custom: " + detailCustom;
        }else{
            infoCustom = " | Standar";
        }
        return  "Sweater | " + getNama() + " | Bahan: " + getBahan() + " | Ukuran: " + ukuran + infoCustom;
    }
    @Override
    public void setDetailCustom(String detail){
        this.detailCustom = detail;
        this.getBiayaTambahan = 25000;
    }
    @Override
    public double getBiayaTambahan(){
        return getBiayaTambahan;
    }
    @Override
    public String getInfoCustom(){
        if(detailCustom != null){
            return "Custom: " + detailCustom;
        }else{
            return "Standar";
        }
    }
}

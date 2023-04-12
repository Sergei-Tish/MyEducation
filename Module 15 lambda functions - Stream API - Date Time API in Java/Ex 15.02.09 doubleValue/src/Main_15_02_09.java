public class Main_15_02_09 {
    public static void main(String[] args) {
        int i = 1;
        Integer ii = i;
        double d = ii.doubleValue();
        Double p = 2.2321321;


        Bobable doubt = new Bobable() {
            @Override
            public double meBob(Number number) {
                return number.doubleValue();
            }
        };
        Bobable doubt1 = (Number num) -> num.doubleValue();
        Bobable doubt2 = Number::doubleValue;

        System.out.println(doubt.meBob(ii));
        System.out.println(doubt2.meBob(i));
        System.out.println(doubt1.meBob(p));
    }
}


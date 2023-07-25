package EnumCodes;

/**
 * 使用枚举代替数字（魔法数）
 *
 * @author Beta
 */
public class EnumEnsemble {
    public static void main(String[] args) {
        System.out.printf("%s %s --- %d %d", Ensemble.SOLO, Ensemble.DUET,
                Ensemble.SOLO.getNumberOfMusicians(), Ensemble.DUET.getNumberOfMusicians());
    }

    enum Ensemble {
        SOLO(1), DUET(2), TRIO(3),
        QUARTET(4), QUINTET(5), SEXTET(6),
        SEPTET(7), OCTET(8), NONET(9),
        DECTET(10);
        private final int numberOfMusicians;

        Ensemble(int numberOfMusicians) {
            this.numberOfMusicians = numberOfMusicians;
        }

        public int getNumberOfMusicians() {
            return numberOfMusicians;
        }
    }

}

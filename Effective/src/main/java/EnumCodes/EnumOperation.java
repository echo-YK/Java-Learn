package EnumCodes;

/**
 * 1、重写toString方法，自定义输出方式
 * 2、使用abstract方法，强制每个枚举类必须实现指定方法
 *
 * @author Beta
 */
public class EnumOperation {
    public static void main(String[] args) {
        for (Operations p : Operations.values()) {
            System.out.printf("%d %s %d = %d\n", 2, p, 3, p.apply(2, 3));
        }
    }

    private enum Operations {
        ADD("+") {
            public int apply(int a, int b) {
                return a + b;
            }
        },
        SUB("-") {
            public int apply(int a, int b) {
                return a - b;
            }
        },
        TIMES("*") {
            public int apply(int a, int b) {
                return a * b;
            }
        },

        DIVDE("/") {
            public int apply(int a, int b) {
                return a / b;
            }
        };
        //symbol变量就是enum中每个变量构造时的变量，如ADD中的"+"
        private final String symbol;

        /**
         * 枚举类构造方法，
         *
         * @param symbol
         */
        Operations(String symbol) {
            this.symbol = symbol;
        }

        /**
         * 抽象方法，限制每个枚举类必须实现apply
         *
         * @param a
         * @param b
         * @return
         */
        public abstract int apply(int a, int b);

        /**
         * 重写枚举的toString方法，实现打印的不是“ADD”，而是“+”
         * 如果注释掉，效果就是：
         * 2 ADD 3 = 5
         * 2 SUB 3 = -1
         * 2 TIMES 3 = 6
         * 2 DIVDE 3 = 0
         *
         * @return
         */
        @Override
        public String toString() {
            return symbol;
        }
    }


}

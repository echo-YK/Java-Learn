package EnumCodes;

/**
 * 枚举类
 *
 * @author Beta
 */
public class EnumFruit {
    public static void main(String[] args) {
        // 枚举类中的变量本身可以通过values方法进行遍历，values方法以变量声明的顺序返回变量
        for (Fruit f : Fruit.values()) {
            // 枚举变量本身可以以字符串方式进行输出
            System.out.printf("fruit: %s count total price %d \n", f, f.getTotalPrice());
        }
    }

    public enum Fruit {
        APPLE(3, 4),
        CHERRY(10, 3),
        PEACH(4, 10);

        private final int price;
        private final int num;

        private final int total;

        /**
         * 本构造方法不对外开发，而是在上述变量定义时进行自动实例化变量
         *
         * @param price
         * @param num
         */
        Fruit(int price, int num) {
            this.price = price;
            this.num = num;
            this.total = price * num;
        }

        public int getTotalPrice() {
            return this.total;
        }
    }

}

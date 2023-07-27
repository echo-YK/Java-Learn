package EnumCodes;


import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/**
 * 实际场景中的应用
 * 实际需求：
 * 有4个页面（merchant、acct、merchantTrade、acctTrade）需要进行不同逻辑的过滤
 * 过滤的逻辑由页面路径决定
 * 使用枚举方式替代if-else的方式
 */
public class EnumBestPractices {

    public static void main(String[] args) {
        String path = "/retailmgr/checklist/merchant";
        commonFilter(path);
    }

    /**
     * 过滤接口
     *
     * @param path
     */
    public static void commonFilter(String path) {
        // 获取页面
        String segmentPath = path.split("/")[3];
        System.out.println("This page is " + segmentPath);
        /**
         * 根据获取到的页面，获取枚举值，并调用对应的过滤方法
         * 这里不再需要使用四个equals对segmentPath进行if-else
          */
        FilterMethod.fromStringToEnum(segmentPath).doFilter();
    }

    private enum FilterMethod {
        /**
         * 账户入网页面
         */
        ACCT("acct") {
            @Override
            public void doFilter() {
                System.out.println("do filter acct");
            }
        },

        /**
         * 商户入网页面
         */
        MERCHANT("merchant") {
            @Override
            public void doFilter() {
                System.out.println("do filter merchant");
            }
        },

        /**
         * 商户交易页面
         */
        MERCHANT_TRADE("merchantTrade") {
            @Override
            public void doFilter() {
                System.out.println("do filter merchantTrade");
            }
        },

        /**
         * 账户交易页面
         */
        ACCT_TRADE("acctTrade") {
            @Override
            public void doFilter() {
                System.out.println("do filter acctTrade");
            }
        };

        /**
         * 路径常量
         */
        private final String path;

        /**
         * 枚举类构造方法
         *
         * @param path
         */
        private FilterMethod(String path) {
            this.path = path;
        }

        /**
         * 使用抽象类约束实现各个页面的过滤方法
         * 也可以使用enum implements interface
         */
        abstract public void doFilter();

        /**
         * 重写toString方法，使得枚举值返回path
         *
         * @return
         */
        @Override
        public String toString() {
            return this.path;
        }

        /**
         * 构造字符串转枚举的Map
         */
        private static final Map<String, FilterMethod> strToEnum
                = Stream.of(values()).collect(toMap(Object::toString, e -> e));

        /**
         * 根据传入的字符串返回对于的枚举类型
         *
         * @param path
         * @return
         */
        // todo 如何处理不存在的路径
        public static FilterMethod fromStringToEnum(String path) {
            return strToEnum.get(path);
        }
    }
}

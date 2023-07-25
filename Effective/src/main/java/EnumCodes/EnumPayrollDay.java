package EnumCodes;

/**
 * @author Beta
 */
public class EnumPayrollDay {
    public static void main(String[] args) {
        //计算周一 + 周二 + 周六 + 春节的薪资
        int totalPay = PayrollDay.MON.pay(8, 2)
                + PayrollDay.TUE.pay(8, 2)
                + PayrollDay.SAT.pay(8, 2)
                + PayrollDay.SPRING_DAY.pay(8, 3);
        System.out.printf("总薪资：%d", totalPay);
    }

    /**
     * 该枚举类首先定义了不同的日期，同时为了增加灵活性
     * 在内部增加了日期类型，由日期类型来完成不同日期的薪资计算
     * 不仅使得代码具有灵活性，可以在后期继续扩展不同类型
     * 同时通过不同日期类型进行计算薪资，很好地解决了if、switch的使用
     */
    enum PayrollDay {
        MON, TUE, WED, THUR, FRI,
        SAT(PayType.WEEKEND), SUN(PayType.WEEKEND),
        /**
         * 灵活性的体现，后续可以灵活增加不同日期类型，
         * 也可以在PayType中添加类型，自定义计算方式
         */
        SPRING_DAY(PayType.OFFICIAL_HOLIDAY);

        private final PayType payType;

        /**
         * 默认为工作日
         */
        PayrollDay() {
            this(PayType.WEEKDAY);
        }

        /**
         * 指定假期或者工作日
         *
         * @param payType
         */
        PayrollDay(PayType payType) {
            this.payType = payType;
        }

        /**
         * 调用类型本身的支付方式
         *
         * @param hours
         * @param payRate
         * @return
         */
        int pay(int hours, int payRate) {
            return this.payType.pay(hours, payRate);
        }


        /**
         * 日期类型
         */
        private enum PayType {
            WEEKDAY {
                @Override
                int overtimePay(int hours, int payRate) {
                    return hours <= MIN_HOURS ?
                            0 : (MIN_HOURS - hours) * payRate / 2;
                }
            },
            WEEKEND {
                @Override
                int overtimePay(int hours, int payRate) {
                    return hours * payRate / 2;
                }
            },
            /**
             * 后期扩展的法定假期，如春节：SPRING_DAY
             */
            OFFICIAL_HOLIDAY {
                @Override
                int overtimePay(int hours, int payRate) {
                    return hours * payRate;
                }
            };

            /**
             * 抽象函数，强制不同日期实现薪资计算
             *
             * @param hours
             * @param payRate
             * @return
             */
            abstract int overtimePay(int hours, int payRate);

            /**
             * 标准工作日时间
             */
            private static final int MIN_HOURS = 8;

            /**
             * 计算薪资
             *
             * @param hours
             * @param payRate
             * @return
             */
            int pay(int hours, int payRate) {
                int basePay = hours * payRate;
                return basePay + this.overtimePay(hours, payRate);
            }
        }
    }
}

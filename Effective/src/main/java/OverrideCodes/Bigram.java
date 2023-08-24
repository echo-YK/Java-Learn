package OverrideCodes;

/**
 * @Description
 * @Author Beta
 * @Date 2023/8/24 21:00
 **/
public class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    /**
     * 该方法使用的Override注解
     * 并且使用注解口，由于标识重写了Object的equals方法
     * 因此编译和idea都会给出提示，参数需要修改为Object类型
     * 进而需要在代码中使用instanceof判断类型是否为Bigram
     * 从而保证了equals符合开发者的预期
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Bigram)) {
            return false;
        }
        Bigram b = (Bigram) o;
        return b.first == first && b.second == second;
    }

    /**
     * 如果使用以下的方法，由于没有加override，在后续加入Set几何的时候
     * equals的比较会使用Object方法自带的equals
     * 由于Object比较的是内存地址，所以Bigram永远不相等
     * @return
     */
    /*public boolean equals(Bigram b) {
        return b.first == first && b.second == second;
    }*/

    //@Override
    public int hashCode() {
        return 31 * first + second;
    }
}

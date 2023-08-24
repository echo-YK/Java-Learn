import OverrideCodes.Bigram;
import org.junit.Test;

import java.util.HashSet;

/**
 * @Description
 * @Author Beta
 * @Date 2023/8/24 21:05
 **/
public class OverrideTest {

    /**
     * 带Override注解和不带Override注解的效果测试
     * 需要修改Bigram类中的方法来实现比较
     */
    @Test
    public void run() {
        HashSet<Bigram> bigramsHash = new HashSet<>();
        for(int i = 0; i < 10; ++i) {
            for(char ch = 'a'; ch <= 'z'; ++ch) {
                bigramsHash.add(new Bigram(ch, ch));
            }
        }
        System.out.println("bigram set size = " + bigramsHash.size());
    }

}


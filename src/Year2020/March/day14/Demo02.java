package Year2020.March.day14;

import java.util.Arrays;
import java.util.Comparator;

public class Demo02 {

    /**
     * N  辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
     * 每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
     * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
     * 此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
     * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
     * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
     *
     * @return
     */

    class Car {
        public int position;
        public double time;

        Car(int p, double t) {
            position = p;
            time = t;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        double time;
        Car[] cars = new Car[N];
        for (int i = 0; i < N; i++) {
            time = 1.0 * (target - position[i]) / speed[i];
            cars[i] = new Car(position[i], time);
        }
        //车需要按照位置从小到大进行排序
        Arrays.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.position - o2.position;
            }
        });
        //如果后面的车的耗费时间小于前面的车，那么他们可以组成一个车队
        int count = 0;
        int index = N - 1;
        while (index >= 0) {
            int pre = index - 1;
            while (pre >= 0 && cars[pre].time <= cars[index].time) {
                pre--;
            }
            count++;
            index = pre; //指向下一辆车的起始位置
        }
        return count;
    }

    public static void main(String[] args) {
        int target = 10;
        int[] position = new int[]{0, 4, 2};
        int[] sppeds = new int[]{2, 1, 3};
        int ans = new Demo02().carFleet(target, position, sppeds);
        System.out.println(ans);
    }

}

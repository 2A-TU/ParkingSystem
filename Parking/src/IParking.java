import java.util.ArrayList;
import java.util.Scanner;

public interface IParking {
    public void print(ArrayList a);

    // 检查是否有 carType 对应的停车位
    // 如果没有空车位，请返回 false ，否则将该车停入车位并返回 true
    public boolean addCar(int carType);

    // 解析命令行输入的参数（格式），如文档描述
    public static IParams parse() throws Exception {
        String st1, st2;
        int big, med, sma;
        ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        System.out.println("请输入停车场位数:");
        st2 = in.nextLine();
        big = Integer.parseInt(st2.substring(2, 3));
        med = Integer.parseInt(st2.substring(4, 5));
        sma = Integer.parseInt(st2.substring(6, 7));

        for (int k = 10; k < st2.length(); k = k + 4) {
            list.add(Integer.parseInt(st2.substring(k, k + 1)));
        }

        in.close();
        return new IParams() {

            public int getBig() {
                return big;
            }

            public int getMedium() {
                return med;
            }

            public int getSmall() {
                return sma;
            }

            public ArrayList<Integer> getPlanParking() {
                return list;
            }
        };

    }
}

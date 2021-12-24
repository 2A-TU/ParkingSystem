import java.util.ArrayList;

public class ParkingSystem implements IParking {
    private int big, medium, small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    @Override
    public void print(ArrayList list) {
        System.out.println("停车场空车位情况:");
        System.out.print("[null");
        for (int i = 0; i < list.size(); i++) {
            System.out.print("," + list.get(i));
        }
        System.out.print("]");
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (this.big > 0) {
                this.big--;
                return true;
            } else {
                return false;
            }
        } else if (carType == 2) {
            if (this.medium > 0) {
                this.medium--;
                return true;
            } else {
                return false;
            }
        } else {
            if (this.small > 0) {
                this.small--;
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Boolean> list1 = new ArrayList<Boolean>();
        IParams params = IParking.parse();
        ParkingSystem ps = new ParkingSystem(params.getBig(), params.getMedium(), params.getSmall());
        ArrayList<Integer> plan = params.getPlanParking();
        for (int i = 0; i < plan.size(); i++) {
            list1.add(ps.addCar(plan.get(i)));
        }
        ps.print(list1);
    }
}

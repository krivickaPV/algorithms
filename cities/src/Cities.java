import java.util.ArrayList;

public class Cities {
        public static void main(String[] arr){
            String[] string = { "Воронеж", "Жданов", "Витебск"};
            EulerianCircuit eulerianCircuit = new EulerianCircuit();
            int[][] matrix= EulerianCircuit.createMatrix(string);
            if(eulerianCircuit.doesEulerCycleExist(matrix)){
                System.out.println("yes");
            }
            else System.out.println("no");
        }
}

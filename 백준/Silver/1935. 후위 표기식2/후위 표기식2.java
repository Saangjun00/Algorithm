import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String data = br.readLine();
        double[] arr = new double[num];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        StringBuilder sb = new StringBuilder();

        Stack<Double> stack = new Stack<>();

        double result = 0;

        for(int i = 0; i < data.length(); i++) {
            if('A' <= data.charAt(i) && 'Z' >= data.charAt(i)) {
                stack.push(arr[data.charAt(i) - 'A']);
            }
            else {
                if(!stack.empty()) {
                    double num1 = stack.pop();
                    double num2 = stack.pop();

                    switch(data.charAt(i)) {
                        case '*':
                            result = num2 * num1;
                            stack.push(result);
                            continue;
                        case '/':
                            result = num2 / num1;
                            stack.push(result);
                            continue;
                        case '+':
                            result = num2 + num1;
                            stack.push(result);
                            continue;
                        case '-':
                            result = num2 - num1;
                            stack.push(result);
                            continue;
                    }

                }
            }
        }

        sb.append(String.format("%.2f", stack.pop()));
        System.out.println(sb);
    }
}

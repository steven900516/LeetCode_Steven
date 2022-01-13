package SpringTest.First;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Steven0516
 * @create 2022-01-12
 */
public class Cards {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void card() throws IOException {
        String[] input = br.readLine().split(" ");
        int[] res = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            res[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(res);

    }
}

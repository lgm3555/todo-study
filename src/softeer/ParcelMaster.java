package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ParcelMaster {
    static int[] rails;
    static int[] input;
    static boolean[] visit;

    static int N, M, K, minW;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        minW = M * K;

        rails = new int[N];
        input = new int[N];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N ; i++){
            rails[i] = Integer.parseInt(st.nextToken());
        }

        perm(0, 0);

        System.out.println(minW);
    }

    private static void perm(int start, int count){
        if(count == N){
            Queue<Integer> myQueue = new LinkedList<>();
            System.out.println(input);
            for(int v : input){
                myQueue.offer(v);
            }

            int kCount = 0;
            int sum = 0;
            int total = 0;

            while(true){
                sum += myQueue.peek();
                myQueue.offer(myQueue.poll());

                if(sum + myQueue.peek() > M){
                    kCount++;
                    total += sum;
                    sum = 0;
                }

                if(kCount == K) break;
            }

            minW = Math.min(total, minW);
            return;
        }

        for(int i=0; i<N; i++){
            if(!visit[i]){
                visit[i] = true;
                input[count] = rails[i];
                perm(0, count + 1);
                visit[i] = false;
            }
        }
    }
}
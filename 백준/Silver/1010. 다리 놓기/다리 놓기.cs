using System;
using System.Runtime.Intrinsics.Arm;

class Program
{
    static void Main(string[] args)
    {
        // DP 테이블 
        long[,] dp = new long[31, 31];

        for (int i = 0; i <= 30; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                if (j == 0 || j == i) 
                {
                    // mC0 = 1, mCm = 1 인 경우 (삼각형의 양 끝)
                    dp[i, j] = 1;
                }
                else 
                {
                    // 파스칼의 삼각형 공식: iCj = (i-1)C(j-1) + (i-1)Cj
                    dp[i, j] = dp[i - 1, j - 1] + dp[i - 1, j];
                }
            }
        }

        
        int t = int.Parse(Console.ReadLine());

        for (int i = 0; i < t; i++)
        {
            string[] input = Console.ReadLine().Split();
            int n = int.Parse(input[0]);
            int m = int.Parse(input[1]);

            Console.WriteLine(dp[m, n]);
        }
    }
}

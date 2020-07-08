#include <bits/stdc++.h>
#define LL long long

const LL lens = 1e6 + 5;
LL num[lens],same[lens];
int main()
{
    LL n,k;
    std::cin >> n >> k;
    for(LL i = 1;i <= n;i++) std::cin >> num[i];
    std::sort(num + 1,num + n + 1);

    for(LL i = 1;i <= n;i++) same[i] = 1;
    for(LL i = 2;i <= n;i++) if(num[i] == num[i - 1]) same[i] = same[i - 1] + 1;
    
    LL tot = 1,flag = 0;
    std::cout << num[(k + n - 1) / n] << " ";
    for(LL i = (k + n - 1) / n - 1;i >= 1;i--)
    {
        if(num[i] != num[(k + n - 1) / n])
        {
            flag = i;
            break;
        }
    }
    for(LL i = (k + n - 1) / n;;i++)
    {
        tot = std::max(same[i],tot);
        if(i + 1 > n || same[i + 1] == 1) break;
    }
    //std::cout << tot << "\n\n";
    std::cout << num[(k - flag * n + tot - 1) / tot];
   // std::cout << (k - flag * n + tot - 1) / tot << "\n" << flag;
   // std::cout << " " << k << " " <<  tot;
    return 0;
}
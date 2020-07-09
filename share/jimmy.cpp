#include<bits/stdc++.h>
using namespace std;
int n , x1 , x2 , x , y , mh;
int dp[1000][2];
struct board{
    int x1,x2,h;
}bd[1000];

bool cmp(board r , board l){
    return r.h<l.h;
}

void leftJump(int number){
    int tmp = number-1;
    while(tmp>0 && bd[number].h-bd[tmp].h<=mh){
        if(bd[number].x1>bd[tmp].x1 && bd[number].x1<bd[tmp].x2){
            dp[number][0] = bd[number].h-bd[tmp].h + min(dp[tmp][0]+bd[number].x1-bd[tmp].x1 , dp[tmp][1]+bd[tmp].x2-bd[number].x1);
            return;
        }
        else
            tmp--;
    }
    
    if(bd[number].h>mh){
        dp[number][0] = 999999;
    }
    else{
        dp[number][0] = bd[number].h;
    }
}

void rightJump(int number){
    int tmp = number-1;
    while(tmp>0 && bd[number].h-bd[tmp].h<=mh){
        if(bd[number].x2<bd[tmp].x2 && bd[number].x2>bd[tmp].x1){
            dp[tmp][1] = bd[number].h-bd[tmp].h + min(dp[tmp][1]+bd[tmp].x2-bd[number].x2 , dp[tmp][0]+bd[number].x2-bd[tmp].x1);
            return;
        }
        else
            tmp--;
    }

    if(bd[number].h>mh){
        dp[number] = 999999;
    }
    else{
        dp[number] = bd[number].h;
    }
}

int main()
{
    cin>>n>>x>>y>>mh;
    
    bd[0].x1 = -100000;
    bd[0].x2 = 100000;
    bd[0].h = 0;
    bd[n+1].x1 = bd[n+1].x2;

    memset(dp , 0 , sizeof dp);

    for(int i=1 ; i<=n ; i++)
        cin>>bd[i].x1>>bd[i].x2>>bd[i].h;
    sort(bd,bd+n+1,cmp);
    for(int i=0 ; i<=n+1 ; i++){
        leftJump(i);
        rightJump(i);
    }
    
    cout<<min(dp[n+1][0] , dp[n+1][1]);
    return 0;
}
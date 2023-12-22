#include <stdio.h>

int main(void) {
    long long flag = 0;
    int tmp;
    for(int i = 0; i< 10 ; i++) {
        scanf("%d", &tmp);
        flag |= (1LL << (tmp % 42));
    }
    int ans = 0;
    for(int i = 41; i >= 0; i--) {
        if((flag & (1LL << i)) != 0) {
            ans++;
        }  
    }
    printf("%d",ans);
    return 0;
}
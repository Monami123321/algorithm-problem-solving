#include <stdio.h>
int main(void) {
    int n;
    int flag = 0;
    for(int i = 0; i< 28;i++) {
        scanf("%d", &n);
        flag ^= (1 << n);
    }
    for(int i = 1; i<=30; i++) {
        if((flag & (1 << i)) ==0) {
            printf("%d\n",i);
        }
    }

    return 0;
}
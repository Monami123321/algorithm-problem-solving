#include <stdio.h>
int main(void) {

    int x, n;
    int total = 0;
    scanf("%d", &x);
    scanf("%d", &n);
    for(int i = 0; i<n; i++) {
        int a,b;
        scanf("%d %d", &a, &b);
        total += (a * b);
    
    }
    if(total == x) {
        printf("Yes");
    
    } else {
        printf("No");
    }
    
    return 0;

}
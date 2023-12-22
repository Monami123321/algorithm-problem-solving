#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int n;
    double max = 0;
    scanf("%d", &n);
    int* arr = (int*)malloc(sizeof(int)*n);
    for(int i = 0; i< n; i++) {
        scanf("%d",&arr[i]);
        if(arr[i] > max) {
            max = arr[i];
        }
    }
    double tmp = 0;
    for(int i = 0; i<n; i++) {
        tmp += arr[i]/max*100;
    }
    printf("%f",tmp/n);
    
}
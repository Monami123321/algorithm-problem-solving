#include <stdio.h>
#include <stdlib.h>

void swap(int* arr, int x, int y) {
    int tmp = arr[x];
    arr[x] = arr[y];
    arr[y] = tmp;
    return;
}


int main(void) {
    int n,m;
    scanf("%d %d",&n,&m);
    int* arr = (int*)malloc(sizeof(int)*(n+1));
    for(int i = 1; i<n+1;i++) {
        arr[i] = i;
        
    }

    int start, end;

    for(int i = 0; i<m;i++) {
        scanf("%d %d",&start,&end);
        while(start<end) {
            swap(arr,start++,end--);
        }
        
    }
    for(int i = 1; i<n+1; i++) {
        printf("%d ",arr[i]);
    }
    free(arr);
    return 0;
}
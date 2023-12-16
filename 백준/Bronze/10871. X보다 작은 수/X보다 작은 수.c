#include <stdio.h>
int main(void) {
    int n,x;
    scanf("%d",&n);
    scanf("%d",&x);
    int* arr = (int*)malloc(sizeof(int)*n);
    for (size_t i = 0; i < n; i++)
    {
        scanf("%d",&arr[i]);
        
    }
    for (size_t i = 0; i < n; i++)
    {
        if(arr[i]<x) {
            printf("%d ",arr[i]);
        }
    }
    free(arr);
    return 0;
    



}
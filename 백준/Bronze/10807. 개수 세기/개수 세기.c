#include <stdio.h>
int main(void)
{
    int n,v;
    scanf("%d",&n);

    int* arr = (int*)malloc(n*sizeof(int));



    for (size_t i = 0; i < n; i++)
    {
        scanf("%d",&arr[i]);
    }
    scanf("%d",&v);
    int cnt = 0;

    for(int i = 0; i<n; i++) {
        if(arr[i] == v) {
            cnt++;
        }
    }
    printf("%d",cnt);
    //free(arr);
    return 0;
    
}
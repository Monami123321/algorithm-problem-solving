#include <stdio.h>
int main(int argc, char const *argv[])
{
    int n,m;
    scanf("%d %d",&n,&m);

    int* arr = (int*)malloc(sizeof(int)*(n+1));
    for (size_t i = 1; i < n+1; i++)
    {
        arr[i] = i;
    }
    


    for (size_t i = 0; i < m; i++)
    {
        int a,b,tmp;
        scanf("%d %d",&a,&b);
        tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    for (size_t i = 1; i < n+1; i++)
    {
        printf("%d ",arr[i]);
    }
    free(arr);
    return 0;
}

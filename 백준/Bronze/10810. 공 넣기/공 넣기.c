#include <stdio.h>
int main(int argc, char const *argv[])
{
    int n,m;
    scanf("%d",&n);
    scanf("%d",&m);

    int* arr = (int*)malloc(sizeof(int)*(n+1));
    for (size_t i = 0; i < m; i++)
    {
        int start,end,ball;
        scanf("%d %d %d",&start,&end,&ball);
        for (size_t j = start; j <= end; j++)
        {
            arr[j] = ball;
        }
    }
    for (size_t i = 1; i < n+1; i++)
    {
        printf("%d ",arr[i]);
    } 

    free(arr);
    return 0;
}

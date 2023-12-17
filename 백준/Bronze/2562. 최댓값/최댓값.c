#include <stdio.h>
int main(int argc, char const *argv[])
{
    int arr[9];
    int max = -1;
    int index = 0;
    for (size_t i = 0; i < 9; i++)
    {
        scanf("%d",&arr[i]);
        if(arr[i] > max) {
            max = arr[i];
            index = i;
        }
    }
    printf("%d\n",max);
    printf("%d\n",index+1);

    
    return 0;
}
